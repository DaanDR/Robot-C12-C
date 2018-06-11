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
	private static UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	private static UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);
	private ColorSensor color = new ColorSensor(SensorPort.S4);
	private Scale toonladder;	
	private final static int TONE_DURATION = 50;
	private final static int MOTOR_SPEED = -10;
	private final static int GREEN_LIGHT = 4;

	// Constructor
	public DriveWithMusic(Scale toonladder) {
		super();
		this.toonladder = toonladder;
	}

	// Methode colorId
	public void driveWithColor() {

		startProgram();
		setUpColorSensor();
		startDriving();

		// blijf rijden totdat de Escape knop wordt ingedrukt
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

		stopDriving();		
		freeResources();
		Sound.beepSequence(); // klaar
	}
	
	private void startProgram() {
		Button.LEDPattern(GREEN_LIGHT);
		Sound.beepSequenceUp(); // make een geluid wanneer het gereed is
		System.out.println("Press any key to start");
		Button.waitForAnyPress(); // wacht op druk op knop
	}
	
	private void setUpColorSensor() {
		color.setColorIdMode();
		color.setFloodLight(false);
	}
	
	private void startDriving() {
		motorA.setPower(MOTOR_SPEED);
		motorB.setPower(MOTOR_SPEED);
	}
	
	private void stopDriving() {
		motorA.stop();
		motorB.stop();
	}
	
	private void freeResources() {
		motorA.close();
		motorB.close();
		color.close();
	}
}
