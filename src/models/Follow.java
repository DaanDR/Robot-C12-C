package models;

import hardware.Engineblock;
import hardware.Lcd;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

public class Follow extends Trick {

	SensorMode seek = ir.getSeekMode(); // Make the ir sensor seek
	float[] sample = new float[seek.sampleSize()]; // create float[] to store beacon coordinates in sample

	// Constructor
	public Follow(Engineblock engineblock) {
		super(engineblock);
	}

	/**
	 * Find beacon locates the beacon (monster), drives towards it and makes slashing
	 * motion with arms Robot wins when five executive arm slashes have been
	 * executed Count to five starts again if beacon moves and has to be relocated
	 * If slashing starts and beacon moves closer, robot will back away
	 */

	public void findBeacon() {

		Lcd.print(1, "Monster Slayer");
		
		int victory = 0; // counter until robot has won
		final int MAX_HITS = 5; // Number of hits needed for robot to win
		final int START_OVER = 0; // Number of hits remaining when starting over

		while (Button.ESCAPE.isUp() && victory < MAX_HITS) {
			Lcd.clear(4);
			Lcd.print(4, "Strike: %d", victory);
			// determine position relative to beacon
			seek.fetchSample(sample, 0); // sample == coordinates of beacon
			int direction = (int) sample[0];
			Lcd.clear(2);
			Lcd.print(2, "Direction: " + direction); // make direction appear on screen
			int distance = (int) sample[1];
			Lcd.clear(3);
			Lcd.print(3, "Distance: " + distance); // make distance to beacon appear on screen
			
			// find and slash until victory
			if (direction >= 5) { // if direction > 0 robot turns left
				victory = START_OVER;
				motorA.setPower(0);
				motorB.setPower(-60);
			} else if (direction <= -5) { // if direction < 0 robot turns right
				victory = START_OVER;
				motorA.setPower(-60);
				motorB.setPower(0);
			} else if (distance > 45) { // when direction is set go forward
				victory = START_OVER;
				motorA.setPower(-60);
				motorB.setPower(-60);
			} else if (distance <= 45 && distance > 30) { // when close enough:
				motorA.setPower(0);
				motorB.setPower(0); // stop driving
				motorC.setPower(-70); // slash monster beacon
				Delay.msDelay(500);
				motorC.setPower(70); // pull arms up
				Delay.msDelay(500);
				victory++;
			} else if (distance <= 30) { // when too close: back away slowly
				victory = START_OVER;
				motorA.setPower(40);
				motorB.setPower(40);
			}
		}

		// Do victory dance + play victory music
		Lcd.print(5, "!! -VICTORY- !!");
		victoryDance();
		victoryMusic();

	}

	// Method do victory dance
	public void victoryDance() {
		Delay.msDelay(1000);
		Button.LEDPattern(7); // fast flash green led
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

	// Method with victory music
	public void victoryMusic() {
		// wave arm once
		motorC.setPower(70);
		Delay.msDelay(500);
		motorC.setPower(-70);
		// play music
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