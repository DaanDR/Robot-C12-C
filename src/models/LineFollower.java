package models;

import hardware.Engineblock;
import hardware.Lcd;
import lejos.hardware.Button;

public class LineFollower extends Trick {

	// Attributes
	float colorValue; // Used to store red-value during while-loop

	// aanmaken variabelen voor max / min snelheden
	static final int MAX_SPEED = 50;
	static final int MED_SPEED = 30;
	static final int MIN_SPEED = 10;

	// aanmaken vasta variabelen voor red sensor
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

			// als de sensor 50% wit en 50% zwart ziet gaat hij rechtdoor
			if (colorValue >= (BLACK + .08f) && colorValue <= (BLACK_WHITE)) {
				motorA.setPower(-MAX_SPEED);
				motorB.setPower(-MAX_SPEED);
				// als de sensor 25% wit ziet en 75% zwart dan gaat hij een flauwe bocht naar
				// rechts
			} else if (colorValue < (BLACK + .08f) && colorValue >= BLACK) {
				motorA.setPower((-MED_SPEED) + 10);
				motorB.setPower(-MED_SPEED);
				// als de sensor 100% zwart ziet dan gaat hij met een scherpere bocht naar
				// rechts
			} else if (colorValue < BLACK) {
				motorA.setPower(-MIN_SPEED + 5);
				motorB.setPower(-MED_SPEED);
				// als de sensor voornamelijk wit ziet begint hij een flauwe bocht naar links
			} else if (colorValue > BLACK_WHITE && colorValue <= (BLACK_WHITE + .1f)) {
				motorA.setPower((-MED_SPEED) - 10);
				motorB.setPower(-MED_SPEED);
				// iets scherpere bocht naar links
			} else if (colorValue > (BLACK_WHITE + .1f) && colorValue < (BLACK_WHITE + .15f)) {
				motorA.setPower((-MED_SPEED) - 10);
				motorB.setPower((-MED_SPEED) + 5);
				// nog iets scherpere bocht
			} else if (colorValue >= (BLACK_WHITE + .15f) && colorValue <= WHITE) {
				motorA.setPower((-MED_SPEED) - 10);
				motorB.setPower((-MIN_SPEED) - 10);
				// scherpe bocht naar links, linker wielen gaan naar achter en rechter wielen
				// naar voren
			} else if (colorValue > WHITE) {
				motorA.setPower((-MAX_SPEED) + 10);
				motorB.setPower(MAX_SPEED - 10);
			}

		}

		stopDriving();

	}

}
