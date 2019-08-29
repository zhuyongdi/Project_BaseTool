package com.zhuyongdi.basetool.widget.nine_grid_view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zhuyongdi.basetool.R;
import com.zhuyongdi.basetool.tool.screen.XXScreenUtil;

import java.util.ArrayList;

/**
 * 九宫格控件
 * Created by ZhuYongdi on 2019/4/3.
 */
@SuppressLint("WrongConstant")
public class XXNineGridView extends ViewGroup {

    private XXImageLoader mImageLoader; //图片加载框架
    private int mMaxImgSize; //最大图片数量
    private int mSingleMinWidth; //X1FillMode(保持比例)时,单张图片时最小屏幕占比
    private int mSingleMaxWidth; //X1FillMode(保持比例)时,单张图片时最大屏幕占比
    private int mGridSpacing; //网格间隙
    private int mGridWidth; //一张图片的宽度
    private int mGridHeight; //一张图片的高度
    private int mRowCount; //行数
    private int mColumnCount; //列数
    private X1FillMode m1FillMode = X1FillMode.MATCH_PARENT; //单张图片时填充方式
    private X2FillMode m2FillMode = X2FillMode.MODE_11; //两张图片时填充方式
    private X4FillMode m4FillMode = X4FillMode.MODE_3X1; //四张图片时填充方式
    private ArrayList<XXImageInfo> mImageInfoList = new ArrayList<>();
    private ArrayList<ImageView> mImageViewList = new ArrayList<>();
    private XXNineGridViewAdapter mAdapter;

    public XXNineGridView(Context context) {
        this(context, (AttributeSet) null);
    }

    public XXNineGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XXNineGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.XXNineGridView);
        this.mMaxImgSize = a.getInt(R.styleable.XXNineGridView_xx_nine_grid_view_max_size, 9);
        this.mGridSpacing = (int) a.getDimension(R.styleable.XXNineGridView_xx_nine_grid_view_spacing, 20);
        this.mSingleMinWidth = (int) (XXScreenUtil.getScreenWidth(getContext()) * a.getFloat(R.styleable.XXNineGridView_xx_nine_grid_view_single_min_width, 0.2f));
        this.mSingleMaxWidth = (int) (XXScreenUtil.getScreenWidth(getContext()) * a.getFloat(R.styleable.XXNineGridView_xx_nine_grid_view_single_max_width, 0.3f));
        a.recycle();
    }

    public XXNineGridView imageLoader(XXImageLoader imageLoader) {
        mImageLoader = imageLoader;
        return this;
    }

    public XXNineGridView maxNum(int maxNum) {
        this.mMaxImgSize = maxNum > 0 ? maxNum : 9;
        return this;
    }

    public XXNineGridView x1FillMode(X1FillMode mode) {
        this.m1FillMode = mode;
        return this;
    }

    public XXNineGridView x2FillMode(X2FillMode mode) {
        this.m2FillMode = mode;
        return this;
    }

    public XXNineGridView x4FillMode(X4FillMode mode) {
        this.m4FillMode = mode;
        return this;
    }

    public XXNineGridView spacing(int spacing) {
        this.mGridSpacing = spacing;
        return this;
    }

    public XXNineGridView singleMinScreenRatio(float rate) {
        this.mSingleMinWidth = (int) (XXScreenUtil.getScreenWidth(getContext()) * rate);
        return this;
    }

    public XXNineGridView singleMaxScreenRatio(float rate) {
        this.mSingleMaxWidth = (int) (XXScreenUtil.getScreenWidth(getContext()) * rate);
        return this;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = 0;
        int totalWidth = width - this.getPaddingLeft() - this.getPaddingRight();
        if (this.mImageInfoList != null && this.mImageInfoList.size() > 0) {
            if (this.mImageInfoList.size() == 1) {
                handle1FillMode(totalWidth);
            } else if (this.mImageInfoList.size() == 2) {
                handle2FillMode(totalWidth);
            } else {
                handle3FillMode(totalWidth);
            }
            height = getMeasuredTotalHeight(this.mImageInfoList.size());
        }
        this.setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (this.mImageInfoList != null) {
            int childCount = this.mImageInfoList.size();
            for (int i = 0; i < childCount; ++i) {
                ImageView childrenView = (ImageView) this.getChildAt(i);
                int rowNum = i / this.mColumnCount;
                int columnNum = i % this.mColumnCount;
                int left = (this.mGridWidth + this.mGridSpacing) * columnNum + this.getPaddingLeft();
                int top = (this.mGridHeight + this.mGridSpacing) * rowNum + this.getPaddingTop();
                int right = left + this.mGridWidth;
                int bottom = top + this.mGridHeight;
                if (childCount == 4 && m4FillMode == X4FillMode.MODE_2X2_NOT_FILL) {
                    if (i == 2) {
                        left = this.mGridWidth + this.mGridSpacing + this.getPaddingLeft();
                        top = this.mGridHeight + this.mGridSpacing + this.getPaddingTop();
                        right = left + this.mGridWidth;
                        bottom = top + this.mGridHeight;
                    } else if (i == 3) {
                        left = this.getPaddingLeft();
                        top = this.mGridHeight + this.mGridSpacing + this.getPaddingTop();
                        right = left + this.mGridWidth;
                        bottom = top + this.mGridHeight;
                    }
                }
                childrenView.layout(left, top, right, bottom);
                if (mImageLoader != null) {
                    mImageLoader.onDisplayImage(this.getContext(), childrenView, this.mImageInfoList.get(i).getImageUrl());
                }
            }
        }
    }

    public void setAdapter(@NonNull XXNineGridViewAdapter adapter) {
        this.mAdapter = adapter;
        ArrayList<XXImageInfo> imageInfoList = adapter.getImageInfo();
        if (imageInfoList != null && !imageInfoList.isEmpty()) {
            this.setVisibility(0);
            int imageCount = imageInfoList.size();
            if (this.mMaxImgSize > 0 && imageCount > this.mMaxImgSize) {
                imageInfoList = (ArrayList<XXImageInfo>) imageInfoList.subList(0, this.mMaxImgSize);
                imageCount = imageInfoList.size();
            }
            switch (imageCount) {
                case 1:
                    this.mColumnCount = 1;
                    this.mRowCount = 1;
                    break;
                case 2:
                    this.mColumnCount = 2;
                    this.mRowCount = 1;
                    break;
                case 3:
                    this.mColumnCount = 3;
                    this.mRowCount = 1;
                    break;
                case 4:
                    switch (m4FillMode) {
                        case MODE_2X2_NOT_FILL:
                            this.mColumnCount = 3;
                            this.mRowCount = 2;
                            break;
                        case MODE_2X2_FILL:
                            this.mColumnCount = 2;
                            this.mRowCount = 2;
                            break;
                        case MODE_3X1:
                            this.mColumnCount = 3;
                            this.mRowCount = 2;
                            break;
                    }
                    break;
                default:
                    this.mColumnCount = 3;
                    this.mRowCount = imageCount / 3 + (imageCount % 3 == 0 ? 0 : 1);
                    break;
            }
            int oldViewCount;
            if (this.mImageInfoList == null || this.mImageInfoList.isEmpty()) {
                for (oldViewCount = 0; oldViewCount < imageCount; ++oldViewCount) {
                    ImageView iv = this.getImageView(oldViewCount);
                    if (iv == null) {
                        return;
                    }
                    this.addView(iv, this.generateDefaultLayoutParams());
                }
            } else {
                oldViewCount = this.mImageInfoList.size();
                if (oldViewCount > imageCount) {
                    this.removeViews(imageCount, oldViewCount - imageCount);
                } else if (oldViewCount < imageCount) {
                    for (int i = oldViewCount; i < imageCount; ++i) {
                        ImageView iv = this.getImageView(i);
                        if (iv == null) {
                            return;
                        }
                        this.addView(iv, this.generateDefaultLayoutParams());
                    }
                }
            }
            this.mImageInfoList = imageInfoList;
            this.requestLayout();
        } else {
            this.setVisibility(8);
        }
    }

    private ImageView getImageView(final int position) {
        ImageView imageView;
        if (position < this.mImageViewList.size()) {
            imageView = this.mImageViewList.get(position);
        } else {
            imageView = this.mImageLoader.onConfigImageView(XXNineGridView.this.getContext());
            if (imageView == null) {
                imageView = new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    XXNineGridView.this.mAdapter.onImageItemClick(XXNineGridView.this.getContext(), XXNineGridView.this, position, XXNineGridView.this.mAdapter.getImageInfo());
                }
            });
            this.mImageViewList.add(imageView);
        }
        return imageView;
    }

    private void handle1FillMode(int totalWidth) {
        switch (m1FillMode) {
            case MODE_100:
                this.mGridWidth = this.mGridHeight = (totalWidth - this.mGridSpacing * 2) / 3;
                break;
            case MATCH_PARENT:
                this.mGridWidth = this.mGridHeight = totalWidth;
                break;
            case SPECIFIC:
                int[] var = getSingleImageWidth();
                this.mGridWidth = var[0];
                this.mGridHeight = var[1];
                break;
        }
    }

    private void handle2FillMode(int totalWidth) {
        switch (m2FillMode) {
            case MODE_110:
                this.mGridWidth = this.mGridHeight = (totalWidth - this.mGridSpacing * 2) / 3;
                break;
            case MODE_11:
                this.mGridWidth = this.mGridHeight = (totalWidth - this.mGridSpacing) / 2;
                break;
        }
    }

    private void handle3FillMode(int totalWidth) {
        this.mGridWidth = this.mGridHeight = (totalWidth - this.mGridSpacing * (this.mColumnCount - 1)) / this.mColumnCount;
    }

    private int getMeasuredTotalHeight(int size) {
        switch (size) {
            case 1:
                switch (m1FillMode) {
                    case MATCH_PARENT:
                        return this.mGridWidth + this.getPaddingLeft() + this.getPaddingRight();
                    case SPECIFIC:
                        return this.mGridHeight + this.getPaddingTop() + this.getPaddingBottom();
                }
                break;
        }
        return this.mGridHeight * this.mRowCount + this.mGridSpacing * (this.mRowCount - 1) + this.getPaddingTop() + this.getPaddingBottom();
    }

    private int[] getSingleImageWidth() {
        int[] result = new int[2];
        XXImageInfo info = mImageInfoList.get(0);
        int width = info.getImageWidth();
        int height = info.getImageHeight();
        if (width == 0 || height == 0) {
            result[0] = mSingleMinWidth;
            result[1] = mSingleMaxWidth * 3 / 2;
        } else {
            if (width <= mSingleMinWidth) {
                result[0] = mSingleMinWidth;
                result[1] = mSingleMinWidth * height / width;
            } else if (width >= mSingleMaxWidth) {
                result[0] = mSingleMaxWidth;
                result[1] = mSingleMaxWidth * height / width;
            } else {
                result[0] = width;
                result[1] = height;
            }
        }
        return result;
    }

}
