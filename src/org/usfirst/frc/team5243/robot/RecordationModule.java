package org.usfirst.frc.team5243.robot;

import java.awt.AWTException;
import java.util.ArrayList;

import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RecordationModule {
	
	ArrayList<Double> frontleft;
	ArrayList<Double> frontright;
	ArrayList<Double> backleft;
	ArrayList<Double> backright;
	DriveSubsystem driveSubsystem;
	
	public RecordationModule() {
	}
	
	public void initialize() {
		frontleft = new ArrayList<Double>();
		frontright = new ArrayList<Double>();
		backleft = new ArrayList<Double>();
		backright = new ArrayList<Double>();
		driveSubsystem = Robot.driveSubsystem;
	}
	
	public void record() {
		ArrayList<Double> motors = new ArrayList<Double>();
		/*motors.add(driveSubsystem.getFrontLeftSpeed());
		motors.add(driveSubsystem.getFrontRightSpeed());
		motors.add(driveSubsystem.getBackLeftSpeed());
		motors.add(driveSubsystem.getBackRightSpeed());*/
		frontleft.add(driveSubsystem.getFrontLeftSpeed());
		frontright.add(driveSubsystem.getFrontRightSpeed());
		backleft.add(driveSubsystem.getBackLeftSpeed());
		backright.add(driveSubsystem.getBackRightSpeed());
	}
	
	public void playback() {
		for (int i = 0; i < frontleft.size(); i++) {
			Timer.delay(0.02);
			driveSubsystem.setFrontLeft(frontleft.get(i));
			driveSubsystem.setFrontRight(frontright.get(i));
			driveSubsystem.setBackLeft(backleft.get(i));
			driveSubsystem.setBackRight(backright.get(i));			
		}
	}
	
	public void clearData() {
		frontleft.clear();
		frontright.clear();
		backleft.clear();
		backright.clear();
	}

}
