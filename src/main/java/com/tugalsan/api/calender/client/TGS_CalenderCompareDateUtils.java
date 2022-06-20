package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack3;

public class TGS_CalenderCompareDateUtils {

    public static boolean equal(TGS_Pack3<Integer, Integer, Integer> srcDatePack, TGS_Pack3<Integer, Integer, Integer> toDatePack) {
        return TGS_CalenderCastByLongUtils.toDate(srcDatePack) == TGS_CalenderCastByLongUtils.toDate(toDatePack);
    }

    public static boolean greater(TGS_Pack3<Integer, Integer, Integer> srcDatePack, TGS_Pack3<Integer, Integer, Integer> toDatePack) {
        return TGS_CalenderCastByLongUtils.toDate(srcDatePack) > TGS_CalenderCastByLongUtils.toDate(toDatePack);
    }

    public static boolean greaterOrEqual(TGS_Pack3<Integer, Integer, Integer> srcDatePack, TGS_Pack3<Integer, Integer, Integer> toDatePack) {
        return TGS_CalenderCastByLongUtils.toDate(srcDatePack) >= TGS_CalenderCastByLongUtils.toDate(toDatePack);
    }

    public static boolean smaller(TGS_Pack3<Integer, Integer, Integer> srcDatePack, TGS_Pack3<Integer, Integer, Integer> toDatePack) {
        return TGS_CalenderCastByLongUtils.toDate(srcDatePack) < TGS_CalenderCastByLongUtils.toDate(toDatePack);
    }

    public static boolean smallerOrEqual(TGS_Pack3<Integer, Integer, Integer> srcDatePack, TGS_Pack3<Integer, Integer, Integer> toDatePack) {
        return TGS_CalenderCastByLongUtils.toDate(srcDatePack) <= TGS_CalenderCastByLongUtils.toDate(toDatePack);
    }
}
