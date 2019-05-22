package com.zhuyongdi.basetool.tool.screen;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.zhuyongdi.basetool.bean.ScreenInfo;

import static android.content.Context.WINDOW_SERVICE;

/**
 * 屏幕相关工具类
 * Created by ZhuYongdi on 2019/3/14.
 */
public class ScreenTool {

    /**
     * 获取屏幕信息
     * 屏幕信息:屏幕宽度,屏幕高度,密度,像素密度
     */
    public static ScreenInfo getScreenInfo(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            ScreenInfo screenInfo = new ScreenInfo();
            screenInfo.setScreenWidthPx(displayMetrics.widthPixels);
            screenInfo.setScreenHeightPx(displayMetrics.heightPixels);
            screenInfo.setDensity(displayMetrics.density);
            screenInfo.setDensityDpi(displayMetrics.densityDpi);
            return screenInfo;
        }
        return null;
    }

    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display;
        if (windowManager != null) {
            display = windowManager.getDefaultDisplay();
            Point outPoint = new Point();
            if (Build.VERSION.SDK_INT >= 19) {
                //考虑到了可能有底部虚拟按键的情况
                display.getRealSize(outPoint);
            } else {
                //不可能有底部虚拟按键
                display.getSize(outPoint);
            }
            return outPoint.x;
        }
        return 0;
    }

    /**
     * 获取屏幕高度
     */
    @SuppressLint("ObsoleteSdkInt")
    public static int getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display;
        if (windowManager != null) {
            display = windowManager.getDefaultDisplay();
            Point outPoint = new Point();
            if (Build.VERSION.SDK_INT >= 19) {
                //考虑到了可能有底部虚拟按键的情况
                display.getRealSize(outPoint);
            } else {
                //不可能有底部虚拟按键
                display.getSize(outPoint);
            }
            return outPoint.y;
        }
        return 0;
    }

    /**
     * 获取状态栏的高度
     */
    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = -1;
        try {
            @SuppressLint("PrivateApi")
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }

    /**
     * 设置状态栏字体颜色变黑,Android 23 以上生效
     */
    @TargetApi(Build.VERSION_CODES.M)
    public static void setStatusBarLightMode(Activity activity) {
        if (activity.getWindow().getDecorView().getSystemUiVisibility() != (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    /**
     * 设置状态栏字体颜色变白,Android 16 以上生效
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void setStatusBarDarkMode(Activity activity) {
        if (activity.getWindow().getDecorView().getSystemUiVisibility() != (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE)) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }

    }

    /**
     * 设置沉浸式状态栏,即首先设置全屏,再设置view的高度为状态栏的高度,防止布局与状态栏重叠。
     */
    public static void setImmersiveStatusBarMode(Activity activity, View view, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            activity.getWindow().setStatusBarColor(color);
            view.getLayoutParams().height = getStatusBarHeight(activity);
            view.setLayoutParams(view.getLayoutParams());
            view.setBackgroundColor(color);
        }
    }

    /**
     * 获取沉浸式模式下的状态栏高度,当设备支持沉浸式返回状态栏高度,当设备不支持的时候返回0.
     */
    public static int getImmersiveStatusBarHeight(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return getStatusBarHeight(context);
        }
        return 0;
    }

    /**
     * 获取沉浸式模式下的屏幕高度,当设备支持沉浸式返回屏幕的高度,当设备不支持的时候返回屏幕高度减去状态栏的高度.
     */
    public static int getImmersiveScreenHeight(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return getScreenHeight(context);
        }
        return getScreenHeight(context) - getStatusBarHeight(context);
    }

}
