package org.usfirst.frc.team2363.robot.subsystems;

import static org.usfirst.frc.team2363.robot.RobotMap.*;
import org.usfirst.frc.team2363.robot.commands.tramps.RetractTramps;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Tramps extends Subsystem {
	
	private DoubleSolenoid deploy = new DoubleSolenoid (TRAMPS_DEPLOY, TRAMPS_RETRACT);
	private DoubleSolenoid left1 = new DoubleSolenoid(LEFT1_TRAMP_RAISE, LEFT1_TRAMP_LOWER);
//	private DoubleSolenoid left2 = new DoubleSolenoid(LEFT2_TRAMP_RAISE, LEFT2_TRAMP_LOWER)
//	private DoubleSolenoid right1 = new DoubleSolenoid(1, RIGHT1_TRAMP_RAISE, RIGHT1_TRAMP_LOWER);
//	private DoubleSolenoid right2 = new DoubleSolenoid(1, RIGHT2_TRAMP_RAISE, RIGHT2_TRAMP_LOWER);

    public void initDefaultCommand() {
        setDefaultCommand(new RetractTramps());
    }
    
    public void deploy() {
    	deploy.set(DoubleSolenoid.Value.kForward);
    }
    
    public void raiseLeft() {
    	left1.set(DoubleSolenoid.Value.kForward);
//    	left2.set(DoubleSolenoid.Value.kForward);
    }
    
    public void raiseRight() {
//    	right1.set(DoubleSolenoid.Value.kForward);
//    	right2.set(DoubleSolenoid.Value.kForward);
    }
    
    public void retract() {
    	deploy.set(DoubleSolenoid.Value.kReverse);
    	left1.set(DoubleSolenoid.Value.kReverse);
//    	left2.set(DoubleSolenoid.Value.kReverse);
//    	right1.set(DoubleSolenoid.Value.kReverse);
//    	right2.set(DoubleSolenoid.Value.kReverse);
    }
}

