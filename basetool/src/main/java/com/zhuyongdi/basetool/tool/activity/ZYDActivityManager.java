package com.zhuyongdi.basetool.tool.activity;

import android.app.Activity;
import android.content.Intent;

import com.zhuyongdi.basetool.tool.ZYDActivityTool;
import com.zhuyongdi.basetool.tool.ZYDClassTool;
import com.zhuyongdi.basetool.tool.ZYDReflectUtil;

import java.util.Stack;

/**
 * Activity管理类
 */
public class ZYDActivityManager {

    private ZYDActivityManager() {
        activityStack = new Stack<>();
    }

    public static ZYDActivityManager obtain() {
        return ClassHolder.INST;
    }

    private static final class ClassHolder {
        private static final ZYDActivityManager INST = new ZYDActivityManager();
    }

    private Stack<Activity> activityStack = new Stack<>();

    /**
     * 当Application异常启动的时候启动AndroidManifest中的启动Activity
     * 1.当程序运行中用户去后台将应用权限从"询问","允许"变更为了"禁止".
     * 2.当程序内存不足被系统杀死了之后
     */
    public void startFirstActivityWhenApplicationRestart(Activity activity) {
        if (activity != null) {
            final String startActivityFullName = ZYDActivityTool.obtainStartActivityName(activity);
            if (!activityStack.isEmpty()) {
                String realFirstActivityFullName = ZYDClassTool.getClassFullName(activityStack.get(0).getClass());
                if (!realFirstActivityFullName.equals(startActivityFullName)) {
                    Class c = ZYDReflectUtil.reflectClassByClassName(realFirstActivityFullName);
                    activity.startActivity(new Intent(activity, c));
                    activity.finish();
                }
            }
        }
    }

    /**
     * 添加一个Activity
     */
    public void addActivity(Activity activity) {
        if (activity != null) {
            this.activityStack.add(activity);
        }
    }

    /**
     * 获取所有的Activity
     */
    public Stack<Activity> getAllActivity() {
        return activityStack;
    }

    /**
     * 结束所有的Activity
     */
    public void finishAllActivity() {
        for (Activity activity : activityStack) {
            if (activity != null) {
                activity.finish();
            }
        }
    }

}
