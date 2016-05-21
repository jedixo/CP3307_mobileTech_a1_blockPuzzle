package com.example.jake_.cp3307_a1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class StatisticsActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        listView  = (ListView) findViewById(R.id.listView);
    }

    public void back(View view) {
        finish();
    }
}


/**Cursor cursor = database.getAllCursor();
 int count = cursor.getCount();

 System.out.println("entry: " + count);
 while (cursor.moveToNext()) {
 int id = cursor.getInt(0);
 int comp = cursor.getInt(1);
 int touch = cursor.getInt(2);
 System.out.println(String.format("%s %s %s", id, comp, touch));
 }
 cursor.close();*/