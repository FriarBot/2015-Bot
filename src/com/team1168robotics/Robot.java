package com.team1168robotics;


import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Servo;

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
 
    public static Joystick xboxCon = new Joystick(1);
    public static Joystick opCon = new Joystick(0);
    public CameraServer server;
   
    /**
     * This function is called exactly once when the competition starts
     */
    public void robotInit() {
        Drive.init();
    	camera();
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
        Drive.mecanum();
       	Lift.tote();
    	Lift.arms();
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
    }
    
    public void dummy(){
    	DigitalOutput out0 = new DigitalOutput(0);
    	DigitalOutput out1 = new DigitalOutput(1);
    	DigitalOutput out2 = new DigitalOutput(2);
    	DigitalOutput out3 = new DigitalOutput(3);
    	DigitalOutput out4 = new DigitalOutput(4);
    	DigitalOutput out5 = new DigitalOutput(5);
    	DigitalOutput out6 = new DigitalOutput(6);
    	DigitalOutput out7 = new DigitalOutput(7);
    	DigitalOutput out8 = new DigitalOutput(8);
    	DigitalOutput out9 = new DigitalOutput(9);
    	
    	out1.set(false);
    	out3.set(false);
    	out5.set(false);
    	out7.set(false);
    	out9.set(false);
    	
    	out0.set(true);
    	out2.set(true);
    	out4.set(true);
    	out6.set(true);
    	out8.set(false);
    }
    
    public void servo(){
    	Servo servo = new Servo(5);
    	servo.setAngle(60);
    }
    
    public void dummyMotor(){
    	Jaguar jag = new Jaguar(9);
    	jag.set(1);
    }
}
