package com.example.zylaoshi.rulerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvDesc,tvDesc1;
    private RulerMoneyView rmView;
    private RulerDateView rdView;
    int select_money = 0;
    int select_date = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tvDesc = (TextView) findViewById(R.id.tv_desc);
        tvDesc1 = (TextView) findViewById(R.id.tv_desc1);
        rmView = (RulerMoneyView) findViewById(R.id.rulerView_money);
        rdView = (RulerDateView) findViewById(R.id.rulerView_Date);
        //设置金钱刻度尺的初始值
        rmView.setValue(500, 500, 20000, 100);
        select_money= (int) rmView.getSelectorValue();
        tvDesc.setText(select_money + "元");
        rmView.setOnValueChangeListener(new RulerMoneyView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                select_money = (int) value;
                tvDesc.setText(select_money + "元");
            }
        });
        //设置日期刻度尺的初始值
        rdView.setValue(7, 7, 40, 1);
        select_date = (int) rdView.getSelectorValue();
        tvDesc1.setText(select_date + "天");
        rdView.setOnValueChangeListener(new RulerDateView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                select_date = (int) value;
                tvDesc1.setText(select_date + "天");
            }
        });

    }

}
