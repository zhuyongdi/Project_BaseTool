/*
 * Copyright 2019 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zhuyongdi.basetool.function.screen_adaption_ctx;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.zhuyongdi.basetool.function.screen_adaption_ctx.external.XXExternalAdaptInfo;
import com.zhuyongdi.basetool.function.screen_adaption_ctx.external.XXExternalAdaptManager;
import com.zhuyongdi.basetool.function.screen_adaption_ctx.internal.XXCustomAdapt;
import com.zhuyongdi.basetool.function.screen_adaption_ctx.utils.XXPreconditions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ================================================
 * 当遇到本来适配正常的布局突然出现适配失效，适配异常等问题, 重写当前 {@link Activity} 的 {@link Activity#getResources()} 并调用
 * {@link XXAutoSizeCompat} 的对应方法即可解决问题
 * <p>
 * Created by JessYan on 2018/8/8 19:20
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public final class XXAutoSizeCompat {
    private static Map<String, XXDisplayMetricsInfo> mCache = new ConcurrentHashMap<>();

    private XXAutoSizeCompat() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    /**
     * 使用 AndroidAutoSize 初始化时设置的默认适配参数进行适配 (AndroidManifest 的 Meta 属性)
     *
     * @param resources {@link Resources}
     */
    public static void autoConvertDensityOfGlobal(Resources resources) {
        if (XXAutoSizeConfig.getInstance().isBaseOnWidth()) {
            autoConvertDensityBaseOnWidth(resources, XXAutoSizeConfig.getInstance().getDesignWidthInDp());
        } else {
            autoConvertDensityBaseOnHeight(resources, XXAutoSizeConfig.getInstance().getDesignHeightInDp());
        }
    }

    /**
     * 使用 {@link Activity} 或 {@link android.support.v4.app.Fragment} 的自定义参数进行适配
     *
     * @param resources   {@link Resources}
     * @param customAdapt {@link Activity} 或 {@link android.support.v4.app.Fragment} 需实现 {@link XXCustomAdapt}
     */
    public static void autoConvertDensityOfCustomAdapt(Resources resources, XXCustomAdapt customAdapt) {
        XXPreconditions.checkNotNull(customAdapt, "customAdapt == null");
        float sizeInDp = customAdapt.getSizeInDp();

        //如果 CustomAdapt#getSizeInDp() 返回 0, 则使用在 AndroidManifest 上填写的设计图尺寸
        if (sizeInDp <= 0) {
            if (customAdapt.isBaseOnWidth()) {
                sizeInDp = XXAutoSizeConfig.getInstance().getDesignWidthInDp();
            } else {
                sizeInDp = XXAutoSizeConfig.getInstance().getDesignHeightInDp();
            }
        }
        autoConvertDensity(resources, sizeInDp, customAdapt.isBaseOnWidth());
    }

    /**
     * 使用外部三方库的 {@link Activity} 或 {@link android.support.v4.app.Fragment} 的自定义适配参数进行适配
     *
     * @param resources         {@link Resources}
     * @param externalAdaptInfo 三方库的 {@link Activity} 或 {@link android.support.v4.app.Fragment} 提供的适配参数, 需要配合 {@link XXExternalAdaptManager#addExternalAdaptInfoOfActivity(Class, XXExternalAdaptInfo)}
     */
    public static void autoConvertDensityOfExternalAdaptInfo(Resources resources, XXExternalAdaptInfo externalAdaptInfo) {
        XXPreconditions.checkNotNull(externalAdaptInfo, "externalAdaptInfo == null");
        float sizeInDp = externalAdaptInfo.getSizeInDp();

        //如果 ExternalAdaptInfo#getSizeInDp() 返回 0, 则使用在 AndroidManifest 上填写的设计图尺寸
        if (sizeInDp <= 0) {
            if (externalAdaptInfo.isBaseOnWidth()) {
                sizeInDp = XXAutoSizeConfig.getInstance().getDesignWidthInDp();
            } else {
                sizeInDp = XXAutoSizeConfig.getInstance().getDesignHeightInDp();
            }
        }
        autoConvertDensity(resources, sizeInDp, externalAdaptInfo.isBaseOnWidth());
    }

    /**
     * 以宽度为基准进行适配
     *
     * @param resources       {@link Resources}
     * @param designWidthInDp 设计图的总宽度
     */
    public static void autoConvertDensityBaseOnWidth(Resources resources, float designWidthInDp) {
        autoConvertDensity(resources, designWidthInDp, true);
    }

    /**
     * 以高度为基准进行适配
     *
     * @param resources        {@link Resources}
     * @param designHeightInDp 设计图的总高度
     */
    public static void autoConvertDensityBaseOnHeight(Resources resources, float designHeightInDp) {
        autoConvertDensity(resources, designHeightInDp, false);
    }

    /**
     * 这里是今日头条适配方案的核心代码, 核心在于根据当前设备的实际情况做自动计算并转换 {@link DisplayMetrics#density}、
     * {@link DisplayMetrics#scaledDensity}、{@link DisplayMetrics#densityDpi} 这三个值, 额外增加 {@link DisplayMetrics#xdpi}
     * 以支持单位 {@code pt}、{@code in}、{@code mm}
     *
     * @param resources     {@link Resources}
     * @param sizeInDp      设计图上的设计尺寸, 单位 dp, 如果 {@param isBaseOnWidth} 设置为 {@code true},
     *                      {@param sizeInDp} 则应该填写设计图的总宽度, 如果 {@param isBaseOnWidth} 设置为 {@code false},
     *                      {@param sizeInDp} 则应该填写设计图的总高度
     * @param isBaseOnWidth 是否按照宽度进行等比例适配, {@code true} 为以宽度进行等比例适配, {@code false} 为以高度进行等比例适配
     * @see <a href="https://mp.weixin.qq.com/s/d9QCoBP6kV9VSWvVldVVwA">今日头条官方适配方案</a>
     */
    public static void autoConvertDensity(Resources resources, float sizeInDp, boolean isBaseOnWidth) {
        XXPreconditions.checkNotNull(resources, "resources == null");

        float subunitsDesignSize = isBaseOnWidth ? XXAutoSizeConfig.getInstance().getUnitsManager().getDesignWidth()
                : XXAutoSizeConfig.getInstance().getUnitsManager().getDesignHeight();
        subunitsDesignSize = subunitsDesignSize > 0 ? subunitsDesignSize : sizeInDp;

        int screenSize = isBaseOnWidth ? XXAutoSizeConfig.getInstance().getScreenWidth()
                : XXAutoSizeConfig.getInstance().getScreenHeight();
        String key = sizeInDp + "|" + subunitsDesignSize + "|" + isBaseOnWidth + "|"
                + XXAutoSizeConfig.getInstance().isUseDeviceSize() + "|"
                + XXAutoSizeConfig.getInstance().getInitScaledDensity() + "|"
                + screenSize;

        XXDisplayMetricsInfo displayMetricsInfo = mCache.get(key);

        float targetDensity = 0;
        int targetDensityDpi = 0;
        float targetScaledDensity = 0;
        float targetXdpi = 0;

        if (displayMetricsInfo == null) {
            if (isBaseOnWidth) {
                targetDensity = XXAutoSizeConfig.getInstance().getScreenWidth() * 1.0f / sizeInDp;
            } else {
                targetDensity = XXAutoSizeConfig.getInstance().getScreenHeight() * 1.0f / sizeInDp;
            }
            float scale = XXAutoSizeConfig.getInstance().isExcludeFontScale() ? 1 : XXAutoSizeConfig.getInstance().
                    getInitScaledDensity() * 1.0f / XXAutoSizeConfig.getInstance().getInitDensity();
            targetScaledDensity = targetDensity * scale;
            targetDensityDpi = (int) (targetDensity * 160);

            if (isBaseOnWidth) {
                targetXdpi = XXAutoSizeConfig.getInstance().getScreenWidth() * 1.0f / subunitsDesignSize;
            } else {
                targetXdpi = XXAutoSizeConfig.getInstance().getScreenHeight() * 1.0f / subunitsDesignSize;
            }

            mCache.put(key, new XXDisplayMetricsInfo(targetDensity, targetDensityDpi, targetScaledDensity, targetXdpi));
        } else {
            targetDensity = displayMetricsInfo.getDensity();
            targetDensityDpi = displayMetricsInfo.getDensityDpi();
            targetScaledDensity = displayMetricsInfo.getScaledDensity();
            targetXdpi = displayMetricsInfo.getXdpi();
        }

        setDensity(resources, targetDensity, targetDensityDpi, targetScaledDensity, targetXdpi);
    }

    /**
     * 取消适配
     *
     * @param resources {@link Resources}
     */
    public static void cancelAdapt(Resources resources) {
        float initXdpi = XXAutoSizeConfig.getInstance().getInitXdpi();
        switch (XXAutoSizeConfig.getInstance().getUnitsManager().getSupportSubunits()) {
            case PT:
                initXdpi = initXdpi / 72f;
                break;
            case MM:
                initXdpi = initXdpi / 25.4f;
                break;
            default:
        }
        setDensity(resources, XXAutoSizeConfig.getInstance().getInitDensity()
                , XXAutoSizeConfig.getInstance().getInitDensityDpi()
                , XXAutoSizeConfig.getInstance().getInitScaledDensity()
                , initXdpi);
    }

    /**
     * 给几大 {@link DisplayMetrics} 赋值
     *
     * @param resources     {@link Resources}
     * @param density       {@link DisplayMetrics#density}
     * @param densityDpi    {@link DisplayMetrics#densityDpi}
     * @param scaledDensity {@link DisplayMetrics#scaledDensity}
     * @param xdpi          {@link DisplayMetrics#xdpi}
     */
    private static void setDensity(Resources resources, float density, int densityDpi, float scaledDensity, float xdpi) {
        //兼容 MIUI
        DisplayMetrics activityDisplayMetricsOnMIUI = getMetricsOnMiui(resources);
        DisplayMetrics appDisplayMetricsOnMIUI = getMetricsOnMiui(XXAutoSizeConfig.getInstance().getApplication().getResources());

        if (activityDisplayMetricsOnMIUI != null) {
            setDensity(activityDisplayMetricsOnMIUI, density, densityDpi, scaledDensity, xdpi);
        } else {
            DisplayMetrics activityDisplayMetrics = resources.getDisplayMetrics();
            setDensity(activityDisplayMetrics, density, densityDpi, scaledDensity, xdpi);
        }

        if (appDisplayMetricsOnMIUI != null) {
            setDensity(appDisplayMetricsOnMIUI, density, densityDpi, scaledDensity, xdpi);
        } else {
            DisplayMetrics appDisplayMetrics = XXAutoSizeConfig.getInstance().getApplication().getResources().getDisplayMetrics();
            setDensity(appDisplayMetrics, density, densityDpi, scaledDensity, xdpi);
        }
    }

    /**
     * 赋值
     *
     * @param displayMetrics {@link DisplayMetrics}
     * @param density        {@link DisplayMetrics#density}
     * @param densityDpi     {@link DisplayMetrics#densityDpi}
     * @param scaledDensity  {@link DisplayMetrics#scaledDensity}
     * @param xdpi           {@link DisplayMetrics#xdpi}
     */
    private static void setDensity(DisplayMetrics displayMetrics, float density, int densityDpi, float scaledDensity, float xdpi) {
        if (XXAutoSizeConfig.getInstance().getUnitsManager().isSupportDP()) {
            displayMetrics.density = density;
            displayMetrics.densityDpi = densityDpi;
        }
        if (XXAutoSizeConfig.getInstance().getUnitsManager().isSupportSP()) {
            displayMetrics.scaledDensity = scaledDensity;
        }
        switch (XXAutoSizeConfig.getInstance().getUnitsManager().getSupportSubunits()) {
            case NONE:
                break;
            case PT:
                displayMetrics.xdpi = xdpi * 72f;
                break;
            case IN:
                displayMetrics.xdpi = xdpi;
                break;
            case MM:
                displayMetrics.xdpi = xdpi * 25.4f;
                break;
            default:
        }
    }

    /**
     * 解决 MIUI 更改框架导致的 MIUI7 + Android5.1.1 上出现的失效问题 (以及极少数基于这部分 MIUI 去掉 ART 然后置入 XPosed 的手机)
     * 来源于: https://github.com/Firedamp/Rudeness/blob/master/rudeness-sdk/src/main/java/com/bulong/rudeness/RudenessScreenHelper.java#L61:5
     *
     * @param resources {@link Resources}
     * @return {@link DisplayMetrics}, 可能为 {@code null}
     */
    private static DisplayMetrics getMetricsOnMiui(Resources resources) {
        if (XXAutoSizeConfig.getInstance().isMiui() && XXAutoSizeConfig.getInstance().getTmpMetricsField() != null) {
            try {
                return (DisplayMetrics) XXAutoSizeConfig.getInstance().getTmpMetricsField().get(resources);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
