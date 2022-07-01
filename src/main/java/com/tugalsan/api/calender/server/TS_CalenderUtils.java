package com.tugalsan.api.calender.server;

import com.sun.jna.*;
import com.sun.jna.platform.win32.WinBase.*;
import com.sun.jna.win32.*;
import com.tugalsan.api.pack.client.*;
import com.tugalsan.api.string.client.*;
import com.tugalsan.api.unsafe.client.*;
import java.text.*;
import java.util.*;

public class TS_CalenderUtils {

    public static String defaultDateFormat() {
        return "yyyy-MM-dd HH:mm:ss";
    }

    public static Date date(String dateStr, String dateFormat) {
        return TGS_UnSafe.compile(() -> {
            var sdf = new SimpleDateFormat(dateFormat);
            return sdf.parse(dateStr);
        });
    }

    public static interface WinKernel32 extends StdCallLibrary {

        boolean SetLocalTime(SYSTEMTIME st);
        WinKernel32 instance = (WinKernel32) Native.load("kernel32.dll", WinKernel32.class);
    }

    public static boolean setDateAndTime(TGS_Pack2<TGS_Pack3<Integer, Integer, Integer>, TGS_Pack3<Integer, Integer, Integer>> calenderPack) {
        if (System.getProperty("os.name").toLowerCase(Locale.ROOT).startsWith("windows")) {
            var st = new SYSTEMTIME();
            st.wYear = calenderPack.value1.value2.shortValue();
            st.wMonth = calenderPack.value1.value1.shortValue();
            st.wDay = calenderPack.value1.value0.shortValue();
            st.wHour = calenderPack.value0.value2.shortValue();
            st.wMinute = calenderPack.value0.value1.shortValue();
            st.wSecond = calenderPack.value0.value0.shortValue();
            return WinKernel32.instance.SetLocalTime(st);
        } else {
            var b1 = execute(TGS_StringUtils.concat(
                    "date +%Y%m%d -s \"" + TGS_StringUtils.make4Chars(calenderPack.value1.value2),
                    TGS_StringUtils.make2Chars(calenderPack.value1.value1),
                    TGS_StringUtils.make2Chars(calenderPack.value1.value0),
                    "\""
            ));
            var b2 = execute(TGS_StringUtils.concat(
                    "date +%T -s \"",
                    TGS_StringUtils.make2Chars(calenderPack.value0.value1),
                    ":",
                    TGS_StringUtils.make2Chars(calenderPack.value0.value1),
                    ":",
                    TGS_StringUtils.make2Chars(calenderPack.value0.value0),
                    "\""
            ));
            return b1 && b2;
        }
    }

    private static boolean execute(CharSequence commandLine) {
        try {
            Runtime.getRuntime().exec(commandLine.toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
