package com.zhuyongdi.basetool.function.permission.checker;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by ZhuYongdi on 2019/5/10.
 */
public final class XXDoubleChecker implements XXPermissionChecker {

    private static final XXPermissionChecker STANDARD_CHECKER = new XXStandardChecker();
    private static final XXPermissionChecker STRICT_CHECKER = new XXStrictChecker();

    @Override
    public boolean hasPermission(@NonNull Context context, @NonNull String... permissions) {
        return STANDARD_CHECKER.hasPermission(context, permissions)
                && STRICT_CHECKER.hasPermission(context, permissions);
    }

    @Override
    public boolean hasPermission(@NonNull Context context, @NonNull List<String> permissions) {
        return STANDARD_CHECKER.hasPermission(context, permissions)
                && STRICT_CHECKER.hasPermission(context, permissions);
    }

}
