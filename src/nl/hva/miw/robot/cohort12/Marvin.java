
package nl.hva.miw.robot.cohort12;

import hardware.Engineblock;
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
		System.out.printf("Maak een keuze tussen:\n"
							+ "<  Volg een lijn\n"
							+ "[] Speel muziek\n"
							+ ">  Val aan");
		
		
		// Maak een keuze tussen de drie functies
		Button.waitForAnyPress();
		if(Button.LEFT.isDown()) {
			
			/**
			 * Task # 1: Follow line Robot follows a black on white line parcours
			 * Stand-alone program: engages and closes engines
			 */
			
			LineFollower lijnvolger = new LineFollower(engineblock1);
			lijnvolger.startProgram();
			lijnvolger.followLine();
			lijnvolger.stopProgram();
			
		} else if(Button.ENTER.isDown()) {
			
			/**
			 * Task # 2: Drive With Music Robot drives over strip of colors, playing a
			 * specific note for each color Task # 3: Slay Monster Robot finds and follows
			 * beacon, moves arm when close enough If arm is moved 5 times, robot wins and
			 * does victory dance Both tasks use the same engineblock.
			 */
			
			DriveWithMusic seven = new DriveWithMusic(engineblock1, new Scale("sevennation"));
			seven.startProgram();
			seven.driveWithColor();
			seven.stopProgram();
			
		} else if(Button.RIGHT.isDown()) {
			
			// Task # 3: Slay monster
			
			Follow shinyKnight = new Follow(engineblock1);
			shinyKnight.startProgram();
			shinyKnight.findBeacon();
			shinyKnight.stopProgram();	
		}

		// Close motors and sensors
		engineblock1.closeEngines();

	}
}