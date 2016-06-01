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

    private int[] images = {R.drawable.eg1, R.drawable.eg2, R.drawable.eg3};
    private String theme = "pipes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageViewController.clearBitmaps();

        radioThemeGroup = (RadioGroup) findViewById(R.id.radioTheme);

        changeBgImage(0);
    }

    /**
     * done button callback
     *
     * @param view - the view
     */
    public void DonePressed(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("theme", theme);
        startActivity(intent);
    }

    /**
     * radio button listener
     * sets the background and the theme variable
     *
     * @param view - the view
     */
    public void radButtonPressed(View view) {
        int selectedID = radioThemeGroup.getCheckedRadioButtonId();
        RadioButton radioThemeButton = (RadioButton) findViewById(selectedID);

        if (radioThemeButton != null) {

            if (radioThemeButton.getText().equals(theme = "pipes")) {
                changeBgImage(0);

            } else if (radioThemeButton.getText().equals(theme = "shapes")) {
                changeBgImage(1);

            } else {
                theme = "patterns";
                changeBgImage(2);
            }
        }
    }

    /**
     * changeBgImage - changes the activity background image
     *
     * @param image - the resource for the image
     */
    private void changeBgImage(int image) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundResource(images[image]);
    }
}