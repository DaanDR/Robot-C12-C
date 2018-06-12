
package nl.hva.miw.robot.cohort12;

import hardware.Engineblock;
import models.*;

public class Marvin {

	public static void main(String[] args) {

		/**
		 * Task # 1: Follow line Robot follows a black on white line parcours
		 * Stand-alone program: engages and closes engines
		 */

		// Engage motors and sensors
		Engineblock engineblock1 = new Engineblock();
		engineblock1.startEngines();

		// Follow line
		LineFollower lijnvolger = new LineFollower(engineblock1);
		lijnvolger.startProgram();
		lijnvolger.followLine();
		lijnvolger.stopProgram();

		// Close motors and sensors
//		engineblock1.closeEngines();

		/**
		 * Task # 2: Drive With Music Robot drives over strip of colors, playing a
		 * specific note for each color Task # 3: Slay Monster Robot finds and follows
		 * beacon, moves arm when close enough If arm is moved 5 times, robot wins and
		 * does victory dance Both tasks use the same engineblock.
		 */

		// Engage motors and sensors
		// Engineblock engineblock2 = new Engineblock();
		// engineblock2.startEngines();

		// Task # 1: Drive with music

		DriveWithMusic seven = new DriveWithMusic(engineblock1, new Scale("sevennation"));
		seven.startProgram();
		seven.driveWithColor();
		seven.stopProgram();


		// Tast # 2: Slay monster
		Follow shinyKnight = new Follow(engineblock1);
		shinyKnight.startProgram();
		shinyKnight.findBeacon();
		shinyKnight.stopProgram();

		// Close motors and sensors
		engineblock1.closeEngines();

	}
}