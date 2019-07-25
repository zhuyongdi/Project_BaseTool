package com.zhuyongdi.basetool.function.screen_adaption_view.conversion;

import android.view.View;

import com.zhuyongdi.basetool.function.screen_adaption_view.loadviewhelper.AbsLoadViewHelper;


public class CustomConversion implements IConversion {

    @Override
    public void transform(View view, AbsLoadViewHelper loadViewHelper) {
        if (view.getLayoutParams() != null) {
            loadViewHelper.loadWidthHeightFont(view);
            loadViewHelper.loadPadding(view);
            loadViewHelper.loadLayoutMargin(view);
            loadViewHelper.loadMaxWidthAndHeight(view);
            loadViewHelper.loadMinWidthAndHeight(view);
        }
    }

}
