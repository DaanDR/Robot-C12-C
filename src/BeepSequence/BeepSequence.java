package BeepSequence;

import lejos.hardware.Button;
import lejos.hardware.Key;
import lejos.hardware.KeyListener;
import lejos.hardware.Sound;
import lejos.utility.Delay;

public class BeepSequence {

	public static void main(String[] args) {

//		Button.LEFT.addKeyListener(new KeyListener() {
//			@Override
//			public void keyReleased(Key k) {
//				Button.LEDPattern(3); // static yellow led
//				twinkle();
//				Sound.beepSequence(); // we are done.
//			}
//			@Override
//			public void keyPressed(Key k) {
//			}
//		});
//
//		Button.RIGHT.addKeyListener(new KeyListener() {
//			@Override
//			public void keyReleased(Key k) {
//				Button.LEDPattern(5); // flash red led
//				starWars();
//				Sound.beepSequence(); // we are done.
//			}
//			@Override
//			public void keyPressed(Key k) {
//			}
//		});

		System.out.println("Play melody\n");
		System.out.println("Press left for Twinkle");
		System.out.println("Press right for StarWars");

		Button.LEDPattern(4); // flash green led and
		Sound.beepSequenceUp(); // make sound when ready.

		Button.waitForAnyPress();
		
		Button.LEDPattern(5); // flash red led

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

		
		Sound.beepSequence(); // we are done.

	}
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
//}
