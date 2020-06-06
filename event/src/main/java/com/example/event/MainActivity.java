package com.example.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //分发事件的方法
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent: "+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }
    //处理事件的方法
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "dispatchTouchEvent: "+event.getAction());
        return super.onTouchEvent(event);
    }
}
