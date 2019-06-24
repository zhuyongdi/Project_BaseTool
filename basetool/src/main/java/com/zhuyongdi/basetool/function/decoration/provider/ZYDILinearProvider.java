package com.zhuyongdi.basetool.function.decoration.provider;

import com.zhuyongdi.app.decoration.divider.ZYDIDivider;

/**
 * Created by dkzwm on 2017/4/12.
 *
 * @author dkzwm
 */
public interface ZYDILinearProvider extends ZYDIProvider {

    ZYDIDivider createDivider(int position);

    boolean isDividerNeedDraw(int position);

    int marginStart(int position);

    int marginEnd(int position);

}
