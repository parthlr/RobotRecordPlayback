package org.usfirst.frc.team5243.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Victor frontLeft;
	Victor frontRight;
	Victor backLeft;
	Victor backRight;
	
	public DriveSubsystem() {
		frontLeft = new Victor(1);
		frontRight = new Victor(2);
		backLeft = new Victor(3);
		backRight = new Victor(4);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
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

