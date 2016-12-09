package com.example.gualbertoscolari.grupp3.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.gualbertoscolari.grupp3.R;
//Skriver ut info om utvecklarna och en företagslogga.
//Är klar men väntar på slutgiltiga designen.


public class AboutActivity extends AppCompatActivity {

    /**
     * This method is used called when user enters this activity
     * Sets the corresponding layout for this activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    /**
     * Creates an Intent and starts MenuActivity.
     * @param view     takes the player back to main menu.
     */
    public void back(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }



    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }
}