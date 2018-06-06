package models;

import java.io.IOException;
import lejos.hardware.video.Video;
import lejos.hardware.video.YUYVImage;
import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.hardware.lcd.GraphicsLCD;

public class LineFollowerExtensive {
	private static int x = 1;
	private static int y = 119;
	private static int line = 0;
	private static int brl = 0;
	private static int brr = 0;
	private static int integral = 0;
	private static int brightness = 0;
	private static boolean got = false;
	private static char a = 0;
	private static int xle = 0;
	private static int xri = 0;
	private static int target = 0;
	private static int xup = 0;
	private static int xdo = 0;
	private static int meanbr = 0;
	private static int minus = 150;
	private static int d = 0;
	private static int dold = 0;
	private static int diff = 0;
	private static int prop = 0;

	public LineFollowerExtensive() {
		super();
	}

	public void followLineextensive() {
		try {
			Video wc = BrickFinder.getDefault().getVideo();
			wc.open(160, 120);
			byte[] frame = wc.createFrame();
			YUYVImage img = new YUYVImage(frame, 160, 120);
			GraphicsLCD g = BrickFinder.getDefault().getGraphicsLCD();
			Sound.beepSequenceUp();
			Button.LEDPattern(3);
			Button.waitForAnyPress();
			wc.grabFrame(frame);
			meanbr = img.getMeanY();
			System.out.println(meanbr);
			Sound.beepSequence();
			Button.LEDPattern(1);
			while (Button.ENTER.isUp()) {
				wc.grabFrame(frame);
				img.display(g, 0, 0, meanbr - 50);
			}

			while (true) {
				got = false;
				brl = 0;
				brr = 0;
				wc.grabFrame(frame);
				y = 1;
				while (y < 120 && got == false) {
					x = 1;
					while (x < 160 && got == false) {

						if (img.getY(x, y) > 0 && img.getY(x, y) < meanbr - 50) {
							xle = x;
						}
						x = x + 2;
					}
					y = y + 2;
				}
				y = 1;
				got = false;
				while (y < 120 && got == false) {
					x = 159;
					while (x > 0 && got == false) {
						if (img.getY(x, y) > 0 && img.getY(x, y) < meanbr - 50) {
							xri = x;
							got = true;
						}
						x = x - 2;
					}
					y = y + 2;
				}

				xup = 80 - (xri + xle) / 2;

				target = xup;
				d = target;
				diff = (int) ((d - dold) * 1.5);
				prop = (int) (target * 1.5);
				if (java.lang.Math.abs(integral) < 70) {

					integral = integral + target / 3;
				} else {

					if (integral > 0)
						integral = integral - 10;
					if (integral < 0)
						integral = integral + 10;
				}
				//motor A was B, motor B was C
				Motor.A.setSpeed((700 - minus) - (int) ((prop + integral + diff) * 1.2));
				Motor.B.setSpeed((700 - minus) + (int) ((prop + integral + diff) * 1.2));
				Motor.A.backward();
				Motor.B.backward();

				dold = d;
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Driver exception: " + ioe.getMessage());
		}
	}

}
