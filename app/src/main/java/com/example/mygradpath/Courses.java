package com.example.mygradpath;

import androidx.appcompat.app.AppCompatActivity;



import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Courses extends AppCompatActivity {

    private ArrayList<String> coursesList;
    private ArrayAdapter<String> coursesAdapter;
    private ListView listViewCourses;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);


        coursesList = new ArrayList<>();
        coursesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesList);
        listViewCourses = findViewById(R.id.listViewCourses);
        listViewCourses.setAdapter(coursesAdapter);

        listViewCourses.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Courses.this);
                builder.setTitle("Confirmation")
                        .setMessage("Are you sure you want to delete this course?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                coursesList.remove(position);
                                coursesAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
            }
        });
    }

    public void addCourse(View view) {
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextTime = findViewById(R.id.editTextTime);
        EditText editTextLocation = findViewById(R.id.editTextLocation);

        String courseName = editTextName.getText().toString();
        String courseTime = editTextTime.getText().toString();
        String courseLocation = editTextLocation.getText().toString();

        String courseDetails = "Subject: " + courseName + "\nTime: " + courseTime + "\nLocation: " + courseLocation;

        coursesList.add(courseDetails);
        coursesAdapter.notifyDataSetChanged();

        editTextName.setText("");
        editTextTime.setText("");
        editTextLocation.setText("");


    }
}