package com.zhuyongdi.basetool.widget.banner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class XXBannerAdapter extends PagerAdapter {

    private Context context;
    private ViewPager viewPager;
    private List<View> viewList;
    private List<String> urlList;
    private XXImageLoader imageLoader;
    private XXBannerClickListener listener;

    private boolean isAutoSlide = true; //是否自动滑动
    private int currentPosition; //当前的position
    private long changeInterval; //自动滚动时间间隔
    private boolean isTouched; //是否被触摸
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {

        @Override
        public void run() {
            handler.postDelayed(this, changeInterval);
            if (currentPosition == viewList.size() - 1) {
                viewPager.setCurrentItem(2, true);
            } else {
                viewPager.setCurrentItem(currentPosition + 1, true);
            }
        }
    };

    void setChangeInterval(long millis) {
        changeInterval = millis;
    }

    void setAutoSlide(boolean isAutoSlide) {
        this.isAutoSlide = isAutoSlide;
    }

    @SuppressLint("ClickableViewAccessibility")
    XXBannerAdapter(ViewPager viewPager, List<String> urlList, XXImageLoader creator, XXBannerClickListener listener) {
        this.viewPager = viewPager;
        this.urlList = urlList;
        this.imageLoader = creator;
        this.listener = listener;
        context = viewPager.getContext();
        initView();
        viewPager.addOnPageChangeListener(new BannerChangeListener());//设置滑动监听
        viewPager.setOnTouchListener(new BannerTouchListener()); //设置触摸监听
    }

    /**
     * 开始自动轮播
     */
    void startViewPager() {
        if (!isTouched && viewPager != null && isAutoSlide) {
            handler.postDelayed(runnable, changeInterval);
            isTouched = true;
        }
    }

    /**
     * 关闭自动轮播
     */
    void stopViewPager() {
        if (isTouched && viewPager != null) {
            handler.removeCallbacks(runnable);
            isTouched = false;
        }
    }

    /**
     * 初始化图片
     */
    private void initView() {
        viewList = new ArrayList<>();
        for (int i = 0; i < urlList.size() + 2; i++) {
            final int realPosition;//真实的i
            if (i == 0) {
                realPosition = urlList.size() - 1;
            } else if (i == urlList.size() + 1) {
                realPosition = 0;
            } else {
                realPosition = i - 1;
            }
            View v = null;
            if (imageLoader != null) {
                v = imageLoader.create(context);
            }
            if (v == null) {
                v = new View(context);
            }
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onBannerClick(realPosition);
                    }
                }
            });
            viewList.add(v);
            if (imageLoader != null) {
                imageLoader.onLoadImage(context, v, urlList.get(realPosition));
            }
        }
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View arg0, @NonNull Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v = viewList.get(position);
        container.addView(v);
        return v;
    }

    private final class BannerChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
            /* 滑动中arg0==1,2,滑动停止==0 */
            if (arg0 == ViewPager.SCROLL_STATE_IDLE) {
                /* 如果滑动到第一页,则让当前item无动画(用户看不到任何反应)跳到倒数第二项 */
                if (currentPosition == 0) {
                    viewPager.setCurrentItem(viewList.size() - 2, false);
                }
                /* 如果滑动到最后一页,则让当前item无动画(用户看不到任何反应)跳回第二项 */
                else if (currentPosition == viewList.size() - 1) {
                    viewPager.setCurrentItem(1, false);
                }
            }
        }

        @Override
        public void onPageScrolled(int position, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int arg0) {
            currentPosition = arg0;
        }

    }

    private class BannerTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: //手指按下,停止滑动
                case MotionEvent.ACTION_MOVE: //手指移动,停止滑动
                    isTouched = true;
                    stopViewPager();
                    break;
                case MotionEvent.ACTION_UP: //手指抬起,开始滑动
                    view.performClick();
                    isTouched = false;
                    startViewPager();
                    break;
            }
            return false; //返回false只会执行一次此事件
        }

    }

}
