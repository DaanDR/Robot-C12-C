package models;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

public class InfraredBeaconFinder {



	public static void main(String[] args) {


		EV3IRSensor ir = new EV3IRSensor(SensorPort.S3);
		UnregulatedMotor left = new UnregulatedMotor(MotorPort.A);
		UnregulatedMotor right = new UnregulatedMotor(MotorPort.B);
		UnregulatedMotor motorC = new UnregulatedMotor(MotorPort.C);

		SensorMode seek = ir.getSeekMode();
		float[] sample = new float[seek.sampleSize()];
		
		System.out.println("IR Seeker\n");

		Button.LEDPattern(4); // flash green led and
		Sound.beepSequenceUp(); // make sound when ready.

		System.out.println("Press any key to start");

		Button.waitForAnyPress();

		while (Button.ESCAPE.isUp()) {
			seek.fetchSample(sample, 0);
			int direction = (int) sample[0];
			System.out.println("Direction: " + direction);
			int distance = (int) sample[1];
			System.out.println("Distance: " + distance);

			if (direction >= 5) { // als de richting boven nul is gaat de auto naar links
				left.setPower(0);
				right.setPower(-80);

			} else if (direction <= -5) { // onder nul, auto gaat rechts
				left.setPower(-80);
				right.setPower(0);
			} else if (distance > 40) { // als de afstand
				left.setPower(-80);
				right.setPower(-80);
			} else if (distance < 40) {
				// } else if (distance < 40 && (direction < 1 && direction > -1)){
				// } else if ((distance >= 20 && distance <= 40) && (direction <10 && direction
				// > -10)){
				left.setPower(0);
				right.setPower(0);
				motorC.setPower(-70);
				Delay.msDelay(500);
				motorC.setPower(70);
				Delay.msDelay(500);
				motorC.setPower(-70);

			}
		}

		left.close();
		right.close();
		ir.close();
	}
}
