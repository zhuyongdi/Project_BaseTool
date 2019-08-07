package com.zhuyongdi.basetool.function.screen_adaption_view.loadviewhelper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.zhuyongdi.basetool.bean.XXScreenInfo;
import com.zhuyongdi.basetool.function.screen_adaption_view.conversion.XXIConversion;
import com.zhuyongdi.basetool.function.screen_adaption_view.conversion.XXSimpleConversion;
import com.zhuyongdi.basetool.tool.screen.XXPixelUtil;
import com.zhuyongdi.basetool.tool.screen.XXScreenUtil;

public abstract class XXAbsLoadViewHelper implements XXILoadViewHelper {

    float actualDensity;
    float actualDensityDpi;
    float actualWidth;
    float actualHeight;

    int designWidth;
    int designDpi;
    float fontSize;
    String unit;

    XXAbsLoadViewHelper(Context context, int designWidth, int designDpi, float fontSize, String unit) {
        this.designWidth = designWidth;
        this.designDpi = designDpi;
        this.fontSize = fontSize;
        this.unit = unit;
        setActualParams(context);
    }

    public void reset(Context context) {
        setActualParams(context);
    }

    private void setActualParams(Context context) {
        XXScreenInfo screenInfo = XXScreenUtil.getScreenInfo(context);
        if (screenInfo != null) {
            actualWidth = screenInfo.getScreenWidthPx();
            actualHeight = screenInfo.getScreenHeightPx();
            actualDensity = screenInfo.getDensity();
            actualDensityDpi = screenInfo.getDensityDpi();
        }
    }

    public void loadView(View view) {
        loadView(view, new XXSimpleConversion());
    }

    public final void loadView(View view, XXIConversion conversion) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            conversion.transform(viewGroup, this);
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (viewGroup.getChildAt(i) instanceof ViewGroup) {
                    loadView(viewGroup.getChildAt(i), conversion);
                } else {
                    conversion.transform(viewGroup.getChildAt(i), this);
                }
            }
        } else {
            conversion.transform(view, this);
        }

    }

    public int getValue(int value) {
        if (value == 0) {
            return 0;
        } else if (value == 1) {
            return 1;
        }
        return (int) calculateValue(value);
    }

    float calculateValue(float value) {
        if ("px".equals(unit)) {
            return value * (actualWidth / (float) designWidth);
        } else if ("dp".equals(unit)) {
            int dip = XXPixelUtil.px2dp(actualDensity, value);
            value = ((float) designDpi / 160) * dip;
            return value * (actualWidth / (float) designWidth);
        }
        return 0;
    }

}
