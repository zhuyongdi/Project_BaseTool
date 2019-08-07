package com.zhuyongdi.basetool.function.third_api.wechat.share.bean;

public class WXShareImageBean extends WXShareBean {

    private String imageUrl;
    private int placeholder;

    public String getImageUrl() {
        return imageUrl;
    }

    public WXShareImageBean setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getPlaceholder() {
        return placeholder;
    }

    public WXShareImageBean setPlaceholder(int placeholder) {
        this.placeholder = placeholder;
        return this;
    }
}
