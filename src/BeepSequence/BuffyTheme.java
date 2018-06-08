package BeepSequence;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.utility.Delay;
import models.ColorSensor;
import models.Lcd;
import models.Scale;

public class BuffyTheme {
	
	public static void main(String[] args) {

		System.out.println("Play Buffy theme\n");
		
		Button.LEDPattern(4); // flash green led and
		Sound.beepSequenceUp(); // make sound when ready.

		Button.waitForAnyPress();
		
		Button.LEDPattern(5); // flash red led
		
		
		Scale buffyScale = new Scale("buffy");	
		int STANDAARD_TOON = 100;
		int STANDAARD_DELAY = 20;

		// Melodie
		Delay.msDelay(500);
		
		// 1
		for(int i = 0; i < 12; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[1], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 2; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[2], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 2; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[3], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 14; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[0], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 2; i++) {
			Delay.msDelay(STANDAARD_TOON);		}
		// 2
		for(int i = 0; i < 11; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[0], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 3; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[1], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 2; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[2], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 16; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[0], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}	
		// 3
		for(int i = 0; i < 11; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[1], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 3; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[2], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 2; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[1], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 14; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[0], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}	
		// 4
		for(int i = 0; i < 11; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[0], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 3; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[1], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 2; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[2], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 14; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[0], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}	
		// 5
		for(int i = 0; i < 11; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[4], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 3; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[5], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 2; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[4], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 13; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[3], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 2; i++) {
			Delay.msDelay(STANDAARD_TOON);		}
		for(int i = 0; i < 1; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[3], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 16; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[2], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		
		// 6
		for(int i = 0; i < 11; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[1], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 3; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[2], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 2; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[3], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 11; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[0], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}	
		for(int i = 0; i < 3; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[1], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 2; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[2], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 11; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[0], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}	
		for(int i = 0; i < 3; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[1], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 2; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[2], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}
		for(int i = 0; i < 16; i++) {
			Sound.playNote(Sound.PIANO, buffyScale.getSelectedScaleNotes()[0], STANDAARD_TOON);
			Delay.msDelay(STANDAARD_DELAY);		}	
		
				
		Delay.msDelay(1000);

		
		Sound.beepSequence(); // we are done.

	}







//	// Methode Twinkle TwinkleStar
//	public static void twinkle() {
//		Delay.msDelay(500);
//		Sound.playTone(200, 500);
//		Delay.msDelay(20);
//		Sound.playTone(262, 180);
//		Delay.msDelay(20);
//		Sound.playTone(262, 180);
//		Delay.msDelay(20);
//		Sound.playTone(392, 180);
//		Delay.msDelay(20);
//		Sound.playTone(392, 180);
//		Delay.msDelay(20);
//		Sound.playTone(440, 180);
//		Delay.msDelay(20);
//		Sound.playTone(440, 180);
//		Delay.msDelay(20);
//		Sound.playTone(392, 380);
//		Delay.msDelay(20);
//		Sound.playTone(349, 180);
//		Delay.msDelay(20);
//		Sound.playTone(349, 180);
//		Delay.msDelay(20);
//		Sound.playTone(330, 180);
//		Delay.msDelay(20);
//		Sound.playTone(330, 180);
//		Delay.msDelay(20);
//		Sound.playTone(294, 180);
//		Delay.msDelay(20);
//		Sound.playTone(294, 180);
//		Delay.msDelay(20);
//		Sound.playTone(262, 400);
//		Delay.msDelay(1500);
//	}
//
//	// Methode Star Wars
//	public static void starWars() {
//		Delay.msDelay(500);
//		Sound.playTone(392, 350);
//		Delay.msDelay(100);
//		Sound.playTone(392, 350);
//		Delay.msDelay(100);
//		Sound.playTone(392, 350);
//		Delay.msDelay(100);
//		Sound.playTone(311, 250);
//		Delay.msDelay(100);
//		Sound.playTone(466, 25);
//		Delay.msDelay(100);
//		Sound.playTone(392, 350);
//		Delay.msDelay(100);
//		Sound.playTone(311, 250);
//		Delay.msDelay(100);
//		Sound.playTone(466, 25);
//		Delay.msDelay(100);
//		Sound.playTone(392, 700);
//		Delay.msDelay(100);
//		Sound.playTone(587, 350);
//		Delay.msDelay(100);
//		Sound.playTone(587, 350);
//		Delay.msDelay(100);
//		Sound.playTone(587, 350);
//		Delay.msDelay(100);
//		Sound.playTone(622, 250);
//		Delay.msDelay(100);
//		Sound.playTone(466, 25);
//		Delay.msDelay(100);
//		Sound.playTone(369, 350);
//		Delay.msDelay(100);
//		Sound.playTone(311, 250);
//		Delay.msDelay(100);
//		Sound.playTone(466, 25);
//		Delay.msDelay(100);
//		Sound.playTone(392, 700);
//		Delay.msDelay(100);
//		Sound.playTone(784, 350);
//		Delay.msDelay(100);
//		Sound.playTone(392, 250);
//		Delay.msDelay(100);
//		Sound.playTone(392, 25);
//		Delay.msDelay(100);
//		Sound.playTone(784, 350);
//		Delay.msDelay(100);
//		Sound.playTone(739, 250);
//		Delay.msDelay(100);
//		Sound.playTone(698, 25);
//		Delay.msDelay(100);
//		Sound.playTone(659, 25);
//		Delay.msDelay(100);
//		Sound.playTone(622, 25);
//		Delay.msDelay(100);
//		Sound.playTone(659, 50);
//		Delay.msDelay(400);
//		Sound.playTone(415, 25);
//		Delay.msDelay(200);
//		Sound.playTone(554, 350);
//		Delay.msDelay(100);
//		Sound.playTone(523, 250);
//		Delay.msDelay(100);
//		Sound.playTone(493, 25);
//		Delay.msDelay(100);
//		Sound.playTone(466, 25);
//		Delay.msDelay(100);
//		Sound.playTone(440, 25);
//		Delay.msDelay(100);
//		Sound.playTone(466, 50);
//		Delay.msDelay(400);
//		Sound.playTone(311, 25);
//		Delay.msDelay(200);
//		Sound.playTone(369, 350);
//		Delay.msDelay(100);
//		Sound.playTone(311, 250);
//		Delay.msDelay(100);
//		Sound.playTone(392, 25);
//		Delay.msDelay(100);
//		Sound.playTone(466, 350);
//		Delay.msDelay(100);
//		Sound.playTone(392, 250);
//		Delay.msDelay(100);
//		Sound.playTone(466, 25);
//		Delay.msDelay(100);
//		Sound.playTone(587, 700);
//		Delay.msDelay(100);
//		Sound.playTone(784, 350);
//		Delay.msDelay(100);
//		Sound.playTone(392, 250);
//		Delay.msDelay(100);
//		Sound.playTone(392, 25);
//		Delay.msDelay(100);
//		Sound.playTone(784, 350);
//		Delay.msDelay(100);
//		Sound.playTone(739, 250);
//		Delay.msDelay(100);
//		Sound.playTone(698, 25);
//		Delay.msDelay(100);
//		Sound.playTone(659, 25);
//		Delay.msDelay(100);
//		Sound.playTone(622, 25);
//		Delay.msDelay(100);
//		Sound.playTone(659, 50);
//		Delay.msDelay(400);
//		Sound.playTone(415, 25);
//		Delay.msDelay(200);
//		Sound.playTone(554, 350);
//		Delay.msDelay(100);
//		Sound.playTone(523, 250);
//		Delay.msDelay(100);
//		Sound.playTone(493, 25);
//		Delay.msDelay(100);
//		Sound.playTone(466, 25);
//		Delay.msDelay(100);
//		Sound.playTone(440, 25);
//		Delay.msDelay(100);
//		Sound.playTone(466, 50);
//		Delay.msDelay(400);
//		Sound.playTone(311, 25);
//		Delay.msDelay(200);
//		Sound.playTone(392, 350);
//		Delay.msDelay(100);
//		Sound.playTone(311, 250);
//		Delay.msDelay(100);
//		Sound.playTone(466, 25);
//		Delay.msDelay(100);
//		Sound.playTone(392, 300);
//		Delay.msDelay(150);
//		Sound.playTone(311, 250);
//		Delay.msDelay(100);
//		Sound.playTone(466, 25);
//		Delay.msDelay(100);
//		Sound.playTone(392, 700);
//		Delay.msDelay(1500);
//	}
//
	
	
	
	
	
}
