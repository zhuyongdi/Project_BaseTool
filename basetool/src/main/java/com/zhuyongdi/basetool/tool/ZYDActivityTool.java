package com.zhuyongdi.basetool.tool;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import com.zhuyongdi.basetool.tool.string.ZYDStringTool;

import java.util.List;

/**
 * Activity工具类
 */
public class ZYDActivityTool {

    /**
     * 获取启动Activity的名称
     * 此Activity是AndroidManifest中注册的启动Activity
     *
     * @return 返回com.a.StartActivity
     */
    public static String obtainStartActivityName(Context c) {
        String packageName = c.getPackageName();
        PackageManager pm = c.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> list = pm.queryIntentActivities(intent, 0);
        if (list != null && !list.isEmpty()) {
            for (ResolveInfo info : list) {
                if (packageName.equalsIgnoreCase(info.activityInfo.packageName)) {
                    return info.activityInfo.name;
                }
            }
        }
        return null;
    }

}
