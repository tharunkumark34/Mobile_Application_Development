package com.example.miniproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import androidx.appcompat.app.AppCompatActivity;



public class suggestions extends AppCompatActivity {
    Button back, submit;
    EditText write,regno;

    DatabaseReference app_data;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);
        back = findViewById(R.id.back);
        submit = findViewById(R.id.submit);
        write = findViewById(R.id.suggestion);
        regno=findViewById(R.id.regno);

        app_data = FirebaseDatabase.getInstance().getReference().child("Data_collection");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back(view);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(regno.getText().toString()) || TextUtils.isEmpty(write.getText().toString())){
                    Toast.makeText(suggestions.this,"please write something",Toast.LENGTH_SHORT).show();
                }
                    else {
                        insertdata();
                    }
            }
        });
    }

    public void back(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public void insertdata(){
        String s_reg = regno.getText().toString();
        String s_write = write.getText().toString();

        Data_collection data_collection = new Data_collection(s_reg, s_write);
        app_data.push().setValue(data_collection);
        Toast.makeText(getApplicationContext(),"Thanks for the feedback!", Toast.LENGTH_SHORT).show();
    }
}
