package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team2363.robot.commands.elevator.RaiseElevator;
import org.usfirst.frc.team2363.robot.commands.gripper.ShootCube;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;
import org.usfirst.frc.team319.models.SrxTrajectory;
import org.usfirst.frc.team319.robot.commands.FollowTrajectory;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
/**
 *
 */
public class AutoGroup extends CommandGroup {
	
	 public AutoGroup(SrxTrajectory path, Height elevatorHeight, double elevatorDelay) {
		 this(path, elevatorHeight, elevatorDelay, null);
	 }

    public AutoGroup(SrxTrajectory path, Height elevatorHeight, double elevatorDelay, Command phase2) {
        addParallel(new ElevatorCommand(elevatorHeight, elevatorDelay));
        addSequential(new FollowTrajectory(path));
        addParallel(new ShootCube());
        addSequential(new WaitCommand(0.25));
        if (phase2 != null) {
        	addSequential(phase2);
        }
    }
    
    private class ElevatorCommand extends CommandGroup {
    	
    	public ElevatorCommand(Height height, double delay) {
    		addSequential(new WaitCommand(delay));
    		addSequential(new RaiseElevator(height));
    	}
    }
}
