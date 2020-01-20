package project2;

public class Rosters {

	
		String teamName,teamID,playerID,position,playerName,dob,shirtName,club,height,weight;
		
		public Rosters() {}
		

		public Rosters(String teamName, String teamID, String playerID, String position, String playerName) {
			super();
			this.teamName = teamName;
			this.teamID = teamID;
			this.playerID = playerID;
			this.position = position;
			this.playerName = playerName;
		}

		public String getTeamName() {
			return teamName;
		}

		public void setTeamName(String teamName) {
			this.teamName = teamName;
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

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public String getPlayerName() {
			return playerName;
		}

		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getShirtName() {
			return shirtName;
		}

		public void setShirtName(String shirtName) {
			this.shirtName = shirtName;
		}

		public String getClub() {
			return club;
		}

		public void setClub(String club) {
			this.club = club;
		}

		public String getHeight() {
			return height;
		}

		public void setHeight(String height) {
			this.height = height;
		}

		public String getWeight() {
			return weight;
		}

		public void setWeight(String weight) {
			this.weight = weight;
		}	



}
