package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack3;

public class TGS_CalenderMonthUtils {

    public static String monthName(int month, boolean turkish) {
        return turkish ? NAME_TR()[month - 1] : NAME_EN()[month - 1];
    }

    private static String[] NAME_EN() {
        return new String[]{"Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
    }

    private static String[] NAME_TR() {
        return new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    }

    public static int dayMax(int month, int year) {
        if (month < 1 || month > 12) {
            return 0;
        }
        if (month != 2) {
            return MONTH_LENGTH(month);
        }
        var i = year % 4;
        if (i == 0) {
            return MONTH_LENGTH(month) + 1;
        } else {
            return MONTH_LENGTH(month);
        }
    }

    private static int MONTH_LENGTH(int monthNumber) {
        return new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}[monthNumber - 1];
    }

    public static TGS_Pack3<Integer, Integer, Integer> newStart(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return setStart(TGS_CalenderCloneUtils.newDate(datePack));
    }

    public static TGS_Pack3<Integer, Integer, Integer> setStart(TGS_Pack3<Integer, Integer, Integer> datePack) {
        datePack.value0 = 1;
        return datePack;
    }

    public static TGS_Pack3<Integer, Integer, Integer> newEnd(TGS_Pack3<Integer, Integer, Integer> datePack) {
        return setEnd(TGS_CalenderCloneUtils.newDate(datePack));
    }

    public static TGS_Pack3<Integer, Integer, Integer> setEnd(TGS_Pack3<Integer, Integer, Integer> datePack) {
        datePack.value0 = 31;
        return datePack;
    }
}
