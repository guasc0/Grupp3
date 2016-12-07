package com.example.gualbertoscolari.grupp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
//Klassen är till för att skapa egna kategorier.
//Den tar emot en text sträng från användaren med valt kategori namn,
//och skickar in det till databasen.
//Metoden getCategory ska tas bort då vi hämtar kategorin från databasen.
//Toasters och if satser för felhantering.

public class CreateCategoryActivity extends AppCompatActivity {

    private EditText category;
    private String cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_category);
    }

    /**
     *
     * @param v takes the player back to game settings
     */
    public void goToGameSettings(View v){
        Intent gameSettings = new Intent(this, GameSettingsActivity.class);
        startActivity(gameSettings);
    }

    /**
     *
     * @param v  adds the input category if conditions are met.
     */
    public void addCategory(View v){
        DbHelper db = new DbHelper(getApplicationContext());
        category = (EditText) findViewById(R.id.categorie_name);
        cat = category.getText().toString();

        if(!cat.matches("^[a-zåäöA-ZÅÄÖ]{3,12}$")){
            Toast.makeText(this, "Max 12 letters", Toast.LENGTH_SHORT).show();
            category.setText("");
            category.setHint(this.getString(R.string.enter_category_name));

        } else if(!db.checkIfCatExists(cat)) {
            Toast.makeText(this, "Category already exists!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "You added a new category", Toast.LENGTH_SHORT).show();
            category.setText("");
            category.setHint(this.getString(R.string.enter_category_name));
            db.addCategorys(cat);
            db.addPlaceholderHSCategory(cat);
            db.close();
        }
    }

    /**
     *
     * @return returns category
     */
    public String getCategory() {
        return cat;
    }
}

