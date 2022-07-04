package com.tugalsan.api.calender.client;

import com.tugalsan.api.cast.client.TGS_CastUtils;
import com.tugalsan.api.pack.client.TGS_Pack2;
import com.tugalsan.api.pack.client.TGS_Pack3;
import com.tugalsan.api.unsafe.client.*;
import java.util.*;

public class TGS_CalenderCastByStringUtils {

    private static TGS_Pack3<Integer, Integer, Integer> toTarget(CharSequence inputString, TGS_Pack3<Integer, Integer, Integer> targetPack, List<String> delims) {
        return TGS_UnSafe.compile(() -> {
            var inputStringStr = inputString.toString().trim();
            String delimChar = null;
            var delimStartIdx = -1;
            for (var tmp : delims) {
                if (delimStartIdx == -1) {
                    delimStartIdx = inputStringStr.indexOf(tmp);
                    if (delimStartIdx != -1) {
                        delimChar = tmp;
                    }
                }
            }
            var delimEndIdx = inputStringStr.lastIndexOf(delimChar);
            if (delimStartIdx == -1) {//first tag onlu
                targetPack.value0 = TGS_CastUtils.toInteger(inputStringStr);
            } else if (delimEndIdx == -1) {//two tag only
                targetPack.value0 = TGS_CastUtils.toInteger(inputStringStr.substring(0, delimStartIdx));
                targetPack.value1 = TGS_CastUtils.toInteger(inputStringStr.substring(delimStartIdx + 1));
            } else {
                targetPack.value0 = TGS_CastUtils.toInteger(inputStringStr.substring(0, delimStartIdx));
                targetPack.value1 = TGS_CastUtils.toInteger(inputStringStr.substring(delimStartIdx + 1, delimEndIdx));
                targetPack.value2 = TGS_CastUtils.toInteger(inputStringStr.substring(delimEndIdx + 1, inputStringStr.length()));
            }
            if (targetPack.value0 == null || targetPack.value1 == null || targetPack.value2 == null) {
                return null;
            }
            return targetPack;
        }, e -> null);
    }

    public static TGS_Pack3<Integer, Integer, Integer> toTime(CharSequence timeString) {
        return toTarget(timeString, TGS_CalenderSetNowUtils.newTime(), new ArrayList(Arrays.asList(":", "-", " ")));
    }

    public static TGS_Pack3<Integer, Integer, Integer> toDate(CharSequence dateString) {
        return toTarget(dateString, TGS_CalenderSetNowUtils.newDate(), new ArrayList(Arrays.asList(".", "/", "-", " ")));
    }

    public static TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> toCalender(CharSequence dateString_space_timeString) {//09.01.2021 20:54:23
        return TGS_UnSafe.compile(() -> {
            var split = dateString_space_timeString.toString().split(" ");
            var date = toDate(split[0]);
            var time = toTime(split[1]);
            if (date == null || time == null) {
                return null;
            }
            return new TGS_Pack2(time, date);
        }, e -> null);
    }

    public static TGS_Pack3<Integer, Integer, Integer> toDateHTML5(CharSequence YYYY_MM_DD) {
        return TGS_UnSafe.compile(() -> {
            TGS_Pack3<Integer, Integer, Integer> datePack = new TGS_Pack3();
            datePack.value2 = TGS_CastUtils.toInteger(YYYY_MM_DD.subSequence(0, 4).toString());
            datePack.value1 = TGS_CastUtils.toInteger(YYYY_MM_DD.subSequence(5, 7).toString());
            datePack.value0 = TGS_CastUtils.toInteger(YYYY_MM_DD.subSequence(8, 10).toString());
            if (datePack.value0 == null || datePack.value1 == null || datePack.value2 == null) {
                return null;
            }
            return datePack;
        }, e -> null);
    }
}
