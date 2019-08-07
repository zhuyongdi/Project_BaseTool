package com.zhuyongdi.basetool.widget.image_view.round;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class XXRoundImageView extends ImageView {

    private XXRoundImageViewHelper mHelper;

    public XXRoundImageView(Context context) {
        this(context, null);
    }

    public XXRoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHelper = new XXRoundImageViewHelper(context, this, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        if (mHelper.isNormal()) {
            super.onDraw(canvas);
        } else {
            mHelper.onDraw(canvas);
        }
    }

    public XXRoundImageViewHelper getHelper() {
        return mHelper;
    }

}
