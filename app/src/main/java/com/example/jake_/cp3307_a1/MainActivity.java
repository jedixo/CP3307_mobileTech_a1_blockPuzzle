package com.example.jake_.cp3307_a1;

import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
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

        try {
            ImageView img = (ImageView) findViewById(R.id.topLeft);
            worker.loadResource(img, 1, R.drawable.test, handler);
            img = (ImageView) findViewById(R.id.topRight);
            worker.loadResource(img, 2, R.drawable.test, handler);
            img = (ImageView) findViewById(R.id.bottomLeft);
            worker.loadResource(img, 3, R.drawable.test, handler);
            img = (ImageView) findViewById(R.id.bottomRight);
            worker.loadResource(img, 4, R.drawable.test, handler);
        } catch (Exception e) {
            Log.e("MainActivity", e.toString());
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
        System.out.println("test");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        this.finish();
        Runtime.getRuntime().gc();
    }

}

