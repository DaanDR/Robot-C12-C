
package nl.hva.miw.robot.cohort12;

import models.*;

public class Marvin { 
	 
    public static void main(String[] args) {
   	//lijnvolger oproepen (voor parcour)
    LineFollower lijnvolger = new LineFollower(); 
    lijnvolger.followLine();
   	
//   	Scale scale = new Scale("sevennation");
//   	
//    DriveWithMusic muziekDemo = new DriveWithMusic(scale);
//    muziekDemo.driveWithColor();

    }
}