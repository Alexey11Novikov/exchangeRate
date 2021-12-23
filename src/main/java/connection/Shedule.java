package connection;

import parseJson.ResultOut;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Shedule {
    Timer timer = new Timer();
    ResultOut result = new ResultOut();

    public void sheduleSend(Calendar date) {
      if (date.getTime().before(new Date())) {
        date.add(Calendar.DATE, 1);
      }
        result.printDate(date.getTime().toString());
      timer.scheduleAtFixedRate(new StartShedule(), date.getTime(), 1000 * 60 * 60 * 24);
    }
}
