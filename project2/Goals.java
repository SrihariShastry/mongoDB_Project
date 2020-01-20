package project2;

public class Goals {
	
	String gameID,teamID,playerID,time,goalType;
	
	public Goals() {}
	
	public Goals(String gameID, String teamID, String playerID, String time, String goalType) {
		super();
		this.gameID = gameID;
		this.teamID = teamID;
		this.playerID = playerID;
		this.time = time;
		this.goalType = goalType;
	}
	
	public String getGameID() {
		return gameID;
	}

	public void setGameID(String gameID) {
		this.gameID = gameID;
	}

	public String getTeamID() {
		return teamID;
	}

	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	public String getPlayerID() {
		return playerID;
	}

	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getGoalType() {
		return goalType;
	}

	public void setGoalType(String goalType) {
		this.goalType = goalType;
	}


}
