package com.example.gualbertoscolari.grupp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class CreateCategoryActivity extends AppCompatActivity {

    private String category = "";
    EditText cat;
    String a = "Choose your category";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_category);

    }

    public void goToGameSettings(View v){
        Intent gameSettings = new Intent(this, GameSettingsActivity.class);
        startActivity(gameSettings);
    }

    public void addCategory(View v){
        // Calls the addCategory method in the CreateAndDelete class
        // and uses DBHelper to add the category
        cat = (EditText) findViewById(R.id.categorie_name);
        //cat = getString(R.string.category_name);
        //DbHelper.addCategory(cat.toString());



    }

    public String getCategory() {
        return category;
    }
}
