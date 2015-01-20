package com.team1168robotics;


import edu.wpi.first.wpilibj.CameraServer;
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

public class Robot extends IterativeRobot {
	
	public static final boolean UP = true;
	public static final boolean DOWN = false;    
    private Joystick controller = new Joystick(1);
    public CameraServer server;
   
    /**
     * This function is called exactly once when the competition starts
     */
    public void robotInit() {
        Drive.init();
        controller = new Joystick(1);
    }   
    
    public void camera(){
    	 server = CameraServer.getInstance();
         server.setQuality(50);
         //the camera name (ex "cam0") can be found through the roborio web interface
         server.startAutomaticCapture("cam0");
    }

    /**
     * This function is called periodically each time the robot enters teleoperated mode
     */
    public void teleopPeriodic() {
        Drive.driveSys(controller);
        camera();
    }
    
    /**
     * This function is called periodically each time the robot enters test mode
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
