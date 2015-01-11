package com.team1168robotics;

import edu.wpi.first.wpilibj.Ultrasonic;

public class Auton {
	
	private static Ultrasonic ultra;
	private static final boolean UP = true;
	private static final boolean DOWN = false;
	
	/**
	 * Initializes data members
	 */
	public static void init(){
		ultra = new Ultrasonic(9, 8, Ultrasonic.Unit.kInches);
	}
	
	/**
	 * Uses sensors to determine when to move on to the next step 
	 */
	public static void reactive() {
		while(ultra.getRangeInches() > 12) {
			Drive.auton(.75, .75);
		}
		Lift.tote(UP);
		Drive.auton(-.75, -.75);
		Lift.tote(DOWN);
		Drive.auton(-1, -.5);
	}
	
	/**
	 * Strictly uses time delays to determine when to move own to the next step
	 */
	public static void hard() {
		
	}
}
