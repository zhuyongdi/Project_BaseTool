package com.zhuyongdi.basetool.tool;

import android.view.View;
import android.widget.TextView;

public class XXViewUtil {

    public static void View_setVisibility(View view, int visibility) {
        if (view != null && view.getVisibility() != visibility) {
            view.setVisibility(visibility);
        }
    }

    public static void setTextViewText(TextView tv, String text) {
        if (tv != null && text != null) {
            String a = tv.getText().toString();
            if (!text.equals(a)) {
                tv.setText(text);
            }
        }
    }

}
