package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack3;

public class TGS_CalenderWeekUtils {

    public static String dayNumberName(int dayNumber, boolean turkish) {
        return turkish ? NAME_TR()[dayNumber - 1] : NAME_EN()[dayNumber - 1];
    }

    private static String[] NAME_EN() {
        return new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    }

    private static String[] NAME_TR() {
        return new String[]{"Pazartesi", "Sali", "Carsamba", "Persembe", "Cuma", "Cumartesi", "Pazar"};
    }

    public final static int dayNumber(TGS_Pack3<Integer, Integer, Integer> datePack) {//1-7
        var day = datePack.value0;
        var month = datePack.value1;
        var year = datePack.value2;
        if (month < 3) {
            month += 12;
            year--;
        }
        int dow = (day + (int) ((month + 1) * 2.6) + year + (int) (year / 4) + 6 * (int) (year / 100) + (int) (year / 400) + 6) % 7;
        return dow == 0 ? 7 : dow;
    }

    public final int weekNumber(TGS_Pack3<Integer, Integer, Integer> datePack) {//TODO
        var yearStart = TGS_CalenderYearUtils.newStart(datePack);
        var dayNumber_yearStart = dayNumber(yearStart);
        var fixedDayCount = TGS_CalenderYearUtils.dayCount(datePack) + (dayNumber_yearStart - 1);
        var weekNumber = ((fixedDayCount - 1) / 7) + 1;
        if (dayNumber_yearStart != 1) {
            weekNumber--;
        }
        return weekNumber;
    }

    public static TGS_Pack3<Integer, Integer, Integer> newStart(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return setStart(TGS_CalenderCloneUtils.newDate(datePack));
    }

    public static TGS_Pack3<Integer, Integer, Integer> setStart(TGS_Pack3<Integer, Integer, Integer> datePack) {
        while (dayNumber(datePack) != 1) {
            TGS_CalenderIncrementUtils.day(datePack, -1);
        }
        return datePack;
    }

    public static TGS_Pack3<Integer, Integer, Integer> newEnd(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return setEnd(TGS_CalenderCloneUtils.newDate(datePack));
    }

    public static TGS_Pack3<Integer, Integer, Integer> setEnd(TGS_Pack3<Integer, Integer, Integer> datePack) {
        while (dayNumber(datePack) != 7) {
            TGS_CalenderIncrementUtils.day(datePack, 1);
        }
        return datePack;
    }
}
