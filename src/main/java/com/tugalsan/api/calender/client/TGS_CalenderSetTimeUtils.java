package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack3;

public class TGS_CalenderSetTimeUtils {

    public static TGS_Pack3<Integer, Integer, Integer> newZero() {
        return setZero(new TGS_Pack3());
    }

    public static TGS_Pack3<Integer, Integer, Integer> setZero(TGS_Pack3<Integer, Integer, Integer> timePack) {
        timePack.value0 = 0;
        timePack.value1 = 0;
        timePack.value2 = 0;
        return timePack;
    }

    public static boolean isZero(TGS_Pack3<Integer, Integer, Integer> timePack) {
        return timePack.value0 == 0 && timePack.value1 == 0 && timePack.value2 == 0;
    }

    public static boolean hasZero(TGS_Pack3<Integer, Integer, Integer> timePack) {
        return timePack.value0 == 0 || timePack.value1 == 0 || timePack.value2 == 0;
    }

    public static TGS_Pack3<Integer, Integer, Integer> newUndefined() {
        return setUndefined(new TGS_Pack3());
    }

    public static TGS_Pack3<Integer, Integer, Integer> setUndefined(TGS_Pack3<Integer, Integer, Integer> timePack) {
        timePack.value0 = 0;
        timePack.value1 = 99;
        timePack.value2 = 99;
        return timePack;
    }

    public static boolean isUndefined(TGS_Pack3<Integer, Integer, Integer> timePack) {
        return timePack.value0 == 0 && timePack.value1 == 99 && timePack.value2 == 99;
    }

    public static TGS_Pack3<Integer, Integer, Integer> newNull() {
        return setNull(new TGS_Pack3());
    }

    public static TGS_Pack3<Integer, Integer, Integer> setNull(TGS_Pack3<Integer, Integer, Integer> timePack) {
        timePack.value0 = null;
        timePack.value1 = null;
        timePack.value2 = null;
        return timePack;
    }

    public static boolean isNull(TGS_Pack3<Integer, Integer, Integer> timePack) {
        return timePack.value0 == null && timePack.value1 == null && timePack.value2 == null;
    }

    public static boolean hasNull(TGS_Pack3<Integer, Integer, Integer> timePack) {
        return timePack.value0 == null || timePack.value1 == null || timePack.value2 == null;
    }
}
