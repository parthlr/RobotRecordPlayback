package org.usfirst.frc.team5243.robot;

import java.util.ArrayList;

import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team5243.robot.textfile.WriteToCSV;
import org.usfirst.frc.team5243.robot.textfile.WriteToTextFile;

import edu.wpi.first.wpilibj.Timer;

public class RecordationModule {
	
	public ArrayList<Double> frontleft;
	public ArrayList<Double> frontright;
	public ArrayList<Double> backleft;
	public ArrayList<Double> backright;
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
		Timer.delay(0.02);
		frontleft.add(driveSubsystem.getRightValues());
		frontright.add(driveSubsystem.getLeftValues());
		backleft.add(driveSubsystem.getRightValues());
		backright.add(driveSubsystem.getLeftValues());
		System.out.println(Timer.getFPGATimestamp());
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
		//WriteToCSV.write(frontleft, frontright, backleft, backright, ");
		frontleft.clear();
		frontright.clear();
		backleft.clear();
		backright.clear();
	}

}
