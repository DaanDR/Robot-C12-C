package models;

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

	static private UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	static private UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);
	static private ColorSensor color = new ColorSensor(SensorPort.S4);

	float colorValue;
	
	
	public LineFollower() {
		super();
	}


	public void followLine() {
		System.out.println("Line Follower\n");

		color.setRedMode();
		color.setFloodLight(Color.RED);
		color.setFloodLight(true);

		Button.LEDPattern(4); // flash green led and
		Sound.beepSequenceUp(); // make sound when ready.

		System.out.println("Press any key to start");

		Button.waitForAnyPress();

		motorA.setPower(-80);
		motorB.setPower(-80);

		// drive waiting for escape key to stop driving.

		while (Button.ESCAPE.isUp()) {
			colorValue = color.getRed();

			Lcd.clear(7);
			Lcd.print(7, "value=%.3f", colorValue);

			if (colorValue > .130) {
				motorA.setPower(-60);
				motorB.setPower(0);
			} else {
				motorA.setPower(0);
				motorB.setPower(-60);
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
