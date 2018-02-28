package org.usfirst.frc.team2363.robot.subsystems;

import org.usfirst.frc.team2363.robot.RobotMap;
import org.usfirst.frc.team2363.robot.commands.tramps.RetractTramps;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Tramps extends Subsystem {
	
	private Solenoid deploy = new Solenoid (RobotMap.TRAMPS);
	private DoubleSolenoid left1 = new DoubleSolenoid(2, 5);
	private DoubleSolenoid left2 = new DoubleSolenoid(3, 4);
	private DoubleSolenoid right1 = new DoubleSolenoid(1, 0, 7);
	private DoubleSolenoid right2 = new DoubleSolenoid(1, 1, 6);

    public void initDefaultCommand() {
        setDefaultCommand(new RetractTramps());
    }
    
    public void deploy() {
    	deploy.set(true);
    }
    
    public void deployLeft() {
    	left1.set(DoubleSolenoid.Value.kForward);
    	left2.set(DoubleSolenoid.Value.kForward);
    }
    
    public void deployRight() {
    	right1.set(DoubleSolenoid.Value.kForward);
    	right2.set(DoubleSolenoid.Value.kForward);
    }
    
    public void retract() {
    	deploy.set(false);
    	left1.set(DoubleSolenoid.Value.kForward);
    	left2.set(DoubleSolenoid.Value.kForward);
    	right1.set(DoubleSolenoid.Value.kForward);
    	right2.set(DoubleSolenoid.Value.kForward);
    }
}

