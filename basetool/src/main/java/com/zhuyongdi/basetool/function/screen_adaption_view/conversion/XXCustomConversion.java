package com.zhuyongdi.basetool.function.screen_adaption_view.conversion;

import android.view.View;

import com.zhuyongdi.basetool.function.screen_adaption_view.loadviewhelper.XXAbsLoadViewHelper;


public class XXCustomConversion implements XXIConversion {

    @Override
    public void transform(View view, XXAbsLoadViewHelper loadViewHelper) {
        if (view.getLayoutParams() != null) {
            loadViewHelper.loadWidthHeightFont(view);
            loadViewHelper.loadPadding(view);
            loadViewHelper.loadLayoutMargin(view);
            loadViewHelper.loadMaxWidthAndHeight(view);
            loadViewHelper.loadMinWidthAndHeight(view);
        }
    }

}
