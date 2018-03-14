package org.usfirst.frc.team2363.robot.subsystems;

import static org.usfirst.frc.team2363.robot.RobotMap.*;
import org.usfirst.frc.team2363.robot.commands.tramps.RetractTramps;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Tramps extends Subsystem {
	
	private DoubleSolenoid deploy = new DoubleSolenoid (TRAMPS_DEPLOY, TRAMPS_RETRACT);
//	private DoubleSolenoid left1 = new DoubleSolenoid(LEFT1_TRAMP_RAISE, LEFT1_TRAMP_LOWER);
//	private DoubleSolenoid left2 = new DoubleSolenoid(LEFT2_TRAMP_RAISE, LEFT2_TRAMP_LOWER)
//	private DoubleSolenoid right1 = new DoubleSolenoid(1, RIGHT1_TRAMP_RAISE, RIGHT1_TRAMP_LOWER);
//	private DoubleSolenoid right2 = new DoubleSolenoid(1, RIGHT2_TRAMP_RAISE, RIGHT2_TRAMP_LOWER);
	private TalonSRX frontLeft = new TalonSRX(FRONT_LEFT_TRAMP);
	private TalonSRX frontRight = new TalonSRX(FRONT_RIGHT_TRAMP);
	private BaseMotorController rearLeft = new VictorSPX(REAR_LEFT_TRAMP);
	private BaseMotorController rearRight = new VictorSPX(REAR_RIGHT_TRAMP);

	//Slaves need to be inverted
	
	public Tramps() {
		rearLeft.follow(frontLeft);
		rearRight.follow(frontRight);
		frontLeft.setInverted(false);
		frontRight.setInverted(true);
		rearLeft.setInverted(true);
		rearRight.setInverted(false);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new RetractTramps());
    }
    
    public void deploy() {
    	deploy.set(DoubleSolenoid.Value.kForward);
    }
    
    public void raiseLeft() {
//    	left1.set(DoubleSolenoid.Value.kForward);
//    	left2.set(DoubleSolenoid.Value.kForward);
    }
    
    public void raiseRight() {
//    	right1.set(DoubleSolenoid.Value.kForward);
//    	right2.set(DoubleSolenoid.Value.kForward);
    }
    
    public void setLeftPower(double power) {
	    frontLeft.set(ControlMode.PercentOutput, power);
    }
    
    public void setRightPower(double power) {
	    frontRight.set(ControlMode.PercentOutput, power);
    }
    
    public void retract() {
    	deploy.set(DoubleSolenoid.Value.kReverse);
//    	left1.set(DoubleSolenoid.Value.kReverse);
//    	left2.set(DoubleSolenoid.Value.kReverse);
//    	right1.set(DoubleSolenoid.Value.kReverse);
//    	right2.set(DoubleSolenoid.Value.kReverse);
    }
}

