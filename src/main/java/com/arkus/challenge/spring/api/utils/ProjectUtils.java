package com.arkus.challenge.spring.api.utils;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ProjectUtils {
    public static String getDateYYYYMMDD(){
        Date date = new Date(); // your date
        // Choose time zone in which you want to interpret your Date
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Mexico"));
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        return buildDataBaseDateString(year,month,day);
    }

    public static String buildDataBaseDateString(int year, int month, int day){
        return new StringBuilder()  .append(year)
                .append("-")
                .append(month)
                .append("-").
                append(new DecimalFormat("00").format(day)).toString();
    }
}
