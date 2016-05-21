package com.example.jake_.cp3307_a1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private PictureWorker worker;
    private static DatabaseAccess database;

    private int[] drawablesPipes = {R.drawable.pipe1, R.drawable.pipe2, R.drawable.pipe3, R.drawable.pipe4, R.drawable.pipe5, R.drawable.pipe6};
    private int[] drawablesShapes = {R.drawable.shape1, R.drawable.shape2, R.drawable.shape3, R.drawable.shape4, R.drawable.shape5};
    private int[] drawablesPatterns = {R.drawable.patterns1, R.drawable.patterns2, R.drawable.patterns3, R.drawable.patterns4,
            R.drawable.patterns5, R.drawable.patterns6};

    private String theme;
    private int touches = 0;
    private int numCompleted = 0;


    public MainActivity() {
        worker = new PictureWorker(this);
        worker.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //pass this entire array into controller
        ImageView[] imgViews = {(ImageView) findViewById(R.id.preview), (ImageView) findViewById(R.id.topLeft),
                (ImageView) findViewById(R.id.topRight), (ImageView) findViewById(R.id.bottomLeft), (ImageView) findViewById(R.id.bottomRight)};

        database = new DatabaseAccess(this);


        Handler handler = new Handler();
        ImageViewController.setViews(imgViews);

        Bundle settingsData = getIntent().getExtras();
        if (settingsData != null) {
            theme = settingsData.getString("theme");
        }

        int length;
        int[] drawables;
        switch (theme) {
            case "pipes":
                length = drawablesPipes.length;
                drawables = drawablesPipes;
                break;
            case "shapes":
                length = drawablesShapes.length;
                drawables = drawablesShapes;
                break;
            default:
                length = drawablesPatterns.length;
                drawables = drawablesPatterns;
                break;
        }

        worker.totalImages = length;
        for (int drawable : drawables) {
            worker.loadResource(drawable, handler);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getTitle().equals("Statistics")) {
            database.addNewEntry(numCompleted, touches);
            Intent intent = new Intent(this, StatisticsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void Randomize(View view) {
        ImageViewController.reset();
    }

    public void nextImage(View view) {

        touches += 1;
        switch (view.getId()) {
            case R.id.topLeft:
                ImageViewController.nextImage(1);
                break;
            case R.id.topRight:
                ImageViewController.nextImage(2);
                break;
            case R.id.bottomLeft:
                ImageViewController.nextImage(3);
                break;
            case R.id.bottomRight:
                ImageViewController.nextImage(4);
                break;
        }

        if (ImageViewController.isComplete()) {
            //activate randomise button
            numCompleted += 1;
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        worker.quit();
        this.finish();
        Runtime.getRuntime().gc();
    }

}

