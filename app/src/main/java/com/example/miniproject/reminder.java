package com.example.miniproject;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.checkerframework.checker.units.qual.C;

import java.util.Calendar;

public class reminder extends AppCompatActivity {
    EditText e1, e2;
    TextView t1, t2;
    Button b1, b2, b3,back;
    TimePickerDialog tp,t;
    Calendar x,x1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        e1 = findViewById(R.id.r1);
        e2 = findViewById(R.id.r2);
        t1 = findViewById(R.id.rt1);
        t2 = findViewById(R.id.rt2);
        b1 = findViewById(R.id.rb1);
        b2 = findViewById(R.id.rb2);
        b3 = findViewById(R.id.set);
        back=findViewById(R.id.back);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager m = getSystemService(NotificationManager.class);
            m.createNotificationChannel(channel);
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = Calendar.getInstance();
                int hour = x.get(Calendar.HOUR_OF_DAY);
                int min = x.get(Calendar.MINUTE);
                 t =new TimePickerDialog(reminder.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        t1.setText(hourOfDay+":"+minute);
                    }
                },hour,min,false);
                t.show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x1 = Calendar.getInstance();
                int hour = x.get(Calendar.HOUR_OF_DAY);
                int min = x.get(Calendar.MINUTE);
                 tp =new TimePickerDialog(reminder.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        t2.setText(hourOfDay+":"+minute);
                    }
                },hour,min,false);
                tp.show();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back(v);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alarm_set(x.getTimeInMillis()+43000);
//                Alarm_set(x1.getTimeInMillis());
            }
        });
    }
    public void back(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
    public void Alarm_set(long ms){
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(this,Alarm.class);
        PendingIntent pi = PendingIntent.getBroadcast(this,0,i,0);
        am.setRepeating(AlarmManager.RTC_WAKEUP,ms,AlarmManager.INTERVAL_DAY,pi);
        Toast.makeText(this,"Reminder set",Toast.LENGTH_LONG).show();
    }

}