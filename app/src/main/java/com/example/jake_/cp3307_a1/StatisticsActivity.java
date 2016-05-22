package com.example.jake_.cp3307_a1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class StatisticsActivity extends AppCompatActivity {

    private ListView listView;
    private TextView totalComplete;
    private TextView numberTouches;
    private TextView avgTouches;
    private DatabaseAccess database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        database = new DatabaseAccess(this);
        listView  = (ListView) findViewById(R.id.listView);
        totalComplete = (TextView) findViewById(R.id.totalPuzzles);
        numberTouches = (TextView) findViewById(R.id.totalTouches);
        avgTouches = (TextView) findViewById(R.id.averageTouches);

        Cursor cursor = database.getAllCursor();
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.item_view,
                cursor,
                new String[] {"_id", "touches"},
                new int[] {R.id.id, R.id.touches},
                0);
        listView.setAdapter(adapter);

        int totalPuzzlesCompleted = listView.getCount();
        int totalTouches = 0;
        while (cursor.moveToNext()) {
            totalTouches += cursor.getInt(1);
        }
        totalComplete.setText(String.format("%d", totalPuzzlesCompleted));
        numberTouches.setText(String.format("%d", totalTouches));
        if (totalPuzzlesCompleted > 0) {
            avgTouches.setText(String.format("%d", totalTouches / totalPuzzlesCompleted));
        }
    }

    public void back(View view) {
        finish();
    }

    public void clearDB(View view) {
        database.clearAll();
        finish();
    }
}