package org.usfirst.frc.team5243.robot.commands;

import java.util.ArrayList;

import org.usfirst.frc.team5243.robot.RecordationModule;
import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.WotInRoboticRecordation;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Playbackation extends Command {
	
	WotInRoboticRecordation wotSubsystem;
	DriveSubsystem driveSubsystem;
	ArrayList<ArrayList<Double>> speeds;

    public Playbackation() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	wotSubsystem = Robot.wotSubsystem;
    	driveSubsystem = Robot.driveSubsystem;
    	for (Subsystem sub : wotSubsystem.getRecordationModule().getSubsystems()) {
    		requires(sub);
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	speeds = wotSubsystem.playback();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	for (ArrayList<Double> motorSpeeds : speeds) {
    		driveSubsystem.setFrontLeft(motorSpeeds.get(0));
    		driveSubsystem.setFrontRight(motorSpeeds.get(1));
    		driveSubsystem.setBackLeft(motorSpeeds.get(2));
    		driveSubsystem.setBackRight(motorSpeeds.get(3));
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
