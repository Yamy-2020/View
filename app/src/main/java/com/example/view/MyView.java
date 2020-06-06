package com.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import static android.content.ContentValues.TAG;

/**
 * 项目名称：View
 * 作者：Yamy
 * 创建时间：2020/6/4   10:19
 **/
public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    //measure()方法不能复写，final方法
    //final，private方法不能复写
    //这个方法在measure()内部调用，实际是完成测量的方法
    //绘制的流程，有可能会调用多次
//    MeasureSpec类
//    Android系统给我们提供了一个设计小而强的工具类——— MeasureSpec类
//      1、MeasureSpec描述了父View对子View大小的期望。里面包含了测量模式和大小。
//      2、MeasureSpec类把测量模式和大小组合到一个32位的int型的数值中，其中高2位表示模式，低30位表示大小而在计算中使用位运算的原因是为了提高并优化效率。
//      3、我们可以通过以下方式从MeasureSpec中提取模式和大小，该方法内部是采用位移计算。
//    也可以通过MeasureSpec的静态方法把大小和模式合成，该方法内部只是简单的相加。
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        Log.e(TAG, "mode: "+mode+",size:"+size);
        //mode: 1073741824,size:900
        //屏幕适配计算公式：px=dp值*dpi/160
    }

    //决定view的摆放位置
    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
    }
    //draw：绘制，view长啥样
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

    }
}
