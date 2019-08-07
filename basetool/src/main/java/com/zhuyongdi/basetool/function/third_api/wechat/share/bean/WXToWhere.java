package com.zhuyongdi.basetool.function.third_api.wechat.share.bean;

public enum WXToWhere {

    /**
     * 朋友
     */
    FRIEND(0),

    /**
     * 朋友圈
     */
    FRIEND_CIRCLE(1);

    int v;

    WXToWhere(int v) {
        this.v = v;
    }

    public int v() {
        return v;
    }


}
