package com.tugalsan.api.calender.client;

import com.tugalsan.api.pack.client.TGS_Pack2;
import com.tugalsan.api.pack.client.TGS_Pack3;
import java.util.Date;

public class TGS_CalenderCastByDateUtils {

    public static TGS_Pack3<Integer, Integer, Integer> toTime(Date date) {
        return new TGS_Pack3(
                date.getSeconds(),//Calendar.getInstance().get(Calendar.SECOND);
                date.getMinutes(),//Calendar.getInstance().get(Calendar.MINUTE);
                date.getHours()//Calendar.getInstance().get(Calendar.HOUR);
        );
    }

    public static TGS_Pack3<Integer, Integer, Integer> toDate(Date date) {
        return new TGS_Pack3(
                date.getDate(),//Calendar.getInstance().get(Calendar.DATE)
                date.getMonth() + 1,//Calendar.getInstance().get(Calendar.MONTH) + 1;
                date.getYear() + 1900//Calendar.getInstance().get(Calendar.YEAR);
        );
    }

    public static TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> toCalender(Date date) {
        return new TGS_Pack2(toTime(date), toDate(date));
    }
}
