import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OttScoreCalculator
{

  public Map<String, TeamScores> calculateOtt2Scores(Map<String, TeamScores> teamsOttResults, List<Game> games)
  {
    HashMap<String, ArrayList<Double>> ottScorePrepMap = new HashMap<>();
    for(int i = 0; i < games.size(); i++)
    {
      Game game = games.get( i );
      int scoreDifference = Math.abs(game.away_score - game.home_score);

      int score_sum = game.away_score + game.home_score;

      if(score_sum < 20)
      {
        continue; //soccer bug
      }
      boolean awayWon = game.away_score > game.home_score;

      double ottScore = 0;
      if(scoreDifference >= 25)
      {
        ottScore = 2.5;
      }
      else if(scoreDifference >= 20)
      {
        ottScore = 2;
      }
      else if( scoreDifference >= 15 )
      {
        ottScore = 1.5;
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
        ottScorePrepMap.get(game.away).add(((3.5 + ottScore) / 6) * teamsOttResults.get( game.home ).getOttScore());
        ottScorePrepMap.get(game.home).add(((3.5 - ottScore) / 6) * teamsOttResults.get( game.away ).getOttScore());
      }
      else
      {
        ottScorePrepMap.get(game.away).add(((3.5 - ottScore) / 6) * teamsOttResults.get( game.home ).getOttScore());
        ottScorePrepMap.get(game.home).add(((3.5 + ottScore) / 6) * teamsOttResults.get( game.away ).getOttScore());
      }
    }

    for( Map.Entry<String, ArrayList<Double>> teamOttPrepScores : ottScorePrepMap.entrySet())
    {
      double score = 0;
      for(int i = 0; i < teamOttPrepScores.getValue().size(); i++)
      {
        score += teamOttPrepScores.getValue().get(i);
      }
      score = score / teamOttPrepScores.getValue().size();

      if(teamOttPrepScores.getValue().size() < 5)
      {
        score = 0;
      }

      TeamScores teamScores = teamsOttResults.get( teamOttPrepScores.getKey() );
      teamScores.setOttScore( score );
    }

    return teamsOttResults;
  }


  public Map<String, TeamScores> calculateOtt1Scores( List<Game> games)
  {
    HashMap<String, ArrayList<Double>> ottScorePrepMap = new HashMap<>();
    for(int i = 0; i < games.size(); i++)
    {
      Game game = games.get( i );
      int scoreDifference = Math.abs(game.away_score - game.home_score);
      int score_sum = game.away_score + game.home_score;

      if(score_sum < 20)
      {
        continue; //soccer bug
      }

      boolean awayWon = game.away_score > game.home_score;

      double ottScore = 0;

      if(scoreDifference >= 25)
      {
        ottScore = 2.5;
      }
      else if(scoreDifference >= 20)
      {
        ottScore = 2;
      }
      else if( scoreDifference >= 15 )
      {
        ottScore = 1.5;
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
        ottScorePrepMap.get(game.away).add(3.5 + ottScore);
        ottScorePrepMap.get(game.home).add(3.5 - ottScore);
      }
      else
      {
        ottScorePrepMap.get(game.away).add(3.5 - ottScore);
        ottScorePrepMap.get(game.home).add(3.5 + ottScore);
      }
    }

    HashMap<String, TeamScores> teamsOttResults = new HashMap<String, TeamScores>();
    for( Map.Entry<String, ArrayList<Double>> teamOttPrepScores : ottScorePrepMap.entrySet())
    {
      double score = 0;
      for(int i = 0; i < teamOttPrepScores.getValue().size(); i++)
      {
        score += teamOttPrepScores.getValue().get(i);
      }
      score = score / teamOttPrepScores.getValue().size();

      if(teamOttPrepScores.getValue().size() < 5)
      {
        score = 0;
      }

      TeamScores teamScores = new TeamScores();
      teamScores.setTeam( teamOttPrepScores.getKey() );
      teamScores.setOttScore( score );
      teamsOttResults.put(teamOttPrepScores.getKey(), teamScores);
    }

    return teamsOttResults;
  }
}
