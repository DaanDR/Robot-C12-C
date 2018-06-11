package models;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

public class Follow {

	// Constructor
	public Follow() {
		super();
	}

	// Attributen
	EV3IRSensor ir = new EV3IRSensor(SensorPort.S3);
	UnregulatedMotor left = new UnregulatedMotor(MotorPort.A);
	UnregulatedMotor right = new UnregulatedMotor(MotorPort.B);
	UnregulatedMotor motorC = new UnregulatedMotor(MotorPort.C);
	SensorMode seek = ir.getSeekMode();
	float[] sample = new float[seek.sampleSize()];

	public void findBeacon() {

		// Commentaar op scherm
		System.out.println("Monster slachter\n");

		// Start programma, straks in aparte methode
		Button.LEDPattern(4); // flash green led and
		Sound.beepSequenceUp(); // make sound when ready.
		System.out.println("Press any key to start");
		Button.waitForAnyPress();

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
				left.setPower(0);
				right.setPower(-60);
			} else if (direction <= -5) { // onder nul, auto gaat rechts
				victory = 0;
				left.setPower(-60);
				right.setPower(0);
			} else if (distance > 45) { // als richting bepaald is ga naar voren
				victory = 0;
				left.setPower(-60);
				right.setPower(-60);
			} else if (distance <= 45 && distance > 30) { // als je dichtbij genoeg bent:
				left.setPower(0);
				right.setPower(0); // stop met rijden
				motorC.setPower(-70); // hak in op monster beacon
				Delay.msDelay(500);
				motorC.setPower(70); // haal arm omhoog
				Delay.msDelay(500);
				victory++;
			} else if (distance <= 30) { // als té dichtbij: back away slowly
				victory = 0;
				left.setPower(40);
				right.setPower(40);
			}
		}

		// Victory dance
		Delay.msDelay(1000);
		Button.LEDPattern(7); // fast flash green led and
		left.setPower(80);
		right.setPower(80);
		Delay.msDelay(400);
		left.setPower(0);
		right.setPower(0);
		Sound.beepSequenceUp(); // make sound three times
		Sound.beepSequenceUp();
		Sound.beepSequenceUp();
		left.setPower(-80);
		right.setPower(60);
		Delay.msDelay(3000);
		left.setPower(0);
		right.setPower(0);
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
		Sound.playTone(392, 350);
		Delay.msDelay(100);
		Sound.playTone(311, 250);
		Delay.msDelay(100);
		Sound.playTone(466, 25);
		Delay.msDelay(100);
		Sound.playTone(392, 700);
		Delay.msDelay(100);
		Sound.playTone(587, 350);
		Delay.msDelay(100);
		Sound.playTone(587, 350);
		Delay.msDelay(100);
		Sound.playTone(587, 350);
		Delay.msDelay(100);
		Sound.playTone(622, 250);
		Delay.msDelay(100);
		Sound.playTone(466, 25);
		Delay.msDelay(100);
		Sound.playTone(369, 350);
		Delay.msDelay(100);
		Sound.playTone(311, 250);
		Delay.msDelay(100);
		Sound.playTone(466, 25);
		Delay.msDelay(100);
		Sound.playTone(392, 700);
		Delay.msDelay(100);
		Sound.playTone(784, 350);
		Delay.msDelay(100);
		Sound.playTone(392, 250);
		Delay.msDelay(100);
		Sound.playTone(392, 25);
		Delay.msDelay(100);
		Sound.playTone(784, 350);
		Delay.msDelay(100);
		Sound.playTone(739, 250);
		Delay.msDelay(100);
		Sound.playTone(698, 25);
		Delay.msDelay(100);
		Sound.playTone(659, 25);
		Delay.msDelay(100);
		Sound.playTone(622, 25);
		Delay.msDelay(100);
		Sound.playTone(659, 50);
		Delay.msDelay(400);
		Sound.playTone(415, 25);
		Delay.msDelay(200);
		Sound.playTone(554, 350);
		Delay.msDelay(100);
		Sound.playTone(523, 250);
		Delay.msDelay(1500);

		// End program
		left.close();
		right.close();
		ir.close();
		// heeft ook eigen methode?
		Sound.beepSequence();

	}

}