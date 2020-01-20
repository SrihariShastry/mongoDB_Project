package project2;

public class Teams {
	String teamID, teamName, continent, league;

	/**
	 * @param teamID
	 * @param teamName
	 * @param continent
	 * @param league
	 */
	public Teams(String teamID, String teamName, String continent, String league) {
		this.teamID = teamID;
		this.teamName = teamName;
		this.continent = continent;
		this.league = league;
	}

	public String getTeamID() {
		return teamID;
	}

	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}
	
	
}
