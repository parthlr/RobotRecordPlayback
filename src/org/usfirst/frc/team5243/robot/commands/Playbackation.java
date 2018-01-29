package org.usfirst.frc.team5243.robot.commands;

import java.util.ArrayList;

import org.usfirst.frc.team5243.robot.RecordationModule;
import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.WotInRoboticRecordation;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Playbackation extends Command {
	
	RecordationModule rm;

    public Playbackation() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	rm = Robot.rm;
    	//for (Subsystem sub : wotSubsystem.getRecordationModule().getSubsystems()) {
    	//	requires(sub);
    	//}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//System.out.println("Playing back");
    	SmartDashboard.putBoolean("Playback", true);
    	rm.playback();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	rm.clearData();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
