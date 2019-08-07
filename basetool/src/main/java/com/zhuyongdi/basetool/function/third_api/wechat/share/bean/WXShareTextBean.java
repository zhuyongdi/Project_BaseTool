package com.zhuyongdi.basetool.function.third_api.wechat.share.bean;

/**
 * 微信分享文字实体
 */
public class WXShareTextBean extends WXShareBean {

    private String text;

    public String getText() {
        return text;
    }

    public WXShareTextBean setText(String text) {
        this.text = text;
        return this;
    }
}
