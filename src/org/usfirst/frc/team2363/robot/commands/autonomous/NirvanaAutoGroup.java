package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team2363.robot.commands.drivetrain.TurnToAngle;
import org.usfirst.frc.team2363.robot.commands.elevator.RaiseElevator;
import org.usfirst.frc.team2363.robot.commands.gripper.EjectCube;
import org.usfirst.frc.team2363.robot.commands.gripper.IntakeCube;
import org.usfirst.frc.team2363.robot.subsystems.Elevator.Height;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class NirvanaAutoGroup extends CommandGroup {

	//placeholder variables
	String scalePath;
	String scaleHeight;
	String pathToCube;
	String shortPath;
	
//	public NirvanaAutoGroup(BoTHTrajectory path, Height elevatorHeight, boolean reverse) {
//        addSequential(new AutoGroup(path, elevatorHeight, reverse));
//        addSequential(new TurnToAngle(180));
//        addParallel(new RaiseElevator(Height.GROUND));
//        addParallel(new IntakeCube());
//        addSequential(new PathRunner(autoRoutines.getPath(AutoTypeEnum.PATH_TO_CUBE), false));
//        addSequential(new RaiseElevator(Height.SWITCH));
//        addSequential(new PathRunner(shortPath));
//        addParallel(new EjectCube());
//    }
}
