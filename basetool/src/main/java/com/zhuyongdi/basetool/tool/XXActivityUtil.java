package com.zhuyongdi.basetool.tool;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity工具类
 */
public class XXActivityUtil {

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

    /**
     * 获取AndroidManifest中所有的Activity
     *
     * @param context          context
     * @param activityNameType 1.MainActivity 2.xx.xx.MainActivity
     */
    public static ArrayList<String> obtainAllActivitiesInManifest(Context context, int activityNameType) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
            if (packageInfo.activities != null && packageInfo.activities.length != 0) {
                ArrayList<String> activityStringList = new ArrayList<>();
                for (int i = 0, size = packageInfo.activities.length; i < size; i++) {
                    ActivityInfo activityInfo = packageInfo.activities[i];
                    String activityFullName = activityInfo.name;
                    switch (activityNameType) {
                        case 1:
                            activityStringList.add(obtainActivityName(activityFullName));
                            break;
                        case 2:
                            activityStringList.add(activityFullName);
                            break;
                    }
                }
                return activityStringList;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String obtainActivityName(String fullName) {
        return fullName.substring(fullName.lastIndexOf(".") + 1, fullName.length());
    }

}
