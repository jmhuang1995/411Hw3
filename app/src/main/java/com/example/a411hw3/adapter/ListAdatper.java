package com.example.a411hw3.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a411hw3.R;
import com.example.a411hw3.StudentInfo;
import com.example.a411hw3.model.Student;
import com.example.a411hw3.model.Student_DB;

public class ListAdatper extends BaseAdapter {

    @Override
    public int getCount() {
        return Student_DB.getStudentList().size();
    }

    @Override
    public Object getItem(int i) {
        return Student_DB.getStudentList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.student_row, viewGroup, false);
        } else row_view = view;

        final Student s = Student_DB.getStudentList().get(i);

        ((TextView) row_view.findViewById(R.id.first_name)).setText(s.getFName());
        ((TextView) row_view.findViewById(R.id.last_name)).setText(s.getLName());
        row_view.setTag((new Integer(i)));

        row_view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Toast.makeText(v.getContext(), "User Selected " + s.getFName(), Toast.LENGTH_SHORT).show();

                        // Nav
                        Intent intent = new Intent(v.getContext(), StudentInfo.class);
                        intent.putExtra("StudentIndex", ((Integer)v.getTag()).intValue());
                        v.getContext().startActivity(intent);
                    }
                }
        );
        return row_view;
    }
}
