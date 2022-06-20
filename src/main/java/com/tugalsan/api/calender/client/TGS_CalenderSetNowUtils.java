package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack2;
import com.tugalsan.api.pack.client.TGS_Pack3;
import java.util.Date;

public class TGS_CalenderSetNowUtils {

    public static TGS_Pack3<Integer, Integer, Integer> newTime() {
        return TGS_CalenderCastByDateUtils.toTime(new Date());
    }

    public static TGS_Pack3<Integer, Integer, Integer> setTime(TGS_Pack3<Integer, Integer, Integer> timePack) {
        var now = TGS_CalenderCastByDateUtils.toTime(new Date());
        timePack.value0 = now.value0;
        timePack.value1 = now.value1;
        timePack.value2 = now.value2;
        return timePack;
    }

    public static TGS_Pack3<Integer, Integer, Integer> newDate() {
        return TGS_CalenderCastByDateUtils.toDate(new Date());
    }

    public static TGS_Pack3<Integer, Integer, Integer> setDate(TGS_Pack3<Integer, Integer, Integer> datepack) {
        var now = TGS_CalenderCastByDateUtils.toTime(new Date());
        datepack.value0 = now.value0;
        datepack.value1 = now.value1;
        datepack.value2 = now.value2;
        return datepack;
    }

    public static TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> newCalender() {
        return TGS_CalenderCastByDateUtils.toCalender(new Date());
    }

    public static TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> setCalender(TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> calenderPack) {
        var now = newCalender();
        calenderPack.value0.value0 = now.value0.value0;
        calenderPack.value0.value1 = now.value0.value1;
        calenderPack.value0.value2 = now.value0.value2;
        calenderPack.value1.value0 = now.value1.value0;
        calenderPack.value1.value1 = now.value1.value1;
        calenderPack.value1.value2 = now.value1.value2;
        return calenderPack;
    }

    public static int hour() {
        return newTime().value2;
    }

    public static int minute() {
        return newTime().value1;
    }

    public static int second() {
        return newTime().value0;
    }

    public static int day() {
        return newDate().value0;
    }

    public static int month() {
        return newDate().value1;
    }

    public static int year() {
        return newDate().value2;
    }

    public static long date() {
        return TGS_CalenderCastByLongUtils.toDate(newDate());
    }

    public static long time() {
        return TGS_CalenderCastByLongUtils.toTime(newTime());
    }
}
