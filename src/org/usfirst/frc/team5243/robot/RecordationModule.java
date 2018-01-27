package org.usfirst.frc.team5243.robot;

import java.awt.AWTException;
import java.util.ArrayList;

import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Timer;
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
		/*motors.add(driveSubsystem.getFrontLeftSpeed());
		motors.add(driveSubsystem.getFrontRightSpeed());
		motors.add(driveSubsystem.getBackLeftSpeed());
		motors.add(driveSubsystem.getBackRightSpeed());*/
		motors.add(driveSubsystem.getRightValues());
		motors.add(driveSubsystem.getLeftValues());
		speeds.add(motors);
	}
	
	public void playback() {
		for (ArrayList<Double> motors : speeds) {
			System.out.println("Right Values: " + motors.get(0));
			System.out.println("Left Values: " + motors.get(1));
			Timer.delay(0.01);
			driveSubsystem.setFrontLeft(motors.get(1));
			driveSubsystem.setFrontRight(motors.get(0));
			driveSubsystem.setBackLeft(motors.get(1));
			driveSubsystem.setBackRight(motors.get(0));			
		}
	}
	
	
	
	public void addMotorSpeed(int index, double speed) {
		speeds.get(index).add(speed);
	}
	
	public ArrayList<ArrayList<Double>> getMotorSpeeds() {
		return speeds;
	}

}
