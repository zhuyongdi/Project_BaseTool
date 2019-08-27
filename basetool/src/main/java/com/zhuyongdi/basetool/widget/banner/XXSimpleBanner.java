package com.zhuyongdi.basetool.widget.banner;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 自动轮播控件
 * Created by ZhuYongdi on 2018/8/30.
 */
public class XXSimpleBanner extends ViewPager {

    private ViewPager.PageTransformer mPageTransformer;
    private boolean mIsAutoSlide;
    private long mChangeInterval; //默认3秒
    private List<String> mImgUrlList;
    private int mPageMargin;
    private XXImageLoader mImageLoader;
    private XXFixedSpeedScroller mFixedSpeedScroller;
    private XXBannerClickListener mListener;

    public XXSimpleBanner(Context context) {
        this(context, null);
    }

    public XXSimpleBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        this.mImgUrlList = new ArrayList<>();
        this.mIsAutoSlide = true;
        this.mChangeInterval = 3000L;
        this.mFixedSpeedScroller = new XXFixedSpeedScroller(getContext());
    }

    public XXSimpleBanner urls(List<String> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            mImgUrlList.clear();
            mImgUrlList.add("null");
        } else {
            mImgUrlList.clear();
            mImgUrlList.addAll(dataList);
        }
        return this;
    }

    public XXSimpleBanner loader(XXImageLoader loader) {
        mImageLoader = loader;
        return this;
    }

    public XXSimpleBanner pageMargin(int pageMargin) {
        this.mPageMargin = pageMargin;
        return this;
    }

    public XXSimpleBanner autoEnable(boolean enable) {
        mIsAutoSlide = enable;
        return this;
    }

    public XXSimpleBanner autoInterval(TimeUnit timeUnit, int value) {
        mChangeInterval = timeUnit.toMillis(value);
        return this;
    }

    public XXSimpleBanner scroller(int duration) {
        mFixedSpeedScroller.setScrollDuration(duration);
        mFixedSpeedScroller.initViewPagerScroll(this);
        return this;
    }

    public XXSimpleBanner transformer(ViewPager.PageTransformer pageTransformer) {
        this.mPageTransformer = pageTransformer;
        return this;
    }

    public XXSimpleBanner listener(XXBannerClickListener listener) {
        this.mListener = listener;
        return this;
    }

    public void start() {
        setOffscreenPageLimit(mImgUrlList.size() + 1);
        if (mPageMargin != 0) {
            setPageMargin(mPageMargin);
        }
        XXBannerAdapter adapter = new XXBannerAdapter(this, mImgUrlList, mImageLoader, mListener);
        adapter.setAutoSlide(mIsAutoSlide);
        adapter.setChangeInterval(mChangeInterval);
        adapter.startViewPager();
        setAdapter(adapter);
        if (mPageTransformer != null) {
            setPageTransformer(true, mPageTransformer);
        }
    }

}
