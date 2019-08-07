package com.zhuyongdi.basetool.tool.input;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * 键盘工具类
 * Created by ZhuYongdi on 2019/3/14.
 */
public class XXKeyboardUtil {

    /**
     * 强制弹出软键盘
     * ---------------------------------
     * 情形一:在onCreate中需要弹出软键盘:
     * final EditText et;
     * et.setFocusable(true);
     * et.setFocusableInTouchMode(true);
     * et.requestFocus();
     * new Handler().postDelay(new Runnable(){
     * public void run(){
     * openKeyboard(et);
     * }
     * });
     * ---------------------------------
     * 情形二:在非onCreate中需要弹出软键盘:
     * 直接调用openKeyboard(et);
     * ---------------------------------
     */
    public static void openKeyboard(EditText et) {
        InputMethodManager imm = (InputMethodManager) et.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInput(et, InputMethodManager.RESULT_SHOWN);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        }
    }

    /**
     * 强制关闭软键盘
     */
    public static void hideKeyboard(EditText et) {
        InputMethodManager imm = (InputMethodManager) et.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
        }
    }

    /**
     * 保存软键盘的高度到SP
     */
    public static void saveKeyboardHeightToSp(Context context, String key, int keyboardHeight) {
        SharedPreferences sp = context.getSharedPreferences(key, 0);
        sp.edit().putInt(key, keyboardHeight).apply();
    }

    /**
     * 获取软键盘的高度从SP
     * 如果之前没有保存过,则返回屏幕高度的2/5.
     */
    public static int getKeyboardHeightToSp(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(key, 0);
        int result = sp.getInt(key, 0);
        if (result == 0) {
            result = context.getResources().getDisplayMetrics().heightPixels * 2 / 5;
        }
        return result;
    }

}
