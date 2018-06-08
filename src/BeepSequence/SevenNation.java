package BeepSequence;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;
import models.ColorSensor;
import models.Lcd;
import models.Scale;

public class SevenNation {

	// attributen
	static private UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	static private UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);
	private ColorSensor color = new ColorSensor(SensorPort.S4);
	final static int STANDAARD_TOON = 50;
	final static int STANDAARD_DELAY = 20;

	// Constructor
	public SevenNation() {
		super();
	}

	public void startProgram() {
		// Start programma
		Button.LEDPattern(4); // flash green led
		Sound.beepSequenceUp(); // make sound when ready
		System.out.println("Press any key to start");
		Button.waitForAnyPress(); // wait for key-press
	}
	
	public void waitForPress() {
		System.out.println("Press any key to continue");
		Button.waitForAnyPress(); // wait for key-press
	}

	public void driveSevenNation(Scale noot) {

		this.startProgram();
		
		// stel kleursensor in
		color.setColorIdMode();
		color.setFloodLight(false);

		// Drive...
		motorA.setPower(-30);
		motorB.setPower(-30);

		// ... while waiting for escape key to stop driving
		while (Button.ESCAPE.isUp()) {

			// display de kleur die gescand wordt op het scherm
			Lcd.clear(4);
			Lcd.print(4, "id=%s", ColorSensor.colorName(color.getColorID()));

			// speel toon per kleur
			String kleur = ColorSensor.colorName(color.getColorID());
			Scale scaleSevenNation = new Scale("sevennation");

			switch (kleur) {
			case "Blue":
				Sound.playNote(Sound.PIANO, scaleSevenNation.getSelectedScaleNotes()[0], STANDAARD_TOON);
				break;
			case "Green":
				Sound.playNote(Sound.PIANO, scaleSevenNation.getSelectedScaleNotes()[1], STANDAARD_TOON);
				break;
			case "Black":
				Sound.playNote(Sound.PIANO, scaleSevenNation.getSelectedScaleNotes()[2], STANDAARD_TOON);
				break;
			case "Red":
				Sound.playNote(Sound.PIANO, scaleSevenNation.getSelectedScaleNotes()[3], STANDAARD_TOON);
				break;
			case "White":
				Sound.playNote(Sound.PIANO, scaleSevenNation.getSelectedScaleNotes()[5], STANDAARD_TOON);
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

	public void playSevenNation(Scale noot) {

		Sound.playNote(Sound.PIANO, noot.getSelectedScaleNotes()[3], 1000);
		Delay.msDelay(STANDAARD_DELAY);
		Sound.playNote(Sound.PIANO, noot.getSelectedScaleNotes()[3], 300);
		Delay.msDelay(STANDAARD_DELAY);
		Sound.playNote(Sound.PIANO, noot.getSelectedScaleNotes()[5], 300);
		Delay.msDelay(STANDAARD_DELAY);
		Sound.playNote(Sound.PIANO, noot.getSelectedScaleNotes()[3], 300);
		Delay.msDelay(STANDAARD_DELAY);
		Sound.playNote(Sound.PIANO, noot.getSelectedScaleNotes()[2], 300);
		Delay.msDelay(STANDAARD_DELAY);
		Sound.playNote(Sound.PIANO, noot.getSelectedScaleNotes()[1], 800);
		Delay.msDelay(STANDAARD_DELAY);
		Sound.playNote(Sound.PIANO, noot.getSelectedScaleNotes()[0], 1000);
		Delay.msDelay(STANDAARD_DELAY);
		Delay.msDelay(1500);
	}

}
