package org.usfirst.frc.team5243.robot.commands;

import java.util.ArrayList;

import org.usfirst.frc.team5243.robot.RecordationModule;
import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.WotInRoboticRecordation;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Recordation extends Command {
	
	RecordationModule rm;
	DriveSubsystem driveSubsystem;

    public Recordation() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	rm = Robot.rm;
    	driveSubsystem = Robot.driveSubsystem;
    	//wotSubsystem.addSubsystem(driveSubsystem);
    	//wotSubsystem.addSubsystem(wotSubsystem);
    	//for (Subsystem sub : wotSubsystem.getRecordationModule().getSubsystems()) {
    	//	requires(sub);
    	//}
    	requires(driveSubsystem);
    	requires(Robot.wotSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putBoolean("Recording", true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putString("Front Right", driveSubsystem.getFrontRightSpeed()+"");
    	SmartDashboard.putString("Front Left", driveSubsystem.getFrontLeftSpeed()+"");
    	SmartDashboard.putString("Back Right", driveSubsystem.getBackRightSpeed()+"");
    	SmartDashboard.putString("Back Left", driveSubsystem.getBackLeftSpeed()+"");
    	driveSubsystem.tankDrive();
    	rm.record();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//end();
    }
}
