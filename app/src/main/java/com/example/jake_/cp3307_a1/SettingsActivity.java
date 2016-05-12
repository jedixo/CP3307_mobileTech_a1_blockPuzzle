package com.example.jake_.cp3307_a1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    private PictureSingletonStorageClass pictureSingletonStorageClass = PictureSingletonStorageClass.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pictureSingletonStorageClass.clearBitmaps();
    }

    public void DonePressed(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
