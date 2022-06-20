package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack3;

public class TGS_CalenderIncrementUtils {

    public static TGS_Pack3<Integer, Integer, Integer> second(TGS_Pack3<Integer, Integer, Integer> targetTimePack, int secondStep) {
        targetTimePack.value0 += secondStep;
        while (targetTimePack.value0 < 0) {
            targetTimePack.value0 += 60;
            minute(targetTimePack, -1);
        }
        while (targetTimePack.value0 > 60) {
            targetTimePack.value0 -= 60;
            minute(targetTimePack, +1);
        }
        return targetTimePack;
    }

    public static TGS_Pack3<Integer, Integer, Integer> minute(TGS_Pack3<Integer, Integer, Integer> targetTimePack, int minuteStep) {
        targetTimePack.value1 += minuteStep;
        while (targetTimePack.value1 < 0) {
            targetTimePack.value1 += 60;
            hour(targetTimePack, -1);
        }
        while (targetTimePack.value1 > 60) {
            targetTimePack.value1 -= 60;
            hour(targetTimePack, +1);
        }
        return targetTimePack;
    }

    public static TGS_Pack3<Integer, Integer, Integer> hour(TGS_Pack3<Integer, Integer, Integer> targetTimePack, int hourStep) {
        targetTimePack.value2 += hourStep;
        while (targetTimePack.value2 < 0) {
            targetTimePack.value2 += 24;
            day(targetTimePack, -1);
        }
        while (targetTimePack.value2 > 24) {
            targetTimePack.value2 -= 24;
            day(targetTimePack, +1);
        }
        return targetTimePack;
    }

    public static TGS_Pack3<Integer, Integer, Integer> day(TGS_Pack3<Integer, Integer, Integer> targetDatePack, int dayStep) {
        var directionForward = dayStep > 0;
        dayStep = Math.abs(dayStep);
        if (directionForward) {
            while (true) {
                var dayToNextMonth = TGS_CalenderMonthUtils.dayMax(targetDatePack.value1, targetDatePack.value2) - targetDatePack.value0 + 1;
                if (dayStep >= dayToNextMonth) {
                    dayStep -= dayToNextMonth;
                    targetDatePack.value0 = 1;
                    targetDatePack.value1++;
                    if (targetDatePack.value1 == 13) {
                        targetDatePack.value1 = 1;
                        targetDatePack.value2++;
                    }
                } else {
                    targetDatePack.value0 += dayStep;
                    return targetDatePack;
                }
            }
        } else {
            while (true) {
                if (dayStep >= targetDatePack.value0) {
                    dayStep -= targetDatePack.value0;
                    targetDatePack.value1--;
                    if (targetDatePack.value1 == 0) {
                        targetDatePack.value1 = 12;
                        targetDatePack.value2--;
                    }
                    targetDatePack.value0 = TGS_CalenderMonthUtils.dayMax(targetDatePack.value1, targetDatePack.value2);
                } else {
                    targetDatePack.value0 -= dayStep;
                    return targetDatePack;
                }
            }
        }
    }

    public static TGS_Pack3<Integer, Integer, Integer> month(TGS_Pack3<Integer, Integer, Integer> targetDatePack, int i) {
        while (i != 0) {
            if (i < 0) {
                targetDatePack.value1--;
                i++;
                if (targetDatePack.value1 < 1) {
                    targetDatePack.value1 = 12;
                    targetDatePack.value2--;
                }
            } else {
                targetDatePack.value1++;
                i--;
                if (targetDatePack.value1 > 12) {
                    targetDatePack.value1 = 1;
                    targetDatePack.value2++;
                }
            }
        }
        return targetDatePack;
    }

    public static TGS_Pack3<Integer, Integer, Integer> year(TGS_Pack3<Integer, Integer, Integer> targetDatePack, int i) {
        targetDatePack.value2 += i;
        return targetDatePack;
    }
}
