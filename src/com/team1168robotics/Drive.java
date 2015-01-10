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
    
    public static void init(){
        rightF = new Talon(0);
        rightB = new Talon(1);
        leftF = new Talon(2);
        leftB = new Talon(3);
        driveSys = 0;
    }
    
    private static void mecanum(Joystick controller){
        double leftY = controller.getRawAxis(2);
        double rightX = controller.getRawAxis(4);
        double leftX = controller.getRawAxis(1);
        
        if(leftY - rightX - leftX > 1) {
            rightF.set(1);
        } else if (leftY - rightX - leftX < -1){
            rightF.set(-1);
        } else {
            rightF.set(leftY - rightX - leftX);
        }
        if(leftY - rightX + leftX > 1) {
            rightB.set(1);
        } else if(leftY - rightX + leftX < -1) {
            rightB.set(-1);
        } else {
            rightB.set(leftY - rightX + leftX);
        }
        
        if (leftY + rightX + leftX > 1) {
            leftF.set(1);
        } else if (leftY + rightX + leftX < -1) {
            leftF.set(-1);
        } else {
            leftF.set(leftY + rightX + leftX);
        }
        
        if (leftY + rightX - leftX > 1) {
            leftB.set(1);
        } else if (leftY + rightX - leftX < -1) {
            leftB.set(-1);
        } else {
            leftB.set(leftY + rightX - leftX);
        }
    }
    
    private static void tank(Joystick controller) {
        double leftY = controller.getRawAxis(2);
        double rightY = controller.getRawAxis(5);
        rightF.set(rightY);
        rightB.set(leftY);
    }
    
    public static void driveSys(Joystick controller){
        if(controller.getRawButton(1)){
            driveSys++;
        }
        if(driveSys > 1){
            driveSys = 0;
        }
        driveOpt(controller);
    }
    
    private static void driveOpt(Joystick controller) {
        if(driveSys == 0){
            mecanum(controller);
        } else if (driveSys == 1) {
            tank(controller);
        }
    }
    
}