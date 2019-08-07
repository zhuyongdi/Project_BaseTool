package com.zhuyongdi.basetool.tool;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;

import com.zhuyongdi.basetool.tool.string.XXStringUtil;

import java.io.File;

/**
 * Created by ZhuYongdi on 2019/3/26.
 */
public class XXApplicationUtil {

    /**
     * 检查手机是否有外部存储
     */
    public static boolean hasExternalStorage() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 安装apk
     * 需要在Manifest文件中注册provider
     *
     * @param context   context
     * @param authority provider的authorities的值
     */
    public static void installAPK(final Context context, final String authority, final String apkFileName) {
        if (context != null && XXStringUtil.isNotEmpty(authority) && XXStringUtil.isNotEmpty(apkFileName)) {
            File file = new File(apkFileName);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (Build.VERSION.SDK_INT >= 24) {
                Uri apkUri = FileProvider.getUriForFile(context, authority, file);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            }
            context.startActivity(intent);
        }
    }

    /**
     * 获取手机可用内存
     */
    public static long getAvailableMemory(Context context) {
        long memory = 0L;
        if (context != null) {
            ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
            if (am != null) {
                am.getMemoryInfo(mi);
                memory = mi.availMem / 1024;
            }
        }
        return memory;
    }

}
