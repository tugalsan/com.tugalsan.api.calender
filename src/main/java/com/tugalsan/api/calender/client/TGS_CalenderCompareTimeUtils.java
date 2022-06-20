package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack3;

public class TGS_CalenderCompareTimeUtils {

    public static boolean equal(TGS_Pack3<Integer, Integer, Integer> srcTimePack, TGS_Pack3<Integer, Integer, Integer> toTimePack) {
        return TGS_CalenderCastByLongUtils.toTime(srcTimePack) == TGS_CalenderCastByLongUtils.toTime(toTimePack);
    }

    public static boolean greater(TGS_Pack3<Integer, Integer, Integer> srcTimePack, TGS_Pack3<Integer, Integer, Integer> toTimePack) {
        return TGS_CalenderCastByLongUtils.toTime(srcTimePack) > TGS_CalenderCastByLongUtils.toTime(toTimePack);
    }

    public static boolean greaterOrEqual(TGS_Pack3<Integer, Integer, Integer> srcTimePack, TGS_Pack3<Integer, Integer, Integer> toTimePack) {
        return TGS_CalenderCastByLongUtils.toTime(srcTimePack) >= TGS_CalenderCastByLongUtils.toTime(toTimePack);
    }

    public static boolean smaller(TGS_Pack3<Integer, Integer, Integer> srcTimePack, TGS_Pack3<Integer, Integer, Integer> toTimePack) {
        return TGS_CalenderCastByLongUtils.toTime(srcTimePack) < TGS_CalenderCastByLongUtils.toTime(toTimePack);
    }

    public static boolean smallerOrEqual(TGS_Pack3<Integer, Integer, Integer> srcTimePack, TGS_Pack3<Integer, Integer, Integer> toTimePack) {
        return TGS_CalenderCastByLongUtils.toTime(srcTimePack) <= TGS_CalenderCastByLongUtils.toTime(toTimePack);
    }
}
