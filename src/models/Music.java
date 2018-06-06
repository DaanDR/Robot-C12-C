package models;

import lejos.hardware.Button;
import lejos.hardware.Key;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;
import lejos.utility.Delay;
import lejos.hardware.Sound;

import models.ColorSensor;
import models.Lcd;

public class Music {
		
	private ColorSensor color;
		

	public Music() {
		super();
		this.color = new ColorSensor(SensorPort.S4 );
	}




	public void makeMusic() {
        
		

        System.out.println("Color Demo");
        Lcd.print(2, "Press to start");
        
        Button.LEDPattern(4);    // flash green led and
        Sound.beepSequenceUp();    // make sound when ready.

        Button.waitForAnyPress();
        Button.LEDPattern(0);
        
        // run until escape button pressed.
        
        while (Button.ESCAPE.isUp())
        {
            Lcd.clear(4);
            Lcd.print(4, "ambient=%.3f", color.getAmbient());
            Delay.msDelay(250);
        }

        Delay.msDelay(1000);

        color.setRedMode();
        color.setFloodLight(Color.RED);
        color.setFloodLight(true);
        
        while (Button.ESCAPE.isUp())
        {
            Lcd.clear(5);
            Lcd.print(5, "red=%.3f", color.getRed());
            Delay.msDelay(250);
        }

        Delay.msDelay(1000);

        color.setRGBMode();
        color.setFloodLight(Color.WHITE);
        
        Color rgb;
        
        while (Button.ESCAPE.isUp())
        {
            rgb = color.getColor();
            
            Lcd.clear(6);
            Lcd.print(6, "r=%d g=%d b=%d", rgb.getRed(), rgb.getGreen(), rgb.getBlue());
            Delay.msDelay(250);
        }

        Delay.msDelay(1000);

        color.setColorIdMode();
        color.setFloodLight(false);
        
        while (Button.ESCAPE.isUp())
        {
            Lcd.clear(7);
            Lcd.print(7, "id=%s", ColorSensor.colorName(color.getColorID()));
            Delay.msDelay(250);
            
            String kleur = ColorSensor.colorName(color.getColorID());
            
//            
//            if(kleur == "Red") {
//            	Sound.playTone(392, 350);
//            } else if(kleur == "Black") {
//            	Sound.playTone(311, 350);
//            }
            
            switch(kleur) {
            	case "Red":
            		Sound.playTone(523, 350);
            		break;
            	case "Black":
            		Sound.playTone(587, 350);
            		break;
            	case "Blue":
            		Sound.playTone(659, 350);
            		break;	
            }
            
            
        }

        // free up resources.
        color.close();
        
        Sound.beepSequence();    // we are done.

        Button.LEDPattern(4);
        Button.waitForAnyPress();
    }


}
