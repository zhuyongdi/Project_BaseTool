package com.zhuyongdi.basetool.tool;

import java.util.List;

/**
 * List工具类
 * Created by ZhuYongdi on 2019/3/18.
 */
public class XXListUtil {

    private XXListUtil() {
    }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.size() == 0;
    }

    public static boolean isNotEmpty(List<?> list) {
        return list != null && list.size() != 0;
    }

    public static int size(List<?> list) {
        return isEmpty(list) ? 0 : list.size();
    }

    public static void clearAll(List<?> list, int start, int end) {
        if (start < 0 || end < 0) {
            return;
        }
        int size = size(list);
        if (end >= size) {
            end = size - 1;
        }
        if (start > end) {
            end = start;
        }
        int total = end - start + 1;
        int removeCount = 0;
        for (int i = 0; i < size; i++) {
            if (i >= start && i <= end) {
                list.remove(i - removeCount);
                removeCount++;
            }
            if (removeCount == total) {
                return;
            }
        }
    }

}
