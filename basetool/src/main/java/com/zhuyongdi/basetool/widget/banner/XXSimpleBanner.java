package com.zhuyongdi.basetool.widget.banner;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import com.zhuyongdi.basetool.tool.XXListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 自动轮播控件
 * Created by ZhuYongdi on 2018/8/30.
 */
public class XXSimpleBanner extends ViewPager {

    private XXFixedSpeedScroller fixedSpeedScroller;
    private XXBannerAdapter adapter;
    private List<String> mUrlList;
    private List<View> mViewList;
    private XXImageLoader mImageLoader;
    private boolean autoEnable = true;
    private Context context;

    public XXSimpleBanner(Context context) {
        this(context, null);
    }

    public XXSimpleBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        this.mViewList = new ArrayList<>();
        this.fixedSpeedScroller = new XXFixedSpeedScroller(getContext());
        this.adapter = new XXBannerAdapter(this, mViewList);
        this.adapter.setAutoSlide(true);
        this.adapter.setChangeInterval(3000);
        this.setAdapter(this.adapter);
    }

    public XXSimpleBanner urls(List<String> dataList) {
        this.mUrlList = dataList;
        return this;
    }

    private void addItemView(XXImageLoader loader, String url) {
        View view = null;
        if (loader != null) {
            view = loader.create(context);
        }
        if (view == null) {
            view = new View(context);
        }
        this.mViewList.add(view);
        if (loader != null) {
            loader.onLoadImage(context, view, url);
        }
    }

    public XXSimpleBanner loader(XXImageLoader loader) {
        this.mImageLoader = loader;
        return this;
    }

    public XXSimpleBanner pageMargin(int pageMargin) {
        this.setPageMargin(pageMargin);
        return this;
    }

    public XXSimpleBanner autoEnable(boolean enable) {
        this.autoEnable = enable;
        return this;
    }

    public XXSimpleBanner autoInterval(long interval) {
        this.adapter.setChangeInterval(interval);
        return this;
    }

    public XXSimpleBanner scroller(int duration) {
        this.fixedSpeedScroller.setScrollDuration(duration);
        this.fixedSpeedScroller.initViewPagerScroll(this);
        return this;
    }

    public XXSimpleBanner transformer(ViewPager.PageTransformer pageTransformer) {
        this.setPageTransformer(true, pageTransformer);
        return this;
    }

    public void start() {
        if (XXListUtil.isEmpty(mUrlList)) {
            this.mViewList.clear();
            this.addItemView(mImageLoader, "null");
            this.adapter.setAutoSlide(false);
            this.setOffscreenPageLimit(1);
        } else {
            this.mViewList.clear();
            final int len = mUrlList.size();
            if (len == 1) {
                this.addItemView(mImageLoader, mUrlList.get(0));
                this.adapter.setAutoSlide(false);
                this.setOffscreenPageLimit(1);
            } else {
                for (int i = 0; i < len + 2; i++) {
                    final String url;
                    if (i == 0) {
                        url = mUrlList.get(len - 1);
                    } else if (i == len + 1) {
                        url = mUrlList.get(0);
                    } else {
                        url = mUrlList.get(i - 1);
                    }
                    this.addItemView(mImageLoader, url);
                }
                this.adapter.setAutoSlide(autoEnable);
            }
        }
        this.adapter.notifyDataSetChanged();
    }

}
