package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack3;

public class TGS_CalenderTimeUtils {

    public static TGS_Pack3<Integer, Integer, Integer> newStart() {
        return setStart(new TGS_Pack3());
    }

    public static TGS_Pack3<Integer, Integer, Integer> setStart(TGS_Pack3<Integer, Integer, Integer> timePack) {
        return TGS_CalenderSetTimeUtils.setZero(timePack);
    }

    public static TGS_Pack3<Integer, Integer, Integer> newEnd() {
        return setEnd(new TGS_Pack3());
    }

    public static TGS_Pack3<Integer, Integer, Integer> setEnd(TGS_Pack3<Integer, Integer, Integer> timePack) {
        timePack.value0 = 59;
        timePack.value1 = 59;
        timePack.value2 = 23;
        return timePack;
    }
}
