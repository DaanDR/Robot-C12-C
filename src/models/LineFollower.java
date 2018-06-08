package models;
/* het doel van deze class is een lijn volgen
 * 
 */
import ev3.exercises.library.ColorSensor;
import ev3.exercises.library.Lcd;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;

import lejos.hardware.Brick;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import ev3.exercises.library.*;

public class LineFollower {
	
	//motors voor de wielen worden aangemaakt
	static private UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	static private UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);
	
	//motor voor grijparmen wordt aangemaakt
	static private UnregulatedMotor motorC = new UnregulatedMotor(MotorPort.C);
	//color sensor wordt aangemaakt 
	static private ColorSensor color = new ColorSensor(SensorPort.S4);

	float colorValue;

	public LineFollower() {
		super();
	}

	public void followLine() {
		System.out.println("Line Follower\n");
		//color mode sensor gebruikt de RED sensor functie voor detectie
		color.setRedMode();
		color.setFloodLight(Color.RED);
		color.setFloodLight(true);

		Button.LEDPattern(4); // flash green led and
		Sound.beepSequenceUp(); // make sound when ready.

		//wanneer knop wordt ingedrukt: start 
		System.out.println("Press any key to start");
		
		//standaard motor waardes, ze staan op negatief, anders draait hij verkeerde kant
		Button.waitForAnyPress();
		motorA.setPower(-30);
		motorB.setPower(-30);
		motorC.setPower(-90);

		// drive waiting for escape key to stop driving.

		while (Button.ESCAPE.isUp()) {
			colorValue = color.getRed();

			Lcd.clear(7);
			Lcd.print(7, "value=%.3f", colorValue);
			
			//eerste if voor een "smooth" rechte lijn
			if (colorValue > .1 && colorValue < .55) {
				motorA.setPower(-30);
				motorB.setPower(-30);
				
				//motorC grijparm, vooralsnog voor de sier
				motorC.setPower(-60);
			//bijsturen naar rechts als kleur waarde veranderd
			} else if (colorValue < .1) {
				motorA.setPower(40);
				motorB.setPower(-40);
				
				motorC.setPower(-60);
			//bijsturen naar links als kleur waarde veranderd
			} else if (colorValue > .55){
				motorA.setPower(-40);
				motorB.setPower(40);
				
				motorC.setPower(60);
			}
		}

		// stop motors with brakes on.
		motorA.stop();
		motorB.stop();

		// free up resources.
		motorA.close();
		motorB.close();
		color.close();

		Sound.beepSequence(); // we are done.
	}
}
