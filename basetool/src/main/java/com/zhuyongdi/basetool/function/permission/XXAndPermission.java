package com.zhuyongdi.basetool.function.permission;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

import com.zhuyongdi.basetool.function.permission.setting.XXPermissionSetting;
import com.zhuyongdi.basetool.function.permission.setting.XXSettingService;
import com.zhuyongdi.basetool.function.permission.source.XXAppActivitySource;
import com.zhuyongdi.basetool.function.permission.source.XXContextSource;
import com.zhuyongdi.basetool.function.permission.source.XXFragmentSource;
import com.zhuyongdi.basetool.function.permission.source.XXSource;
import com.zhuyongdi.basetool.function.permission.source.XXSupportFragmentSource;

import java.util.List;

/**
 * Created by ZhuYongdi on 2019/5/10.
 */
public class XXAndPermission {

    private static final RequestFactory FACTORY;

    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            FACTORY = new MRequestFactory();
        } else {
            FACTORY = new LRequestFactory();
        }
    }

    /**
     * Some privileges permanently disabled, may need to set up in the execute.
     *
     * @param activity          {@link Activity}.
     * @param deniedPermissions one or more permissions.
     * @return true, other wise is false.
     */
    public static boolean hasAlwaysDeniedPermission(
            @NonNull Activity activity,
            @NonNull List<String> deniedPermissions) {
        return hasAlwaysDeniedPermission(new XXAppActivitySource(activity), deniedPermissions);
    }

    /**
     * Some privileges permanently disabled, may need to set up in the execute.
     *
     * @param fragment          {@link android.support.v4.app.Fragment}.
     * @param deniedPermissions one or more permissions.
     * @return true, other wise is false.
     */
    public static boolean hasAlwaysDeniedPermission(
            @NonNull android.support.v4.app.Fragment fragment,
            @NonNull List<String> deniedPermissions) {
        return hasAlwaysDeniedPermission(new XXSupportFragmentSource(fragment), deniedPermissions);
    }

    /**
     * Some privileges permanently disabled, may need to set up in the execute.
     *
     * @param fragment          {@link android.app.Fragment}.
     * @param deniedPermissions one or more permissions.
     * @return true, other wise is false.
     */
    public static boolean hasAlwaysDeniedPermission(
            @NonNull android.app.Fragment fragment,
            @NonNull List<String> deniedPermissions) {
        return hasAlwaysDeniedPermission(new XXFragmentSource(fragment), deniedPermissions);
    }

    /**
     * Some privileges permanently disabled, may need to set up in the execute.
     *
     * @param context           {@link Context}.
     * @param deniedPermissions one or more permissions.
     * @return true, other wise is false.
     */
    public static boolean hasAlwaysDeniedPermission(
            @NonNull Context context,
            @NonNull List<String> deniedPermissions) {
        return hasAlwaysDeniedPermission(new XXContextSource(context), deniedPermissions);
    }

    /**
     * Has always been denied permission.
     */
    private static boolean hasAlwaysDeniedPermission(
            @NonNull XXSource source,
            @NonNull List<String> deniedPermissions) {
        for (String permission : deniedPermissions) {
            if (!source.isShowRationalePermission(permission)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Some privileges permanently disabled, may need to set up in the execute.
     *
     * @param activity          {@link Activity}.
     * @param deniedPermissions one or more permissions.
     * @return true, other wise is false.
     */
    public static boolean hasAlwaysDeniedPermission(
            @NonNull Activity activity,
            @NonNull String... deniedPermissions) {
        return hasAlwaysDeniedPermission(new XXAppActivitySource(activity), deniedPermissions);
    }

    /**
     * Some privileges permanently disabled, may need to set up in the execute.
     *
     * @param fragment          {@link android.support.v4.app.Fragment}.
     * @param deniedPermissions one or more permissions.
     * @return true, other wise is false.
     */
    public static boolean hasAlwaysDeniedPermission(
            @NonNull android.support.v4.app.Fragment fragment,
            @NonNull String... deniedPermissions) {
        return hasAlwaysDeniedPermission(new XXSupportFragmentSource(fragment), deniedPermissions);
    }

    /**
     * Some privileges permanently disabled, may need to set up in the execute.
     *
     * @param fragment          {@link android.app.Fragment}.
     * @param deniedPermissions one or more permissions.
     * @return true, other wise is false.
     */
    public static boolean hasAlwaysDeniedPermission(
            @NonNull android.app.Fragment fragment,
            @NonNull String... deniedPermissions) {
        return hasAlwaysDeniedPermission(new XXFragmentSource(fragment), deniedPermissions);
    }

    /**
     * Some privileges permanently disabled, may need to set up in the execute.
     *
     * @param context           {@link Context}.
     * @param deniedPermissions one or more permissions.
     * @return true, other wise is false.
     */
    public static boolean hasAlwaysDeniedPermission(
            @NonNull Context context,
            @NonNull String... deniedPermissions) {
        return hasAlwaysDeniedPermission(new XXContextSource(context), deniedPermissions);
    }

    /**
     * Has always been denied permission.
     */
    private static boolean hasAlwaysDeniedPermission(
            @NonNull XXSource source,
            @NonNull String... deniedPermissions) {
        for (String permission : deniedPermissions) {
            if (!source.isShowRationalePermission(permission)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Create a service that opens the permission setting page.
     *
     * @param activity {@link Activity}.
     * @return {@link XXSettingService}.
     */
    @NonNull
    public static XXSettingService permissionSetting(@NonNull Activity activity) {
        return new XXPermissionSetting(new XXAppActivitySource(activity));
    }

    /**
     * Create a service that opens the permission setting page.
     *
     * @param fragment {@link android.support.v4.app.Fragment}.
     * @return {@link XXSettingService}.
     */
    @NonNull
    public static XXSettingService permissionSetting(@NonNull android.support.v4.app.Fragment fragment) {
        return new XXPermissionSetting(new XXSupportFragmentSource(fragment));
    }

    /**
     * Create a service that opens the permission setting page.
     *
     * @param fragment {@link android.app.Fragment}.
     * @return {@link XXSettingService}.
     */
    @NonNull
    public static XXSettingService permissionSetting(@NonNull android.app.Fragment fragment) {
        return new XXPermissionSetting(new XXFragmentSource(fragment));
    }

    /**
     * Create a service that opens the permission setting page.
     *
     * @param context {@link Context}.
     * @return {@link XXSettingService}.
     */
    @NonNull
    public static XXSettingService permissionSetting(@NonNull Context context) {
        return new XXPermissionSetting(new XXContextSource(context));
    }

    /**
     * With Activity.
     *
     * @param activity {@link Activity}.
     * @return {@link XXRequest}.
     */
    @NonNull
    public static XXRequest with(@NonNull Activity activity) {
        return FACTORY.create(new XXAppActivitySource(activity));
    }

    /**
     * With android.support.v4.app.Fragment.
     *
     * @param fragment {@link android.support.v4.app.Fragment}.
     * @return {@link XXRequest}.
     */
    @NonNull
    public static XXRequest with(@NonNull android.support.v4.app.Fragment fragment) {
        return FACTORY.create(new XXSupportFragmentSource(fragment));
    }

    /**
     * With android.app.Fragment.
     *
     * @param fragment {@link android.app.Fragment}.
     * @return {@link XXRequest}.
     */
    @NonNull
    public static XXRequest with(@NonNull android.app.Fragment fragment) {
        return FACTORY.create(new XXFragmentSource(fragment));
    }

    /**
     * With context.
     *
     * @param context {@link Context}.
     * @return {@link XXRequest}.
     */
    @NonNull
    public static XXRequest with(@NonNull Context context) {
        return FACTORY.create(new XXContextSource(context));
    }

    private XXAndPermission() {
    }

    private interface RequestFactory {
        /**
         * Create permission request.
         */
        XXRequest create(XXSource source);
    }

    private static class LRequestFactory implements RequestFactory {
        @Override
        public XXRequest create(XXSource source) {
            return new XXLRequest(source);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private static class MRequestFactory implements RequestFactory {
        @Override
        public XXRequest create(XXSource source) {
            return new XXMRequest(source);
        }
    }

}
