package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack3;

public class TGS_CalenderDifferenceUtils {

    public long days(TGS_Pack3<Integer, Integer, Integer> srcDatePack, TGS_Pack3<Integer, Integer, Integer> toDatePack) {
        srcDatePack = TGS_CalenderCloneUtils.newDate(srcDatePack);
        var days = 0L;
        if (TGS_CalenderCompareDateUtils.equal(srcDatePack, toDatePack)) {
            return days;
        }
        if (TGS_CalenderCompareDateUtils.smaller(srcDatePack, toDatePack)) {
            while (!TGS_CalenderCompareDateUtils.equal(srcDatePack, toDatePack)) {
                days++;
                TGS_CalenderIncrementUtils.day(srcDatePack, 1);
            }
            return days;
        }
        while (!TGS_CalenderCompareDateUtils.equal(srcDatePack, toDatePack)) {
            days--;
            TGS_CalenderIncrementUtils.day(srcDatePack, -1);
        }
        return days;
    }

    public long seconds(TGS_Pack3<Integer, Integer, Integer> srcTimePack, TGS_Pack3<Integer, Integer, Integer> toTimePack) {
        srcTimePack = TGS_CalenderCloneUtils.newTime(srcTimePack);
        var secs = 0L;
        if (TGS_CalenderCompareTimeUtils.equal(srcTimePack, toTimePack)) {
            return secs;
        }
        if (TGS_CalenderCompareTimeUtils.smaller(srcTimePack, toTimePack)) {
            while (!TGS_CalenderCompareTimeUtils.equal(srcTimePack, toTimePack)) {
                secs++;
                TGS_CalenderIncrementUtils.second(srcTimePack, 1);
            }
            return secs;
        }
        while (!TGS_CalenderCompareTimeUtils.equal(srcTimePack, toTimePack)) {
            secs--;
            TGS_CalenderIncrementUtils.second(srcTimePack, -1);
        }
        return secs;
    }
}
