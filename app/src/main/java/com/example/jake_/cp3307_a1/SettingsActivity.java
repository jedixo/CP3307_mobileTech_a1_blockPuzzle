package com.example.jake_.cp3307_a1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * settings activity controller
 */
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

    /**
     * done button callback
     *
     * @param view - the view
     */
    public void DonePressed(View view) {
        int selectedID = radioThemeGroup.getCheckedRadioButtonId();
        RadioButton radioThemeButton = (RadioButton) findViewById(selectedID);

        if (radioThemeButton != null) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("theme", radioThemeButton.getText());
            startActivity(intent);
        }
    }
}