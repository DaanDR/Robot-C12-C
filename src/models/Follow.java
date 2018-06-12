package models;

import hardware.Engineblock;
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
//		this.seek = ir.getSeekMode();
//		this.sample = new float[seek.sampleSize()];
	}

	/**
	 * Find beacon
	 * Finds beacon (monster), drives towards it and makes slashing motion with arms
	 * Robot wins when five executive arm slashes have been executed
	 * Count to five starts again if beacon moves and has to be relocated
	 * If slashing starts and beacon moves closer, robot will back away
	 */
	
	public void findBeacon() {

		// Commentaar op scherm
		System.out.println("Monster slachter\n");
		startProgram();

		// counter voor wanneer robot gewonnen
		int victory = 0;

		while (Button.ESCAPE.isUp() && victory < 5) {

			// bepaal positie tov sensor
			seek.fetchSample(sample, 0); // sample == coördinaten van beacon??
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
			} else if (distance <= 30) { // als té dichtbij: back away slowly
				victory = 0;
				motorA.setPower(40);
				motorB.setPower(40);
			}
		}

		victoryDance();
		
	}

	
	
	// Victory dance
	protected void victoryDance() {
		Delay.msDelay(1000);
		Button.LEDPattern(7); // fast flash green led and
		motorA.setPower(80);
		motorB.setPower(80);
		Delay.msDelay(400);
		motorA.setPower(0);
		motorB.setPower(0);
		Sound.beepSequenceUp(); // make sound three times
		Sound.beepSequenceUp();
		Sound.beepSequenceUp();
		motorA.setPower(-80);
		motorB.setPower(60);
		Delay.msDelay(3000);
		motorA.setPower(0);
		motorB.setPower(0);
		Delay.msDelay(500);
		Sound.playTone(392, 350);
		Delay.msDelay(100);
		Sound.playTone(392, 350);
		Delay.msDelay(100);
		Sound.playTone(392, 350);
		Delay.msDelay(100);
		Sound.playTone(311, 250);
		Delay.msDelay(100);
		Sound.playTone(466, 25);
		Delay.msDelay(100);
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
		Delay.msDelay(1500);
	}

}