package models;

import lejos.hardware.Button;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;
import lejos.utility.Delay;
import lejos.hardware.Sound;
import lejos.hardware.motor.UnregulatedMotor;
import models.ColorSensor;
import models.Lcd;

public class DriveWithMusic {

	// attributen
	static private UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	static private UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);
	private ColorSensor color = new ColorSensor(SensorPort.S4);
	private Scale toonladder;	
	private final static int TONE_DURATION = 50;

	// Constructor
	public DriveWithMusic(Scale toonladder) {
		super();
		this.toonladder = toonladder;
	}

	// Methode colorId
	public void driveWithColor() {

		// start programma
		Button.LEDPattern(4); // flash green led
		Sound.beepSequenceUp(); // make sound when ready
		System.out.println("Press any key to start");
		Button.waitForAnyPress(); // wait for key-press

		// stel kleursensor in
		color.setColorIdMode();
		color.setFloodLight(false);

		// Start met rijden...
		motorA.setPower(-10);
		motorB.setPower(-10);

		// ... en blijf rijden totdat de Escape knop wordt ingedrukt
		while (Button.ESCAPE.isUp()) {

			// toon de kleur die gescand wordt op het scherm
			Lcd.clear(4);
			Lcd.print(4, "id=%s", ColorSensor.colorName(color.getColorID()));
			
			// scan de kleur en zet deze in String kleur
			String kleur = ColorSensor.colorName(color.getColorID());
			
			// speel toon per kleur
			switch (kleur) {
			case "White":
				Sound.playTone(toonladder.getSelectedScaleNotes()[0], TONE_DURATION);
				break;
			case "Blue":
				Sound.playTone(toonladder.getSelectedScaleNotes()[1], TONE_DURATION);
				break;
			case "Black":
				Sound.playTone(toonladder.getSelectedScaleNotes()[2], TONE_DURATION);
				break;
			case "Green":
				Sound.playTone(toonladder.getSelectedScaleNotes()[3], TONE_DURATION);
				break;
			case "Red":
				Sound.playTone(toonladder.getSelectedScaleNotes()[4], TONE_DURATION);
				break;
			}
		}

		// stop motoren
		motorA.stop();
		motorB.stop();

		// maak resources vrij
		motorA.close();
		motorB.close();
		color.close();

		Sound.beepSequence(); // klaar
	}
}
