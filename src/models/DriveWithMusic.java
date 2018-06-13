package models;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import hardware.ColorSensor;
import hardware.Engineblock;
import hardware.Lcd;

public class DriveWithMusic extends Trick {

	// attributen
	private Scale toonladder;	
	private final static int TONE_DURATION = 50;
	private final static int TONE_VOLUME = 60;
		

	// Constructor
	public DriveWithMusic(Engineblock engineblock, Scale toonladder) {
		super(engineblock);
		this.toonladder = toonladder;
	}

	// Methode colorId
	public void driveWithColor() {
		
		setColorSensorID();
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
			case "Blue":
				Sound.playTone(toonladder.getSelectedScaleNotes()[0], TONE_DURATION, TONE_VOLUME);
				break;
			case "Green":
				Sound.playTone(toonladder.getSelectedScaleNotes()[1], TONE_DURATION, TONE_VOLUME);
				break;
			case "Black":
				Sound.playTone(toonladder.getSelectedScaleNotes()[2], TONE_DURATION, TONE_VOLUME);
				break;
			case "Red":
				Sound.playTone(toonladder.getSelectedScaleNotes()[3], TONE_DURATION, TONE_VOLUME);
				break;
			case "White":
				Sound.playTone(toonladder.getSelectedScaleNotes()[4], TONE_DURATION, TONE_VOLUME);
				break;
			}
		}

		stopDriving();		
	}
	
}
