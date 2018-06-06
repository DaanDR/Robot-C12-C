//package nl.hva.miw.robot.cohort12;
//
//import lejos.hardware.Brick;
//import lejos.hardware.Button;
//import lejos.hardware.Key;
//import lejos.hardware.ev3.LocalEV3;
//import lejos.hardware.lcd.TextLCD;
//import lejos.utility.Delay;
//
//public class Marvin {
//	
//	Brick brick;
//	
//	public Marvin() {
//		super();
//		brick = LocalEV3.get();
//	}
//	
//	public static void main(String[] args) {
//		Marvin marvin = new Marvin();
//		marvin.run();
//	}
//	
//	private void run() {
//		TextLCD display = brick.getTextLCD();
//		display.drawString("Welkom!", 0, 3);
//		display.drawString("Team C", 0, 4);
//		waitForKey(Button.ENTER);
//	}
//	
//	public void waitForKey(Key key) {
//		while(key.isUp()) {
//			Delay.msDelay(100);
//		}
//		while(key.isDown()) {
//			Delay.msDelay(100);
//		}
//	}
//}
//
//package nl.hva.miw.robot.cohort12;
//
//import lejos.hardware.Button;
//import lejos.hardware.Sound;
//import lejos.hardware.motor.*;
//import lejos.hardware.port.*;
//import lejos.utility.Delay;
//
//public class Marvin
//{
//    public static void main(String[] args)
//    {
//        System.out.println("Drive Forward\nand Stop\n");
//        System.out.println("Press any key to start");
//
//        Button.LEDPattern(4);     // flash green led and
//        Sound.beepSequenceUp();   // make sound when ready.
//
//        Button.waitForAnyPress();
//
//        // create two motor objects to control the motors.
//        UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
//        UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);
//
//        // set motors to 50% power.
//        motorA.setPower(50);
//        motorB.setPower(50);
//
//        // wait 2 seconds.
//        Delay.msDelay(1000);
//
////        // stop motors with brakes on. 
////        motorA.stop();
////        motorB.stop();
////        
//        // set motors to 50% power.
//        motorA.setPower(10);
//        motorB.setPower(80);
//
//        // wait 2 seconds.
//        Delay.msDelay(1000);
//
////        // stop motors with brakes on. 
////        motorA.stop();
////        motorB.stop();
////        
//        // set motors to 50% power.
//        motorA.setPower(80);
//        motorB.setPower(10);
//
//        // wait 2 seconds.
//        Delay.msDelay(1000);
//
//        // stop motors with brakes on. 
//        motorA.stop();
//        motorB.stop();
//        // free up motor resources. 
//        motorA.close(); 
//        motorB.close();
// 
//        Sound.beepSequence(); // we are done.
//    }
//}
package nl.hva.miw.robot.cohort12;

import lejos.hardware.Brick;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.robotics.Color;
import ev3.exercises.library.*;

public class Marvin 

{ 

	
    static UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
    static UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);
    static ColorSensor        color = new ColorSensor(SensorPort.S4);
    
    public static void main(String[] args)
    {
        float    colorValue;
        
        System.out.println("Line Follower\n");
        
        color.setRedMode();
        color.setFloodLight(Color.RED);
        color.setFloodLight(true);

        Button.LEDPattern(4);    // flash green led and 
        Sound.beepSequenceUp();  // make sound when ready.

        System.out.println("Press any key to start");
        
        Button.waitForAnyPress();
       
        motorA.setPower(10);
        motorB.setPower(10);
       
        // drive waiting for escape key to stop driving.

        while (Button.ESCAPE.isUp()) 
        {
            colorValue = color.getRed();
            
            Lcd.clear(7);
            Lcd.print(7,  "value=%.3f", colorValue);

            if (colorValue > .120)
            {
                motorA.setPower(40);
                motorB.setPower(10);
            }
            else
            {
                motorA.setPower(10);    
                motorB.setPower(40);
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
}
