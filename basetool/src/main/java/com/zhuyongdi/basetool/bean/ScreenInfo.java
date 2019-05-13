package com.zhuyongdi.basetool.bean;

/**
 * Created by ZhuYongdi on 2019/5/13.
 */
public class ScreenInfo {

    private int screenWidthPx;
    private int screenHeightPx;
    private float density;
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
