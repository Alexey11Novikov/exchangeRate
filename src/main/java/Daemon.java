import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import config.ConfigModule;
import connection.Shedule;

public class Daemon extends Thread {
  Calendar configTime = Calendar.getInstance();
  Calendar date = Calendar.getInstance();
  Shedule timer = new Shedule();

  String config = ConfigModule.instance().getTimeConfig();
  public void run() {
    try {
      if (isDaemon()) {
        System.out.println("старт потока-демона");

        try {
          date.setTime(new SimpleDateFormat("HH:mm:ss").parse(config));
        } catch (ParseException e) {
          e.printStackTrace();
        }

        int hour = date.get(Calendar.HOUR);
        int minute = date.get(Calendar.MINUTE);
        int second = date.get(Calendar.SECOND);
        configTime.set(Calendar.HOUR, hour);
        configTime.set(Calendar.MINUTE, minute);
        configTime.set(Calendar.SECOND, second);

        timer.sheduleSend(configTime);

        sleep(7500);

      } else {

        System.out.println("старт обычного потока");

      }

    } catch (InterruptedException e) {

      System.err.print("Error" + e);

    }
  }
}
