package com.example.a411hw3;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a411hw3.model.Course_Enroll;
import com.example.a411hw3.model.Student;
import com.example.a411hw3.model.Student_DB;

import java.util.ArrayList;

public class StudentInfo extends AppCompatActivity {

    protected Student sObj;
    protected int studentIndex;
    protected Menu Menu;
    Student_DB DB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DB = new Student_DB(this);

        setContentView(R.layout.student_info);

        studentIndex = getIntent().getIntExtra("StudentIndex", 0);

        // Retrieve data
        sObj = Student_DB.getStudentList().get(studentIndex);

        // Display first name
        EditText editView = findViewById(R.id.p_fname_id);
        editView.setText(sObj.getFName());
        editView.setEnabled(false);

        // Display last name
        editView = findViewById(R.id.p_lname_id);
        editView.setText(sObj.getLName());
        editView.setEnabled(false);

        // Display CWID
        TextView textView = findViewById((R.id.p_cwid_id));
        textView.setText(sObj.getCwid().toString());
        textView.setEnabled(false);

        // Display List of Courses in detail screen
        ArrayList<Course_Enroll> courseList = sObj.getCourses();

        for(int i = 0; i < sObj.getCourses().size(); i++) {

            Course_Enroll ce = courseList.get(i);

            TextView tv = findViewById(R.id.p_course_name_id);
            tv.append(ce.getCourseId());
            tv.append("\n");
            tv.setEnabled(false);

            tv = findViewById(R.id.p_course_grade_id);
            tv.append(ce.getGrade());
            tv.append("\n");
            tv.setEnabled(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.findItem(R.id.action_edit).setVisible(true);
        menu.findItem(R.id.action_done).setVisible(false);
        Menu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Student upStu = new Student("", "", "");
        if (item.getItemId() == R.id.action_edit) {
            EditText editView = findViewById(R.id.p_fname_id);
            editView.setEnabled(true);
            editView = findViewById(R.id.p_lname_id);
            editView.setEnabled(true);

            item.setVisible(false);
            Menu.findItem(R.id.action_done).setVisible(true);
        } else if (item.getItemId() == R.id.action_done) {
            EditText editView = findViewById(R.id.p_fname_id);
            upStu.setFName(editView.getText().toString());
            editView.setEnabled(false);

            editView = findViewById(R.id.p_lname_id);
            upStu.setLName(editView.getText().toString());
            editView.setEnabled(false);

            editView = findViewById(R.id.p_cwid_id);
            upStu.setCwid(editView.getText().toString());

            item.setVisible(false);
            Menu.findItem(R.id.action_edit).setVisible(true);



            DB.updateDB(upStu);
        }

        return super.onOptionsItemSelected(item);
    }
}
