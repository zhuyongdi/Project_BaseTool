package com.zhuyongdi.basetool.tool.validate;

import com.zhuyongdi.basetool.constants.XXCommonRegEx;

/**
 * 汉字验证工具类
 * Created by ZhuYongdi on 2019/4/18.
 */
public class XXChinaCharValidateUtil {

    //验证是否是汉字
    public static boolean isChineseChar(CharSequence input) {
        return XXPatternMatcher.isMatchByRegEx(XXCommonRegEx.REGEX_CHINESE_CHAR, input);
    }

}
