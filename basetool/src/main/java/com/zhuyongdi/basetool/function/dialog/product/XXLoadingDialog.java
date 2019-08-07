package com.zhuyongdi.basetool.function.dialog.product;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zhuyongdi.basetool.R;
import com.zhuyongdi.basetool.tool.screen.XXPixelUtil;

/**
 * 加载提示框
 * Created by ZhuYongdi on 2019/3/18.
 */
public class XXLoadingDialog extends Dialog {

    private View view;
    private ProgressBar pb_loading;
    private TextView tv_hint;

    public XXLoadingDialog(Context context) {
        super(context, R.style.XXDialogStyleBgDark);
        view = LayoutInflater.from(context).inflate(R.layout.xx_dialog_loading, null);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        window.setContentView(view);
        int dialogWidthAndHeight = XXPixelUtil.dp2px(context, 220);
        window.setLayout(dialogWidthAndHeight, dialogWidthAndHeight);
        window.setGravity(Gravity.CENTER);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        initUI();
    }

    private void initUI() {
        pb_loading = view.findViewById(R.id.progress_bar);
        tv_hint = view.findViewById(R.id.tv_hint);
    }

    public void setProgressBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            pb_loading.setIndeterminateTintList(ColorStateList.valueOf(color));
            pb_loading.setIndeterminateTintMode(PorterDuff.Mode.SRC_ATOP);
        }
    }

    public void setHint(String hint) {
        tv_hint.setText(hint);
    }

}
