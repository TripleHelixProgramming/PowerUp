package org.usfirst.frc.team319.models;

public class GameState {
	
	public Side mySwitchSide;
	public Side scaleSide;
	public Side theirSwitchSide;
	
	public GameState(String gameSpecificMessage) {
		
		if(gameSpecificMessage.charAt(0) == 'L') {
			this.mySwitchSide = Side.LEFT;
		}else {
			this.mySwitchSide = Side.RIGHT;
		}
		
		if(gameSpecificMessage.charAt(1) == 'L') {
			this.scaleSide = Side.LEFT;
		}else {
			this.scaleSide = Side.RIGHT;
		}
		
		if(gameSpecificMessage.charAt(2) == 'L') {
			this.theirSwitchSide = Side.LEFT;
		}else {
			this.theirSwitchSide = Side.RIGHT;
		}
			
	}
	
	public enum Side{LEFT, RIGHT}

}
