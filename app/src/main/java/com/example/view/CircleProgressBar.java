package com.example.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 项目名称：View
 * 作者：Yamy
 * 创建时间：2020/6/5   9:37
 **/
public class CircleProgressBar extends View {
    private static final String TAG = "CircleProgressBar";
    private int color;
    private int color1;
    private int color2;
    private float dimension;
    private float dimension1;
    private float aFloat;
    private float aFloat1;
    private String string;
    private RectF rectF;
    private Paint paint;
    private int cx;
    private int cy;
    private int radius;
    private Paint circlePaint;
    private Paint textpaint;
    private float dy;

    public CircleProgressBar(Context context) {
        super(context);
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressBar);
        if (array != null) {
            color = array.getColor(R.styleable.CircleProgressBar_circleColor, 0);
            color1 = array.getColor(R.styleable.CircleProgressBar_ringColor, 0);
            color2 = array.getColor(R.styleable.CircleProgressBar_android_textColor, 0);
            dimension = array.getDimension(R.styleable.CircleProgressBar_ringWidth, 20);
            dimension1 = array.getDimension(R.styleable.CircleProgressBar_android_textSize, 30);
            aFloat = array.getFloat(R.styleable.CircleProgressBar_startAngle, -90);
            aFloat1 = array.getFloat(R.styleable.CircleProgressBar_sweepAngle, 0);
            string = array.getString(R.styleable.CircleProgressBar_android_text);
            Log.e(TAG, "CircleProgressBar: " + string);
            //回收
            array.recycle();
        }
        //不能写死，应该由控件长宽决定
//        rectF = new RectF(50, 50, 800, 800);
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(color1);
        paint.setStrokeWidth(dimension);
        paint.setAntiAlias(true);//去锯齿

        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);

        textpaint = new Paint();
        textpaint.setColor(color2);
        textpaint.setTextSize(dimension1);
        textpaint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = textpaint.getFontMetrics();
        float height = fontMetrics.descent - fontMetrics.ascent;
        dy = 0.5f * height - fontMetrics.descent;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //控件是正方形的，用户可能设置的宽高不一样
        //我们使用用户设置的最大宽高
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int size1 = MeasureSpec.getSize(heightMeasureSpec);
        //最新的宽高
        int max = Math.max(size, size1);
        //重新生成的期望
        int i = MeasureSpec.makeMeasureSpec(max, MeasureSpec.EXACTLY);//精确模式
        super.onMeasure(i, i);
        rectF = new RectF(0.1f * max, 0.1f * max, 0.9f * max, 0.9f * max);
        cx = max / 2;
        cy = max / 2;
        radius = max / 4;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制环
        canvas.drawArc(rectF, aFloat, aFloat1, false, paint);
        canvas.drawCircle(cx, cy, radius, circlePaint);
        canvas.drawText(string, cx, cy + dy, textpaint);
    }

    public void setProgress(int progress) {
        string = progress + " %";
        aFloat1 = 360 * 1.0f / 100 * progress;
//        invalidate();
        postInvalidate();
    }
}
