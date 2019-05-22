package com.zhuyongdi.basetool.tool.anim;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

/**
 * SmoothScrollTo(0,value)动画
 * Created by ZhuYongdi on 2019/5/17.
 */
public class SmoothScrollAnimator {

    /**
     * 属性动画
     */
    private ValueAnimator mAnimator = new ValueAnimator();

    /**
     * 动画view
     */
    private View mView;

    /**
     * 设置动画view
     */
    public SmoothScrollAnimator view(View view) {
        this.mView = view;
        return this;
    }

    /**
     * 设置动画时长
     */
    public SmoothScrollAnimator duration(long duration) {
        mAnimator.setDuration(duration);
        return this;
    }

    /**
     * 设置动画差值器
     */
    public SmoothScrollAnimator interpolator(TimeInterpolator interpolator) {
        mAnimator.setInterpolator(interpolator);
        return this;
    }

    /**
     * 设置动画值
     */
    public SmoothScrollAnimator intValues(int... values) {
        mAnimator.setIntValues(values);
        return this;
    }

    /**
     * 开始动画
     */
    public void start() {
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                if (mView != null) {
                    mView.scrollTo(0, value);
                }
            }
        });
        mAnimator.start();
    }

}
