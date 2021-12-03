import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main
{

  public enum Team
  {
    Byu,
    ClevelandSt,
    SanDiegoSt,
    Oregon,
    CentralMethodist,
    TxSouthern,
    Utah,
    UtahValley,
    MissouriState,
    UtahState,
    Creighton,
    WeberState,
    SouthFlorida,
    WestminsterUt,
    Portland,
    Pacific,
    SaintMarys,
    Gonzaga,
    SanFrancisco,
    SanDiego,
    SantoClara,
    Lmu,
    Pepperdine
  }

  public static void main(String[] args) throws IOException
  {
    String currentDirectory = System.getProperty("user.dir");

    ArrayList<Game> gamesMap = new ArrayList<>();
    gamesMap.add( new Game( "ClevelandSt", "Byu", 59, 69, "11_9" ) );
    gamesMap.add( new Game( "SanDiegoSt", "Byu", 60, 66, "11_12" ));
    gamesMap.add( new Game( "Byu", "Oregon", 81, 49, "11_16" ));
    gamesMap.add( new Game( "CentralMethodist", "Byu", 60, 66, "11_12" ));
    gamesMap.add( new Game( "SanDiegoSt", "Byu", 60, 66, "11_12" ));

    String json = new GsonBuilder().setPrettyPrinting().create().toJson( gamesMap );
    File file = new File( currentDirectory + File.separator + "ncaa_2021_games.json" );
    FileWriter fileWriter = new FileWriter( file );
    fileWriter.write( json );
    fileWriter.close();
  }
}
