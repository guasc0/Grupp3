package com.example.gualbertoscolari.grupp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
//Metoden skall skapa upp ett gamelogic objekt som innehåller 10 frågor.
//Skall visa upp 1 fråga och 4 svar. Skall visa en timer från gamelogic.
//
public class MainGameActivity extends AppCompatActivity {

    GameLogic g1;

    List<Question> quesList;
    int score = 0;
    int qid = 0;

    Question currentQ;
    private TextView questiontv;
    private Button optABtn;
    private Button optBBtn;
    private Button optCBtn;
    private Button optDBtn;
    private String answer;


    private int numberOfAnsweredQ = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        DbHelper db = new DbHelper(this);  // my question bank class
        db.addStandardQuestionsSQL();
    }

    public void generateQuestion(){

        DbHelper db = new DbHelper(this);  // my question bank class

        quesList = db.getAllQuestions();  // this will fetch all quetonall questions
        currentQ = quesList.get(qid); // the current question

        questiontv = (TextView) findViewById(R.id.question_tv);
        optABtn = (Button) findViewById(R.id.answer_btn_a);
        optBBtn = (Button) findViewById(R.id.answer_btn_b);
        optCBtn = (Button) findViewById(R.id.answer_btn_c);
        optDBtn = (Button) findViewById(R.id.answer_btn_d);

        displayQuestion();

    }

    public void displayQuestion() {
        //Hämtar fråga från GameLogic och skriver ut den i TextView:n
        //och skriver ut svaren på knapparna.

        g1 = new GameLogic(lista med 10 frågor);


        questiontv.setText(g1.qList(numberOfAnsweredQ).getQUESTION());
        optABtn.setText(g1.qList(numberOfAnsweredQ).getOPTA());
        optBBtn.setText(g1.qList(numberOfAnsweredQ).getOPTB());
        optCBtn.setText(g1.qList(numberOfAnsweredQ).getOPTC());
        optDBtn.setText(g1.qList(numberOfAnsweredQ).getOPTD());
    }

    public void checkCorrectAnswer(String optString) {
        // Ska användas OnClick på alla knappar när användaren gissar.
        // Ska kolla om den intrykta knappens text är lika med frågans correctAnswer.

        answer = g1.qList(numberOfAnsweredQ).getAnswers();

        if (answer.equals(optString)) {
            //Ifall man svarar rätt händer detta

            questiontv.setText("Hurra du svarade rätt på den här frågan");
        } else {

            //Ifall man svarar fel händer detta
            questiontv.setText("Du svarade fel , du är dum");
        }

        if (numberOfAnsweredQ == 9) {

            //Du har svarat på alla frågor , du tas till resultskärmen.
            goToResult();
        }
    }

    public void goToResult() {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

    public void btn_a_pressed(View view) {
        checkCorrectAnswer(optABtn.getText().toString());
        numberOfAnsweredQ++;
    }

    public void btn_b_pressed(View view) {
        checkCorrectAnswer(optBBtn.getText().toString());
        numberOfAnsweredQ++;
    }

    public void btn_c_pressed(View view) {
        checkCorrectAnswer(optCBtn.getText().toString());
        numberOfAnsweredQ++;
    }

    public void btn_d_pressed(View view) {
        checkCorrectAnswer(optDBtn.getText().toString());
        numberOfAnsweredQ++;
    }
}