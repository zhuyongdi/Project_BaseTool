package com.zhuyongdi.basetool.tool.validate;

import com.zhuyongdi.basetool.tool.string.XXCharSequenceUtil;

import java.util.regex.Pattern;

/**
 * Created by ZhuYongdi on 2019/4/18.
 */
public class XXPatternMatcher {

    //验证正则表达式是否匹配
    public static boolean isMatchByRegEx(String regEx, CharSequence input) {
        return XXCharSequenceUtil.isNotEmpty(input) && Pattern.matches(regEx, input);
    }

}
