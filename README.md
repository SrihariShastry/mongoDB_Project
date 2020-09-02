# MongoDB Project

In this project, we will use MongoDB as an example of a document-oriented NOSQL system, and see how data is stored and queried in such a system. We will demonstrate the difference between storing data in a flat (relational) format versus in a document (complex object) JSON format.
The input to the program will be several data files in flat relational format for the WORLD CUP 2018 database example (see attached approximate ER and relational schemas). The files contain data records about information regarding the 2018 soccer world cup tournament. 

Project 2, Part 1:

Install Mongo DB on your computer. Load the data files into Mongo DB as flat files: TEAM, GAME, PLAYER, STARTING_LINEUP, GOALS.

Turn in documentation to show that you installed Mongo DB and created the flat file document collections corresponding to the above tables. Due date: Sunday August 4, 2019.

Project 2, Part 2:

We have designed two document (complex object) schemas corresponding to this data:

1.	The TEAM_SCORES document will include the following data about each team: Team (that is, the team name, and a collection of the team match (GAME) scores). Each match score in the collection will include: the date of the match, the name of the city and stadium where the match was played, repeat of the team’s name, the team score in the match, the name of the opposing team, and the score of the opposing team.
2.	The PLAYER_DATA document will include the following data about each player: the player name (Pname), the player’s team name (Team), the player number (PNo) and position (Position), and a collection of games that the player has started – for each game (match) the player  has started, include the MatchDate, City, Stadium Name, and opposing team name. Also include for each player a collection of goals that the player has scored (if any) – for each goal scored, include the GoalType, Time, MatchDate, City, Stadium Name, and opposing team name.

