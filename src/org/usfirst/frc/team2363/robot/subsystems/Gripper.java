package org.usfirst.frc.team2363.robot.subsystems;

import org.usfirst.frc.team2363.robot.Robot;
import org.usfirst.frc.team2363.robot.RobotMap;
import org.usfirst.frc.team2363.robot.commands.gripper.StopWheels;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Gripper extends Subsystem {
	
	private TalonSRX leftWheel = new TalonSRX(RobotMap.GRIPPER_LEFT_WHEEL);
	private TalonSRX rightWheel = new TalonSRX(RobotMap.GRIPPER_RIGHT_WHEEL);
//	private BaseMotorController leftWheel = new VictorSPX(RobotMap.GRIPPER_LEFT_WHEEL);
//	private BaseMotorController rightWheel = new VictorSPX(RobotMap.GRIPPER_RIGHT_WHEEL);
	
//	private DoubleSolenoid wrist = new DoubleSolenoid(RobotMap.GRIPPER_RAISE, RobotMap.GRIPPER_LOWER);
//	private DigitalInput hasCube = new DigitalInput(0);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Gripper() {
		
		Robot.LOG.addSource("GRIPPER Left Current", leftWheel, f -> "" + ((TalonSRX)(f)).getOutputCurrent());
		Robot.LOG.addSource("GRIPPER Right Current", rightWheel, f -> "" + ((TalonSRX)(f)).getOutputCurrent());
		Robot.LOG.addSource("GRIPPER Left Voltage", leftWheel, f -> "" + ((TalonSRX)(f)).getMotorOutputVoltage());
		Robot.LOG.addSource("GRIPPER Right Voltage", rightWheel, f -> "" + ((TalonSRX)(f)).getMotorOutputVoltage());
//		Robot.LOG.addSource("GRIPPER Wrist Solenoid State", wrist, f -> "" + ((DoubleSolenoid)(f)).get());
		
		leftWheel.configContinuousCurrentLimit(5, 10);
		leftWheel.configPeakCurrentLimit(20, 10);
		leftWheel.configPeakCurrentDuration(1000, 10);
		
		rightWheel.configContinuousCurrentLimit(5, 10);
		rightWheel.configPeakCurrentLimit(20, 10);
		rightWheel.configPeakCurrentDuration(1000, 10);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new StopWheels());
    }
    
    public void intake() {
    	leftWheel.set(ControlMode.PercentOutput, 0.75);
    	rightWheel.set(ControlMode.PercentOutput, -0.75);
    }
    
@Override
	public void periodic() {
		putSmartDash();
	}
    
    public void eject() {
    	leftWheel.set(ControlMode.PercentOutput, -0.35);
    	rightWheel.set(ControlMode.PercentOutput, 0.35);
    }
    
    public void autoEject() {
    	leftWheel.set(ControlMode.PercentOutput, -0.9);
    	rightWheel.set(ControlMode.PercentOutput, 0.9);
    }
    
    public void shoot() {
    	leftWheel.set(ControlMode.PercentOutput, -1);
    	rightWheel.set(ControlMode.PercentOutput, 1);
    }
    
    public void stop() {
    	leftWheel.set(ControlMode.PercentOutput, 0.2);
    	rightWheel.set(ControlMode.PercentOutput, -0.2);
    }
    
/*    public void lower() {
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
    }*/
    
    public void putSmartDash() {
    	SmartDashboard.putNumber("GripperLeftCurrent", leftWheel.getOutputCurrent());
    	SmartDashboard.putNumber("GripperRightCurrent", rightWheel.getOutputCurrent());
    }
        
    public double getOutputCurrent() {
    	return Math.max(leftWheel.getOutputCurrent(), rightWheel.getOutputCurrent());
    }
    
    /**
     * Use to detect if the gear grabber roller is over current
     * @return true if over 20 amps
     */
    public boolean isOverCurrent() {
    	if (getOutputCurrent() > 15) {
    		return true;
    	} else {
    		return false;
    	}
    }
}