package com.example.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private CircleProgressBar cpb;
    private Button btn;
    private int a = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        cpb = (CircleProgressBar) findViewById(R.id.cpb);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                if (a == 100) {
                    downLoad();
                    Log.e(TAG, "onClick: " + "0000000");
                } else if (a == 1000) {
                    downLoad();
                }
                break;
        }
    }

    private void downLoad() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 101; i++) {
                    a = i;
                    cpb.setProgress(i);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}