package org.usfirst.frc.team319.models;

//Combines left and right motion profiles in one object
public class SrxTrajectory {
	public SrxMotionProfile leftProfile;
	public SrxMotionProfile rightProfile;
	
	public SrxTrajectory() { }

	public SrxTrajectory(SrxMotionProfile left, SrxMotionProfile right) {
		this.leftProfile = left;
		this.rightProfile = right;
	}
}
