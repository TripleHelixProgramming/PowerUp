package org.usfirst.frc.team2363.robot.commands.autonomous;

import org.usfirst.frc.team319.robot.commands.FollowTrajectory;
import org.usfirst.frc.team319.utils.SrxTrajectoryImporter;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 */
public class PathTesting extends CommandGroup {
	
	private static final SrxTrajectoryImporter importer = new SrxTrajectoryImporter("/home/lvuser/Autos");

    public PathTesting() {
        try {
//        	addSequential(new FollowTrajectory(importer.importSrxTrajectory("OppositeSideScale"), false));
//        	addSequential(new FollowTrajectory(importer.importSrxTrajectory("OppositeSideScalePart2"), false));
			addSequential(new FollowTrajectory(importer.importSrxTrajectory("SameSideScale"), false));
			addSequential(new FollowTrajectory(importer.importSrxTrajectory("SameSideScalePart2"), false));
			addSequential(new FollowTrajectory(importer.importSrxTrajectory("SameSideScalePart3"), false));
			addSequential(new FollowTrajectory(importer.importSrxTrajectory("SameSideScalePart4"), false));
			addSequential(new FollowTrajectory(importer.importSrxTrajectory("SameSideScalePart5"), false));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
