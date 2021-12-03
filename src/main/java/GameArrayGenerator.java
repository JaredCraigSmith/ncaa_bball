import java.util.ArrayList;

public class GameArrayGenerator
{
  private String Byu = "Byu";
  private String ClevelandSt = "ClevelandSt";
  private String SanDiegoSt = "SanDiegoSt";
  private String Oregon = "Oregon";
  private String CentralMethodist = "CentralMethodist";
  private String TxSouthern = "TxSouthern";
  private String Utah = "Utah";
  private String UtahValley = "UtahValley";
  private String MissouriState = "MissouriState";
  private String UtahState = "UtahState";
  private String Creighton = "Creighton";
  private String WeberState = "WeberState";
  private String SouthFlorida = "SouthFlorida";
  private String WestminsterUt = "WestminsterUt";
  private String Portland = "Portland";
  private String Pacific = "Pacific";
  private String SaintMarys = "SaintMarys";
  private String Gonzaga = "Gonzaga";
  private String SanFrancisco = "SanFrancisco";
  private String SanDiego = "SanDiego";
  private String SantoClara = "SantoClara";
  private String Lmu = "Lmu";
  private String Pepperdine = "Pepperdine";




  public ArrayList<Game> generate2021Games()
  {
    ArrayList<Game> gamesMap = new ArrayList<>();
    gamesMap.add( new Game( ClevelandSt, Byu, 59, 69, "11_9" ) );
    gamesMap.add( new Game( SanDiego, Byu, 60, 66, "11_12" ));
    gamesMap.add( new Game( Byu, Oregon, 81, 49, "11_16" ));
    gamesMap.add( new Game( CentralMethodist, Byu, 97, 61, "11_20" ));
    gamesMap.add( new Game( TxSouthern, Byu, 81, 64, "11_24" ));
    gamesMap.add( new Game( Utah, Byu, 75, 64, "11_27" ));
    gamesMap.add( new Game( UtahValley, Byu, 65, 72, "11_27" ));
    return gamesMap;
  }
}
