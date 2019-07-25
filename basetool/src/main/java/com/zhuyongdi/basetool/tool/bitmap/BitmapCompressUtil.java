package com.zhuyongdi.basetool.tool.bitmap;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

/**
 * Bitmap压缩工具类
 */
public class BitmapCompressUtil {

    /**
     * 压缩Bitmap
     *
     * @param bitmap   需要压缩的bitmap
     * @param maxKB    需要压缩到多少b
     * @param callback 压缩成功后的回调
     */
    public static void compressBitmap(final Bitmap bitmap, final int maxKB, final Callback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
                int options = 100;
                while (output.toByteArray().length > maxKB && options != 1) {
                    output.reset(); //清空output
                    bitmap.compress(Bitmap.CompressFormat.JPEG, options, output);//这里压缩options%，把压缩后的数据存放到output中
                    options -= 1;
                }
                if (callback != null) {
                    callback.onSuccess(output.toByteArray());
                }
            }
        }).start();
    }

    public interface Callback {

        void onSuccess(byte[] data);

    }

}
