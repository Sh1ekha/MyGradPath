package com.example.mygradpath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterName extends AppCompatActivity {

    private Button back2;
    private Button Contin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entername);

        back2 = findViewById(R.id.backbutton2);
        Contin = findViewById(R.id.conti);


        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnterName.this, LogPage.class);
                startActivity(intent);

            }
        });


        Contin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextName = findViewById(R.id.editTextText);
                String name = editTextName.getText().toString();

                {
                    Intent intent = new Intent(EnterName.this, FirstBasicP.class);
                    startActivity(intent);
                }

                if (!name.isEmpty()) {
                    String message = "Hello, " + name + "!"; // Customize the message as desired
                    Toast.makeText(EnterName.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EnterName.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnterName.this, EnterName.class);
                    startActivity(intent);
                }
            }
        });
    }
}