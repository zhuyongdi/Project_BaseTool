package com.zhuyongdi.basetool.function.screen_adaption_view.loadviewhelper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhuyongdi.basetool.tool.XXViewReflectUtil;

public class XXLoadViewHelper extends XXAbsLoadViewHelper {

    public XXLoadViewHelper(Context context, int designWidth, int designDpi, float fontSize, String unit) {
        super(context, designWidth, designDpi, fontSize, unit);
    }

    @Override
    public void loadWidthHeightFont(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width > 0) {
            layoutParams.width = getValue(layoutParams.width);
        }
        if (layoutParams.height > 0) {
            layoutParams.height = getValue(layoutParams.height);
        }
        loadViewFont(view);
    }


    private void loadViewFont(View view) {
        if ((view instanceof TextView)) {
            TextView textView = (TextView) view;
            ((TextView) view).setTextSize(0, setFontSize(textView));
        }
    }

    private float setFontSize(TextView textView) {
        return calculateValue(textView.getTextSize() * fontSize);
    }

    @Override
    public void loadPadding(View view) {
        view.setPadding(getValue(view.getPaddingLeft()), getValue(view.getPaddingTop()), getValue(view.getPaddingRight()), getValue(view.getPaddingBottom()));
    }

    @Override
    public void loadLayoutMargin(View view) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (params instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) params;
            marginLayoutParams.leftMargin = getValue(marginLayoutParams.leftMargin);
            marginLayoutParams.topMargin = getValue(marginLayoutParams.topMargin);
            marginLayoutParams.rightMargin = getValue(marginLayoutParams.rightMargin);
            marginLayoutParams.bottomMargin = getValue(marginLayoutParams.bottomMargin);
            view.setLayoutParams(marginLayoutParams);
        }
    }

    @Override
    public void loadMaxWidthAndHeight(View view) {
        XXViewReflectUtil.setMaxWidth(view, getValue(XXViewReflectUtil.getMaxWidth(view)));
        XXViewReflectUtil.setMaxHeight(view, getValue(XXViewReflectUtil.getMaxHeight(view)));
    }

    @Override
    public void loadMinWidthAndHeight(View view) {
        XXViewReflectUtil.setMinWidth(view, getValue(XXViewReflectUtil.getMinWidth(view)));
        XXViewReflectUtil.setMinHeight(view, getValue(XXViewReflectUtil.getMinHeight(view)));
    }

    @Override
    public int loadCustomAttrValue(int px) {
        return getValue(px);
    }

}
