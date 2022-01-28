import java.util.HashMap;

public class Team
{
  public String name;
  public HashMap<String, Team> teamsPlayed = new HashMap<>();


  public Team( String name )
  {
    this.name = name;
  }
}
