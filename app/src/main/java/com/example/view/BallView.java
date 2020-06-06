package com.example.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.icu.text.MessagePattern;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 项目名称：View
 * 作者：Yamy
 * 创建时间：2020/6/4   15:54
 **/
public class BallView extends View {

    private final Bitmap bitmap;
    private final Paint paint;
    private float x;
    private float y;

    public BallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, x, y, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        invalidate();
        return true;
    }
}
