package com.zhuyongdi.basetool.function.log;

import android.util.Log;

/**
 * Log工具类
 * Created by Administrator on 2019/3/18.
 */
public class ZYD_Logger {

    private static boolean isDebug;

    private ZYD_Logger() {
    }

    public static void setDebug(boolean isDebug) {
        ZYD_Logger.isDebug = isDebug;
    }

    public static boolean getIsDebug() {
        return ZYD_Logger.isDebug;
    }

    public static void v(String tag, String msg) {
        if (isDebug) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (isDebug) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, msg);
        }
    }

}
