package com.zhuyongdi.basetool.function.screen_adaption_view.loadviewhelper;

import android.view.View;

public interface ILoadViewHelper {

    void loadWidthHeightFont(View view);

    void loadPadding(View view);

    void loadLayoutMargin(View view);

    void loadMaxWidthAndHeight(View view);

    void loadMinWidthAndHeight(View view);

    int loadCustomAttrValue(int px);
}
