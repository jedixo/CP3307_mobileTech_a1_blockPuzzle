package com.example.jake_.cp3307_a1;

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
    private int[] drawablesPipes = {R.drawable.pipe1, R.drawable.pipe2, R.drawable.pipe3, R.drawable.pipe4, R.drawable.pipe5, R.drawable.pipe6};
    private int[] drawablesShapes = {R.drawable.shape1, R.drawable.shape2, R.drawable.shape3, R.drawable.shape4, R.drawable.shape5};
    private int[] drawablesPatterns = {R.drawable.patterns1, R.drawable.patterns2, R.drawable.patterns3, R.drawable.patterns4,
            R.drawable.patterns5, R.drawable.patterns6};

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


        Handler handler = new Handler();
        ImageViewController.setViews(imgViews);

        int length;
        int[] drawables;
        switch (SettingsSingleton.getTheme()) {
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void click(View view) {
        ImageViewController.reset();
    }

    public void nextImage(View view) {
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
            System.out.println("complete");
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

