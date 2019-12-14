package com.example.a411hw3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a411hw3.adapter.ListAdatper;
import com.example.a411hw3.model.Student_DB;

public class Summary extends AppCompatActivity {

    protected ListView mSummaryView;
    protected ListAdatper ad;
    protected Menu Menu;
    Student_DB db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new Student_DB(this);

        setContentView(R.layout.student_list_lv);

        mSummaryView = findViewById(R.id.student_list_id);
        ad = new ListAdatper();
        mSummaryView.setAdapter(ad);

    }

    @Override
    protected void onStart() {
        ad.notifyDataSetChanged();
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_items, menu);
        menu.findItem(R.id.action_add).setVisible(true);
        menu.findItem(R.id.action_submit).setVisible(false);
        Menu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            Intent intent = new Intent(this, StuddentAdd.class);
            startActivity(intent);

            item.setVisible(false);
        } else if (item.getItemId() == R.id.action_submit) {

            Intent intent = new Intent(getBaseContext(), Summary.class);
            startActivity(intent);
            item.setVisible(false);
            Menu.findItem(R.id.action_add).setVisible(true);



        }

        return super.onOptionsItemSelected(item);
    }
}
