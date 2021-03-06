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
    private boolean isCheck = false;

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
                if (isCheck = false) {
                    downLoad();
                }
                break;
        }
    }

    private void downLoad() {
        isCheck = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 101; i++) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cpb.setProgress(i);
                    if (i == 100) {
                        isCheck = false;
                    }
                }
            }
        }).start();
    }
}