import lombok.Data;

@Data
public class Game
{
  public String away;
  public String home;
  public int away_score;
  public int home_score;
  public String month_day;

  public Game(String away, String home, int away_score, int home_score, String month_day )
  {
    this.away = away;
    this.home = home;
    this.away_score = away_score;
    this.home_score = home_score;
    this.month_day = month_day;
  }
}
