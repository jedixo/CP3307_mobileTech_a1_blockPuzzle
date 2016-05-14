package com.example.jake_.cp3307_a1;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private PictureWorker worker;

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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Handler handler = new Handler();

            ImageViewController.setImageViews(0,(ImageView) findViewById(R.id.preview));
            ImageViewController.setImageViews(1,(ImageView) findViewById(R.id.topLeft));
            ImageViewController.setImageViews(2,(ImageView) findViewById(R.id.topRight));
            ImageViewController.setImageViews(3,(ImageView) findViewById(R.id.bottomLeft));
            ImageViewController.setImageViews(4,(ImageView) findViewById(R.id.bottomRight));

            worker.loadResource(R.drawable.a1, handler);
            worker.loadResource(R.drawable.a2, handler);


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
        System.out.println("test");
        ImageViewController.randomiseImages();
    }

    public void nextImage(View view) {
        switch(view.getId()) {
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

