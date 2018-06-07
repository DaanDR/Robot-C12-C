package nl.hva.miw.robot.cohort12;

import lejos.hardware.Brick;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.robotics.Color;
import models.*;
import ev3.exercises.library.*;

public class Marvin 

{ 
	 
    public static void main(String[] args)
    {
    
//    	LineFollower lijnvolger = new LineFollower();
//    	lijnvolger.followLine();
    	
    	//LineFollowerExtensive lijnvolger2 = new LineFollowerExtensive();
    	//lijnvolger2.followLineextensive();
    	
//    	Music muziek = new Music("c");
//    	muziek.makeMusic();
//    	
    	
    	DriveWithMusic muziekDemo = new DriveWithMusic();
    	muziekDemo.driveWithMusic();
    	
    }
}