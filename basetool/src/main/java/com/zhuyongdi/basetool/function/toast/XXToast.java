package com.zhuyongdi.basetool.function.toast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Toaster
 * Created by ZhuYongdi on 2019/3/18.
 */
@SuppressLint({"StaticFieldLeak", "ShowToast"})
public final class XXToast {

    private static Context context;

    private XXToast() {
    }

    public static void setContext(Context context) {
        XXToast.context = context.getApplicationContext();
    }

    public static void showToast(final int resId) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @SuppressLint("ShowToast")
            public void run() {
                Toast toast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
                toast.setText(resId);
                toast.setGravity(Gravity.BOTTOM, 0, 100);
                toast.show();
            }
        });
    }

    public static void showToast(final String text) {
        new Handler(Looper.myLooper()).post(new Runnable() {
            public void run() {
                Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                toast.setText(text);
                toast.setGravity(Gravity.BOTTOM, 0, 100);
                toast.show();
            }
        });
    }

}
