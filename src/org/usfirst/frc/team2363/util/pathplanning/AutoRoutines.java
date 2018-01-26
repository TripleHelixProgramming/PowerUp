package org.usfirst.frc.team2363.util.pathplanning;

import java.util.HashMap;
import java.util.Map;

import org.usfirst.frc.team2363.robot.commands.autonomous.AutoGroup;
import org.usfirst.frc.team2363.robot.commands.autonomous.BaselineAutoGroup;
import org.usfirst.frc.team2363.util.pathplanning.SrxPathReader;

public class AutoRoutines {
	
	private String[] paths = {
		"centerSwitchLeftPath", 
		"centerSwitchRightPath", 
		"leftSwitchPath", 
		"rightSwitchPath", 
		"leftScaleLeftPath", 
		"rightScaleLeftPath", 
		"rightScaleRightPath", 
		"baselinePath"
	};
	Map automap = new HashMap();
	BoTHTrajectory auto;
	
	public void load() {
		for (String path: paths) {
			auto = SrxPathReader.importSrxTrajectory(path);
			automap.put(path, auto);
		}
	}
}