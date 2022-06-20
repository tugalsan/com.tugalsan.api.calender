package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack3;

public class TGS_CalenderYearUtils {

    public static int dayMax(int year) {
        var maxDays = 0;
        for (var i = 1; i <= 12; i++) {
            maxDays += TGS_CalenderMonthUtils.dayMax(i, year);
        }
        return maxDays;
    }

    public static int dayCount(TGS_Pack3<Integer, Integer, Integer> datePack) {
        var start = newStart(datePack);
        var diff = 1;
        while (TGS_CalenderCompareDateUtils.smaller(start, datePack)) {
            TGS_CalenderIncrementUtils.day(start, 1);
            diff++;
        }
        return diff;
    }

    public static TGS_Pack3<Integer, Integer, Integer> newStart(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return setStart(TGS_CalenderCloneUtils.newDate(datePack));
    }

    public static TGS_Pack3<Integer, Integer, Integer> setStart(TGS_Pack3<Integer, Integer, Integer> datePack) {
        datePack.value0 = 1;
        datePack.value1 = 1;
        return datePack;
    }

    public static TGS_Pack3<Integer, Integer, Integer> newEnd(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return setEnd(TGS_CalenderCloneUtils.newDate(datePack));
    }

    public static TGS_Pack3<Integer, Integer, Integer> setEnd(TGS_Pack3<Integer, Integer, Integer> datePack) {
        datePack.value0 = 31;
        datePack.value1 = 12;
        return datePack;
    }

}
