import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GameArrayGenerator
{

  protected String currentDirectory = System.getProperty("user.dir");
  protected String year = "2018";

  public void generate2021GamesFile() throws IOException
  {
    ArrayList<Game> games2021 = new ArrayList<>();
    NcaaPageParser ncaaPageParser = new NcaaPageParser();

    //parse pages.

    //Nov
    for(int i = 6; i <= 30; i++)
    {
      String dayString = String.valueOf(i);
      if(i < 10)
      {
        dayString = "0" + dayString;
      }

      String gameDate = year + "/" + "11/" + dayString;
      ArrayList<Game> pageGames = ncaaPageParser.pageToGames( "https://www.ncaa.com/scoreboard/basketball-men/d1/"+ gameDate +"/all-conf", gameDate );
      games2021.addAll( pageGames );
    }

    //Dec
    for(int i = 1; i <= 31; i++)
    {
      String dayString = String.valueOf(i);
      if(i < 10)
      {
        dayString = "0" + dayString;
      }

      String gameDate = year + "/" + "12/" + dayString;
      ArrayList<Game> pageGames = ncaaPageParser.pageToGames( "https://www.ncaa.com/scoreboard/basketball-men/d1/"+ gameDate +"/all-conf", gameDate );
      games2021.addAll( pageGames );
    }

    year = "2019";

    //Jan
    for(int i = 1; i <= 31; i++)
    {
      String dayString = String.valueOf(i);
      if(i < 10)
      {
        dayString = "0" + dayString;
      }

      String gameDate = year + "/" + "01/" + dayString;
      ArrayList<Game> pageGames = ncaaPageParser.pageToGames( "https://www.ncaa.com/scoreboard/basketball-men/d1/"+ gameDate +"/all-conf", gameDate );
      games2021.addAll( pageGames );
    }

    //Feb
    for(int i = 1; i <= 28; i++)
    {
      String dayString = String.valueOf(i);
      if(i < 10)
      {
        dayString = "0" + dayString;
      }

      String gameDate = year + "/" + "02/" + dayString;
      ArrayList<Game> pageGames = ncaaPageParser.pageToGames( "https://www.ncaa.com/scoreboard/basketball-men/d1/"+ gameDate +"/all-conf", gameDate );
      games2021.addAll( pageGames );
    }

    //Mar
    for(int i = 1; i <= 17; i++)
    {
      String dayString = String.valueOf(i);
      if(i < 10)
      {
        dayString = "0" + dayString;
      }

      String gameDate = year + "/" + "03/" + dayString;
      ArrayList<Game> pageGames = ncaaPageParser.pageToGames( "https://www.ncaa.com/scoreboard/basketball-men/d1/"+ gameDate +"/all-conf", gameDate );
      games2021.addAll( pageGames );
    }

    //Write file
    String json = new GsonBuilder().setPrettyPrinting().create().toJson( games2021 );
    File file = new File( currentDirectory + File.separator + "ncaa_2018_2019_games.json" );
    FileWriter fileWriter = new FileWriter( file );
    fileWriter.write( json );
    fileWriter.close();
  }
}
