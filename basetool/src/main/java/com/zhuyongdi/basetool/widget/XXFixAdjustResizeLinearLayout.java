package com.zhuyongdi.basetool.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.LinearLayout;

/**
 * Created by ZhuYongdi on 2019/4/8.
 */
@SuppressLint("ObsoleteSdkInt")
public class XXFixAdjustResizeLinearLayout extends LinearLayout {

    public XXFixAdjustResizeLinearLayout(Context context) {
        super(context);
    }

    public XXFixAdjustResizeLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XXFixAdjustResizeLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public XXFixAdjustResizeLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected final boolean fitSystemWindows(Rect insets) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            insets.left = 0;
            insets.top = 0;
            insets.right = 0;
        }
        return super.fitSystemWindows(insets);
    }

    @Override
    public final WindowInsets onApplyWindowInsets(WindowInsets insets) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            return super.onApplyWindowInsets(insets.replaceSystemWindowInsets(0, 0, 0,
                    insets.getSystemWindowInsetBottom()));
        } else {
            return insets;
        }
    }

}
