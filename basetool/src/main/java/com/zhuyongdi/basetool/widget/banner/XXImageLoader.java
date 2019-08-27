package com.zhuyongdi.basetool.widget.banner;

import android.content.Context;
import android.view.View;

public interface XXImageLoader<T extends View> {

    T create(Context context);

    void onLoadImage(Context context, T t, String url);

}
