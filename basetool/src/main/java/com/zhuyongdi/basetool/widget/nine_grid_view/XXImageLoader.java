package com.zhuyongdi.basetool.widget.nine_grid_view;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by ZhuYongdi on 2019/4/3.
 */
public interface XXImageLoader {

    void onDisplayImage(Context context, ImageView iv, String url);

    ImageView onConfigImageView(Context context);

}
