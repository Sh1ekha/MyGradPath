package com.example.mygradpath;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class Login_Sign extends AppCompatActivity {
    
    private Button back1;
    private Button btmtwo;

    private Button btmone;

    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign);
        
        back1 = findViewById(R.id.backbutton);
        btmtwo = findViewById(R.id.Bt2);
        btmone = findViewById(R.id.Bt1);

        firebaseAuth = FirebaseAuth.getInstance();


        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);


        btmone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextName = findViewById(R.id.editName);
                String namL = editTextName.getText().toString();

                {
                    Intent intent = new Intent(Login_Sign.this, FirstBasicP.class);
                    startActivity(intent);
                }

                if (!namL.isEmpty()) {
                    String message = "Hello!"; // Customize the message as desired
                    Toast.makeText(Login_Sign.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login_Sign.this, "Please Complete your information!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login_Sign.this, Login_Sign.class);
                    startActivity(intent);

                }
            }
        });





        TextView textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Sign.this, Forgotpass.class);
                startActivity(intent);
            }
        });

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Sign.this, LogPage.class);
                startActivity(intent);

            }
        });

        btmtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Sign.this, Registerpage.class);
                startActivity(intent);
            }
        });










        

      
        
        

    





    }
}