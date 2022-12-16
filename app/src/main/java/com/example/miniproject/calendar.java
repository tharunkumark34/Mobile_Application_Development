package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calendar extends AppCompatActivity {
    Button back;
    EditText day, month, year;
    TextView ans;
    Button calculate;
    int monthcode=0, yearcode=0, yearlasttwo, y1, result;
    int d, y, m;
    String d1, m1, y_1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        back = findViewById(R.id.back);
        day = findViewById(R.id.day);
        month = findViewById(R.id.month);
        year = findViewById(R.id.year);
        ans = findViewById(R.id.ans);
        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d1 = day.getText().toString();
                m1 = month.getText().toString();
                y_1 = year.getText().toString();

                d = Integer.parseInt(d1);
                m = Integer.parseInt(m1);
                y = Integer.parseInt(y_1);


                if ((m == 1) || (m == 10)) {
                    monthcode = 0;
                } else if ((m == 2) || (m == 3) || (m == 11)) {
                    monthcode = 3;
                } else if ((m == 4) || (m == 7)) {
                    monthcode = 6;
                } else if ((m == 5)) {
                    monthcode = 1;
                } else if ((m == 6)) {
                    monthcode = 4;
                } else if (m == 8) {
                    monthcode = 2;
                } else if ((m == 9) || (m == 12)) {
                    monthcode = 5;
                }


                y1 = y /100;


                if (y1 % 4 == 0) {
                    yearcode = 6;
                } else if (y1 % 4 == 1) {
                    yearcode = 4;
                } else if (y1 % 4 == 2) {
                    yearcode = 2;
                } else {
                    yearcode = 0;
                }

                yearlasttwo = y % 100;

                if((y/4)!=0){
                    result =( (yearlasttwo + (yearlasttwo / 4) + d + monthcode + yearcode) % 7);
                }else{
                    result =(((yearlasttwo + (yearlasttwo / 4) + d + monthcode + yearcode) % 7))+1;
                }
                if (result == 0) {
                    ans.setText("SUNDAY");
                } else if (result == 1) {
                    ans.setText("MONDAY");
                } else if (result == 2) {
                    ans.setText("TUESDAY");
                } else if (result == 3) {
                    ans.setText("WEDNESDAY");
                } else if (result == 4) {
                    ans.setText("THURSDAY");
                } else if (result == 5) {
                    ans.setText("FRIDAY");
                } else {
                    ans.setText("SATURDAY");
                }


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back(view);
            }
        });

    }

    public void back(View view){
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}