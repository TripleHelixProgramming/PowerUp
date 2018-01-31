package org.usfirst.frc.team2363.robot.subsystems;

import org.usfirst.frc.team2363.robot.RobotMap;
import org.usfirst.frc.team2363.robot.commands.drivetrain.JoystickDrive;
import org.usfirst.frc.team2363.robot.commands.elevator.OperateElevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Elevator extends Subsystem {
	
	public enum Height {
		
		GROUND(0),
		SWITCH(1),
		SCALE(2),
		RUNG(2);
		
		private final double height;
		
		private Height(double height) {
			this.height = height;
		}
		
		public double getHeight() {
			return height;
		}
	}
	
	private TalonSRX leftMotor = new TalonSRX(RobotMap.LEFT_ELEVATOR_MOTOR);
	private TalonSRX rightMotor = new TalonSRX(RobotMap.RIGHT_ELEVATOR_MOTOR);
	private DigitalInput defaultPosition = new DigitalInput(RobotMap.DEFAULT_POSITION);
	private DigitalInput groundLimit = new DigitalInput(RobotMap.ELEVATOR_GROUND_LIMIT_CHANNEL);
	private DigitalInput upperLimit = new DigitalInput(RobotMap.ELEVATOR_UPPER_LIMIT_CHANNEL);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void elevate (double power) {
		rightMotor.set(ControlMode.Follower, leftMotor.getDeviceID());
		
		if (isAtGroundLimit() == true)  {
			leftMotor.set(ControlMode.PercentOutput, 0);
		} else {
			leftMotor.set(ControlMode.PercentOutput, power);
		}
	}
//	private void getPosition() {
//		return TalonSRX.getSelectedSensorPosition(0);	        
	   
	        
//	}
	
	public void goTo (Height height) {
		leftMotor.set(ControlMode.Position, height.getHeight());
	}
	protected void initDefaultCommand() {
		// sets the default drive mode to Colson drive
		setDefaultCommand(new OperateElevator());
	}
	
    
    public boolean isAtGroundLimit () {
    	return groundLimit.get();
    }
 
       
}

