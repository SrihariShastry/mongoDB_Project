package project2;

public class ScheduleResults {
	
	String gameID,groups,matchDate,stadiumID,teamID1,teamID2,team1Score,team2Score;

	public String getGameID() {
		return gameID;
	}

	public void setGameID(String gameID) {
		this.gameID = gameID;
	}

	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public String getStadiumID() {
		return stadiumID;
	}

	public void setStadiumID(String stadiumID) {
		this.stadiumID = stadiumID;
	}

	public String getTeamID1() {
		return teamID1;
	}

	public void setTeamID1(String teamID1) {
		this.teamID1 = teamID1;
	}

	public String getTeamID2() {
		return teamID2;
	}

	public void setTeamID2(String teamID2) {
		this.teamID2 = teamID2;
	}

	public String getTeam1Score() {
		return team1Score;
	}

	public void setTeam1Score(String team1Score) {
		this.team1Score = team1Score;
	}

	public String getTeam2Score() {
		return team2Score;
	}

	public void setTeam2Score(String team2Score) {
		this.team2Score = team2Score;
	}

	public ScheduleResults(String gameID, String groups, String matchDate, String stadiumID, String teamID1,
			String teamID2) {
		super();
		this.gameID = gameID;
		this.groups = groups;
		this.matchDate = matchDate;
		this.stadiumID = stadiumID;
		this.teamID1 = teamID1;
		this.teamID2 = teamID2;
	}


}
