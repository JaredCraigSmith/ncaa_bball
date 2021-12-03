import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main
{



  public static void main(String[] args) throws IOException
  {
    String currentDirectory = System.getProperty("user.dir");

    GameArrayGenerator gameArrayGenerator = new GameArrayGenerator();

    ArrayList<Game> gamesMap = gameArrayGenerator.generate2021Games();

    String json = new GsonBuilder().setPrettyPrinting().create().toJson( gamesMap );
    File file = new File( currentDirectory + File.separator + "ncaa_2021_games.json" );
    FileWriter fileWriter = new FileWriter( file );
    fileWriter.write( json );
    fileWriter.close();
  }
}
