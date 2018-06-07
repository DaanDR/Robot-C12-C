package models;

import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;
import lejos.utility.Delay;
import lejos.hardware.Sound;
import models.ColorSensor;
import models.Lcd;

public class DriveWithMusic {

	// Constructor
	public DriveWithMusic() {
		super();
	}
		
	private ColorSensor color = new ColorSensor(SensorPort.S4);

	// Methode
	public void driveWithMusic() {

		// Attributen
		Color rgb;
		String kleur;
		int roodwaarde;
		
		// Aanvang programma, 
		// display tekst en wacht op druk op knop.
		
		System.out.println("Drive with Music");
		Lcd.print(2, "Press to start");

		Button.LEDPattern(4); // flash green led and
		Sound.beepSequenceUp(); // make sound when ready.

		Button.waitForAnyPress();
		Button.LEDPattern(0);


		// RGB program: Koppel toon aan (rood-waarde van) RGB
		// Flood light white.
		
		color.setRGBMode();
		color.setFloodLight(Color.WHITE);

		while (Button.ESCAPE.isUp()) {
			rgb = color.getColor();

			Lcd.clear(4);
			Lcd.print(4, "r=%d g=%d b=%d", rgb.getRed(), rgb.getGreen(), rgb.getBlue());
			Delay.msDelay(250);

			// herkent de kleuren op basis van de eerste waarde (rood) van de rgb code
			// en speelt de juiste noot uit de selectedScaleString array

			roodwaarde = rgb.getRed();
			Scale toonladderC = new Scale("c");

			if (roodwaarde >= 4 && roodwaarde <= 6) { // black
				Sound.playTone(toonladderC.getSelectedScaleNotes()[1], 350);
				Delay.msDelay(100);
			} else if (roodwaarde >= 15 && roodwaarde <= 17) { // blue
				Sound.playTone(toonladderC.getSelectedScaleNotes()[2], 350);
				Delay.msDelay(100);
			} else if (roodwaarde >= 57 && roodwaarde <= 62) { // red
				Sound.playTone(toonladderC.getSelectedScaleNotes()[3], 350);
				Delay.msDelay(100);
			}
		}

		Delay.msDelay(1000);

		
		// Color ID program: Koppel toon aan color ID
		// Flood light uit??.

		color.setColorIdMode();
		color.setFloodLight(false);

		while (Button.ESCAPE.isUp()) {
			Lcd.clear(5);
			Lcd.print(5, "id=%s", ColorSensor.colorName(color.getColorID()));
			Delay.msDelay(250);

			kleur = ColorSensor.colorName(color.getColorID());	
			Scale toonladderD = new Scale("d");

			switch (kleur) {
			case "Red":
				Sound.playTone(toonladderD.getSelectedScaleNotes()[0], 350);
				break;
			case "Black":
				Sound.playTone(toonladderD.getSelectedScaleNotes()[1], 350);
				break;
			case "Blue":
				Sound.playTone(toonladderD.getSelectedScaleNotes()[2], 350);
				break;
			case "Green":
				Sound.playTone(toonladderD.getSelectedScaleNotes()[3], 350);
				break;
			case "Yellow":
				Sound.playTone(toonladderD.getSelectedScaleNotes()[4], 350);
				break;
			case "White":
				Sound.playTone(toonladderD.getSelectedScaleNotes()[5], 350);
				break;
			case "Brown":
				Sound.playTone(toonladderD.getSelectedScaleNotes()[6], 350);
				break;
			}

		}

		// free up resources.
		color.close();

		Sound.beepSequence(); // we are done.

		Button.LEDPattern(4);
		Button.waitForAnyPress();
	}

}


