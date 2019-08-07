package com.zhuyongdi.basetool.widget.nine_grid_view;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by ZhuYongdi on 2019/4/3.
 */
public abstract class XXNineGridViewAdapter {

    public abstract void onImageItemClick(Context context, XXNineGridView gridView, int index, ArrayList<XXImageInfo> imageInfo);

    protected Context mContext;
    private ArrayList<XXImageInfo> mImageInfoList;

    public XXNineGridViewAdapter(Context context) {
        this.mContext = context;
    }

    public XXNineGridViewAdapter(Context context, ArrayList<XXImageInfo> imageInfoList) {
        this.mContext = context;
        this.mImageInfoList = imageInfoList;
    }

    public ArrayList<XXImageInfo> getImageInfo() {
        return this.mImageInfoList;
    }

    public void setImageInfoList(ArrayList<XXImageInfo> imageInfoList) {
        this.mImageInfoList = imageInfoList;
    }

}
