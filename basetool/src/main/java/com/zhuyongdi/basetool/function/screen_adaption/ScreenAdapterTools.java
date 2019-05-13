package com.zhuyongdi.basetool.function.screen_adaption;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.zhuyongdi.basetool.function.screen_adaption.loadviewhelper.AbsLoadViewHelper;
import com.zhuyongdi.basetool.function.screen_adaption.loadviewhelper.LoadViewHelper;

/**
 * Created by zhyongdi on 2018/2/6.
 */
public class ScreenAdapterTools {

    private static AbsLoadViewHelper sLoadViewHelper;

    private static final String KEY_DESIGN_WIDTH = "design_width";
    private static final String KEY_DESIGN_DPI = "design_dpi";
    private static final String KEY_FONT_SIZE = "font_size";
    private static final String KEY_UNIT = "unit";

    public static AbsLoadViewHelper getInstance() {
        return sLoadViewHelper;
    }

    public static void init(Context context) {
        init(context, new IProvider() {
            @Override
            public AbsLoadViewHelper provide(Context context, int designWidth, int designDpi, float fontSize, String unit) {
                return new LoadViewHelper(context, designWidth, designDpi, fontSize, unit);
            }
        });
    }

    public static void init(Context context, IProvider provider) {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context
                    .getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (applicationInfo != null) {
            int designWidth = applicationInfo.metaData.getInt(KEY_DESIGN_WIDTH);
            int designDpi = applicationInfo.metaData.getInt(KEY_DESIGN_DPI);
            float fontSize = applicationInfo.metaData.getFloat(KEY_FONT_SIZE);
            String unit = applicationInfo.metaData.getString(KEY_UNIT);
            sLoadViewHelper = provider.provide(context, designWidth, designDpi, fontSize, unit);
        }
    }

    public interface IProvider {
        AbsLoadViewHelper provide(Context context, int designWidth, int designDpi, float fontSize, String unit);
    }
}
