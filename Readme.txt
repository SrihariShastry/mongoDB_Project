Authors: 
Srihari Shastry (1001662267)
Sushmita Ravindranath Punneshetty(1001652846)

Building Nested JSON from the csv files: 

Create a java project with package name "project2". Copy Paste all files inside the project2 folder. 
Include "json-20180813.jar" in the build path for accessing ORG.JSON package.
Create two files "player-data.json" & "team-results.json" under the main project folder.
Copy paste all the CSV files present in the CSV folder under the main project folder.

Run CSVtoJSON.java as a java program to get the team-results data as required by the first task of phase 2
Run CSVtoJSON2.java as a java program to get the player-data as required by the second task of phase 2.

The above two programs read the required CSV files and store the data in arrays. 
Then, we loop through the arrays to construct the JSON we need as per the requirement presented in the document.
Every document which was built, is then written on to the JSON files "team-results.json" and "player-data.json".

We have used the mongoDB compass Community to import the JSON files "player-data.json" & "team-results.json" 
under "PLAYER_DATA" and "TEAM-SCORES" collections respectively.

Each document in the TEAM-SCORES collection contains details about the team such as team name, and the list of games they've played.
It also contains the stadium details and the city in which the match was played. 
It contains the team scores and team names of teh two teams.

Each document in PLAYER_DATA contains details about the player like the team he belongs to, the games he was involved in,
the list of goals he has acquired if any and against which team. 
It also includes the match details like the stadium in which the match was played, date of the match, city etc.