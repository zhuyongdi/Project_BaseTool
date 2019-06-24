package com.zhuyongdi.basetool.function.decoration.provider;

/**
 * Created by dkzwm on 2017/4/13.
 *
 * @author dkzwm
 */
public abstract class ZYDGridProvider implements ZYDIGridProvider {
    @Override
    public boolean isRowNeedDraw(int row) {
        return true;
    }

    @Override
    public boolean isColumnNeedDraw(int column) {
        return true;
    }

}
