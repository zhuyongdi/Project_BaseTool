package com.zhuyongdi.basetool.function.decoration.provider;

import com.zhuyongdi.basetool.function.decoration.divider.XXIDivider;

/**
 * Created by dkzwm on 2017/4/12.
 *
 * @author dkzwm
 */
public interface XXILinearProvider extends XXIProvider {

    XXIDivider createDivider(int position);

    boolean isDividerNeedDraw(int position);

    int marginStart(int position);

    int marginEnd(int position);

}
