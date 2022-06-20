package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack3;

public class TGS_CalenderSetDateUtils {

    public static TGS_Pack3<Integer, Integer, Integer> newZero() {
        return setZero(new TGS_Pack3());
    }

    public static TGS_Pack3<Integer, Integer, Integer> setZero(TGS_Pack3<Integer, Integer, Integer> datePack) {
        datePack.value0 = 0;
        datePack.value1 = 0;
        datePack.value2 = 0;
        return datePack;
    }

    public static boolean isZero(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return datePack.value0 == 0 && datePack.value1 == 0 && datePack.value2 == 0;
    }

    public static boolean hasZero(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return datePack.value0 == 0 || datePack.value1 == 0 || datePack.value2 == 0;
    }

    public static TGS_Pack3<Integer, Integer, Integer> newUndefined() {
        return setUndefined(new TGS_Pack3());
    }

    public static TGS_Pack3<Integer, Integer, Integer> setUndefined(TGS_Pack3<Integer, Integer, Integer> datePack) {
        datePack.value0 = 0;
        datePack.value1 = 0;
        datePack.value2 = 2000;
        return datePack;
    }

    public static boolean isUndefined(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return datePack.value0 == 0 && datePack.value1 == 0 && datePack.value2 == 2000;
    }

    public static TGS_Pack3<Integer, Integer, Integer> newNull() {
        return setNull(new TGS_Pack3());
    }

    public static TGS_Pack3<Integer, Integer, Integer> setNull(TGS_Pack3<Integer, Integer, Integer> datePack) {
        datePack.value0 = null;
        datePack.value1 = null;
        datePack.value2 = null;
        return datePack;
    }

    public static boolean isNull(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return datePack.value0 == null && datePack.value1 == null && datePack.value2 == null;
    }

    public static boolean hasNull(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return datePack.value0 == null || datePack.value1 == null || datePack.value2 == null;
    }

}
