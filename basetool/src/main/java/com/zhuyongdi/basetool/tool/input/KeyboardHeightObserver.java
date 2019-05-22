package com.zhuyongdi.basetool.tool.input;

/**
 * 软键盘高度监听回调
 * Created by ZhuYongdi on 2019/5/14.
 */
public interface KeyboardHeightObserver {


    /**
     * Called when the keyboard has changed.
     *
     * @param height      The height of the keyboard in pixels
     * @param orientation The orientation either: Configuration.ORIENTATION_PORTRAIT or
     *                    Configuration.ORIENTATION_LANDSCAPE
     */
    void onKeyboardHeightChanged(int height, int orientation);

}
