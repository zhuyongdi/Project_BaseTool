package com.zhuyongdi.basetool.tool;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

public class XXSystemUtil {

    /**
     * 跳转到权限设置界面
     */
    public static void toPermissionSetting(Context context) {
        Intent mIntent = new Intent();
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            mIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            mIntent.setData(Uri.fromParts("package", context.getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            mIntent.setAction(Intent.ACTION_VIEW);
            mIntent.setClassName("com.android.settings", "com.android.setting.InstalledAppDetails");
            mIntent.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
        }
        context.startActivity(mIntent);
    }

}
