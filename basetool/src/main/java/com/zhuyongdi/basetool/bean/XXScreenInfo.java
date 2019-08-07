package com.zhuyongdi.basetool.bean;

/**
 * 屏幕信息
 * Created by ZhuYongdi on 2019/5/13.
 */
public class XXScreenInfo {

    /**
     * 屏幕宽度,单位px
     */
    private int screenWidthPx;

    /**
     * 屏幕高度,单位px
     */
    private int screenHeightPx;

    /**
     * 屏幕密度
     */
    private float density;

    /**
     * 屏幕像素密度
     */
    private int densityDpi;

    public int getScreenWidthPx() {
        return screenWidthPx;
    }

    public void setScreenWidthPx(int screenWidthPx) {
        this.screenWidthPx = screenWidthPx;
    }

    public int getScreenHeightPx() {
        return screenHeightPx;
    }

    public void setScreenHeightPx(int screenHeightPx) {
        this.screenHeightPx = screenHeightPx;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public int getDensityDpi() {
        return densityDpi;
    }

    public void setDensityDpi(int densityDpi) {
        this.densityDpi = densityDpi;
    }

}
