package com.example.mygradpath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogPage extends AppCompatActivity {


    private Button loginButton;
    private Button skpButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logpage);

        loginButton = findViewById(R.id.Log);
        skpButton = findViewById(R.id.skp);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform login logic here
                // For demonstration purposes, let's just display a toast message
                Intent intent = new Intent(LogPage.this, Login_Sign.class);
                startActivity(intent);
            }
        });

        skpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Continue without login logic here
                // For demonstration purposes, let's start a new activity
                Intent intent = new Intent(LogPage.this, EnterName.class);
                startActivity(intent);
            }
        });




    }
}