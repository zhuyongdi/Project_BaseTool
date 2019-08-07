package com.zhuyongdi.basetool.function.text;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;

public class XXSpannableString {

    private SpannableString spannableString;
    private String str;

    private XXSpannableString(String str) {
        this.str = str;
        spannableString = new SpannableString(str);
    }

    public static XXSpannableString getInstance(String str) {
        return new XXSpannableString(str);
    }

    /**
     * 设置字体颜色
     */
    public XXSpannableString color(int color, int start, int end) {
        spannableString.setSpan(new ForegroundColorSpan(color), start, end, 0);
        return this;
    }

    /**
     * 设置字体颜色
     */
    public XXSpannableString color(int color, String part) {
        int start = str.indexOf(part);
        if (start == -1) {
            return this;
        }
        int end = start + part.length();
        return color(color, start, end);
    }

    /**
     * 设置字体背景色
     */
    public XXSpannableString color_background(int color, int start, int end) {
        spannableString.setSpan(new BackgroundColorSpan(color), start, end, 0);
        return this;
    }

    /**
     * 设置字体大小
     */
    public XXSpannableString size(int textSize, int start, int end) {
        spannableString.setSpan(new AbsoluteSizeSpan(textSize), start, end, 0);
        return this;
    }

    /**
     * 设置字体为上标
     */
    public XXSpannableString superscript(int start, int end) {
        spannableString.setSpan(new SuperscriptSpan(), start, end, 0);
        return this;
    }

    /**
     * 设置字体为下标
     */
    public XXSpannableString subscript(int start, int end) {
        spannableString.setSpan(new SubscriptSpan(), start, end, 0);
        return this;
    }

    /**
     * 添加图片到某个位置
     */
    public XXSpannableString addImg(int offset, Drawable drawable, int drawableSize) {
        StringBuilder sb = new StringBuilder(str);
        String insertStr = "888".hashCode() + "";
        sb.insert(offset, insertStr);
        spannableString = new SpannableString(sb.toString());
        return replaceImg(offset, offset + insertStr.length(), drawable, drawableSize);
    }

    /**
     * 替换字体为图片
     */
    public XXSpannableString replaceImg(int start, int end, Drawable drawable, int drawableSize) {
        drawable.setBounds(0, 0, drawableSize, drawableSize);
        spannableString.setSpan(new ImageSpan(drawable), start, end, 0);
        return this;
    }

    /**
     * 设置字体风格
     */
    public XXSpannableString style(int style, int start, int end) {
        spannableString.setSpan(new StyleSpan(style), start, end, 0);
        return this;
    }

    /**
     * 设置删除线
     */
    public XXSpannableString strikethrough(int start, int end) {
        spannableString.setSpan(new StrikethroughSpan(), start, end, 0);
        return this;
    }

    /**
     * 设置下划线
     */
    public XXSpannableString underline(int start, int end) {
        spannableString.setSpan(new UnderlineSpan(), start, end, 0);
        return this;
    }

    /**
     * 设置点击事件
     * TextView需要设置TextView.setMovementMethod(LinkMovementMethod.getInstance())才会生效
     */
    public XXSpannableString onClick(int start, int end, OnTextClickListener onTextClickListener, boolean isShowUnderline) {
        spannableString.setSpan(new ClickableSpan(onTextClickListener, isShowUnderline), start, end, 0);
        return this;
    }

    /**
     * 设置为url,默认带下划线
     * TextView需要设置TextView.setMovementMethod(LinkMovementMethod.getInstance())才会生效
     */
    public XXSpannableString onURL(int start, int end, String url) {
        spannableString.setSpan(new URLSpan(url), start, end, 0);
        return this;
    }

    /**
     * 获取SpanningString
     */
    public SpannableString get() {
        return spannableString;
    }

    /**
     * 自定义ClickableSpan
     */
    private class ClickableSpan extends android.text.style.ClickableSpan {

        OnTextClickListener onTextClickListener;
        boolean isShowUnderline;

        public ClickableSpan(OnTextClickListener onTextClickListener, boolean isShowUnderline) {
            this.onTextClickListener = onTextClickListener;
            this.isShowUnderline = isShowUnderline;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(isShowUnderline);
        }

        /**
         * 参数widget即是整个TextView,注意是整个TextView
         */
        @Override
        public void onClick(View widget) {
            if (onTextClickListener != null) {
                onTextClickListener.onTextClick(widget);
            }
        }
    }

    /**
     * ClickableSpan的点击事件接口
     */
    public interface OnTextClickListener {

        void onTextClick(View v);

    }


}
