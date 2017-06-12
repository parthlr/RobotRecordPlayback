package org.usfirst.frc.team5243.robot;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RecordationModule {
	
	ArrayList<Subsystem> subsystems;
	ArrayList<ArrayList<Double>> speeds;
	
	public RecordationModule() {
		 
	}
	
	public void initialize() {
		speeds = new ArrayList<ArrayList<Double>>();
		subsystems = new ArrayList<Subsystem>();
	}
	
	public void addMotorSpeed(int index, double speed) {
		speeds.get(index).add(speed);
	}
	
	public ArrayList<ArrayList<Double>> getMotorSpeeds() {
		return speeds;
	}
	
	public void addSubsystem(Subsystem sub) {
		subsystems.add(sub);
	}
	
	public ArrayList<Subsystem> getSubsystems() {
		return subsystems;
	}

}
