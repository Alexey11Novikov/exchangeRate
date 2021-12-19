package connection;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;


public class Shedule extends TimerTask {

    public void run() {

        Calendar date = Calendar.getInstance();

        String endDate = new SimpleDateFormat("yyyy-MM-dd").format(date.getTime());
        date.add(Calendar.DATE, -1);
        Date yesterday = date.getTime();
    }
}
