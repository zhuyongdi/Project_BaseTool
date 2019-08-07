package com.zhuyongdi.basetool.function.permission;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

import com.zhuyongdi.basetool.function.permission.checker.XXDoubleChecker;
import com.zhuyongdi.basetool.function.permission.checker.XXPermissionChecker;
import com.zhuyongdi.basetool.function.permission.checker.XXStandardChecker;
import com.zhuyongdi.basetool.function.permission.source.XXSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ZhuYongdi on 2019/5/10.
 */
@RequiresApi(api = Build.VERSION_CODES.M)
class XXMRequest implements XXRequest, XXRequestExecutor, XXPermissionActivity.PermissionListener {

    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    private static final XXPermissionChecker CHECKER = new XXStandardChecker();
    private static final XXPermissionChecker DOUBLE_CHECKER = new XXDoubleChecker();

    private XXSource mSource;

    private String[] mPermissions;
    private XXRationale mRationaleListener;
    private XXAction mGranted;
    private XXAction mDenied;

    private String[] mDeniedPermissions;

    XXMRequest(XXSource source) {
        this.mSource = source;
    }

    @NonNull
    @Override
    public XXRequest permission(String... permissions) {
        this.mPermissions = permissions;
        return this;
    }

    @NonNull
    @Override
    public XXRequest permission(String[]... groups) {
        List<String> permissionList = new ArrayList<>();
        for (String[] group : groups) {
            permissionList.addAll(Arrays.asList(group));
        }
        this.mPermissions = permissionList.toArray(new String[permissionList.size()]);
        return this;
    }


    @NonNull
    @Override
    public XXRequest rationale(XXRationale listener) {
        this.mRationaleListener = listener;
        return this;
    }

    @NonNull
    @Override
    public XXRequest onGranted(XXAction granted) {
        this.mGranted = granted;
        return this;
    }

    @NonNull
    @Override
    public XXRequest onDenied(XXAction denied) {
        this.mDenied = denied;
        return this;
    }

    @Override
    public void start() {
        List<String> deniedList = getDeniedPermissions(CHECKER, mSource, mPermissions);
        mDeniedPermissions = deniedList.toArray(new String[deniedList.size()]);
        if (mDeniedPermissions.length > 0) {
            List<String> rationaleList = getRationalePermissions(mSource, mDeniedPermissions);
            if (rationaleList.size() > 0 && mRationaleListener != null) {
                mRationaleListener.showRationale(mSource.getContext(), rationaleList, this);
            } else {
                execute();
            }
        } else {
            callbackSucceed();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void execute() {
        XXPermissionActivity.requestPermission(mSource.getContext(), mDeniedPermissions, this);
    }

    @Override
    public void cancel() {
        onRequestPermissionsResult(mDeniedPermissions);
    }

    @Override
    public void onRequestPermissionsResult(@NonNull final String[] permissions) {
        HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<String> deniedList = getDeniedPermissions(DOUBLE_CHECKER, mSource, permissions);
                if (deniedList.isEmpty()) {
                    callbackSucceed();
                } else {
                    callbackFailed(deniedList);
                }
            }
        }, 250);
    }

    /**
     * Callback acceptance status.
     */
    private void callbackSucceed() {
        if (mGranted != null) {
            List<String> permissionList = Arrays.asList(mPermissions);
            try {
                mGranted.onAction(permissionList);
            } catch (Exception e) {
                if (mDenied != null) {
                    mDenied.onAction(permissionList);
                }
            }
        }
    }

    /**
     * Callback rejected state.
     */
    private void callbackFailed(@NonNull List<String> deniedList) {
        if (mDenied != null) {
            mDenied.onAction(deniedList);
        }
    }

    /**
     * Get denied permissions.
     */
    private static List<String> getDeniedPermissions(XXPermissionChecker checker, @NonNull XXSource source, @NonNull String... permissions) {
        List<String> deniedList = new ArrayList<>(1);
        for (String permission : permissions) {
            if (!checker.hasPermission(source.getContext(), permission)) {
                deniedList.add(permission);
            }
        }
        return deniedList;
    }

    /**
     * Get permissions to show rationale.
     */
    private static List<String> getRationalePermissions(@NonNull XXSource source, @NonNull String... permissions) {
        List<String> rationaleList = new ArrayList<>(1);
        for (String permission : permissions) {
            if (source.isShowRationalePermission(permission)) {
                rationaleList.add(permission);
            }
        }
        return rationaleList;
    }

}
