import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class Main
{



  public static void main(String[] args) throws IOException, RestClientResponseCheckedException
  {

    //members
    String currentDirectory = System.getProperty("user.dir");

    //Create game file
//    GameArrayGenerator gameArrayGenerator = new GameArrayGenerator();
//    gameArrayGenerator.generate2021GamesFile();


    //Read game file
    File file = new File( currentDirectory + File.separator + "ncaa_2018_2019_games.json" );
    String fileContent = new String( Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
    List<Game> games = new Gson().fromJson(fileContent, new TypeToken<List<Game>>(){}.getType());

    //do stuff

    CommonPlayedTeamFinder commonPlayedTeamFinder = new CommonPlayedTeamFinder();
    commonPlayedTeamFinder.findCommonPlayedTeams( games, null, null, 1 );

    //OTT
//    OttScoreCalculator ottScoreCalculator = new OttScoreCalculator();
//    Map<String, TeamScores> allTeamsScores = ottScoreCalculator.calculateOtt1Scores( games );
//    for(int i = 0; i < 50; i++)
//    {
//      allTeamsScores = ottScoreCalculator.calculateOtt2Scores( allTeamsScores, games );
//    }
//
//
//    System.out.println("team,ott,ott2");
//    for(TeamScores scores : allTeamsScores.values())
//    {
//      System.out.println(scores);
//    }



    return;
  }

}
