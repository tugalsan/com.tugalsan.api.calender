package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack3;

public class TGS_CalenderValidUtils {

    public static boolean date(TGS_Pack3<Integer, Integer, Integer> datePack) {
        var maxMonthDays = 0;
        switch (datePack.value1) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                maxMonthDays = 31;
                break;
            case 2:
                maxMonthDays = datePack.value2 % 4 == 0 ? 29 : 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                maxMonthDays = 30;
                break;
            default:
        }
        return datePack.value0 >= 0 && datePack.value0 <= maxMonthDays && datePack.value1 >= 0 && datePack.value1 <= 12;
    }

    public static boolean time(TGS_Pack3<Integer, Integer, Integer> timePack) {
        if (timePack.value2 > 23 || timePack.value1 > 59 || timePack.value0 > 59) {
            return false;
        }
        return !(timePack.value2 < 0 || timePack.value1 < 0 || timePack.value0 < 0);
    }
}
