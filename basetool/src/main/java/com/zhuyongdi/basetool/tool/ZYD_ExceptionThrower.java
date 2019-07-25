package com.zhuyongdi.basetool.tool;

/**
 * 抛出异常工具类
 */
public final class ZYD_ExceptionThrower {

    private ZYD_ExceptionThrower() {
    }

    public static void throwRuntime() {
        throw new RuntimeException();
    }

    public static void throwRuntime(String errorMsg) {
        throw new RuntimeException(errorMsg);
    }

    public static void throwIllegalArgument() {
        throw new IllegalArgumentException();
    }

    public static void throwIllegalArgument(String errorMsg) {
        throw new IllegalArgumentException(errorMsg);
    }

    public static void throwNullPointer() {
        throw new NullPointerException();
    }

    public static void throwNullPointer(String errorMsg) {
        throw new NullPointerException(errorMsg);
    }

    public static void throwIndexOutOfBounds() {
        throw new IndexOutOfBoundsException();
    }

    public static void throwIndexOutOfBounds(String errorMsg) {
        throw new IndexOutOfBoundsException(errorMsg);
    }

}
