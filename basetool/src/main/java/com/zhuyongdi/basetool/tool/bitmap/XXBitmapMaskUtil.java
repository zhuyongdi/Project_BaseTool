package com.zhuyongdi.basetool.tool.bitmap;

import android.content.Context;
import android.graphics.Bitmap;

import com.zhuyongdi.basetool.transformations.XXMaskTransformation;


/**
 * Created by ZhuYongdi on 2019/4/17.
 */
public class XXBitmapMaskUtil {

    /**
     * Bitmap遮盖
     */
    public static Bitmap addMask(Context context, Bitmap bitmap, int maskResId) {
        if (bitmap == null) {
            return null;
        }
        return XXMaskTransformation.transfer(context, bitmap, XXBitmapConvertUtil.resourceToDrawable(context, maskResId));
    }

    /**
     * Bitmap遮盖
     */
    public static Bitmap addMask(Context context, Bitmap bitmap, Bitmap maskBitmap) {
        if (bitmap == null) {
            return null;
        }
        return XXMaskTransformation.transfer(context, bitmap, XXBitmapConvertUtil.bitmapToDrawable(context, maskBitmap));
    }

}
