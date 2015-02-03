package com.team1168robotics;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.DigitalInput;

public class Lift {
	public static Solenoid armsOut;
	public static Solenoid armsIn;
	public static Jaguar winch = new Jaguar(4);
	public static DigitalInput lsb = new DigitalInput(9);
	public static DigitalInput lst;
	
	
	/**
	 * Lifts the tote
	 */
	public static void tote() {
		boolean liftSys = lsb.get();
		if(liftSys == false){
			freeMotion();
		}
		if(liftSys == true) {
			restrictedToUp();
		}
	}
	
	private static void restrictedToUp() {
		if(Robot.opCon.getRawAxis(1) < 0) {
			winch.set(0);
		} else {
			winch.set(Robot.opCon.getRawAxis(1));
		}
	}

	/**
	 * Opens or closes the lifting arms
	 */
	public static void arms() {
		if(Robot.opCon.getRawButton(2)){
			armsIn.set(true);
			armsOut.set(false);
		} else if(Robot.opCon.getRawButton(3)) {
			armsIn.set(false);
			armsOut.set(true);
		}
	}
	
	public static void freeMotion() {
		winch.set(Robot.opCon.getRawAxis(1));
	}
	
	/**
	 * Lifts the recycling bin
	 */
	public static void bin() {
		//TODO: Implement lifting mechanism
	}

}