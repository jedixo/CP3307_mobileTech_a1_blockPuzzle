package com.example.jake_.cp3307_a1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
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