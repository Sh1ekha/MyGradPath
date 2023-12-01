package com.example.mygradpath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;


import android.view.View;
import android.widget.Toast;

public class FirstBasicP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_basicp);


        // Find the CardViews
        View coursesCard = findViewById(R.id.one);
        View scheduleCard = findViewById(R.id.two);
        View notesCard = findViewById(R.id.three);
        View filesCard = findViewById(R.id.four);

        // Set click listeners for each CardView
        coursesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToCoursesPage();
            }
        });

        scheduleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSchedulePage();
            }
        });

        notesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNotesPage();
            }
        });

        filesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFilesPage();
            }
        });
    }

    private void navigateToCoursesPage() {
        Intent intent = new Intent(this, CreatNote.class);
        startActivity(intent);
    }

    private void navigateToSchedulePage() {
        Intent intent = new Intent(this, Courses.class);
        startActivity(intent);
    }

    private void navigateToNotesPage() {
        Intent intent = new Intent(this, MyFiles.class);
        startActivity(intent);
    }

    private void navigateToFilesPage() {
        Intent intent = new Intent(this, Todolist.class);
        startActivity(intent);

    }
}