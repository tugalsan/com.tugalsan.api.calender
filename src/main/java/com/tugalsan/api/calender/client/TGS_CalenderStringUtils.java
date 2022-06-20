package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack3;
import com.tugalsan.api.string.client.TGS_StringUtils;

public class TGS_CalenderStringUtils {

    public static String year(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return TGS_StringUtils.make4Chars(datePack.value2);
    }

    public static String month(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return TGS_StringUtils.make2Chars(datePack.value1);
    }

    public static String day(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return TGS_StringUtils.make2Chars(datePack.value0);
    }

    public static String hour(TGS_Pack3<Integer, Integer, Integer> timePack) {
        return TGS_StringUtils.make2Chars(timePack.value2);
    }

    public static String minute(TGS_Pack3<Integer, Integer, Integer> timePack) {
        return TGS_StringUtils.make2Chars(timePack.value1);
    }

    public static String second(TGS_Pack3<Integer, Integer, Integer> timePack) {
        return TGS_StringUtils.make2Chars(timePack.value0);
    }

    public static String calender(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return TGS_StringUtils.concat(date(datePack), " ", time(datePack));
    }

    public static String time(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return TGS_StringUtils.concat(hour(datePack), ":", minute(datePack), ":", second(datePack));
    }

    public static String date(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return TGS_StringUtils.concat(day(datePack), ".", month(datePack), ".", year(datePack));
    }

    public static String calenderNoSeconds(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return TGS_StringUtils.concat(date(datePack), " ", timeNoSeconds(datePack));
    }

    public static String timeNoSeconds(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return TGS_StringUtils.concat(hour(datePack), ":", minute(datePack));
    }

    public static String dateReverse(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return TGS_StringUtils.concat(year(datePack), ".", month(datePack), ".", day(datePack));
    }

    public String dateHTML5_YYYY_MM_DD(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return year(datePack) + "-" + month(datePack) + "-" + day(datePack);
    }

    public String dateHTML5_YYYY_MM(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return year(datePack) + "-" + month(datePack);
    }
    
    public String dateStamp(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return TGS_StringUtils.concat(dateHTML5_YYYY_MM_DD(datePack), " 00:00:00.000");
    }
}
