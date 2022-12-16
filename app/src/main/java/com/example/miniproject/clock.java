package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;



public class clock extends AppCompatActivity {
    Button back;
    TimePicker t;
    TextView tv;
    Button b;
    double ans;
    int h,m;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        back = findViewById(R.id.back);

        t=findViewById(R.id.t);
        tv=findViewById(R.id.tv2);
        b=findViewById(R.id.sub);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour = t.getCurrentHour();
                int min = t.getCurrentMinute();
                if(hour>=13){
                    hour=hour-12;
                }
                if(hour == 12 && min == 0){
                    ans = 0;
                    String res = String.valueOf(ans);
                    tv.setText(res);
                    return;
                }
                if((30*hour)>(5.5*min)){
                    ans = (30*hour)-(5.5*min);
                }else{
                    ans = (5.5*min)-(30*hour);
                }

                String res = String.valueOf(ans);
                tv.setText(res);

            }});

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back(view);
            }
        });
    }

    public void back(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}