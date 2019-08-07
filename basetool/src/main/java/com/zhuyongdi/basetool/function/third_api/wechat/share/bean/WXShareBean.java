package com.zhuyongdi.basetool.function.third_api.wechat.share.bean;

public class WXShareBean {

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 缩略图url
     */
    private String thumbUrl;

    /**
     * 缩略图占位图
     */
    private int thumbUrlPlaceholder;

    public String getTitle() {
        return title;
    }

    public WXShareBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public WXShareBean setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public WXShareBean setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public int getThumbUrlPlaceholder() {
        return thumbUrlPlaceholder;
    }

    public WXShareBean setThumbUrlPlaceholder(int thumbUrlPlaceholder) {
        this.thumbUrlPlaceholder = thumbUrlPlaceholder;
        return this;
    }
}
