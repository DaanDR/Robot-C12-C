package models;

import hardware.ColorSensor;
import hardware.Lcd;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;

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

		
		startProgram();
		setUpColorSensor();
		startMotor();
		
		// blijf rijden totdat de Escape knop wordt ingedrukt


		while (Button.ESCAPE.isUp()) {
			colorValue = color.getRed();
//			Sound.playSample(file, 100);
			Lcd.clear(7);
			Lcd.print(7, "value=%.3f", colorValue);
			
			//eerste if voor een "smooth" rechte lijn

			if (colorValue >= .2 && colorValue <= .45) {
				motorA.setPower(-50);
				motorB.setPower(-50);
				
				//motorC grijparm, vooralsnog voor de sier
//				motorC.setPower(-60);
			//bijsturen naar rechts als kleur waarde veranderd
			} else if (colorValue < .2 && colorValue >=.1) {
				motorA.setPower(-20);
				motorB.setPower(-30);
				
//				motorC.setPower(-60);
			//bijsturen naar links als kleur waarde veranderd
			} 
			else if (colorValue < .1) {
				motorA.setPower(-10);
				motorB.setPower(-30);
				
//				motorC.setPower(-60);
			//bijsturen naar links als kleur waarde veranderd
			} else if (colorValue >= .64){
				motorA.setPower(-40);
				motorB.setPower(40);
				
//				motorC.setPower(60);
			}else if ( colorValue >.55 && colorValue < .64) {
				motorA.setPower(-40);
				motorB.setPower(-10);
				
//				motorC.setPower(-60);
			//bijsturen naar links als kleur waarde veranderd
			} else if (colorValue >.45 && colorValue <=.55) {
				motorA.setPower(-40);
				motorB.setPower(-20);
			}
		}


		stopMotor();
		freeResources();
		Sound.beepSequence(); // klaar
	}
	
	private void startProgram() {
		Button.LEDPattern(4); // flash green led and
		Sound.beepSequenceUp(); // make sound when ready.
		System.out.println("Press any key to start");
		Button.waitForAnyPress();
	}
	
	private void setUpColorSensor() {
		//color mode sensor gebruikt de RED sensor functie voor detectie
		color.setRedMode();
		color.setFloodLight(Color.RED);
		color.setFloodLight(true);
	}
	
	private void startMotor() {
		//standaard motor waardes, ze staan op negatief, anders draait hij verkeerde kant
		motorA.setPower(-30);
		motorB.setPower(-30);
		motorC.setPower(-90);
	}
	
	private void stopMotor() {
		motorA.stop();
		motorB.stop();
	}
	
	private void freeResources() {
		motorA.close();
		motorB.close();
		color.close();
	}
}
