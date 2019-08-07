package com.zhuyongdi.basetool.widget.shadow.r;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.zhuyongdi.basetool.widget.shadow.XXRSHelper;

/**
 * Created by ZhuYongdi on 2019/4/8.
 */
public class XXRSRelativeLayout extends RelativeLayout {

    private XXRSHelper helper = new XXRSHelper();

    public XXRSRelativeLayout(Context context) {
        this(context, null);
    }

    public XXRSRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XXRSRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        helper.initAttrs(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        helper.onSizeChanged(this, w, h);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        helper.createShadow(canvas);
        canvas.saveLayer(helper.mLayer, null, Canvas.ALL_SAVE_FLAG);
        canvas.save();
        super.dispatchDraw(canvas);
        helper.clipCanvas(canvas);
        canvas.restore();
        helper.clipPath(canvas);
    }

    public void setRadius(int radius) {
        for (int i = 0; i < helper.radii.length; i++) {
            helper.radii[i] = radius;
        }
        invalidate();
    }

    public void setLeftTopRadius(int leftTopRadius) {
        helper.radii[0] = leftTopRadius;
        helper.radii[1] = leftTopRadius;
        invalidate();
    }

    public void setLeftBottomRadius(int leftBottomRadius) {
        helper.radii[6] = leftBottomRadius;
        helper.radii[7] = leftBottomRadius;
        invalidate();
    }

    public void setRightTopRadius(int rightTopRadius) {
        helper.radii[2] = rightTopRadius;
        helper.radii[3] = rightTopRadius;
        invalidate();
    }

    public void setRightBottomRadius(int rightBottomRadius) {
        helper.radii[4] = rightBottomRadius;
        helper.radii[5] = rightBottomRadius;
        invalidate();
    }

    public void setShadowColor(int shadowColor) {
        helper.mShadowColor = shadowColor;
        invalidate();
    }

    public void setShadowOffsetX(int shadowOffsetX) {
        helper.mShadowOffsetX = shadowOffsetX;
        invalidate();
    }

    public void setShadowOffsetY(int shadowOffsetY) {
        helper.mShadowOffsetY = shadowOffsetY;
        invalidate();
    }

}
