package com.zhuyongdi.basetool.tool.screen;

import android.content.Context;

/**
 * 像素相关工具类
 * Created by ZhuYongdi on 2019/4/17.
 */
public class XXPixelUtil {

    //dp转px
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    //px转px
    public static int dp2px(float scale, float dpValue) {
        return (int) (dpValue * scale + 0.5f);
    }

    //px转dp
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    //px转dp
    public static int px2dp(float scale, float pxValue) {
        return (int) (pxValue / scale + 0.5f);
    }

    //sp转px
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    //sp转px
    public static int sp2px(float fontScale, float spValue) {
        return (int) (spValue * fontScale + 0.5f);
    }

    //px转sp
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    //px转sp
    public static int px2sp(float fontScale, float pxValue) {
        return (int) (pxValue / fontScale + 0.5f);
    }
}
