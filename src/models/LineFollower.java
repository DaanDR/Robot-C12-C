package models;

import hardware.Engineblock;
import hardware.Lcd;
import lejos.hardware.Button;

public class LineFollower extends Trick {

	// Attributes
	float colorValue; // Used to store red-value during while-loop

	// create variables for max/min speeds
	static final int MAX_SPEED = 50;
	static final int MED_SPEED = 30;
	static final int MIN_SPEED = 10;

	// create variables for using the red sensor on black/white
	static final float BLACK = 0.1f;
	static final float WHITE = 0.70f;
	static final float BLACK_WHITE = 0.45f;

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
			
			// if the sensor reads 50% white and 50% black, both motors go at same speed 
			if (colorValue >= (BLACK + .08f) && colorValue <= (BLACK_WHITE)) {
				motorA.setPower(-MAX_SPEED);
				motorB.setPower(-MAX_SPEED);
			
				// if the sensor reads 25% white and 75% black, soft turn to right
			} else if (colorValue < (BLACK + .08f) && colorValue >= BLACK) {
				motorA.setPower((-MED_SPEED) + 10);
				motorB.setPower(-MED_SPEED);
				
				// if sensor reads 100% black, sharp turn to right
			} else if (colorValue < BLACK) {
				motorA.setPower(-MIN_SPEED + 5);
				motorB.setPower(-MED_SPEED);
				
				// if the sensor reads more than 50% white, soft turn to left
			} else if (colorValue > BLACK_WHITE && colorValue <= (BLACK_WHITE + .1f)) {
				motorA.setPower((-MED_SPEED) - 10);
				motorB.setPower(-MED_SPEED);
				
				// sharper turn to left
			} else if (colorValue > (BLACK_WHITE + .1f) && colorValue < (BLACK_WHITE + .15f)) {
				motorA.setPower((-MED_SPEED) - 10);
				motorB.setPower((-MED_SPEED) + 5);
				
				// sharper turn to left
			} else if (colorValue >= (BLACK_WHITE + .15f) && colorValue <= WHITE) {
				motorA.setPower((-MED_SPEED) - 10);
				motorB.setPower((-MIN_SPEED) - 10);
				
				// if sensor reads 100% white, sharp turn to right
			} else if (colorValue > WHITE) {
				motorA.setPower((-MAX_SPEED) + 10);
				motorB.setPower(MAX_SPEED - 10);
			}

		}

		stopDriving();

	}

}
