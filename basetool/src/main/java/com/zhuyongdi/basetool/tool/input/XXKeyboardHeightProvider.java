package com.zhuyongdi.basetool.tool.input;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.zhuyongdi.basetool.R;

/**
 * 软键盘高度监听器
 * 可以在AdjustNothing的情况下监听软键盘高度
 * Created by ZhuYongdi on 2019/5/14.
 */
public class XXKeyboardHeightProvider extends PopupWindow {

    /**
     * 用来打印Log的标签
     */
    private final static String TAG = "KeyboardHeightProvider";

    /**
     * 软键盘高度回调监听
     */
    private XXKeyboardHeightObserver observer;

    /**
     * 水平方向的软键盘高度
     */
    private int keyboardLandscapeHeight;

    /**
     * 垂直方向的软键盘高度
     */
    private int keyboardPortraitHeight;

    /**
     * 用来获取软键盘高度的PopWindow的View
     */
    private View popupView;

    /**
     * Activity的R.id.content的View
     */
    private View parentView;

    /**
     * Activity
     */
    private Activity activity;

    /**
     * 用来获取软键盘高度的PopWindow的View的高度
     */
    private int popWindowHeight;

    /**
     * 判断软键盘弹出与否的基准
     */
    public int COMPARE;

    /**
     * 实例化入口
     *
     * @param activity activity
     */
    public XXKeyboardHeightProvider(Activity activity) {
        super(activity);
        this.activity = activity;
        this.COMPARE = dp2px(activity, 200);

        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        this.popupView = inflater.inflate(R.layout.xx_popupwindow_keyboard, null, false);
        setContentView(popupView);

        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);

        parentView = activity.findViewById(android.R.id.content);

        setWidth(0);
        setHeight(WindowManager.LayoutParams.MATCH_PARENT);

        popupView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (popupView != null) {
                    handleOnGlobalLayout();
                }
            }
        });
    }

    /**
     * 开始监听软键盘高度变化,由于PopWindow不允许在onResume执行之前调用
     * 所以如果在onCreate中可以如下调用:
     * activity.getWindow().getDecorView().post(new Runnable() {
     * public void run() {
     * provider.start();
     * }
     * });
     */
    public void start() {
        if (!isShowing() && parentView.getWindowToken() != null) {
            setBackgroundDrawable(new ColorDrawable(0));
            showAtLocation(parentView, Gravity.NO_GRAVITY, 0, 0);
        }
    }

    /**
     * 关闭PopWindow并销毁回调
     */
    public void close() {
        this.observer = null;
        dismiss();
    }

    /**
     * 设置软键盘监听回调
     */
    public void setKeyboardHeightObserver(XXKeyboardHeightObserver observer) {
        this.observer = observer;
    }

    /**
     * 获取屏幕方向
     */
    private int getScreenOrientation() {
        return activity.getResources().getConfiguration().orientation;
    }

    /**
     * 计算软键盘高度
     */
    private void handleOnGlobalLayout() {
        Rect rect = new Rect();
        popupView.getWindowVisibleDisplayFrame(rect);
        int orientation = getScreenOrientation();
        if (popWindowHeight < popupView.getHeight()) {
            popWindowHeight = popupView.getHeight();
        }
        int keyboardHeight = popWindowHeight - rect.bottom;
        if (keyboardHeight == 0) {
            notifyKeyboardHeightChanged(0, orientation);
        } else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            this.keyboardPortraitHeight = keyboardHeight;
            notifyKeyboardHeightChanged(keyboardPortraitHeight, orientation);
        } else {
            this.keyboardLandscapeHeight = keyboardHeight;
            notifyKeyboardHeightChanged(keyboardLandscapeHeight, orientation);
        }
    }

    /**
     * 通知回调函数
     */
    private void notifyKeyboardHeightChanged(int height, int orientation) {
        if (observer != null) {
            observer.onKeyboardHeightChanged(height, orientation);
        }
    }

    /**
     * dp转换为px
     */
    private int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
