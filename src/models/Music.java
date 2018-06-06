package models;

import java.util.Arrays;

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
	private String selectedScale;
	
	private final static int A = 440;
	private final static int A_SHARP = 466;
	private final static int B = 493;
	private final static int C = 523;
	private final static int C_SHARP = 554;
	private final static int D = 587;
	private final static int D_SHARP = 622;
	private final static int E = 659;
	private final static int F = 698;
	private final static int F_SHARP = 739;
	private final static int G = 783;
	private final static int G_SHARP = 830;
	
	private final static int[] A_SCALE = {A, B, C_SHARP, D, E, F_SHARP, G_SHARP};
	private final static int[] B_SCALE = {B, C_SHARP, D_SHARP, E, F_SHARP, G_SHARP, A_SHARP};
	private final static int[] C_SCALE = {C, D, E, F, G, A, B, C};
	private final static int[] D_SCALE = {D, E, F_SHARP, G, A, B, C_SHARP};
	private final static int[] E_SCALE = {E, F_SHARP, G_SHARP, A, B, C_SHARP, D_SHARP};
	private final static int[] F_SCALE = {F, G, A, A_SHARP, C, D, E};
	private final static int[] G_SCALE = {G, A, B, C, D, E, F_SHARP};
	
	private final static int SCALE_LENGTH = 7;
	
	private static int[] selectedScaleString;

	
	public Music(String selectedScale) {
		super();
		this.color = new ColorSensor(SensorPort.S4);
		this.selectedScale = selectedScale;
		this.selectScale();
	}
	
	private void selectScale() {
		
		// kopieert de juiste scale naar de selectedScaleString
		
		switch(this.selectedScale) {
			case "a":
			selectedScaleString = Arrays.copyOf(A_SCALE, SCALE_LENGTH);
			break;
			case "b":
			selectedScaleString = Arrays.copyOf(B_SCALE, SCALE_LENGTH);			
			break;
			case "c":
			selectedScaleString = Arrays.copyOf(C_SCALE, SCALE_LENGTH);			
			break;
			case "d":
			selectedScaleString = Arrays.copyOf(D_SCALE, SCALE_LENGTH);			
			break;
			case "e":
			selectedScaleString = Arrays.copyOf(E_SCALE, SCALE_LENGTH);			
			break;
			case "f":
			selectedScaleString = Arrays.copyOf(F_SCALE, SCALE_LENGTH);			
			break;
			case "g":
			selectedScaleString = Arrays.copyOf(G_SCALE, SCALE_LENGTH);			
			break;
			default:
			selectedScaleString = Arrays.copyOf(A_SCALE, SCALE_LENGTH);		
		}
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
            
            // herkent de kleuren op basis van de eerste waarde (rood) van de rgb code
            // en speelt de juiste noot uit de selectedScaleString array
            
            int kleur = rgb.getRed();
            
            if(kleur >= 4 && kleur <= 6) {                    //black
            	Sound.playTone(selectedScaleString[0], 350);
            } else if(kleur >= 15 && kleur <= 17) {           //blue
            	Sound.playTone(selectedScaleString[1], 350);
            } else if(kleur >= 57 && kleur <= 62) {           //red
            	Sound.playTone(selectedScaleString[2], 350);
            }
            
            
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
