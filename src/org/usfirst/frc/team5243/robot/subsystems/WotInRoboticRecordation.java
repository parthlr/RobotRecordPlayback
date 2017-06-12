package org.usfirst.frc.team5243.robot.subsystems;

import java.util.ArrayList;

import org.usfirst.frc.team5243.robot.RecordationModule;
import org.usfirst.frc.team5243.robot.commands.Playbackation;
import org.usfirst.frc.team5243.robot.commands.Recordation;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WotInRoboticRecordation extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	RecordationModule rm;
	
	Recordation record;
	Playbackation playback;
	
	public WotInRoboticRecordation() {
		rm = new RecordationModule();
		rm.initialize();
	}
	
	public void commandInitializer() {
		record = new Recordation();
		playback = new Playbackation();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(record);
    }
    
    public void changeDefaultCommand() {
    	if (getDefaultCommand().equals(record))
    		setDefaultCommand(playback);
    }
    
    public RecordationModule getRecordationModule() {
    	return rm;
    }
    
    public void addSubsystem(Subsystem subsystem) {
    	rm.addSubsystem(subsystem);
    }
    
    public void addData(ArrayList<Double> speeds) {
    	rm.getMotorSpeeds().add(speeds);
    }
    
    public ArrayList<ArrayList<Double>> playback() {
    	return rm.getMotorSpeeds();
    }
}

