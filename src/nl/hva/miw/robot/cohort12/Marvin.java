
package nl.hva.miw.robot.cohort12;

import hardware.Engineblock;
import hardware.Lcd;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import models.*;

public class Marvin {

	public static void main(String[] args) {
		
		
		// Engage motors and sensors
		Engineblock engineblock1 = new Engineblock();
		engineblock1.startEngines();

		
		// Menu
		Sound.beepSequenceUp(); // make sound when ready.
		Lcd.clear();
		Lcd.print(1, "Maak een keuze tussen:");
		Lcd.print(2, "<  Volg een lijn");
		Lcd.print(3, "[] Speel muziek");
		Lcd.print(4, ">  Val aan");
				
		// Choose one of three functions
		Button.waitForAnyPress();
		Lcd.clear();
		if(Button.LEFT.isDown()) {
			
			/**
			 * Task # 1: Follow line - Robot follows a black on white line trail
			 */
			
			LineFollower lijnvolger = new LineFollower(engineblock1);
			lijnvolger.startProgram();
			lijnvolger.followLine();
			lijnvolger.stopProgram();
			
		} else if(Button.ENTER.isDown()) {
			
			/**
			 * Task # 2: Drive With Music - Robot drives over strip of colors, playing a
			 * specific note for each color.
			 */
			
			DriveWithMusic seven = new DriveWithMusic(engineblock1, new Scale("sevennation"));
			seven.startProgram();
			seven.driveWithColor();
			seven.stopProgram();
			
		} else if(Button.RIGHT.isDown()) {
			
			/**
			 * Task # 3: Slay Monster - Robot finds and follows beacon and
			 * moves arm when close enough. If arm is moved 5 times, robot wins and
			 * does victory dance.
			*/
			 
			Follow shinyKnight = new Follow(engineblock1);
			shinyKnight.startProgram();
			shinyKnight.findBeacon();
			shinyKnight.stopProgram();	
		}


		// Close motors and sensors
		engineblock1.closeEngines();

	}
}