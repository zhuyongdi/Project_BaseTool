package com.zhuyongdi.basetool.function.image_selector.activity;

import android.app.Activity;

import com.zhuyongdi.basetool.R;
import com.zhuyongdi.basetool.function.permission.XXAction;
import com.zhuyongdi.basetool.function.permission.XXAndPermission;
import com.zhuyongdi.basetool.function.permission.XXPermission;
import com.zhuyongdi.basetool.function.toast.XXToast;
import com.zhuyongdi.basetool.tool.screen.XXScreenUtil;

import java.util.List;

/**
 * Created by ZhuYongdi on 2019/3/26.
 */
public class BaseActivity extends Activity {

    public void showToast(String toast) {
        XXToast.showToast(toast);
    }

    public void setTxtStatusBar() {
        XXScreenUtil.setImmersiveStatusBarMode(this, findViewById(R.id.empty));
        XXScreenUtil.setStatusBarLightMode(this);
    }

    public void checkPermission(final OnPermissionGrantedCallback callback) {
        XXAndPermission.with(this)
                .permission(XXPermission.READ_EXTERNAL_STORAGE, XXPermission.WRITE_EXTERNAL_STORAGE)
                .onGranted(new XXAction() {
                    @Override
                    public void onAction(List<String> permissions) {
                        if (callback != null) {
                            callback.onPermissionGranted();
                        }
                    }
                })
                .onDenied(new XXAction() {
                    @Override
                    public void onAction(List<String> permissions) {
                        showToast("获取权限失败,请重试并同意权限申请");
                        finish();
                    }
                })
                .start();
    }

    public interface OnPermissionGrantedCallback {

        void onPermissionGranted();

    }

}
