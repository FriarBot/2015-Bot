package com.team1168robotics;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Ultra {
	private Ultrasonic ultra = new Ultrasonic(9, 8, Ultrasonic.Unit.kInches);
	
	public void dashboard(){
		SmartDashboard.putNumber("Ultrasonic Range (inches):", ultra.getRangeInches());
	}
}