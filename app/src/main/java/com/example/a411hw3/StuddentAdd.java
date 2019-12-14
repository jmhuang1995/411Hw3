package com.example.a411hw3;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a411hw3.model.Course_Enroll;
import com.example.a411hw3.model.Student;
import com.example.a411hw3.model.Student_DB;

import java.util.ArrayList;
import java.util.List;

public class StuddentAdd extends AppCompatActivity {

    Student_DB database;

    EditText fname;
    EditText lname;
    EditText cwid;
    EditText course;
    EditText Grade;
    List<String[]> courses;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = new Student_DB(this);

        setContentView(R.layout.student_add);

        fname = findViewById(R.id.add_fname_id);
        lname = findViewById(R.id.add_lname_id);
        cwid = findViewById(R.id.add_cwid_id);
        course = findViewById(R.id.add_course_name);
        Grade = findViewById(R.id.add_course_grade);
        courses = new ArrayList<String[]>();

        Button addC = findViewById(R.id.add_course_btn);
        addC.setOnClickListener(new View.OnClickListener() {
            int r = 0;

            @Override
            public void onClick(View v) {
                if (course.getText().toString() != "" && Grade.getText().toString() != "") {
                    courses.add(new String[]{course.getText().toString(), Grade.getText().toString()});
                    Toast.makeText(getApplicationContext(), course.getText().toString() + " and " + Grade.getText().toString() + " added", Toast.LENGTH_LONG).show();
                    course.setText("");
                    Grade.setText("");
                    r++;
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid entry", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        menu.findItem(R.id.action_submit).setVisible(true);
        menu.findItem(R.id.action_add).setVisible(false);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_submit) {
            ArrayList<Student> studentList = new ArrayList<Student>();
            ArrayList<Course_Enroll> courseList = new ArrayList<>();
            Student tempStu = new Student(fname.getText().toString(), lname.getText().toString(), cwid.getText().toString());
            for (String[] course : courses) {
                courseList.add(new Course_Enroll(course[0], course[1]));
            }
            tempStu.setCourses(courseList);
            studentList.add(tempStu);
            Student_DB.addToDB(studentList);

            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
