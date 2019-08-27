package com.zhuyongdi.basetool.widget.round;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Checkable;
import android.widget.ImageView;

/**
 * 作用：圆角图片
 * 作者：GcsSloop
 */
@SuppressLint("AppCompatCustomView")
public class XXRoundImageView extends ImageView implements Checkable, XXRoundAttrs {

    XXRoundHelper mRoundHelper;

    public XXRoundImageView(Context context) {
        this(context, null);
    }

    public XXRoundImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XXRoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRoundHelper = new XXRoundHelper();
        mRoundHelper.initAttrs(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRoundHelper.onSizeChanged(this, w, h);
    }

    @Override
    public void draw(Canvas canvas) {
        if (mRoundHelper.mClipBackground) {
            canvas.save();
            canvas.clipPath(mRoundHelper.mClipPath);
            super.draw(canvas);
            canvas.restore();
        } else {
            super.draw(canvas);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(mRoundHelper.mLayer, null, Canvas.ALL_SAVE_FLAG);
        super.onDraw(canvas);
        mRoundHelper.onClipDraw(canvas);
        canvas.restore();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == MotionEvent.ACTION_DOWN && !mRoundHelper.mAreaRegion.contains((int) ev.getX(), (int) ev.getY())) {
            return false;
        }
        if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_UP) {
            refreshDrawableState();
        } else if (action == MotionEvent.ACTION_CANCEL) {
            setPressed(false);
            refreshDrawableState();
        }
        return super.dispatchTouchEvent(ev);
    }


    //--- 公开接口 ----------------------------------------------------------------------------------

    public void setClipBackground(boolean clipBackground) {
        mRoundHelper.mClipBackground = clipBackground;
        invalidate();
    }

    public void setRoundAsCircle(boolean roundAsCircle) {
        mRoundHelper.mRoundAsCircle = roundAsCircle;
        invalidate();
    }

    public void setRadius(int radius) {
        for (int i = 0; i < mRoundHelper.radii.length; i++) {
            mRoundHelper.radii[i] = radius;
        }
        invalidate();
    }

    public void setTopLeftRadius(int topLeftRadius) {
        mRoundHelper.radii[0] = topLeftRadius;
        mRoundHelper.radii[1] = topLeftRadius;
        invalidate();
    }

    public void setTopRightRadius(int topRightRadius) {
        mRoundHelper.radii[2] = topRightRadius;
        mRoundHelper.radii[3] = topRightRadius;
        invalidate();
    }

    public void setBottomLeftRadius(int bottomLeftRadius) {
        mRoundHelper.radii[6] = bottomLeftRadius;
        mRoundHelper.radii[7] = bottomLeftRadius;
        invalidate();
    }

    public void setBottomRightRadius(int bottomRightRadius) {
        mRoundHelper.radii[4] = bottomRightRadius;
        mRoundHelper.radii[5] = bottomRightRadius;
        invalidate();
    }

    public void setStrokeWidth(int strokeWidth) {
        mRoundHelper.mStrokeWidth = strokeWidth;
        invalidate();
    }

    public void setStrokeColor(int strokeColor) {
        mRoundHelper.mStrokeColor = strokeColor;
        invalidate();
    }

    @Override
    public void invalidate() {
        if (null != mRoundHelper)
            mRoundHelper.refreshRegion(this);
        super.invalidate();
    }

    public boolean isClipBackground() {
        return mRoundHelper.mClipBackground;
    }

    public boolean isRoundAsCircle() {
        return mRoundHelper.mRoundAsCircle;
    }

    public float getTopLeftRadius() {
        return mRoundHelper.radii[0];
    }

    public float getTopRightRadius() {
        return mRoundHelper.radii[2];
    }

    public float getBottomLeftRadius() {
        return mRoundHelper.radii[4];
    }

    public float getBottomRightRadius() {
        return mRoundHelper.radii[6];
    }

    public int getStrokeWidth() {
        return mRoundHelper.mStrokeWidth;
    }

    public int getStrokeColor() {
        return mRoundHelper.mStrokeColor;
    }


    //--- Selector 支持 ----------------------------------------------------------------------------

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        mRoundHelper.drawableStateChanged(this);
    }

    @Override
    public void setChecked(boolean checked) {
        if (mRoundHelper.mChecked != checked) {
            mRoundHelper.mChecked = checked;
            refreshDrawableState();
            if (mRoundHelper.mOnCheckedChangeListener != null) {
                mRoundHelper.mOnCheckedChangeListener.onCheckedChanged(this, mRoundHelper.mChecked);
            }
        }
    }

    @Override
    public boolean isChecked() {
        return mRoundHelper.mChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mRoundHelper.mChecked);
    }

    public void setOnCheckedChangeListener(XXRoundHelper.OnCheckedChangeListener listener) {
        mRoundHelper.mOnCheckedChangeListener = listener;
    }

}
