package com.zhuyongdi.basetool.widget.card_view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.Nullable;

public interface XXCardViewImpl {

    void initialize(XXCardViewDelegate cardView, Context context, ColorStateList backgroundColor,
                    float radius, float elevation, float maxElevation);

    void setRadius(XXCardViewDelegate cardView, float radius);

    float getRadius(XXCardViewDelegate cardView);

    void setElevation(XXCardViewDelegate cardView, float elevation);

    float getElevation(XXCardViewDelegate cardView);

    void initStatic();

    void setMaxElevation(XXCardViewDelegate cardView, float maxElevation);

    float getMaxElevation(XXCardViewDelegate cardView);

    float getMinWidth(XXCardViewDelegate cardView);

    float getMinHeight(XXCardViewDelegate cardView);

    void updatePadding(XXCardViewDelegate cardView);

    void onCompatPaddingChanged(XXCardViewDelegate cardView);

    void onPreventCornerOverlapChanged(XXCardViewDelegate cardView);

    void setBackgroundColor(XXCardViewDelegate cardView, @Nullable ColorStateList color);

    ColorStateList getBackgroundColor(XXCardViewDelegate cardView);

}
