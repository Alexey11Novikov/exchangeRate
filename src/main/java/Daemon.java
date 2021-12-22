import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import config.ReadConfigImpl;
import connection.Shedule;

public class Daemon extends Thread {
  public void run() {

    try {
      if (isDaemon()) {
        System.out.println("старт потока-демона");
        ReadConfigImpl config = new ReadConfigImpl();
        Shedule timer = new Shedule();
        Calendar configTime = Calendar.getInstance();
        Calendar date = Calendar.getInstance();
        try {
          date.setTime(new SimpleDateFormat("HH:mm:ss").parse(config.getTime()));
        } catch (ParseException e) {
          e.printStackTrace();
        }

        int hour = date.get(Calendar.HOUR);
        int minute = date.get(Calendar.MINUTE);
        int second = date.get(Calendar.SECOND);
        configTime.set(Calendar.HOUR_OF_DAY, hour);
        configTime.set(Calendar.MINUTE, minute);
        configTime.set(Calendar.SECOND, second);

        timer.sheduleSend(configTime);

        sleep(10000); // заменить параметр на 1

      } else {

        System.out.println("старт обычного потока");

      }

    } catch (InterruptedException e) {

      System.err.print("Error" + e);

    } finally {

      if (!isDaemon())

        System.out.println(

            "завершение обычного потока");

      else

        System.out.println(

            "завершение потока-демона");
    }
  }
}
