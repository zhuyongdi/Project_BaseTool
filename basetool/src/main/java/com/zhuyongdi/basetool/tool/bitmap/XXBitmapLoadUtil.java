package com.zhuyongdi.basetool.tool.bitmap;

import android.graphics.Bitmap;

public class XXBitmapLoadUtil {

//    public static void loadBitmap(final Context context, final String url, final onLoadBitmapCallback callback) {
//        Glide.with(context)
//                .load(url)
//                .asBitmap()
//                .into(new Target<Bitmap>() {
//                    @Override
//                    public void onLoadStarted(Drawable placeholder) {
//                    }
//
//                    @Override
//                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
//                        if (callback != null) {
//                            callback.onLoadImageFailed();
//                        }
//                    }
//
//                    @Override
//                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                        if (resource == null) {
//                            if (callback != null) {
//                                callback.onLoadImageFailed();
//                            }
//                        } else {
//                            if (callback != null) {
//                                callback.onLoadImageSucceed(resource);
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onLoadCleared(Drawable placeholder) {
//                    }
//
//                    @Override
//                    public void getSize(SizeReadyCallback cb) {
//                        cb.onSizeReady(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
//                    }
//
//                    @Override
//                    public void setRequest(Request request) {
//                    }
//
//                    @Override
//                    public Request getRequest() {
//                        return null;
//                    }
//
//                    @Override
//                    public void onStart() {
//                    }
//
//                    @Override
//                    public void onStop() {
//                    }
//
//                    @Override
//                    public void onDestroy() {
//                    }
//                });
//    }

    public interface onLoadBitmapCallback {
        void onLoadImageFailed();
        void onLoadImageSucceed(Bitmap successBitmap);
    }

}
