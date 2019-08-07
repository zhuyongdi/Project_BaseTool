package com.zhuyongdi.basetool.function.decoration.provider;

import com.zhuyongdi.basetool.function.decoration.divider.XXIDivider;

/**
 * Created by dkzwm on 2017/4/11.
 *
 * @author dkzwm
 */
public interface XXIGridProvider extends XXIProvider {

    XXIDivider createRowDivider(int row);

    XXIDivider createColumnDivider(int column);

    boolean isRowNeedDraw(int row);

    boolean isColumnNeedDraw(int column);

}
