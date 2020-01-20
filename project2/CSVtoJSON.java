//@Author 1: Srihari Shastry (1001662267)
//@Author 2: Sushmita Ravindranath Punneshetty	(1001652846)
package project2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class CSVtoJSON {
	private static final String COMMA_DELIMITER = ",";

	public static void main(String[] args) {

		BufferedReader gameResultbr = null;					//	reading game results
		BufferedReader teamsbr = null;						// 	reading team data
		BufferedReader stadiumsbr = null;					//	reading Stadium data
		try
		{
			//Reading the csv file
			gameResultbr 	= new BufferedReader(new FileReader("world-cup-schedule-results.csv"));
			teamsbr 		= new BufferedReader(new FileReader("world-cup-teams.csv"));
			stadiumsbr 		= new BufferedReader(new FileReader("world-cup-stadiums.csv"));
			ArrayList<GameResult> gameResults = new ArrayList<>();
			ArrayList<Teams> teams = new ArrayList<>();
			ArrayList<Stadiums> stadiums = new ArrayList<>();
			String line ="";

			// Read Game Results
			gameResultbr.readLine(); 									//	skip header
			while((line=gameResultbr.readLine())!=null) {
				String[] gameDetails = line.split(COMMA_DELIMITER);
				if(gameDetails.length>0) {
					gameResults.add(
							new GameResult(	gameDetails[0], gameDetails[1], gameDetails[2],
									gameDetails[3], gameDetails[4], gameDetails[5], 
									gameDetails[6], gameDetails[7]));
				}
			}


			// Read team data
			teamsbr.readLine();											// skip header
			while((line = teamsbr.readLine())!=null) {
				String[] teamDetails = line.split(COMMA_DELIMITER);
				if(teamDetails.length>0) {
					teams.add(new Teams(teamDetails[0], teamDetails[1], teamDetails[2], teamDetails[3]));
				}
			}

			// Read stadium Data
			stadiumsbr.readLine();										// skip header
			while((line = stadiumsbr.readLine())!=null) {
				String[] stadiumDetails = line.split(COMMA_DELIMITER);
				if(stadiumDetails.length>0) {
					stadiums.add(new Stadiums(stadiumDetails[0], stadiumDetails[1], stadiumDetails[2], stadiumDetails[3]));
				}
			}

			//constructing JSON object 
			JSONObject teamJson = new JSONObject();
			JSONArray teamGamesJson = new JSONArray();
			JSONObject gameJson = new JSONObject();
			for(Teams t: teams) {
				//loop through teams
				teamJson = new JSONObject();
				teamGamesJson = new JSONArray();
				for(GameResult g: gameResults) {
					// loop through games to get the games played by each team
					// can be in teamID1 or teamID2
					if(g.getTeamID1().equals(t.getTeamID())) {
						gameJson = new JSONObject();
						gameJson.put("gameID", g.getGameID());
						gameJson.put("team1name", t.getTeamName());
						gameJson.put("team1score", g.getTeam1Score());
						gameJson.put("date", g.getMatchDate());
						//get the name of the second team
						for(Teams t1:teams) {
							if(t1.getTeamID().equals(g.getTeamID2())) {
								gameJson.put("team2name", t1.getTeamName());
								gameJson.put("team2score", g.getTeam2Score());
								break;
							}
						}
						//get Stadium data
						for(Stadiums s: stadiums) {
							if(s.getStadiumID().equals(g.getStadiumID())) {
								gameJson.put("stadiumName", s.getStadiumName());
								gameJson.put("city", s.getStadiumCity());
								break;
							}
						}
						teamGamesJson.put(gameJson);

					}else if (g.getTeamID2().equals(t.getTeamID())) {
						gameJson = new JSONObject();
						gameJson.put("gameID", g.getGameID());
						gameJson.put("team2name", t.getTeamName());
						gameJson.put("team2score", g.getTeam2Score());
						gameJson.put("date", g.getMatchDate());
						//get name of the first team
						for(Teams t1:teams) {
							if(t1.getTeamID().equals(g.getTeamID1())) {
								gameJson.put("team1name", t1.getTeamName());
								gameJson.put("team1score", g.getTeam1Score());
								break;
							}
						}
						//get stadium details
						for(Stadiums s: stadiums) {
							if(s.getStadiumID().equals(g.getStadiumID())) {
								gameJson.put("stadiumName", s.getStadiumName());
								gameJson.put("city", s.getStadiumCity());
								break;
							}
						}
						//collect all games played by the team
						teamGamesJson.put(gameJson);
					}

				}
				teamJson.put("teamName", t.getTeamName());
				teamJson.put("games", teamGamesJson);
				//	Write team details to Json file 
				write2JsonFile(teamJson);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				gameResultbr.close();
				teamsbr.close();
				stadiumsbr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void write2JsonFile(JSONObject teamJson) {
		try {
			//Write Json object to file
			FileWriter jsonWriter = new FileWriter(new File("team-results.json"),true);
			BufferedWriter br = new BufferedWriter(jsonWriter);
			br.append(teamJson.toString());
			br.newLine();
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
