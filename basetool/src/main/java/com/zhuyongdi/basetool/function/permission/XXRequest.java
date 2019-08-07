package com.zhuyongdi.basetool.function.permission;

import android.support.annotation.NonNull;

/**
 * Created by ZhuYongdi on 2019/5/10.
 */
public interface XXRequest {

    /**
     * One or more permissions.
     */
    @NonNull
    XXRequest permission(String... permissions);

    /**
     * One or more permission groups.
     */
    @NonNull
    XXRequest permission(String[]... groups);

    /**
     * Set request rationale.
     */
    @NonNull
    XXRequest rationale(XXRationale listener);

    /**
     * Action to be taken when all permissions are granted.
     */
    @NonNull
    XXRequest onGranted(XXAction granted);

    /**
     * Action to be taken when all permissions are denied.
     */
    @NonNull
    XXRequest onDenied(XXAction denied);

    /**
     * Request permission.
     */
    void start();

}
