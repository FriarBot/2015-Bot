package com.team1168robotics;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalOutput;

public class Ultra {
	public static AnalogInput ultra = new AnalogInput(0);
	public static DigitalOutput rangePin = new DigitalOutput(8);
	private static final boolean HIGH = true;
	private static final boolean LOW = false;
	
	public static void ultra() {
		rangePin.set(HIGH);
		SmartDashboard.putNumber("Distance (mm): ", (ultra.getVoltage()/5120));
	}
}
