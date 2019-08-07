package com.zhuyongdi.basetool.function.permission.setting;

/**
 * Created by ZhuYongdi on 2019/5/10.
 */
public interface XXSettingService {

    /**
     * Execute setting.
     */
    void execute();

    /**
     * Execute setting with requestCode.
     */
    void execute(int requestCode);

    /**
     * Cancel the operation.
     */
    void cancel();

}
