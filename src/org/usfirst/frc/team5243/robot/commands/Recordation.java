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
public class Recordation extends Command {
	
	DriveSubsystem driveSubsystem;
	WotInRoboticRecordation wotSubsystem;
	int interval;

    public Recordation() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	driveSubsystem = Robot.driveSubsystem;
    	wotSubsystem = Robot.wotSubsystem;
    	wotSubsystem.addSubsystem(driveSubsystem);
    	wotSubsystem.addSubsystem(wotSubsystem);
    	for (Subsystem sub : wotSubsystem.getRecordationModule().getSubsystems()) {
    		requires(sub);
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	interval = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	wotSubsystem.addData(new ArrayList<Double>());
    	wotSubsystem.getRecordationModule().addMotorSpeed(interval, driveSubsystem.getFrontLeftSpeed());
    	wotSubsystem.getRecordationModule().addMotorSpeed(interval, driveSubsystem.getFrontRightSpeed());
    	wotSubsystem.getRecordationModule().addMotorSpeed(interval, driveSubsystem.getBackLeftSpeed());
    	wotSubsystem.getRecordationModule().addMotorSpeed(interval, driveSubsystem.getBackRightSpeed());
    	interval++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (interval == 100)
        	return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
