package com.zhuyongdi.basetool.function.third_api.wechat.share;

public abstract class WXShareBaseUtil {

//    String title;
//    String description;
//    String thumbUrl;
//    int thumbPlaceholder;
//    IWXAPI iwxapi;
//    NotInstalledWechatProvider provider;
//    Context context;
//    WXMediaMessage msg;
//    SendMessageToWX.Req req;
//    private WXToWhere toWhere;
//    private WXShareType shareType;
//
//    public abstract void onChildStart();
//
//    public WXShareBaseUtil(final Context context, final String appId) {
//        this.context = context;
//        this.iwxapi = WXAPIFactory.createWXAPI(context.getApplicationContext(), appId);
//        this.iwxapi.registerApp(appId);
//    }
//
//    public WXShareBaseUtil toWhere(WXToWhere toWhere) {
//        this.toWhere = toWhere;
//        return this;
//    }
//
//    public WXShareBaseUtil title(String title) {
//        this.title = title;
//        return this;
//    }
//
//    public WXShareBaseUtil description(String description) {
//        this.description = description;
//        return this;
//    }
//
//    public WXShareBaseUtil thumbUrl(String thumbUrl) {
//        this.thumbUrl = thumbUrl;
//        return this;
//    }
//
//    public WXShareBaseUtil thumbPlaceholder(int thumbPlaceholder) {
//        this.thumbPlaceholder = thumbPlaceholder;
//        return this;
//    }
//
//    public void start() {
//        msg.title = title;
//        msg.description = description;
//        if (XXStringUtil.isEmpty(thumbUrl)) {
//            if (thumbPlaceholder != 0) {
//                Bitmap bitmap = XXBitmapConvertUtil.resourceToBitmap(context, thumbPlaceholder);
//                XXBitmapCompressUtil.compressBitmapWithSpecificLength(bitmap, 30, new XXBitmapCompressUtil.CompressCallback() {
//                    @Override
//                    public void onSucceed(byte[] data) {
//                        msg.thumbData = data;
//                        next();
//                    }
//                });
//            } else {
//                next();
//            }
//        } else {
//            XXBitmapLoadUtil.loadBitmap(context, thumbUrl, new XXBitmapLoadUtil.onLoadBitmapCallback() {
//                @Override
//                public void onLoadImageFailed() {
//                    if (thumbPlaceholder == 0) {
//                        next();
//                    } else {
//                        Bitmap bitmap = XXBitmapConvertUtil.resourceToBitmap(context, thumbPlaceholder);
//                        XXBitmapCompressUtil.compressBitmapWithSpecificLength(bitmap, 30, new XXBitmapCompressUtil.CompressCallback() {
//                            @Override
//                            public void onSucceed(byte[] data) {
//                                msg.thumbData = data;
//                                next();
//                            }
//                        });
//                    }
//                }
//
//                @Override
//                public void onLoadImageSucceed(Bitmap successBitmap) {
//                    XXBitmapCompressUtil.compressBitmapWithSpecificLength(successBitmap, 30, new XXBitmapCompressUtil.CompressCallback() {
//                        @Override
//                        public void onSucceed(byte[] data) {
//                            msg.thumbData = data;
//                            next();
//                        }
//                    });
//                }
//            });
//        }
//    }
//
//    private void next() {
//        req.message = msg;
//        req.scene = toWhere.v();
//        req.transaction = buildTransaction();
//        onChildStart();
//    }
//
//    public interface NotInstalledWechatProvider {
//        void onNotInstalledWechat();
//    }
//
//    private String buildTransaction() {
//        StringBuilder sb = new StringBuilder(System.currentTimeMillis() + "_");
//        switch (shareType) {
//            case TEXT:
//                sb.append("TEXT");
//            case WEB_PAGE:
//                sb.append("WEB_PAGE");
//        }
//        return sb.toString();
//    }

}
