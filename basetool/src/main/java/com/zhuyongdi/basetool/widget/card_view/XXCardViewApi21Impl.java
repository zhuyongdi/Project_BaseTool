/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zhuyongdi.basetool.widget.card_view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;

@RequiresApi(21)
public class XXCardViewApi21Impl implements XXCardViewImpl {

    @Override
    public void initialize(XXCardViewDelegate cardView, Context context,
                           ColorStateList backgroundColor, float radius, float elevation, float maxElevation) {
        final XXRoundRectDrawable background = new XXRoundRectDrawable(backgroundColor, radius);
        cardView.setCardBackground(background);

        View view = cardView.getCardView();
        view.setClipToOutline(true);
        view.setElevation(elevation);
        setMaxElevation(cardView, maxElevation);
    }

    @Override
    public void setRadius(XXCardViewDelegate cardView, float radius) {
        getCardBackground(cardView).setRadius(radius);
    }

    @Override
    public void initStatic() {
    }

    @Override
    public void setMaxElevation(XXCardViewDelegate cardView, float maxElevation) {
        getCardBackground(cardView).setPadding(maxElevation,
                cardView.getUseCompatPadding(), cardView.getPreventCornerOverlap());
        updatePadding(cardView);
    }

    @Override
    public float getMaxElevation(XXCardViewDelegate cardView) {
        return getCardBackground(cardView).getPadding();
    }

    @Override
    public float getMinWidth(XXCardViewDelegate cardView) {
        return getRadius(cardView) * 2;
    }

    @Override
    public float getMinHeight(XXCardViewDelegate cardView) {
        return getRadius(cardView) * 2;
    }

    @Override
    public float getRadius(XXCardViewDelegate cardView) {
        return getCardBackground(cardView).getRadius();
    }

    @Override
    public void setElevation(XXCardViewDelegate cardView, float elevation) {
        cardView.getCardView().setElevation(elevation);
    }

    @Override
    public float getElevation(XXCardViewDelegate cardView) {
        return cardView.getCardView().getElevation();
    }

    @Override
    public void updatePadding(XXCardViewDelegate cardView) {
        if (!cardView.getUseCompatPadding()) {
            cardView.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float elevation = getMaxElevation(cardView);
        final float radius = getRadius(cardView);
        int hPadding = (int) Math.ceil(XXRoundRectDrawableWithShadow
                .calculateHorizontalPadding(elevation, radius, cardView.getPreventCornerOverlap()));
        int vPadding = (int) Math.ceil(XXRoundRectDrawableWithShadow
                .calculateVerticalPadding(elevation, radius, cardView.getPreventCornerOverlap()));
        cardView.setShadowPadding(hPadding, vPadding, hPadding, vPadding);
    }

    @Override
    public void onCompatPaddingChanged(XXCardViewDelegate cardView) {
        setMaxElevation(cardView, getMaxElevation(cardView));
    }

    @Override
    public void onPreventCornerOverlapChanged(XXCardViewDelegate cardView) {
        setMaxElevation(cardView, getMaxElevation(cardView));
    }

    @Override
    public void setBackgroundColor(XXCardViewDelegate cardView, @Nullable ColorStateList color) {
        getCardBackground(cardView).setColor(color);
    }

    @Override
    public ColorStateList getBackgroundColor(XXCardViewDelegate cardView) {
        return getCardBackground(cardView).getColor();
    }

    private XXRoundRectDrawable getCardBackground(XXCardViewDelegate cardView) {
        return ((XXRoundRectDrawable) cardView.getCardBackground());
    }
}
