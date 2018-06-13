package models;

import hardware.Engineblock;
import hardware.Lcd;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

public class Follow extends Trick {

	SensorMode seek = ir.getSeekMode(); // ??
	float[] sample = new float[seek.sampleSize()]; // ??

	// Constructor
	public Follow(Engineblock engineblock) {
		super(engineblock);
		// this.seek = ir.getSeekMode();
		// this.sample = new float[seek.sampleSize()];
	}

	/**
	 * Find beacon locates the beacon (monster), drives towards it and makes slashing
	 * motion with arms Robot wins when five executive arm slashes have been
	 * executed Count to five starts again if beacon moves and has to be relocated
	 * If slashing starts and beacon moves closer, robot will back away
	 */

	public void findBeacon() {

		// Commentaar op scherm
		Lcd.print(2, "Monster Slayer");
		
		// counter voor wanneer robot gewonnen
		int victory = 0;

		while (Button.ESCAPE.isUp() && victory < 5) {

			Lcd.print(4, "Strike: %d", victory);
			// bepaal positie tov sensor
			seek.fetchSample(sample, 0); // sample == co�rdinaten van beacon??
			int direction = (int) sample[0];
			System.out.println("Direction: " + direction); // zorg dat richting op scherm verschijnt
			int distance = (int) sample[1];
			System.out.println("Distance: " + distance); // zorg dat distance tot aan de beacon op scherm verschijnt

			// find and slash until victory
			if (direction >= 5) { // als de richting boven nul is gaat de auto naar links
				victory = 0;
				motorA.setPower(0);
				motorB.setPower(-60);
			} else if (direction <= -5) { // onder nul, auto gaat rechts
				victory = 0;
				motorA.setPower(-60);
				motorB.setPower(0);
			} else if (distance > 45) { // als richting bepaald is ga naar voren
				victory = 0;
				motorA.setPower(-60);
				motorB.setPower(-60);
			} else if (distance <= 45 && distance > 30) { // als je dichtbij genoeg bent:
				motorA.setPower(0);
				motorB.setPower(0); // stop met rijden
				motorC.setPower(-70); // hak in op monster beacon
				Delay.msDelay(500);
				motorC.setPower(70); // haal arm omhoog
				Delay.msDelay(500);
				victory++;
			} else if (distance <= 30) { // als t� dichtbij: back away slowly
				victory = 0;
				motorA.setPower(40);
				motorB.setPower(40);
			}
		}

		// roep methodes aan Dans + muziek
		Lcd.print(5, "!! -VICTORY- !!");
		victoryDance();
		victoryMusic();

	}

	public void victoryDance() {
		Delay.msDelay(1000);
		Button.LEDPattern(7); // fast flash green led and
		motorA.setPower(80);
		motorB.setPower(80);
		Delay.msDelay(600);
		motorA.setPower(0);
		motorB.setPower(0);
		motorA.setPower(-90);
		motorB.setPower(90);
		Delay.msDelay(2500);
		motorA.setPower(0);
		motorB.setPower(0);

	}

	// methode met victory muziek
	public void victoryMusic() {
		// zwaait 1 keer met arm
		motorC.setPower(70);
		Delay.msDelay(500);
		motorC.setPower(-70);
		// speel muziek
		Delay.msDelay(1000);
		Sound.playTone(784, 100);
		Delay.msDelay(100);
		Sound.playTone(784, 50);
		Delay.msDelay(100);
		Sound.playTone(784, 50);
		Delay.msDelay(100);
		Sound.playTone(784, 100);
		Delay.msDelay(100);

		Sound.playTone(880, 100);
		Delay.msDelay(100);
		Sound.playTone(784, 100);
		Delay.msDelay(100);
		Sound.playTone(880, 100);
		Delay.msDelay(100);

		Sound.playTone(988, 800);
		Delay.msDelay(2000);
	}

}