package com.zhuyongdi.basetool.function.third_api.wechat.share.bean;

public class WXShareWebPageBean extends WXShareBean {

    private String url;
    private String ext;

    public String getUrl() {
        return url;
    }

    public WXShareWebPageBean setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getExt() {
        return ext;
    }

    public WXShareWebPageBean setExt(String ext) {
        this.ext = ext;
        return this;
    }
}
