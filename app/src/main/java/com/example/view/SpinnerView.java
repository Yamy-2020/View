package com.example.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * 项目名称：View
 * 作者：Yamy
 * 创建时间：2020/6/4   9:46
 **/
public class SpinnerView extends RelativeLayout {

    private EditText et;
    private ImageView iv;
    private PopupWindow popupWindow;
    private ArrayList<String> list;

    public SpinnerView(Context context) {
        super(context);
    }
    //俩个参数的构造必须有
    //attrs 所有属性封装之后的对象
    public SpinnerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //添加控件
        View view = LayoutInflater.from(context).inflate(R.layout.spinner_view, null);
        addView(view);
        et = view.findViewById(R.id.et);
        iv = view.findViewById(R.id.iv);
        iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            list.add("小猪"+i);
        }
    }

    private void pop() {
//        if (popupWindow==null){
            ListView view = new ListView(getContext());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,list);
            view.setAdapter(adapter);
            popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, 500);
            popupWindow.setFocusable(true);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
//
//        popupWindow.showAtLocation(et, Gravity.BOTTOM,0,0);
            //在给定的控件下方
            popupWindow.showAsDropDown(et,0,0);
            view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String s=list.get(position);
                    et.setText(s);
                    //et光标移动到后面
                    et.setSelection(s.length());
                    popupWindow.dismiss();
                }
            });
//        }

    }
}
