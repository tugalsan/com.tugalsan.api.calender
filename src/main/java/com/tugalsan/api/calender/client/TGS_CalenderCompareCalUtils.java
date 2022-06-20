package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack2;
import com.tugalsan.api.pack.client.TGS_Pack3;

public class TGS_CalenderCompareCalUtils {

    public static boolean equal(TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> srcCalenderPack, TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> toCalenderPack) {
        return TGS_CalenderCompareDateUtils.equal(srcCalenderPack.value1, toCalenderPack.value1) && TGS_CalenderCompareTimeUtils.equal(srcCalenderPack.value0, toCalenderPack.value0);
    }

    public static boolean greater(TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> srcCalenderPack, TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> toCalenderPack) {
        return TGS_CalenderCompareDateUtils.greater(srcCalenderPack.value1, toCalenderPack.value1) || (TGS_CalenderCompareDateUtils.equal(srcCalenderPack.value1, toCalenderPack.value1) && TGS_CalenderCompareTimeUtils.greater(srcCalenderPack.value0, toCalenderPack.value0));
    }

    public static boolean greaterOrEqual(TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> srcCalenderPack, TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> toCalenderPack) {
        return greater(srcCalenderPack, toCalenderPack) || equal(srcCalenderPack, toCalenderPack);
    }

    public static boolean smaller(TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> srcCalenderPack, TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> toCalenderPack) {
        return TGS_CalenderCompareDateUtils.smaller(srcCalenderPack.value1, toCalenderPack.value1) || (TGS_CalenderCompareDateUtils.equal(srcCalenderPack.value1, toCalenderPack.value1) && TGS_CalenderCompareTimeUtils.smaller(srcCalenderPack.value0, toCalenderPack.value0));
    }

    public static boolean smallerOrEqual(TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> srcCalenderPack, TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> toCalenderPack) {
        return smaller(srcCalenderPack, toCalenderPack) || equal(srcCalenderPack, toCalenderPack);
    }

}
