package com.example.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * 项目名称：View
 * 作者：Yamy
 * 创建时间：2020/6/4   14:32
 **/
public class CustomView extends View {

    private final Paint paint;
    private final Paint paint1;
    private final Bitmap bitmap;
    private final Path path;
    private final RectF rectF;

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.parseColor("#0943ED"));
        paint.setStrokeWidth(20);//线宽
        paint1 = new Paint();
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setColor(Color.parseColor("#09ED1B"));
        paint1.setStrokeWidth(10);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.g);
        //多边形
        path = new Path();
        int x1=50;
        int y1=50;
        int x2=700;
        int y2=100;
        int x3=500;
        int y3=800;
        //第一个点
        path.moveTo(x1,y1);
        //从第一个点移到第二个点
        path.lineTo(x2,y2);
        path.lineTo(x3,y3);
        path.lineTo(x1,y1);

        rectF = new RectF(50, 50, 700, 700);
    }
//一般不在生命周期里创建对象，这些方法可能被多次调用
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画线
//        canvas.drawLine(50,50,450,800,paint);
        //画圆(cx,cy圆心  radius半径)
//        canvas.drawCircle(450,450,100,paint);
        //画空心圆(cx,cy圆心  radius半径)
//        canvas.drawCircle(600,600,100,paint1);
        //画图片
//        canvas.drawBitmap(bitmap,250,250,paint);
        //画三角形
//        canvas.drawPath(path,paint);
        //裁剪
//        canvas.clipPath(path);
        //画椭圆
//        canvas.drawOval(150,150,800,500,paint1);
        //画扇型
        canvas.drawArc(rectF,0,80,true,paint1);
    }
}
