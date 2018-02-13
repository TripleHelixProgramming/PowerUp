package org.usfirst.frc.team2363.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2363.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;


/**
 *
 */
public class Claws extends Subsystem {
	private DoubleSolenoid claws = new DoubleSolenoid(RobotMap.CLAW_OPEN, RobotMap.CLAW_CLOSE);
	public void claws(){
		
	}
	
	public void openClaw() {
    	claws.set(DoubleSolenoid.Value.kForward);
    }
    
    public void closeClaw() {
    	claws.set(DoubleSolenoid.Value.kReverse);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

