import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamScores
{
    protected String team;
    protected double ottScore;
    protected double ott2Score;

    @Override
    public String toString()
    {
        return team + "," + ottScore + "," + ott2Score;
    }

}
