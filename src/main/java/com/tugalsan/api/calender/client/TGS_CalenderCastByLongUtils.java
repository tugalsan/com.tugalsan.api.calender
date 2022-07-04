package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack2;
import com.tugalsan.api.pack.client.TGS_Pack3;
import com.tugalsan.api.unsafe.client.*;

public class TGS_CalenderCastByLongUtils {

    private static long parseLastTwoDecimal(long value) {
        while (value >= 100000000L) {
            value -= 100000000L;
        }
        while (value >= 10000000L) {
            value -= 10000000L;
        }
        while (value >= 1000000L) {
            value -= 1000000L;
        }
        while (value >= 100000L) {
            value -= 100000L;
        }
        while (value >= 10000L) {
            value -= 10000L;
        }
        while (value >= 1000L) {
            value -= 1000L;
        }
        while (value >= 100L) {
            value -= 100L;
        }
        return value;
    }

    public static TGS_Pack3<Integer, Integer, Integer> toTime(long timeLong) {
        return TGS_UnSafe.compile(() -> {
            var mTimeLong = timeLong;
            var sec = parseLastTwoDecimal(mTimeLong);
            mTimeLong -= sec;
            mTimeLong /= 100L;
            var min = parseLastTwoDecimal(mTimeLong);
            mTimeLong -= min;
            mTimeLong /= 100L;
            var hour = mTimeLong;
            return new TGS_Pack3((int) sec, (int) min, (int) hour);
        }, e -> null);
    }

    public static long toTime(TGS_Pack3<Integer, Integer, Integer> timePack) {
        return (long) timePack.value0 + (long) timePack.value1 * 100L + (long) timePack.value2 * 10000L;
    }

    public static TGS_Pack3<Integer, Integer, Integer> toDate(long dateLong) {
        return TGS_UnSafe.compile(() -> {
            var mDateLong = dateLong;
            var day = parseLastTwoDecimal(mDateLong);
            mDateLong -= day;
            mDateLong /= 100L;
            var month = parseLastTwoDecimal(mDateLong);
            mDateLong -= month;
            mDateLong /= 100L;
            var year = mDateLong;
            return new TGS_Pack3((int) day, (int) month, (int) year);
        }, e -> null);
    }

    public static long toDate(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return (long) datePack.value0 + (long) datePack.value1 * 100L + (long) datePack.value2 * 10000L;
    }

    public static TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> toCalenderPack(long dateLong, long timeLong) {
        return TGS_UnSafe.compile(() -> {
            var date = TGS_CalenderCastByLongUtils.toDate(dateLong);
            var time = TGS_CalenderCastByLongUtils.toTime(timeLong);
            if (date == null || time == null) {
                return null;
            }
            return new TGS_Pack2(time, date);
        }, e -> null);
    }
}
