package com.zhuyongdi.basetool.tool.validate;

import com.zhuyongdi.basetool.constants.XXCommonRegEx;

/**
 * Url验证工具类
 * Created by ZhuYongdi on 2019/4/18.
 */
public class XXUrlValidateUtil {

    /**
     * 验证是否是URL
     * true:(http://www.a.com),(http://www),(http://),(a://)
     * false:(www.a.com),(http:/)
     */
    public static boolean isURL(CharSequence input) {
        return XXPatternMatcher.isMatchByRegEx(XXCommonRegEx.REGEX_URL, input);
    }

}
