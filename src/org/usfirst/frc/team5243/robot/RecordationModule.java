package org.usfirst.frc.team5243.robot;

import java.util.ArrayList;

import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RecordationModule {
	
	ArrayList<ArrayList<Double>> speeds;
	DriveSubsystem driveSubsystem;
	
	public RecordationModule() {
		 
	}
	
	public void initialize() {
		speeds = new ArrayList<ArrayList<Double>>();
		driveSubsystem = Robot.driveSubsystem;
	}
	
	public void record() {
		ArrayList<Double> motors = new ArrayList<Double>();
		motors.add(driveSubsystem.getFrontLeftSpeed());
		motors.add(driveSubsystem.getFrontRightSpeed());
		motors.add(driveSubsystem.getBackLeftSpeed());
		motors.add(driveSubsystem.getBackRightSpeed());
		speeds.add(motors);
	}
	
	public void playback() {
		for (ArrayList<Double> motors : speeds) {
			driveSubsystem.setFrontLeft(motors.get(0));
			driveSubsystem.setFrontRight(motors.get(1));
			driveSubsystem.setBackLeft(motors.get(2));
			driveSubsystem.setBackRight(motors.get(3));
		}
	}
	
	
	
	public void addMotorSpeed(int index, double speed) {
		speeds.get(index).add(speed);
	}
	
	public ArrayList<ArrayList<Double>> getMotorSpeeds() {
		return speeds;
	}

}
