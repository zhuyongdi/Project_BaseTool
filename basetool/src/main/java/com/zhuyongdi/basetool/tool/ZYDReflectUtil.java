package com.zhuyongdi.basetool.tool;

/**
 * 反射工具类
 */
public class ZYDReflectUtil {

    /**
     * 根据类名反射类
     *
     * @param className 类名全路径,如:com.google.Book
     */
    public static Class reflectClassByClassName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
