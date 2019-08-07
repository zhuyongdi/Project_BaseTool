package com.zhuyongdi.basetool.function.permission.checker;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.CallLog;
import android.support.annotation.RequiresPermission;

import com.zhuyongdi.basetool.function.permission.XXPermission;


/**
 * Created by ZhuYongdi on 2019/5/10.
 */
class XXCallLogWriteTest implements XXPermissionTest {

    private ContentResolver mResolver;

    XXCallLogWriteTest(Context context) {
        this.mResolver = context.getContentResolver();
    }

    @RequiresPermission(XXPermission.WRITE_CALL_LOG)
    @Override
    public boolean test() throws Throwable {
        try {
            ContentValues content = new ContentValues();
            content.put(CallLog.Calls.TYPE, CallLog.Calls.INCOMING_TYPE);
            content.put(CallLog.Calls.NUMBER, "1");
            content.put(CallLog.Calls.DATE, 20080808);
            content.put(CallLog.Calls.NEW, "0");
            Uri resourceUri = mResolver.insert(CallLog.Calls.CONTENT_URI, content);
            return ContentUris.parseId(resourceUri) > 0;
        } finally {
            mResolver.delete(CallLog.Calls.CONTENT_URI, CallLog.Calls.NUMBER + "=?", new String[]{"1"});
        }
    }

}
