package com.zhuyongdi.basetool.function.permission.checker;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

import com.zhuyongdi.basetool.function.permission.XXPermission;

import java.util.List;

/**
 * Created by ZhuYongdi on 2019/5/10.
 */
public class XXStrictChecker implements XXPermissionChecker {

    public XXStrictChecker() {
    }

    @Override
    public boolean hasPermission(@NonNull Context context, @NonNull String... permissions) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) return true;

        for (String permission : permissions) {
            if (!hasPermission(context, permission)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean hasPermission(@NonNull Context context, @NonNull List<String> permissions) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) return true;

        for (String permission : permissions) {
            if (!hasPermission(context, permission)) {
                return false;
            }
        }
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private boolean hasPermission(Context context, String permission) {
        try {
            switch (permission) {
                case XXPermission.READ_CALENDAR:
                    return checkReadCalendar(context);
                case XXPermission.WRITE_CALENDAR:
                    return checkWriteCalendar(context);
                case XXPermission.CAMERA:
                    return checkCamera(context);
                case XXPermission.READ_CONTACTS:
                    return checkReadContacts(context);
                case XXPermission.WRITE_CONTACTS:
                    return checkWriteContacts(context);
                case XXPermission.GET_ACCOUNTS:
                    return true;
                case XXPermission.ACCESS_COARSE_LOCATION:
                case XXPermission.ACCESS_FINE_LOCATION:
                    return checkLocation(context);
                case XXPermission.RECORD_AUDIO:
                    return checkRecordAudio();
                case XXPermission.READ_PHONE_STATE:
                    return checkReadPhoneState(context);
                case XXPermission.CALL_PHONE:
                    return true;
                case XXPermission.READ_CALL_LOG:
                    return checkReadCallLog(context);
                case XXPermission.WRITE_CALL_LOG:
                    return checkWriteCallLog(context);
                case XXPermission.ADD_VOICEMAIL:
                    return checkAddVoicemail(context);
                case XXPermission.USE_SIP:
                    return checkSip(context);
                case XXPermission.PROCESS_OUTGOING_CALLS:
                    return true;
                case XXPermission.BODY_SENSORS:
                    return checkSensors(context);
                case XXPermission.SEND_SMS:
                case XXPermission.RECEIVE_MMS:
                    return true;
                case XXPermission.READ_SMS:
                    return checkReadSms(context);
                case XXPermission.RECEIVE_WAP_PUSH:
                case XXPermission.RECEIVE_SMS:
                    return true;
                case XXPermission.READ_EXTERNAL_STORAGE:
                    return checkReadStorage();
                case XXPermission.WRITE_EXTERNAL_STORAGE:
                    return checkWriteStorage();
            }
        } catch (Throwable e) {
            return false;
        }
        return true;
    }

    private static boolean checkReadCalendar(Context context) throws Throwable {
        XXPermissionTest test = new XXCalendarReadTest(context);
        return test.test();
    }

    private static boolean checkWriteCalendar(Context context) throws Throwable {
        XXPermissionTest test = new XXCalendarWriteTest(context);
        return test.test();
    }

    private static boolean checkCamera(Context context) throws Throwable {
        XXPermissionTest test = new XXCameraTest(context);
        return test.test();
    }

    private static boolean checkReadContacts(Context context) throws Throwable {
        XXPermissionTest test = new XXContactsReadTest(context);
        return test.test();
    }

    private static boolean checkWriteContacts(Context context) throws Throwable {
        ContentResolver resolver = context.getContentResolver();
        XXPermissionTest test = new XXContactsWriteTest(resolver);
        return test.test();
    }

    private static boolean checkLocation(Context context) throws Throwable {
        XXPermissionTest test = new XXLocationTest(context);
        return test.test();
    }

    private static boolean checkRecordAudio() throws Throwable {
        XXPermissionTest test = new XXRecordAudioTest();
        return test.test();
    }

    private static boolean checkReadPhoneState(Context context) throws Throwable {
        XXPermissionTest test = new XXPhoneStateReadTest(context);
        return test.test();
    }

    private static boolean checkReadCallLog(Context context) throws Throwable {
        XXPermissionTest test = new XXCallLogReadTest(context);
        return test.test();
    }

    private static boolean checkWriteCallLog(Context context) throws Throwable {
        XXPermissionTest test = new XXCallLogWriteTest(context);
        return test.test();
    }

    private static boolean checkAddVoicemail(Context context) throws Throwable {
        XXPermissionTest test = new XXAddVoicemailTest(context);
        return test.test();
    }

    private static boolean checkSip(Context context) throws Throwable {
        XXPermissionTest test = new XXSipTest(context);
        return test.test();
    }

    private static boolean checkSensors(Context context) throws Throwable {
        XXPermissionTest test = new XXSensorsTest(context);
        return test.test();
    }

    private static boolean checkReadSms(Context context) throws Throwable {
        XXPermissionTest test = new XXSmsReadTest(context);
        return test.test();
    }

    private static boolean checkReadStorage() throws Throwable {
        XXPermissionTest test = new XXStorageReadTest();
        return test.test();
    }

    private static boolean checkWriteStorage() throws Throwable {
        XXPermissionTest test = new XXStorageWriteTest();
        return test.test();
    }

}
