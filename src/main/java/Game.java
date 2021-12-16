import lombok.Data;

@Data
public class Game
{
  public String away;
  public String home;
  public int away_score;
  public int home_score;
  public String date;

  public Game(String away, String home, int away_score, int home_score, String date )
  {
    this.away = away;
    this.home = home;
    this.away_score = away_score;
    this.home_score = home_score;
    this.date = date;
  }
}
