package com.example.a411hw3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a411hw3.model.Student;
import com.example.a411hw3.model.Student_DB;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout root;
    Student_DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new Student_DB(this);

        setContentView(R.layout.student_list);
        root = findViewById(R.id.student_list);

        ArrayList<Student> studentList = db.getStudentList();
        for(int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);

            LayoutInflater inflater = LayoutInflater.from(this);
            View row_view = inflater.inflate(R.layout.student_row, root, false);

            ((TextView) row_view.findViewById(R.id.first_name)).setText(s.getFName());
            ((TextView) row_view.findViewById(R.id.last_name)).setText(s.getLName());
            root.addView(row_view);
        }
    }

}
