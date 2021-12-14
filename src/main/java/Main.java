import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main
{



  public static void main(String[] args) throws IOException, RestClientResponseCheckedException
  {
    //NcaaComClient ncaaComClient = new NcaaComClient();
    //String test = ncaaComClient.getMensBasketBallPage( "2021/12/

    NcaaPageParser ncaaPageParser = new NcaaPageParser();
    ncaaPageParser.pageToGames( "https://www.ncaa.com/scoreboard/basketball-men/d1/2021/12/01/all-conf" );

    return;

//    String currentDirectory = System.getProperty("user.dir");
//
//    GameArrayGenerator gameArrayGenerator = new GameArrayGenerator();
//
//    ArrayList<Game> gamesMap = gameArrayGenerator.generate2021Games();
//
//    String json = new GsonBuilder().setPrettyPrinting().create().toJson( gamesMap );
//    File file = new File( currentDirectory + File.separator + "ncaa_2021_games.json" );
//    FileWriter fileWriter = new FileWriter( file );
//    fileWriter.write( json );
//    fileWriter.close();
  }
}
