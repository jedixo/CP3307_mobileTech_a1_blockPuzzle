package com.example.jake_.cp3307_a1;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity {

    private RadioGroup radioThemeGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageViewController.clearBitmaps();

        radioThemeGroup = (RadioGroup) findViewById(R.id.radioTheme);
    }


    public void DonePressed(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        int selectedID = radioThemeGroup.getCheckedRadioButtonId();
        RadioButton radioThemeButton = (RadioButton) findViewById(selectedID);
        intent.putExtra("theme",radioThemeButton.getText());
        startActivity(intent);
    }

}