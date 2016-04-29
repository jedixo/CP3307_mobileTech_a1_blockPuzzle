package com.example.jake_.cp3307_a1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean firstStart = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Picture pic = new Picture(getResources(),R.drawable.test);
        ImageView img = (ImageView) findViewById(R.id.topLeft);
        img.setImageBitmap(pic.getTopLeft());
        img = (ImageView) findViewById(R.id.topRight);
        img.setImageBitmap(pic.getTopRight());
        img = (ImageView) findViewById(R.id.bottomLeft);
        img.setImageBitmap(pic.getBottomLeft());
        img = (ImageView) findViewById(R.id.bottomRight);
        img.setImageBitmap(pic.getBottomRight());




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

}

