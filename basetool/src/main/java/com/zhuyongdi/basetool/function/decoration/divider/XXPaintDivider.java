package com.zhuyongdi.basetool.function.decoration.divider;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by dkzwm on 2017/4/11.
 *
 * @author dkzwm
 */

public class XXPaintDivider implements XXIDivider {

    private Paint mPaint;

    public XXPaintDivider(Paint paint) {
        mPaint = paint;
    }

    @Override
    public void draw(Canvas canvas, float left, float top, float right, float bottom) {
        canvas.drawLine(left, top, right, bottom, mPaint);
    }

    @Override
    public int getType() {
        return TYPE_PAINT;
    }

    @Override
    public int getDividerSize() {
        return Math.round(mPaint.getStrokeWidth());
    }

}
