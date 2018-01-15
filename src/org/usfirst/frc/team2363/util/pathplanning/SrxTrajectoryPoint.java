package org.usfirst.frc.team2363.util.pathplanning;

import com.fasterxml.jackson.annotation.JsonCreator;

import edu.wpi.first.wpilibj.DriverStation;

import com.ctre.phoenix.motion.TrajectoryPoint.TrajectoryDuration;
public class SrxTrajectoryPoint {
	
	private double position;
	private double rpm;
	private int dt;
	
	@JsonCreator
	SrxTrajectoryPoint() { }
	
	public SrxTrajectoryPoint(double position, double rpm,  int dt) {
		this.position = position;
		this.rpm = rpm;
		this.dt = dt;
	}

	public double getPosition() {
		return position;
	}

	public void setPosition(double position) {
		this.position = position;
	}

	public double getRpm() {
		return rpm;
	}

	public void setRpm(double rpm) {
		this.rpm = rpm;
	}

	public TrajectoryDuration getDt() {
		
		/* create return value */
		TrajectoryDuration retval = TrajectoryDuration.Trajectory_Duration_0ms;
		
		/* convert duration to supported type */
		retval = retval.valueOf(dt);
		/* check that it is valid */
		if (retval.value != dt) {
			DriverStation.reportError("Trajectory Duration not supported - use configMotionProfileTrajectoryPeriod instead", false);		
		}
		/* pass to caller */
		return retval;
	}

	public void setDt(int dt) {
		this.dt = dt;
	}

}
