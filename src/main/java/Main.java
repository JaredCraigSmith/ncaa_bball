import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
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
    File file = new File( currentDirectory + File.separator + "ncaa_2021_games.json" );
    String fileContent = new String( Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
    List<Game> games = new Gson().fromJson(fileContent, new TypeToken<List<Game>>(){}.getType());

    //do stuff
    HashMap<String, ArrayList<Double>> ottScorePrepMap = new HashMap<>();
    for(int i = 0; i < games.size(); i++)
    {
      Game game = games.get( i );
      int scoreDifference = Math.abs(game.away_score - game.home_score);
      boolean awayWon = game.away_score > game.home_score;

      double ottScore = 0;
      if(scoreDifference > 25)
      {
        ottScore = 2.5;
      }
      else if(scoreDifference >= 20)
      {
        ottScore = 2;
      }
      else if(scoreDifference >= 10)
      {
        ottScore = 1;
      }
      else
      {
        ottScore = 0;
      }

      if(!ottScorePrepMap.containsKey(game.away))
      {
        ottScorePrepMap.put(game.away, new ArrayList<>());
      }

      if(!ottScorePrepMap.containsKey(game.home))
      {
        ottScorePrepMap.put(game.home, new ArrayList<>());
      }

      if(awayWon)
      {
        ottScorePrepMap.get(game.away).add(2.5 + ottScore);
        ottScorePrepMap.get(game.home).add(2.5 - ottScore);
      }
      else
      {
        ottScorePrepMap.get(game.away).add(2.5 - ottScore);
        ottScorePrepMap.get(game.home).add(2.5 + ottScore);
      }
    }

    ArrayList<TeamOttResult> teamsOttResults = new ArrayList<>();
    for(Map.Entry<String, ArrayList<Double>> teamOttPrepScores : ottScorePrepMap.entrySet())
    {
      double score = 0;
      for(int i = 0; i < teamOttPrepScores.getValue().size(); i++)
      {
        score += teamOttPrepScores.getValue().get(i);
      }
      score = score / teamOttPrepScores.getValue().size();
      teamsOttResults.add(new TeamOttResult(teamOttPrepScores.getKey(), score));
    }

    teamsOttResults.sort(new Comparator<TeamOttResult>() {
      @Override
      public int compare(TeamOttResult o1, TeamOttResult o2)
      {
        if(o1.score > o2.score)
        {
          return -1;
        }
        else if(o1.score < o2.score)
        {
          return 1;
        }
        else {
          return 0;
        }
      }
    });

    for(int i = 0; i < teamsOttResults.size(); i++)
    {
      System.out.println(i + " " + teamsOttResults.get(i));
    }

//    int loss = 0;
//    int win = 0;
//    for(int i = 0; i < games.size(); i++)
//    {
//      Game game = games.get( i );
//      if(game.away.equals("BYU"))
//      {
//        if(game.away_score > game.home_score)
//        {
//          win += 1;
//        }
//        else
//        {
//          loss += 1;
//        }
//      }
//      else if(game.home.equals("BYU"))
//      {
//        if(game.away_score < game.home_score)
//        {
//          win += 1;
//        }
//        else
//        {
//          loss += 1;
//        }
//      }
//    }
//    System.out.println("wins: " + win + ", loss: " + loss);

    return;
  }

}
