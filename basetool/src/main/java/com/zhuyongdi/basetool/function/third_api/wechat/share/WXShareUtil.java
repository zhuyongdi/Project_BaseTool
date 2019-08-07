package com.zhuyongdi.basetool.function.third_api.wechat.share;

/**
 * 微信分享工具类
 */
public class WXShareUtil {

//    private Context context;
//    private WXToWhere toWhere;
//    private WXShareType shareType;
//    private WXShareBean shareBean;
//    private OnShareListener listener;
//    private IWXAPI iwxapi;
//    private WXMediaMessage msg = new WXMediaMessage();
//    private Vector<Object> vct = new Vector<>();
//
//    public static WXShareUtil getInstance(final Context context, final String appId) {
//        return CH.INST(context.getApplicationContext(), appId);
//    }
//
//    private static final class CH {
//        private static WXShareUtil INST(final Context context, final String appId) {
//            return new WXShareUtil(context, appId);
//        }
//    }
//
//    private WXShareUtil(final Context context, final String appId) {
//        this.context = context;
//        this.iwxapi = WXAPIFactory.createWXAPI(context, appId);
//        this.iwxapi.registerApp(appId);
//    }
//
//    public WXShareUtil toWhere(WXToWhere toWhere) {
//        this.toWhere = toWhere;
//        return this;
//    }
//
//    public WXShareUtil shareType(WXShareType shareType) {
//        this.shareType = shareType;
//        return this;
//    }
//
//    public WXShareUtil shareBean(WXShareBean shareBean) {
//        this.shareBean = shareBean;
//        return this;
//    }
//
//    public WXShareUtil listener(OnShareListener listener) {
//        this.listener = listener;
//        return this;
//    }
//
//    public void start() {
//        check();
//        if (listener != null) {
//            listener.onStartShare();
//        }
//        switch (shareType) {
//            case TEXT:
//                msg.mediaObject = createText();
//                break;
//            case IMAGE:
//                msg.mediaObject = createImage();
//                break;
//            case WEB_PAGE:
//                msg.mediaObject = createWebPage();
//                break;
//        }
//        createThumb();
//    }
//
//    private void join() {
//        String baseThumb = shareBean.getThumbUrl();
//    }
//
//    private void notifySendReq() {
//        if (vct.size() == 0) {
//            msg.title = shareBean.getTitle();
//            msg.description = shareBean.getDescription();
//            if (listener != null) {
//                listener.onEndShare();
//            }
//        }
//    }
//
//    private WXTextObject createText() {
//        WXTextObject object = new WXTextObject();
//        object.text = ((WXShareTextBean) shareBean).getText();
//        return object;
//    }
//
//    private WXImageObject createImage() {
//        final WXImageObject object = new WXImageObject();
//        final String url = ((WXShareImageBean) shareBean).getImageUrl();
//        final int placeholder = ((WXShareImageBean) shareBean).getPlaceholder();
//        vct.add("image");
//        XXBitmapLoadUtil.loadBitmap(context, url, new XXBitmapLoadUtil.onLoadBitmapCallback() {
//            @Override
//            public void onLoadImageFailed() {
//                Bitmap placeholderBitmap = XXBitmapConvertUtil.resourceToBitmap(context, placeholder);
//                XXBitmapCompressUtil.compressBitmapWithSpecificLength(placeholderBitmap, 30, new XXBitmapCompressUtil.CompressCallback() {
//                    @Override
//                    public void onSucceed(byte[] data) {
//                        object.imageData = data;
//                        vct.remove("image");
//                        notifySendReq();
//                    }
//                });
//            }
//
//            @Override
//            public void onLoadImageSucceed(Bitmap successBitmap) {
//                XXBitmapCompressUtil.compressBitmapWithSpecificLength(successBitmap, 30, new XXBitmapCompressUtil.CompressCallback() {
//                    @Override
//                    public void onSucceed(byte[] data) {
//                        object.imageData = data;
//                        vct.remove("image");
//                        notifySendReq();
//                    }
//                });
//            }
//        });
//        return object;
//    }
//
//    private void createThumb() {
//        final String thumb = shareBean.getThumbUrl();
//        final int placeholder = shareBean.getThumbUrlPlaceholder();
//        XXBitmapLoadUtil.loadBitmap(context, thumb, new XXBitmapLoadUtil.onLoadBitmapCallback() {
//            @Override
//            public void onLoadImageFailed() {
//                Bitmap placeholderBitmap = XXBitmapConvertUtil.resourceToBitmap(context, placeholder);
//                XXBitmapCompressUtil.compressBitmapWithSpecificLength(placeholderBitmap, 30, new XXBitmapCompressUtil.CompressCallback() {
//                    @Override
//                    public void onSucceed(byte[] data) {
//                        msg.thumbData = data;
//                        notifySendReq();
//                    }
//                });
//            }
//
//            @Override
//            public void onLoadImageSucceed(Bitmap successBitmap) {
//                XXBitmapCompressUtil.compressBitmapWithSpecificLength(successBitmap, 30, new XXBitmapCompressUtil.CompressCallback() {
//                    @Override
//                    public void onSucceed(byte[] data) {
//                        msg.thumbData = data;
//                        notifySendReq();
//                    }
//                });
//            }
//        });
//    }
//
//    private WXWebpageObject createWebPage() {
//        WXWebpageObject object = new WXWebpageObject();
//        object.extInfo = ((WXShareWebPageBean) shareBean).getExt();
//        object.webpageUrl = ((WXShareWebPageBean) shareBean).getUrl();
//        return object;
//    }
//
//    private void check() {
//        if (this.toWhere == null) {
//            XXExceptionThrower.throwNullPointer("toWhere must not be null");
//        }
//        if (this.shareType == null) {
//            XXExceptionThrower.throwNullPointer("shareType must not be null");
//        }
//        if (this.shareBean == null) {
//            XXExceptionThrower.throwNullPointer("shareBean must not be null");
//        }
//    }
//
//    public interface OnShareListener {
//        void onStartShare();
//
//        void onEndShare();
//    }
//
//    public interface OnLoadImageCallback {
//        void onLoadImageFailed();
//
//        void onLoadImageSucceed(Bitmap successBitmap);
//    }

}
