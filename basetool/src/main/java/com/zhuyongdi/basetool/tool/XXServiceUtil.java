package com.zhuyongdi.basetool.tool;

import android.app.ActivityManager;
import android.content.Context;

import java.util.ArrayList;

/**
 * 服务工具类
 */
public class XXServiceUtil {

    /**
     * 判断某个服务是否正在运行
     */
    public static boolean isServiceRunning(Context context, Class<?> service) {
        if (service == null) {
            return false;
        }
        ActivityManager myManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ArrayList<ActivityManager.RunningServiceInfo> runningService = (ArrayList<ActivityManager.RunningServiceInfo>) myManager.getRunningServices(30);
        for (int i = 0; i < runningService.size(); i++) {
            if (runningService.get(i).service.getClassName().equals(service.getName())) {
                return true;
            }
        }
        return false;
    }

}
