package connection;

import java.io.IOException;
import java.util.TimerTask;

import parseJson.ParseJson;

import java.io.FileNotFoundException;


public class StartShedule extends TimerTask {

  ParseJson parseJson = new ParseJson();
  public void run() {
    try {
      parseJson.findBestValute();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
