package com.zhuyongdi.basetool.function.dialog.factory;

import android.app.Dialog;
import android.content.Context;

import com.zhuyongdi.basetool.function.dialog.product.XXLoadingDialog;
import com.zhuyongdi.basetool.function.dialog.product.XXPermissionDialog;


/**
 * Dialog工厂
 * Created by ZhuYongdi on 2019/3/18.
 */
public class XXDialogFactory {

    public enum DialogType {

        DIALOG_LOADING,
        DIALOG_PERMISSION

    }

    public static XXDialogFactory instance;

    private XXDialogFactory() {
    }

    public static XXDialogFactory getInstance() {
        return DialogFactoryClassHolder.INSTANCE;
    }

    private static final class DialogFactoryClassHolder {
        private static XXDialogFactory INSTANCE = new XXDialogFactory();
    }

    public Dialog createDialog(Context context, DialogType type) {
        Dialog dialog = null;
        switch (type) {
            case DIALOG_LOADING:
                dialog = new XXLoadingDialog(context);
                break;
            case DIALOG_PERMISSION:
                dialog = new XXPermissionDialog(context);
        }
        return dialog;
    }

}
