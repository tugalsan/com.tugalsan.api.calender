package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack2;
import com.tugalsan.api.pack.client.TGS_Pack3;

public class TGS_CalenderCloneUtils {

    public static TGS_Pack3<Integer, Integer, Integer> newDate(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return new TGS_Pack3(datePack.value0, datePack.value1, datePack.value2);
    }

    public static TGS_Pack3<Integer, Integer, Integer> newTime(TGS_Pack3<Integer, Integer, Integer> dateTime) {
        return new TGS_Pack3(dateTime.value0, dateTime.value1, dateTime.value2);
    }

    public static TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> newCalender(TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> calenderPack) {
        return new TGS_Pack2(newTime(calenderPack.value0), newDate(calenderPack.value1));
    }
}
