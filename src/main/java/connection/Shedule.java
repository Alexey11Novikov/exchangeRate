package connection;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Shedule {
    Timer timer = new Timer();

    public void sheduleSend(Calendar date) {
      if (date.getTime().before(new Date())) {
        date.add(Calendar.DATE, 1);
      }
      timer.scheduleAtFixedRate(new StartShedule(), date.getTime(), 1000 * 60 * 60 * 24);
    }
}
