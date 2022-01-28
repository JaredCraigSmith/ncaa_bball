import java.util.HashMap;
import java.util.List;

public class CommonPlayedTeamFinder
{

  private HashMap<String, HashMap> teamsPlayed = new HashMap<>();

  public void findCommonPlayedTeams( List<Game> games, String team1, String team2, int generations)
  {

    for(int i = 0; i < games.size(); i++)
    {
      Game game = games.get( i );
      if(!teamsPlayed.containsKey( game.away ))
      {
        HashMap<String, HashMap> teamsPlayed2 = new HashMap<>();
        teamsPlayed2.put( game.home, new HashMap() );
        teamsPlayed.put( game.away, teamsPlayed2 );
      }

      if(!teamsPlayed.containsKey( game.home ))
      {
        teamsPlayed.put( game.home, new HashMap() );
      }
    }

    //print
    return;
  }
}
