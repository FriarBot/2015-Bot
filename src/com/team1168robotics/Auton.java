package com.team1168robotics;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Auton {
	
	/**
	 * Initializes data members
	 */
	public static void init(){
		
	}
	
	/**
	 * Strictly uses time delays to determine when to move own to the next step
	 */
	public static void zone() {
		Drive.auton(.5, .5);
		Timer.delay(SmartDashboard.getNumber("Initial Delay"));
		Drive.auton(0, 0);
		Lift.auton(1);
		Timer.delay(SmartDashboard.getNumber("Lift Delay"));
		Lift.auton(0);
		Drive.auton(.5, -.5);
		Timer.delay(SmartDashboard.getNumber("Turn Delay"));
		Drive.auton(.75, .75);
		Timer.delay(SmartDashboard.getNumber("Final Delay"));
		Drive.auton(0, 0);
	}
}
