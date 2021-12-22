package connection;

import java.util.TimerTask;

import parseJson.ParseJson;

import java.io.FileNotFoundException;


public class StartShedule extends TimerTask {


  public void run() {
    ParseJson parseJson =new ParseJson();
    try {
      parseJson.findBestValute();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
