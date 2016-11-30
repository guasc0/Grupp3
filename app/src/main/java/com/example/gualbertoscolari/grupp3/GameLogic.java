package com.example.gualbertoscolari.grupp3;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

//Standard frågor profiler och kategorier ska skapas upp i Gamelogic vid anrop och skickar en lista
//med dessa till MainGameActivity och skriver ut dom.
//Klassen sköter logiken för varje spelrunda.
//En timer metod som sköter värdet på poängen och avslutar rundan.
//
public class GameLogic extends MainGameActivity {

    private DbHelper db;
    private String category;
    private List<Question> tenQuestions;

    public GameLogic(String category, Context context) {

        this.category = category;
        db = new DbHelper(context);
        tenQuestions = db.getAllQuestions(category);
        db.close();
    }


    public List<Question> getQuestions() {
        return tenQuestions;
    }

    public boolean checkCorrectAnswer(String option, String answer){

        if(option.endsWith(answer)){
            return true;
        } else {
            return false;
        }

    }

    public void shuffleOptions(String a, String b, String c, String d){


    }
}
