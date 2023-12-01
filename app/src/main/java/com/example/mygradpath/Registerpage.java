package com.example.mygradpath;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class Registerpage extends AppCompatActivity {

    private Button signB;

    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);

        firebaseAuth = FirebaseAuth.getInstance();


        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);



        signB = findViewById(R.id.Btnsign);

        signB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                signB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText editTextName = findViewById(R.id.nameedi);
                        String namee = editTextName.getText().toString();

                        {
                            Intent intent = new Intent(Registerpage.this, FirstBasicP.class);
                            startActivity(intent);
                        }

                        if (!namee.isEmpty()) {
                            String message = "Hello, " + namee + "!"; // Customize the message as desired
                            Toast.makeText(Registerpage.this, message, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Registerpage.this, "Please Complete your information!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Registerpage.this, Registerpage.class);
                            startActivity(intent);
                        }
                    }
                });

            }



        });




    }
}