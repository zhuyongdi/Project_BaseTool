package com.zhuyongdi.basetool.widget.bubble;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.FrameLayout;

import com.zhuyongdi.basetool.R;

public class XXBubbleFrameLayout extends FrameLayout {

    private XXBubbleOrientation mOrientation; //默认三角形的方向
    private int mTriWidth; //默认小三角形的宽度
    private int mTriHeight; //默认小三角形的高度
    private double mTriPositionPct; //默认的小三角形的位置,在边框的中心位置,百分比
    private float mTriPositionVal; //默认的小三角形的位置,在边框的中心位置,具体数值

    private int mBackgroundColor; //背景颜色
    private int mStrokeColor; //边框的颜色
    private int mRadius; //圆角角度
    private float mStrokeWidth; //边框厚度

    private Path mPath = new Path();
    private Paint mBgPaint = new Paint();
    private Paint mStrokePaint = new Paint();
    private DisplayMetrics dms;

    public XXBubbleFrameLayout(Context context) {
        this(context, null);
    }

    public XXBubbleFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XXBubbleFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
        dms = getResources().getDisplayMetrics();
        initAttrs(context, attrs);
    }

    /**
     * 初始化Paint
     */
    private void initPaint() {
        //初始化bgPaint
        mBgPaint.setStyle(Paint.Style.FILL);
        mBgPaint.setColor(mBackgroundColor);

        //初始化strokePaint
        mStrokePaint.setStyle(Paint.Style.STROKE);
        mStrokePaint.setColor(mStrokeColor);
        mStrokePaint.setStrokeWidth(mStrokeWidth);
        mStrokePaint.setAntiAlias(true);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.XXBubbleView);
        for (int i = 0; i < typedArray.getIndexCount(); i++) {
            int index = typedArray.getIndex(i);
            if (index == R.styleable.XXBubbleView_xx_bubble_orientation) {
                int orientation = typedArray.getInteger(index, 0);
                switch (orientation) {
                    case 0:
                        mOrientation = XXBubbleOrientation.LEFT;
                        break;
                    case 1:
                        mOrientation = XXBubbleOrientation.TOP;
                        break;
                    case 2:
                        mOrientation = XXBubbleOrientation.RIGHT;
                        break;
                    case 3:
                        mOrientation = XXBubbleOrientation.Bottom;
                        break;
                    default:
                        mOrientation = XXBubbleOrientation.LEFT;
                        break;
                }
                //设置边框宽度
            } else if (index == R.styleable.XXBubbleView_xx_bubble_stroke_width) {
                mStrokeWidth = typedArray.getDimension(index, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 0, dms));
                //边框颜色
            } else if (index == R.styleable.XXBubbleView_xx_bubble_stroke_color) {
                mStrokeColor = typedArray.getColor(index, 0x90000000);
                //设置小三角宽度
            } else if (index == R.styleable.XXBubbleView_xx_bubble_tri_width) {
                mTriWidth = (int) typedArray.getDimension(index, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, dms));
                //设置小三角高度
            } else if (index == R.styleable.XXBubbleView_xx_bubble_tri_height) {
                mTriHeight = (int) typedArray.getDimension(index, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, dms));
                //设置小三角位置,百分比
            } else if (index == R.styleable.XXBubbleView_xx_bubble_tri_position_pct) {
                mTriPositionPct = (double) typedArray.getInteger(index, 50) / 100d;
                //设置小三角位置,具体数值
            } else if (index == R.styleable.XXBubbleView_xx_bubble_tri_position_val) {
                mTriPositionVal = typedArray.getDimension(index, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, dms));
                //设置背景颜色
            } else if (index == R.styleable.XXBubbleView_xx_bubble_background_color) {
                mBackgroundColor = typedArray.getColor(index, 0x20000000);
                //设置圆角角度
            } else if (index == R.styleable.XXBubbleView_xx_bubble_radius) {
                mRadius = (int) typedArray.getDimension(index, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, dms));
            }
        }
        initPaint();
        typedArray.recycle();
    }

    /**
     * 设置方向
     */
    public void setOrientation(XXBubbleOrientation orientation) {
        this.mOrientation = orientation;
        redraw();
    }

    /**
     * 设置圆弧角度
     */
    public void setRadius(int radius) {
        this.mRadius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, radius, dms);
        redraw();
    }

    /**
     * 设置小三角的宽度
     */
    public void setTriWidth(int triWidth) {
        this.mTriWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, triWidth, dms);
        redraw();
    }

    /**
     * 设置小三角的高度
     */
    public void setTriHeight(int triHeight) {
        this.mTriHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, triHeight, dms);
        redraw();
    }

    /**
     * 设置边框厚度
     */
    public void setStrokeWidth(int strokeWidth) {
        this.mStrokeWidth = strokeWidth;
        redraw();
    }

    /**
     * 设置背景颜色
     */
    public void setBackgroundColor(int color) {
        this.mBackgroundColor = color;
        redraw();
    }

    /**
     * 设置边框的颜色
     */
    public void setStrokeColor(int strokeColor) {
        this.mStrokeColor = strokeColor;
        redraw();
    }

    /**
     * 设置小三角的位置,百分比
     */
    public void setTriPositionPct(int positionPct) {
        this.mTriPositionPct = positionPct / 100;
        redraw();
    }

    /**
     * 调整小三角的位置,具体数值
     */
    public void setTriPositionVal(int positionVal) {
        this.mTriPositionVal = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, positionVal, dms);
        redraw();
    }

    public void setTriPositionVal2(int positionVal) {
        this.mTriPositionVal = positionVal;
        redraw();
    }

    /**
     * 初始化Path
     */
    private void initPath(int w, int h) {
        RectF rectFRightTop;
        RectF rectFLeftTop;
        RectF rectFLeftBottom;
        RectF rectFRightBottom;
        int triCenterX = getTriCenter(w);
        int triCenterY = getTriCenter(h);
        mPath.reset();
        switch (mOrientation) {
            //左
            case LEFT:
                mPath.moveTo(w - mStrokeWidth, mStrokeWidth + mRadius);
                rectFRightTop = new RectF(w - mStrokeWidth - mRadius, mStrokeWidth, w - mStrokeWidth, mStrokeWidth + mRadius);
                mPath.arcTo(rectFRightTop, 0, -90);

                mPath.lineTo(mTriHeight + mStrokeWidth + mRadius, mStrokeWidth);
                rectFLeftTop = new RectF(mTriHeight + mStrokeWidth, mStrokeWidth, mTriHeight + mStrokeWidth + mRadius, mStrokeWidth + mRadius);
                mPath.arcTo(rectFLeftTop, -90, -90);

                mPath.lineTo(mTriHeight + mStrokeWidth, triCenterY - mTriWidth / 2);
                mPath.lineTo(mStrokeWidth, triCenterY);
                mPath.lineTo(mTriHeight + mStrokeWidth, triCenterY + mTriWidth / 2);
                mPath.lineTo(mTriHeight + mStrokeWidth, h - mStrokeWidth - mRadius);
                rectFLeftBottom = new RectF(mTriHeight + mStrokeWidth, h - mStrokeWidth - mRadius, mTriHeight + mStrokeWidth + mRadius, h - mStrokeWidth);
                mPath.arcTo(rectFLeftBottom, -180, -90);
                mPath.lineTo(w - mStrokeWidth - mRadius, h - mStrokeWidth);
                rectFRightBottom = new RectF(w - mStrokeWidth - mRadius, h - mRadius - mStrokeWidth, w - mStrokeWidth, h - mStrokeWidth);
                mPath.arcTo(rectFRightBottom, -270, -90);
                mPath.lineTo(w - mStrokeWidth, mStrokeWidth + mRadius);
                break;
            //上
            case TOP:
                mPath.moveTo(w - mStrokeWidth, mTriHeight + mStrokeWidth + mRadius);
                rectFRightTop = new RectF(w - mStrokeWidth - mRadius, mTriHeight + mStrokeWidth, w - mStrokeWidth, mTriHeight + mStrokeWidth + mRadius);
                mPath.arcTo(rectFRightTop, 0, -90);
                mPath.lineTo(triCenterX + mTriWidth / 2, mTriHeight + mStrokeWidth);
                mPath.lineTo(triCenterX, mStrokeWidth);
                mPath.lineTo(triCenterX - mTriWidth / 2, mTriHeight + mStrokeWidth);
                mPath.lineTo(mStrokeWidth + mRadius, mTriHeight + mStrokeWidth);

                rectFLeftTop = new RectF(mStrokeWidth, mTriHeight + mStrokeWidth, mStrokeWidth + mRadius, mTriHeight + mStrokeWidth + mRadius);
                mPath.arcTo(rectFLeftTop, -90, -90);
                mPath.lineTo(mStrokeWidth, h - mStrokeWidth - mRadius);

                rectFLeftBottom = new RectF(mStrokeWidth, h - mStrokeWidth - mRadius, mStrokeWidth + mRadius, h - mStrokeWidth);
                mPath.arcTo(rectFLeftBottom, -180, -90);
                mPath.lineTo(w - mStrokeWidth - mRadius, h - mStrokeWidth);

                rectFRightBottom = new RectF(w - mStrokeWidth - mRadius, h - mRadius - mStrokeWidth, w - mStrokeWidth, h - mStrokeWidth);
                mPath.arcTo(rectFRightBottom, -270, -90);
                mPath.lineTo(w - mStrokeWidth, mTriHeight + mStrokeWidth + mRadius);
                break;
            //右
            case RIGHT:
                mPath.moveTo(w - mStrokeWidth - mTriHeight, mStrokeWidth + mRadius);
                rectFRightTop = new RectF(w - mStrokeWidth - mRadius - mTriHeight, mStrokeWidth, w - mStrokeWidth - mTriHeight, mStrokeWidth + mRadius);
                mPath.arcTo(rectFRightTop, 0, -90);
                mPath.lineTo(mStrokeWidth + mRadius, mStrokeWidth);

                rectFLeftTop = new RectF(mStrokeWidth, mStrokeWidth, mStrokeWidth + mRadius, mStrokeWidth + mRadius);
                mPath.arcTo(rectFLeftTop, -90, -90);
                mPath.lineTo(mStrokeWidth, h - mStrokeWidth - mRadius);

                rectFLeftBottom = new RectF(mStrokeWidth, h - mStrokeWidth - mRadius, mStrokeWidth + mRadius, h - mStrokeWidth);
                mPath.arcTo(rectFLeftBottom, -180, -90);
                mPath.lineTo(w - mStrokeWidth - mTriHeight - mRadius, h - mStrokeWidth);

                rectFRightBottom = new RectF(w - mStrokeWidth - mRadius - mTriHeight, h - mRadius - mStrokeWidth, w - mStrokeWidth - mTriHeight, h - mStrokeWidth);
                mPath.arcTo(rectFRightBottom, -270, -90);
                mPath.lineTo(w - mStrokeWidth - mTriHeight, triCenterY + mTriWidth / 2);
                mPath.lineTo(w - mStrokeWidth, triCenterY);
                mPath.lineTo(w - mStrokeWidth - mTriHeight, triCenterY - mTriWidth / 2);
                mPath.lineTo(w - mStrokeWidth - mTriHeight, mStrokeWidth + mRadius);
                break;
            //下
            case Bottom:
                mPath.moveTo(w - mStrokeWidth, mStrokeWidth + mRadius);
                rectFRightTop = new RectF(w - mStrokeWidth - mRadius, mStrokeWidth, w - mStrokeWidth, mStrokeWidth + mRadius);
                mPath.arcTo(rectFRightTop, 0, -90);
                mPath.lineTo(mStrokeWidth, mStrokeWidth);

                rectFLeftTop = new RectF(mStrokeWidth, mStrokeWidth, mStrokeWidth + mRadius, mStrokeWidth + mRadius);
                mPath.arcTo(rectFLeftTop, -90, -90);
                mPath.lineTo(mStrokeWidth, h - mStrokeWidth - mRadius - mTriHeight);

                rectFLeftBottom = new RectF(mStrokeWidth, h - mStrokeWidth - mRadius - mTriHeight, mStrokeWidth + mRadius, h - mStrokeWidth - mTriHeight);
                mPath.arcTo(rectFLeftBottom, -180, -90);
                mPath.lineTo(triCenterX - mTriWidth / 2, h - mStrokeWidth - mTriHeight);
                mPath.lineTo(triCenterX, h - mStrokeWidth);
                mPath.lineTo(triCenterX + mTriWidth / 2, h - mStrokeWidth - mTriHeight);
                mPath.lineTo(w - mStrokeWidth - mRadius, h - mTriHeight - mStrokeWidth);

                rectFRightBottom = new RectF(w - mStrokeWidth - mRadius, h - mRadius - mStrokeWidth - mTriHeight, w - mStrokeWidth, h - mStrokeWidth - mTriHeight);
                mPath.arcTo(rectFRightBottom, -270, -90);
                mPath.lineTo(w - mStrokeWidth, mStrokeWidth + mRadius);
                break;
        }
        mPath.close();
    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPath(getMeasuredWidth(), getMeasuredHeight());
        canvas.drawPath(mPath, mBgPaint);
        canvas.drawPath(mPath, mStrokePaint);
    }

    /**
     * 调整Padding
     */
    private void resizePadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (mOrientation) {

            case LEFT:
                setPadding(paddingLeft + mTriHeight, paddingTop, paddingRight, paddingBottom);
                break;

            case TOP:
                setPadding(paddingLeft, paddingTop + mTriHeight, paddingRight, paddingBottom);
                break;

            case RIGHT:
                setPadding(paddingLeft, paddingTop, paddingRight + mTriHeight, paddingBottom);
                break;

            case Bottom:
                setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom + mTriHeight);
                break;

        }
    }

    private int getTriCenter(int WH) {
        if (mTriPositionVal <= 0 || mTriPositionVal >= WH) {
            return (int) (mTriPositionPct * WH);
        } else {
            return (int) mTriPositionVal;
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        resizePadding();
    }

    private void redraw() {
        initPaint();
        invalidate();
    }
}
