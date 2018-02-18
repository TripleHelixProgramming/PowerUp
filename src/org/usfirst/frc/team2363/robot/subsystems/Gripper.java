package org.usfirst.frc.team2363.robot.subsystems;

import org.usfirst.frc.team2363.robot.RobotMap;
import org.usfirst.frc.team2363.robot.commands.gripper.StopWheels;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {
	
	private BaseMotorController leftWheel = new TalonSRX(RobotMap.GRIPPER_LEFT_WHEEL);
	private BaseMotorController rightWheel = new TalonSRX(RobotMap.GRIPPER_RIGHT_WHEEL);
	private DoubleSolenoid wrist = new DoubleSolenoid(RobotMap.GRIPPER_RAISE, RobotMap.GRIPPER_LOWER);
//	private DigitalInput hasCube = new DigitalInput(0);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void gripper() {
//		leftWheel.configContinuousCurrentLimit(5, 10);
//		leftWheel.configPeakCurrentLimit(20, 10);
//		leftWheel.configPeakCurrentDuration(1000, 10);
		
//		rightWheel.configContinuousCurrentLimit(5, 10);
//		rightWheel.configPeakCurrentLimit(20, 10);
//		rightWheel.configPeakCurrentDuration(1000, 10);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new StopWheels());
    }
    
    public void intake() {
    	leftWheel.set(ControlMode.PercentOutput, 1);
    	rightWheel.set(ControlMode.PercentOutput, -1);
    }
    
    public void eject() {
    	leftWheel.set(ControlMode.PercentOutput, -0.5);
    	rightWheel.set(ControlMode.PercentOutput, 0.5);
    }
    
    public void shoot() {
    	leftWheel.set(ControlMode.PercentOutput, -1);
    	rightWheel.set(ControlMode.PercentOutput, 1);
    }
    
    public void stop() {
    	leftWheel.set(ControlMode.PercentOutput, 0.2);
    	rightWheel.set(ControlMode.PercentOutput, -0.2);
    }
    
    public void lower() {
    	wrist.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void raise() {
    	wrist.set(DoubleSolenoid.Value.kForward);
    }
    
    public boolean isDown() {
    	return (wrist.get() == DoubleSolenoid.Value.kForward);
    }
    
    public boolean isUp() {
    	return (wrist.get() == DoubleSolenoid.Value.kReverse);
    }
}