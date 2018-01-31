package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	VictorSP frontLeft;
	VictorSP frontRight;
	VictorSP backLeft;
	VictorSP backRight;
	SpeedControllerGroup left;
	SpeedControllerGroup right;
	
	DifferentialDrive drive;
	
	public DriveSubsystem() {
		frontLeft = new VictorSP(RobotMap.frontLeft);
		frontRight = new VictorSP(RobotMap.frontRight);
		backLeft = new VictorSP(RobotMap.backLeft);
		backRight = new VictorSP(RobotMap.backRight);
		left = new SpeedControllerGroup(frontLeft, backLeft);
		right = new SpeedControllerGroup(frontRight, backRight);
		
		drive = new DifferentialDrive(right, left);
		drive.setSafetyEnabled(false);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDrive());
    }
    
    public DifferentialDrive getDrive() {
    	return drive;
    }
    
    public void stopAll() {
    	frontLeft.set(0.0);
		backLeft.set(0.0);
		frontRight.set(0.0);
		backRight.set(0.0);
    }
    
    public void tankDrive() {
    	drive.tankDrive(Robot.oi.getRightStick().getY() / 1, Robot.oi.getLeftStick().getY() / 1);
    }
    
    public double getRightValues() {
    	return Robot.oi.getLeftStick().getY();
    }
    
    public double getLeftValues() {
    	return Robot.oi.getRightStick().getY();
    }
    
    public void setFrontLeft(double speed) {
    	frontLeft.set(speed);
    }
    
    public void setFrontRight(double speed) {
    	frontRight.set(speed);
    }
    
    public void setBackLeft(double speed) {
    	backLeft.set(speed);
    }
    
    public void setBackRight(double speed) {
    	backRight.set(speed);
    }
    
    public double getFrontLeftSpeed() {
    	return frontLeft.getSpeed();
    }
    
    public double getFrontRightSpeed() {
    	return frontRight.getSpeed();
    }
    
    public double getBackLeftSpeed() {
    	return backLeft.getSpeed();
    }
    
    public double getBackRightSpeed() {
    	return backRight.getSpeed();
    }
}

