package org.usfirst.frc.team2363.robot.subsystems;

import org.usfirst.frc.team2363.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {
	
	private TalonSRX leftWheel = new TalonSRX(20);
	private TalonSRX rightWheel = new TalonSRX(21);
	private Solenoid wrist = new Solenoid(RobotMap.WRIST);
	private Solenoid claws = new Solenoid(RobotMap.CLAWS);
	private DigitalInput hasCube = new DigitalInput(0);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void gripper() {
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void intake() {
    	leftWheel.set(ControlMode.PercentOutput, -1);
    	rightWheel.set(ControlMode.PercentOutput, 1);
    }
    
    public void eject() {
    	leftWheel.set(ControlMode.PercentOutput, 1);
    	rightWheel.set(ControlMode.PercentOutput, -1);
    }
    
    public void stop() {
    	leftWheel.set(ControlMode.PercentOutput, 0);
    	rightWheel.set(ControlMode.PercentOutput, 0);
    }
    
    public void openClaw() {
    	claws.set(true);
    }
    
    public void closeClaw() {
    	claws.set(false);
    }
    
    public void lower() {
    	wrist.set(true);
    }
    
    public void raise() {
    	wrist.set(false);
    }
}
