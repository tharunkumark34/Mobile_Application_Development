package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button contact, calendar, clock, reminder;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  STS");



            contact = findViewById(R.id.about_us);
            calendar = findViewById(R.id.calendar);
            clock = findViewById(R.id.clock);
            reminder = findViewById(R.id.reminder);

            reminder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent d = new Intent(MainActivity.this, reminder.class);
                    startActivity(d);
                }
            });

            calendar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    calendar(view);
                }
            });

            clock.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clock(view);
                }
            });

            contact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    contact(view);
                }
            });
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (@NonNull MenuItem item){
            String msg = " ";
            switch (item.getItemId()) {
                case R.id.settings:
                    msg = "settings";
                    Toast.makeText(this, msg + " checked", Toast.LENGTH_LONG).show();
                    break;
                case R.id.help:
                    suggestions();
                    break;
            }
            return super.onOptionsItemSelected(item);
        }
        public void remind (View view){
            Intent j = new Intent(getApplicationContext(), com.example.miniproject.reminder.class);
            startActivityForResult(j, 5);
        }
        public void clock (View view){
            Intent i = new Intent(getApplicationContext(), clock.class);
            startActivityForResult(i, 1);
        }

        public void calendar (View view){
            Intent i = new Intent(getApplicationContext(), calendar.class);
            startActivityForResult(i, 2);
        }

        public void contact (View view){
            Intent i = new Intent(getApplicationContext(), contact.class);
            startActivityForResult(i, 3);
        }

        public void suggestions () {
            Intent i = new Intent(getApplicationContext(), suggestions.class);
            startActivityForResult(i, 4);


        }
    }