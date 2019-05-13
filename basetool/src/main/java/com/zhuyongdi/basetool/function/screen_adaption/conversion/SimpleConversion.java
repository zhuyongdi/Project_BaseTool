package com.zhuyongdi.basetool.function.screen_adaption.conversion;

import android.view.View;

import com.zhuyongdi.basetool.function.screen_adaption.loadviewhelper.AbsLoadViewHelper;

public class SimpleConversion implements IConversion {

    @Override
    public void transform(View view, AbsLoadViewHelper loadViewHelper) {
        if (view.getLayoutParams() != null) {
            loadViewHelper.loadWidthHeightFont(view);
            loadViewHelper.loadPadding(view);
            loadViewHelper.loadLayoutMargin(view);
        }
    }

}
