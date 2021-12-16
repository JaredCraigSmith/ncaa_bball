import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamOttResult
{
    protected String team;
    protected double score;

    @Override
    public String toString()
    {
        return team + " " + score;
    }

}
