package com.zhuyongdi.basetool.tool;

public class ZYD_ClassTool {

    /**
     * 获取类的完整名
     * com.zyd.BaseTool
     */
    public static String getClassFullName(Class c) {
        return c == null ? "" : (c.getPackage().getName() + "." + c.getSimpleName());
    }

    /**
     * 获取类名
     * BaseTool
     */
    public static String getClassName(Class c) {
        return c == null ? "" : c.getSimpleName();
    }

}
