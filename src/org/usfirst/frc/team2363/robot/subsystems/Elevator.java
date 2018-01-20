package org.usfirst.frc.team2363.robot.subsystems;

import org.usfirst.frc.team2363.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
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

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void elevate (double power) {
		leftMotor.set(ControlMode.PercentOutput, power);
		rightMotor.set(ControlMode.Follower, leftMotor.getDeviceID());
	}
	
	public void goTo (Height height) {
		leftMotor.set(ControlMode.Position, height.getHeight());
	}
	
	
    public void initDefaultCommand() {
        goTo(Height.GROUND);
    }
}

