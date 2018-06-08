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
	private Scale toonladderC;
	private static double roodwaarde;
	private final static int TONE_DURATION = 50;

	// Constructor
	public DriveWithMusic(Scale toonladderC) {
		super();
		this.toonladderC = toonladderC;
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

		// Drive...
		motorA.setPower(-10);
		motorB.setPower(-10);

		// ... while waiting for escape key to stop driving
		while (Button.ESCAPE.isUp()) {

			// display de kleur die gescand wordt op het scherm
			Lcd.clear(4);
			Lcd.print(4, "id=%s", ColorSensor.colorName(color.getColorID()));
			
			// speel toon per kleur
			String kleur = ColorSensor.colorName(color.getColorID());
			

			switch (kleur) {
			case "White":
				Sound.playTone(toonladderC.getSelectedScaleNotes()[0], TONE_DURATION);
				break;
			case "Blue":
				Sound.playTone(toonladderC.getSelectedScaleNotes()[1], TONE_DURATION);
				break;
			case "Black":
				Sound.playTone(toonladderC.getSelectedScaleNotes()[2], TONE_DURATION);
				break;
			case "Green":
				Sound.playTone(toonladderC.getSelectedScaleNotes()[3], TONE_DURATION);
				break;
			case "Red":
				Sound.playTone(toonladderC.getSelectedScaleNotes()[4], TONE_DURATION);
				break;
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
	
	
	//methode roodwaarde
	
	public void driveWithColorRGB() {

		// start programma
		Button.LEDPattern(4); // flash green led
		Sound.beepSequenceUp(); // make sound when ready
		System.out.println("Press any key to start");
		Button.waitForAnyPress(); // wait for key-press

		// stel kleursensor in
		color.setRedMode();
		color.setFloodLight(false);

		// Drive...
		motorA.setPower(-10);
		motorB.setPower(-10);

		// ... while waiting for escape key to stop driving
		while (Button.ESCAPE.isUp()) {

			// display de kleur die gescand wordt op het scherm
			Lcd.clear(4);
			Lcd.print(4, "id=%f", color.getRed());
			
			// speel toon per roodwaarde
			
			

			roodwaarde = color.getRed();
			

			if (roodwaarde >= 0.79 && roodwaarde <= 0.8) { // white
				Sound.playTone(toonladderC.getSelectedScaleNotes()[0], TONE_DURATION);
				Delay.msDelay(100);
			} else if (roodwaarde >= 0.18 && roodwaarde <= 0.2) { // blue
				Sound.playTone(toonladderC.getSelectedScaleNotes()[1], TONE_DURATION);
				Delay.msDelay(100);
			} else if (roodwaarde >= 0.86 && roodwaarde <= 0.9) { // yellow
				Sound.playTone(toonladderC.getSelectedScaleNotes()[2], TONE_DURATION);
				Delay.msDelay(100);
			} else if (roodwaarde >= 0.3 && roodwaarde <= 0.33) { // green
				Sound.playTone(toonladderC.getSelectedScaleNotes()[3], TONE_DURATION);
				Delay.msDelay(100);
			} else if (roodwaarde >= 0.68 && roodwaarde <= 0.71) { // red
				Sound.playTone(toonladderC.getSelectedScaleNotes()[4], TONE_DURATION);
				Delay.msDelay(100);
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


//	// Methode
//	public void playByColor() {
//
//		// Attributen
//		Color rgb;
//		String kleur;
//		int roodwaarde;
//
//		// Aanvang programma,
//		// display tekst en wacht op druk op knop.
//
//		System.out.println("Drive with Music");
//		Lcd.print(2, "Press to start");
//
//		Button.LEDPattern(4); // flash green led and
//		Sound.beepSequenceUp(); // make sound when ready.
//
//		Button.waitForAnyPress();
//		Button.LEDPattern(0);
//
//		// RGB program: Koppel toon aan (rood-waarde van) RGB
//		// Flood light white.
//
//		color.setRGBMode();
//		color.setFloodLight(Color.WHITE);
//
//		while (Button.ESCAPE.isUp()) {
//			rgb = color.getColor();
//
//			Lcd.clear(4);
//			Lcd.print(4, "r=%d g=%d b=%d", rgb.getRed(), rgb.getGreen(), rgb.getBlue());
//			Delay.msDelay(250);
//
//			// herkent de kleuren op basis van de eerste waarde (rood) van de rgb code
//			// en speelt de juiste noot uit de selectedScaleString array
//
//			roodwaarde = rgb.getRed();
//			Scale toonladderC = new Scale("c");
//
//			if (roodwaarde >= 4 && roodwaarde <= 6) { // black
//				Sound.playTone(toonladderC.getSelectedScaleNotes()[1], 350);
//				Delay.msDelay(100);
//			} else if (roodwaarde >= 15 && roodwaarde <= 17) { // blue
//				Sound.playTone(toonladderC.getSelectedScaleNotes()[2], 350);
//				Delay.msDelay(100);
//			} else if (roodwaarde >= 57 && roodwaarde <= 62) { // red
//				Sound.playTone(toonladderC.getSelectedScaleNotes()[3], 350);
//				Delay.msDelay(100);
//			}
//		}
//
//		Delay.msDelay(1000);
//
//		// Color ID program: Koppel toon aan color ID
//		// Flood light uit??.
//
//		color.setColorIdMode();
//		color.setFloodLight(false);
//
//		while (Button.ESCAPE.isUp()) {
//			Lcd.clear(5);
//			Lcd.print(5, "id=%s", ColorSensor.colorName(color.getColorID()));
//			Delay.msDelay(250);
//
//			kleur = ColorSensor.colorName(color.getColorID());
//			Scale toonladderD = new Scale("d");
//
//			switch (kleur) {
//			case "Red":
//				Sound.playTone(toonladderD.getSelectedScaleNotes()[0], 350);
//				break;
//			case "Black":
//				Sound.playTone(toonladderD.getSelectedScaleNotes()[1], 350);
//				break;
//			case "Blue":
//				Sound.playTone(toonladderD.getSelectedScaleNotes()[2], 350);
//				break;
//			case "Green":
//				Sound.playTone(toonladderD.getSelectedScaleNotes()[3], 350);
//				break;
//			case "Yellow":
//				Sound.playTone(toonladderD.getSelectedScaleNotes()[4], 350);
//				break;
//			case "White":
//				Sound.playTone(toonladderD.getSelectedScaleNotes()[5], 350);
//				break;
//			case "Brown":
//				Sound.playTone(toonladderD.getSelectedScaleNotes()[6], 350);
//				break;
//			}
//
//		}
//
//		// free up resources.
//		color.close();
//
//		Sound.beepSequence(); // we are done.
//
//		Button.LEDPattern(4);
//		Button.waitForAnyPress();
//	}

}
