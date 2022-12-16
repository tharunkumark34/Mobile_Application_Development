package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class contact extends AppCompatActivity {
    Button back;
    ImageView insta;
    ImageView twi;
    ImageView ll;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        back = findViewById(R.id.back);
        insta = findViewById(R.id.imageView13);
        ll = findViewById(R.id.imageView14);
        twi = findViewById(R.id.imageView15);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bak(view);
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/vitap.university/?hl=en"));
                startActivity(intent);
            }
        });

        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/vellore-institute-of-technology-andhra-pradesh-vit-ap-university/"));
                startActivity(intent);
            }
        });

        twi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/nothing"));
                startActivity(intent);
            }
        });
    }

    public void bak(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}