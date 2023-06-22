package WeatherAPI;

import java.time.LocalTime;

public class TimeNow{

    String TimeNow() {

        LocalTime time=LocalTime.now();
        int hour=time.getHour()-1;
        int minute= time.getMinute();
        String strHour=hour+"";
        String strMinute=minute+"";

        String strTime=strHour.concat(strMinute);
        return strTime;
    }
}