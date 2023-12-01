package com.example.mygradpath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ImageView welcome=findViewById(R.id.Logo);
        Thread thread= new Thread(){
            public void run(){
                try {
                    sleep(3000);
                    Intent nxtpg=new Intent(getApplicationContext(), LogPage.class);
                    startActivity(nxtpg);
                    finish();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        thread.start();
    }
}