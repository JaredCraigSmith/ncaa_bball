import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main
{



  public static void main(String[] args) throws IOException, RestClientResponseCheckedException
  {
    //members
    String currentDirectory = System.getProperty("user.dir");

    //Create game file
//    GameArrayGenerator gameArrayGenerator = new GameArrayGenerator();
//    gameArrayGenerator.generate2021GamesFile();

    //Read game file
    File file = new File( currentDirectory + File.separator + "ncaa_2021_games.json" );
    String fileContent = new String( Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
    List<Game> games = new Gson().fromJson(fileContent, new TypeToken<List<Game>>(){}.getType());

    //do stuff
    int loss = 0;
    int win = 0;
    for(int i = 0; i < games.size(); i++)
    {
      Game game = games.get( i );
      if(game.away.equals("BYU"))
      {
        if(game.away_score > game.home_score)
        {
          win += 1;
        }
        else
        {
          loss += 1;
        }
      }
      else if(game.home.equals("BYU"))
      {
        if(game.away_score < game.home_score)
        {
          win += 1;
        }
        else
        {
          loss += 1;
        }
      }
    }
    System.out.println("wins: " + win + ", loss: " + loss);

    return;
  }
}
