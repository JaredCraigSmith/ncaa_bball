import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class NcaaPageParser
{

  public ArrayList<Game> pageToGames(String url, String date) throws IOException
  {
    System.out.println("parsing page: " + url);
    ArrayList<Game> games = new ArrayList<>();

    Document doc = Jsoup.connect(url).get();
    Elements gameElements = doc.select( ".gamePod-game-teams" );
    for(int i = 0; i < gameElements.size(); i++)
    {
      Element gameElement = gameElements.get( i );

      //Names
      Elements teamNameElements = gameElement.select( ".gamePod-game-team-name" );
      Element team1NameElement = teamNameElements.get( 0 );
      Element team2NameElement =  teamNameElements.get( 1 );
      String team1Name = team1NameElement.text();
      String team2Name = team2NameElement.text();

      //Score
      Elements teamScoreElements = gameElement.select( ".gamePod-game-team-score" );
      Element team1ScoreElement = teamScoreElements.get( 0 );
      Element team2ScoreElement =  teamScoreElements.get( 1 );
      String team1Score = team1ScoreElement.text();
      String team2Score = team2ScoreElement.text();

      if(team1Score != null && !team1Score.isEmpty())
      {
        games.add( new Game( team1Name, team2Name, Integer.valueOf(team1Score), Integer.valueOf(team2Score), date ) );
      }
    }

    return games;
  }
}
