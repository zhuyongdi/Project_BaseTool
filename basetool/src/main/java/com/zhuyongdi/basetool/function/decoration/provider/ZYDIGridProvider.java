package com.zhuyongdi.basetool.function.decoration.provider;

import com.zhuyongdi.app.decoration.divider.ZYDIDivider;

/**
 * Created by dkzwm on 2017/4/11.
 *
 * @author dkzwm
 */
public interface ZYDIGridProvider extends ZYDIProvider {

    ZYDIDivider createRowDivider(int row);

    ZYDIDivider createColumnDivider(int column);

    boolean isRowNeedDraw(int row);

    boolean isColumnNeedDraw(int column);

}
