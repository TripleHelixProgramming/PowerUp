package org.usfirst.frc.team319.models;

//Generic Motion Profile Class
public class SrxMotionProfile {

	public int numPoints;
	// Position (rotations) Velocity (RPM) Duration (ms)
	public double[][] points;

	public SrxMotionProfile() { }

	public SrxMotionProfile(int numPoints, double[][] points) {
		this.numPoints = numPoints;
		this.points = points;
	}
}
