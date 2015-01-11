package com.team1168robotics;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Xbox controller axis index:
 * 
 * LeftY: 2
 * LeftX: 1
 * RightY: 5
 * RightX: 4
 * D-Pad: 6
 * Triggers: 3
 * 
 * Button index:
 * 
 * A: 1
 * B: 2
 * X: 3
 * Y: 4
 * LB: 5
 * RB: 6
 * Back: 7
 * Start: 8
 * LS: 9
 * RS: 10
 */

public class Drive {
    
    private static Talon rightF;
    private static Talon rightB;
    private static Talon leftF;
    private static Talon leftB;
    private static int driveSys;  
    
    /**
     * Initializes the data members
     */
    public static void init(){
        rightF = new Talon(0);
        rightB = new Talon(1);
        leftF = new Talon(2);
        leftB = new Talon(3);
        driveSys = 0;
    }
    
    /**
     * Sums the three states of robot movement (Forward/Backward, Rotate Left/Right, and Strafe Left/Right)
     * then limits the values to be acceptable by the Talon set() method
     * @param controller The Joystick object the Xbox controller is hooked up to
     */    
    private static void mecanum(Joystick controller){
        double leftY = controller.getRawAxis(2);
        double rightX = controller.getRawAxis(4);
        double leftX = controller.getRawAxis(1);
        
        setRightF(leftY - rightX - leftX);
        setRightB(leftY - rightX + leftX);
        setLeftF(leftY + rightX + leftX);
        setLeftB(leftY + rightX - leftX);        
    }
    
    /**
     * Simple tank drive
     * @param controller The Joystick object the Xbox controller is hooked up to
     */    
    private static void tank(Joystick controller) {
        double leftY = controller.getRawAxis(2);
        double rightY = controller.getRawAxis(5);
        rightF.set(rightY);
        rightB.set(rightY);
        leftF.set(leftY);
        leftB.set(leftY);
    }
    
    /**
     * Switches between the tank and mecanum methods of driving
     * Uses an int for expansion ability if more driving systems are added
     * @param controller The Joystick object the Xbox controller is hooked up to
     */
    public static void driveSys(Joystick controller){
        if(controller.getRawButton(1)){
            driveSys++;
        }
        if(driveSys > 1){
            driveSys = 0;
        }
        driveOpt(controller);
    }
    
    /**
     * Determines which drive system to use based on the value of driveSys
     * @param controller The Joystick object the Xbox controller is hooked up to
     */
    private static void driveOpt(Joystick controller) {
        if(driveSys == 0){
            mecanum(controller);
        } else if (driveSys == 1) {
            tank(controller);
        }
    }
    
    /**
     * Sets the rightF Talon controller
     * @param rightFVal Raw Joystick input
     */
    private static void setRightF(double rightFVal){
    	 if(rightFVal > 1) {
             rightF.set(1);
         } else if (rightFVal < -1){
             rightF.set(-1);
         } else {
             rightF.set(rightFVal);
         }
    }
    
    /**
     * Sets the rightB Talon motor controller
     * @param rightBVal Raw Joystick input
     */
    private static void setRightB(double rightBVal){
    	if(rightBVal > 1) {
            rightB.set(1);
        } else if(rightBVal < -1) {
            rightB.set(-1);
        } else {
            rightB.set(rightBVal);
        }
    }
    
    /**
     * Sets the leftF Talon motor controller
     * @param leftFVal Raw Joystick input
     */
    private static void setLeftF(double leftFVal){
    	if (leftFVal > 1) {
            leftF.set(1);
        } else if (leftFVal < -1) {
            leftF.set(-1);
        } else {
            leftF.set(leftFVal);
        }
    }
    
    /**
     * Sets the leftB Talon motor controller
     * @param leftBVal Raw Joystick input
     */
    private static void setLeftB(double leftBVal){
    	if (leftBVal > 1) {
            leftB.set(1);
        } else if (leftBVal < -1) {
            leftB.set(-1);
        } else {
            leftB.set(leftBVal);
        }
    }
    
    public static void auton(double left, double right) {
    	rightF.set(right);
        rightB.set(right);
        leftF.set(left);
        leftB.set(left);
    }
    
}