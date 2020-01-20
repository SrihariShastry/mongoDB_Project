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
import org.json.JSONException;
import org.json.JSONObject;

public class CSVtoJSON2 {
	private static final String COMMA_DELIMITER = ",";

	public static void main(String[] args) {

		//reading from rosters,schedule reports, stadium, goals , teams
		BufferedReader rostersInput =null;
		BufferedReader scheduleResultsInput =null;
		BufferedReader stadiumInput =null;
		BufferedReader goalsInput = null;
		BufferedReader teamsInput =null;

		//Reading from CSV

		try {
			rostersInput =new BufferedReader(new FileReader("world-cup-rosters.csv"));
			scheduleResultsInput =new BufferedReader(new FileReader("world-cup-schedule-results.csv"));
			stadiumInput =new BufferedReader(new FileReader("world-cup-stadiums.csv"));
			goalsInput =new BufferedReader(new FileReader("world-cup-goals.csv"));
			teamsInput = new BufferedReader(new FileReader("world-cup-teams.csv"));

			ArrayList<Rosters> rosters = new ArrayList<>();
			ArrayList<ScheduleResults> scheduleResults =new ArrayList<>();
			ArrayList<Stadiums> stadiums = new ArrayList<>();
			ArrayList<Goals> goals  = new ArrayList<>();
			ArrayList<Teams> teams = new ArrayList<>();

			String input = "";

			//Read Rosters

			rostersInput.readLine(); //skip header
			while((input=rostersInput.readLine())!=null) {
				String[] row = input.split(COMMA_DELIMITER);
				if(row.length>0) {
					Rosters rosterObj = new Rosters();

					rosterObj.setTeamName(row[0]);
					rosterObj.setTeamID(row[1]);
					rosterObj.setPlayerID(row[2]);
					rosterObj.setPosition(row[3]);
					rosterObj.setPlayerName(row[4]);

					rosters.add(rosterObj);

				}
			}

			//read Schedule results
			scheduleResultsInput.readLine();//skip header
			while((input=scheduleResultsInput.readLine())!=null) {
				String[] row1 = input.split(COMMA_DELIMITER);
				if(row1.length>0) {
					ScheduleResults srObj = new ScheduleResults(row1[0], row1[1], row1[2], row1[3], row1[4], row1[5]);
					scheduleResults.add(srObj);
				}
			}

			//read Stadiums
			stadiumInput.readLine();
			while((input=stadiumInput.readLine())!=null) {
				String[] row2 = input.split(COMMA_DELIMITER);
				if(row2.length>0) {
					stadiums.add(new Stadiums(row2[0], row2[1], row2[2], row2[3]));
				}
			}

			//read Goals
			goalsInput.readLine();
			while((input=goalsInput.readLine())!=null) {
				String[] row3 = input.split(COMMA_DELIMITER);
				if(row3.length>0) {
					goals.add(new Goals(row3[0], row3[1], row3[2], row3[3], row3[4]));
				}
			}

			//read Teams
			teamsInput.readLine();
			while((input=teamsInput.readLine())!=null) {
				String[] row4 = input.split(COMMA_DELIMITER);
				if(row4.length>0) {
					teams.add(new Teams(row4[0], row4[1], row4[2], row4[3]));
				}

			}

			//Constructing JSON objects and arrays

			JSONObject rostersObj = new JSONObject();
			JSONObject scheduleResultsObj = new JSONObject();
			JSONObject goalsObj = new JSONObject();

			JSONArray srArray= new JSONArray();
			JSONArray gArray = new JSONArray();
			
			//loop through rosters
			for(Rosters rosteritem : rosters ) {
				rostersObj = new JSONObject();
				srArray= new JSONArray();
				goalsObj = new JSONObject();
				gArray = new JSONArray();

				//loop through schedule results
				for(ScheduleResults sritem : scheduleResults) {		
					//team can teamid1 or teamid2
					if(rosteritem.getTeamID().equalsIgnoreCase(sritem.getTeamID1())||rosteritem.getTeamID().equalsIgnoreCase(sritem.getTeamID2())){
						scheduleResultsObj = new JSONObject();
						scheduleResultsObj.put("Match Date", sritem.getMatchDate());
						//loop through teams to get the team name 
						for(Teams titem :teams) {
							if(sritem.getTeamID1().equalsIgnoreCase(rosteritem.getTeamID())) {
								if(titem.getTeamID().equalsIgnoreCase(sritem.getTeamID2())) {
									scheduleResultsObj.put("Played Against",titem.getTeamName() );
									break;
								}

							}
							else if (sritem.getTeamID2().equalsIgnoreCase(rosteritem.getTeamID())) {
								if(titem.getTeamID().equalsIgnoreCase(sritem.getTeamID1())) {
									scheduleResultsObj.put("Played Against",titem.getTeamName() );
									break;
								}
							}

						}

						//loop through stadiums to get stadium name and city
						for(Stadiums sitem : stadiums) {
							if(sitem.getStadiumID().equalsIgnoreCase(sritem.getStadiumID())) {
								scheduleResultsObj.put("Stadium", sitem.getStadiumName());
								scheduleResultsObj.put("City", sitem.getStadiumCity());
								break;
							}
						}

						srArray.put(scheduleResultsObj);
					}


				}

				//loop through goals 
				for(Goals gitem: goals) {
					goalsObj = new JSONObject();
					if(rosteritem.getPlayerID().equalsIgnoreCase(gitem.getPlayerID()) && rosteritem.getTeamID().equalsIgnoreCase(gitem.getTeamID())) {
						//loop through schedule results
						for(ScheduleResults sritem2 : scheduleResults) {
							if(rosteritem.getTeamID().equalsIgnoreCase(sritem2.getTeamID1())||rosteritem.getTeamID().equalsIgnoreCase(sritem2.getTeamID2())){
								goalsObj.put("Match Date", sritem2.getMatchDate());
								//loop through teams to get the team name
								for(Teams titem :teams) {
									if(sritem2.getTeamID1().equalsIgnoreCase(rosteritem.getTeamID())) {
										if(titem.getTeamID().equalsIgnoreCase(sritem2.getTeamID2())) {
											goalsObj.put("Played Against",titem.getTeamName() );
											break;
										}

									}
									else if (sritem2.getTeamID2().equalsIgnoreCase(rosteritem.getTeamID())) {
										if(titem.getTeamID().equalsIgnoreCase(sritem2.getTeamID1())) {
											goalsObj.put("Played Against",titem.getTeamName() );
											break;
										}
									}

								}
								//loop through stadiums to get stadium name and city
								for(Stadiums sitem : stadiums) {
									if(sitem.getStadiumID().equalsIgnoreCase(sritem2.getStadiumID())) {
										goalsObj.put("Stadium", sitem.getStadiumName());
										goalsObj.put("City", sitem.getStadiumCity());
										break;
									}
								}

							}
						}
						goalsObj.put("Goal Type", gitem.getGoalType());
						goalsObj.put("Time", gitem.getTime());
						gArray.put(goalsObj);
						break;
					}

				}
				rostersObj.put("PlayerID", rosteritem.getPlayerID());
				rostersObj.put("PlayerName", rosteritem.getPlayerName());
				rostersObj.put("Team", rosteritem.getTeamName());
				rostersObj.put("Position", rosteritem.getPosition());
				rostersObj.put("Match Details", srArray);
				rostersObj.put("Goal Details", gArray);

				//Write player/roster details to Json file 
				write2JsonFile(rostersObj);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (JSONException e) {
			
			e.printStackTrace();
		}finally {
			try {
				rostersInput.close();
				stadiumInput.close();
				scheduleResultsInput.close();
				goalsInput.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void write2JsonFile(JSONObject playerJson) {

		try {
			//Write Json object to file
			FileWriter jsonWriter = new FileWriter(new File("player-data.json"),true);
			BufferedWriter br = new BufferedWriter(jsonWriter);
			br.append(playerJson.toString());
			br.newLine();
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
