package models;

import hardware.ColorSensor;
import hardware.Lcd;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;
import lejos.utility.Stopwatch;

public class LineFollower {

	// motors voor de wielen worden aangemaakt
	static private UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	static private UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);

	// motor voor grijparmen wordt aangemaakt
	static private UnregulatedMotor motorC = new UnregulatedMotor(MotorPort.C);
	// color sensor wordt aangemaakt
	static private ColorSensor color = new ColorSensor(SensorPort.S4);

	float colorValue;
	
	// aanmaken variabelen voor max / min snelheden
	static final int MAX_SPEED = 50;
	static final int MED_SPEED = 30;
	static final int MIN_SPEED = 10;
	
	// aanmaken vasta variabelen voor red sensor
	static final float BLACK =  0.1f;
	static final float WHITE = 0.70f;
	static final float BLACK_WHITE = 0.45f;

	public LineFollower() {
		super();
	}

	public void followLine() {
		System.out.println("Line Follower\n");

		startProgram();
		setUpColorSensor();
		startMotor();

		Stopwatch timer = new Stopwatch();
		
		// blijf rijden totdat de Escape knop wordt ingedrukt

		while (Button.ESCAPE.isUp()) {
			colorValue = color.getRed();

			Lcd.clear(7);
			Lcd.print(7, "value=%.3f", colorValue);


			// als de sensor 50% wit en 50% zwart ziet gaat hij rechtdoor
			if (colorValue >= (BLACK+.08f) && colorValue <= (BLACK_WHITE)) {
				motorA.setPower(-MAX_SPEED); 
				motorB.setPower(-MAX_SPEED); 
			// als de sensor 25% wit ziet en 75% zwart dan gaat hij een flauwe bocht naar rechts
			} else if (colorValue < (BLACK+.08f) && colorValue >= BLACK) {
				motorA.setPower((-MED_SPEED) + 10); 
				motorB.setPower(-MED_SPEED);	
			// als de sensor 100% zwart ziet dan gaat hij met een scherpere bocht naar rechts
			} else if (colorValue < BLACK) {
				motorA.setPower(-MIN_SPEED+5); 
				motorB.setPower(-MED_SPEED); 
			// als de sensor voornamelijk wit ziet begint hij een flauwe bocht naar links
			} else if (colorValue > BLACK_WHITE && colorValue <= (BLACK_WHITE+.1f)) {
				motorA.setPower((-MED_SPEED) - 10); 
				motorB.setPower(-MED_SPEED); 
			// iets scherpere bocht naar links
			} else if (colorValue > (BLACK_WHITE+.1f) && colorValue < (BLACK_WHITE+.15f)) {
				motorA.setPower((-MED_SPEED) - 10); 
				motorB.setPower((-MED_SPEED) + 5); 
			// nog iets scherpere bocht
			} else if (colorValue >= (BLACK_WHITE+.15f) && colorValue <= WHITE) {
				motorA.setPower((-MED_SPEED) - 10); 
				motorB.setPower((-MIN_SPEED) - 10); 
			// scherpe bocht naar links, linker wielen gaan naar achter en rechter wielen naar voren
			} else if (colorValue > WHITE) {
				motorA.setPower((-MAX_SPEED)+10); 
				motorB.setPower(MAX_SPEED-10); 
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
		// color mode sensor gebruikt de RED sensor functie voor detectie
		color.setRedMode();
		color.setFloodLight(Color.RED);
		color.setFloodLight(true);
	}

	private void startMotor() {
		// standaard motor waardes, ze staan op negatief, anders draait hij verkeerde
		// kant
		motorA.setPower(-30);
		motorB.setPower(-30);
		// motorC.setPower(-90);
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
