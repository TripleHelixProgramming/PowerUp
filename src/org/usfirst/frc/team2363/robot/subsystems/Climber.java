package org.usfirst.frc.team2363.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import static org.usfirst.frc.team2363.robot.RobotMap.*;

import org.usfirst.frc.team2363.robot.RobotMap;
import org.usfirst.frc.team2363.robot.commands.climber.ClimberCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	
	private TalonSRX front = new TalonSRX(FRONT_CLIMBER);
	private TalonSRX rear = new TalonSRX(REAR_CLIMBER);
	private DoubleSolenoid climber = new DoubleSolenoid(RobotMap.CLIMBER_EXTEND, RobotMap.CLIMBER_RETRACT);
	
	public Climber() {
		rear.follow(front);
		front.setInverted(true);
		rear.setInverted(false);
	}
	
    public void setPower(double power) {
	    front.set(ControlMode.PercentOutput, power);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ClimberCommand());
    }
    
    public void extendClimber() {
    	climber.set(DoubleSolenoid.Value.kForward);
    }
    
    public void retractClimber() {
    	climber.set(DoubleSolenoid.Value.kReverse);
    }
}

