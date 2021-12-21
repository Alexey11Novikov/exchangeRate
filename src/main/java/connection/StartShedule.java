package connection;

import java.util.TimerTask;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class StartShedule extends TimerTask {


  public void run() {
    ConnectApi connection = new ConnectApi();
    connection.connect();
    Calendar date = Calendar.getInstance();

    String endDate = new SimpleDateFormat("yyyy-MM-dd").format(date.getTime());
    date.add(Calendar.DATE, -1);
    Date yesterday = date.getTime();
  }
}
