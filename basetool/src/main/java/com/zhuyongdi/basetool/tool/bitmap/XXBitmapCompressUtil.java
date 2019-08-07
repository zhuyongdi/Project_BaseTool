package com.zhuyongdi.basetool.tool.bitmap;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

/**
 * Bitmap压缩工具类
 */
public class XXBitmapCompressUtil {

    /**
     * 压缩bitmap到指定大小
     *
     * @param bitmap bitmap
     * @param toKb   压缩到多少kb
     */
    public static void compressBitmapWithSpecificLength(final Bitmap bitmap, final int toKb, final CompressCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                //需要压缩
                if (baos.toByteArray().length > toKb) {
                    int options = toKb * 100 / baos.toByteArray().length;
                    if (options <= 0) {
                        options = 1;
                    }
                    baos.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, options, baos);
                    if (callback != null) {
                        callback.onSucceed(baos.toByteArray());
                    }
                }
                //不需要压缩
                else {
                    if (callback != null) {
                        callback.onSucceed(baos.toByteArray());
                    }
                }
            }
        }).start();
    }

    public interface CompressCallback {

        void onSucceed(byte[] data);

    }

}
