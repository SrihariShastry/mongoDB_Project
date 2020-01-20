package project2;

public class GameResult {
	
	String gameID, groups, matchDate,stadiumID,teamID1,teamID2,team1Score,team2Score;
	String team1Name,team2Name, stadiumName, cityName;
	
	
	
	/**
	 * @param gameID
	 * @param groups
	 * @param matchDate
	 * @param stadiumID
	 * @param teamID1
	 * @param teamID2
	 * @param team1Score
	 * @param team2Score
	 */
	public GameResult(String gameID, String groups, String matchDate, String stadiumID, String teamID1, String teamID2,
			String team1Score, String team2Score) {
		this.gameID 	= gameID;
		this.groups 	= groups;
		this.matchDate 	= matchDate;
		this.stadiumID 	= stadiumID;
		this.teamID1 	= teamID1;
		this.teamID2 	= teamID2;
		this.team1Score = team1Score;
		this.team2Score = team2Score;
	}
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
	public String getTeam1Name() {
		return team1Name;
	}
	public void setTeam1Name(String team1Name) {
		this.team1Name = team1Name;
	}
	public String getTeam2Name() {
		return team2Name;
	}
	public void setTeam2Name(String team2Name) {
		this.team2Name = team2Name;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
