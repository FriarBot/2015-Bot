package com.team1168robotics;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

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
public class Main extends IterativeRobot {
    
    private Joystick controller;
   
    /**
     * This function is called exactly once when the competition starts
     */
    public void robotInit() {
        Drive.init();
        controller = new Joystick(1);
    }   

    /**
     * This function is called every time a packet is sent to the robot telling it to be in Teleoperated Enabled mode
     */
    public void teleopInit() {
        Drive.driveSys(controller);
    }    
    
    /**
     * This function is called periodically each time the robot enters test mode.
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
    /**
     * This function is called exactly once when autonomous starts
     */
    public void autonomousInit(){
    	Auton.reactive();
    }
}
