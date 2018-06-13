package models;

import hardware.Engineblock;
import hardware.Lcd;
import lejos.hardware.Button;

public class LineFollower extends Trick {

	// Attributes
	float colorValue; // Used to store red-value during while-loop

	// Constructor
	public LineFollower(Engineblock engineBlock) {
		super(engineBlock);
	}

	/**
	 * LineFollower method Follows a black-on-white line using the RedMode of
	 * colorsensor. Displays colorvalue on lcd while driving. Keeps on driving until
	 * [Escape] is pressed.
	 */

	public void followLine() {
		Lcd.print(1, "Follow the leader,");
		Lcd.print(2, "  leader, ...Line!");

		// Set motors and sensor
		setColorSensorRed(); // set color sensor to the right mode incl floodlight
		startDriving();
		moveArms(60); // move arms

		// Keep driving and following line until [Escape] is pressed
		while (Button.ESCAPE.isUp()) {
			colorValue = color.getRed();
			Lcd.clear(4);
			Lcd.print(4, "value=%.3f", colorValue); // Displays red-value on screen

			// eerste if voor een "smooth" rechte lijn
			if (colorValue >= .2 && colorValue <= .45) {
				motorA.setPower(-50);
				motorB.setPower(-50);
				// moveArms(-60); // grijparm, vooralsnog voor de sier

				// bijsturen naar rechts als kleur waarde veranderd
			} else if (colorValue < .2 && colorValue >= .1) {
				motorA.setPower(-20);
				motorB.setPower(-30);
				// moveArms(-60);
				
				// bijsturen naar links als kleur waarde veranderd
			} else if (colorValue < .1) { 
				motorA.setPower(-10);
				motorB.setPower(-30);
				// moveArms(-60);
				
				// bijsturen naar links als kleur waarde veranderd
			} else if (colorValue >= .64) { 
				motorA.setPower(-40);
				motorB.setPower(40);
				// moveArms(60);
			} else if (colorValue > .55 && colorValue < .64) {
				motorA.setPower(-40);
				motorB.setPower(-10);
				// moveArms(-60);
				
				// bijsturen naar links als kleur waarde veranderd
			} else if (colorValue > .45 && colorValue <= .55) { 
				motorA.setPower(-40);
				motorB.setPower(-20);
			}
		}

		stopDriving();

	}

}
