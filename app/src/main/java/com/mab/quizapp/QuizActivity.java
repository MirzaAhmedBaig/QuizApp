package com.mab.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private String TAG = "QuizActivity";
    private Button nextButton;
    private RadioGroup radioGroup;
    private TextView questionTitle, question;
    private ArrayList<QuizDataModel> quizData;
    private RadioButton firstChoice, secondChoice, thirdChoice, fourthChoice;
    private int currentQuestionIndex = 0;
    private int[] selectedAnswers = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        setIds();
        setListener();
        getDataAndRandomize();
        setNextQuestion();

    }

    private void setIds() {
        nextButton = findViewById(R.id.next_button);
        questionTitle = findViewById(R.id.title);
        question = findViewById(R.id.question);
        firstChoice = findViewById(R.id.first_choice);
        secondChoice = findViewById(R.id.second_choice);
        thirdChoice = findViewById(R.id.third_choice);
        fourthChoice = findViewById(R.id.fourth_choice);
        radioGroup = findViewById(R.id.radioGroup);
    }

    private void getDataAndRandomize() {
        quizData = new ArrayList<>();
        String addedIndexString = "";
        Random ran = new Random();
        ArrayList<QuizDataModel> temp = new QuizData().getAllData();
        int randomIndex = ran.nextInt(10);
        Log.d(TAG, "Random Index = " + randomIndex);
        for (int i = 0; i < temp.size(); i++) {
            quizData.add(temp.get(randomIndex));
            addedIndexString += "" + randomIndex;
            Log.d(TAG, "Added String : " + addedIndexString);
            do {
                randomIndex = ran.nextInt(10);
                Log.d(TAG, "Random Index = " + randomIndex);
            } while (addedIndexString.contains(randomIndex + "") && addedIndexString.length() < 10);
        }
        Log.d(TAG, "Array Size " + quizData.size());
    }

    private void setListener() {
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QuizActivity.this, "Please select a choise", Toast.LENGTH_SHORT).show();
                    return;
                }
                setNextQuestion();
                radioGroup.clearCheck();
            }
        });

        firstChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswers[currentQuestionIndex - 1] = 1;
            }
        });

        secondChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswers[currentQuestionIndex - 1] = 2;
            }
        });

        thirdChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswers[currentQuestionIndex - 1] = 3;
            }
        });

        fourthChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswers[currentQuestionIndex - 1] = 4;
            }
        });
    }

    private void setNextQuestion() {
        if (currentQuestionIndex == 10) {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("name", getIntent().getStringExtra("name"));
            intent.putExtra("selected", selectedAnswers);
            intent.putExtra("score", getTotalScore());
            startActivity(intent);
        } else {
            questionTitle.setText("Question Number " + (currentQuestionIndex + 1));
            question.setText(quizData.get(currentQuestionIndex).getQuestion());
            String[] choices = quizData.get(currentQuestionIndex).getChoices();
            firstChoice.setText(choices[0]);
            secondChoice.setText(choices[1]);
            thirdChoice.setText(choices[2]);
            fourthChoice.setText(choices[3]);
            currentQuestionIndex++;
        }
    }

    private int getTotalScore() {
        int score = 0;
        for (int i = 0; i < quizData.size(); i++) {
            if (quizData.get(i).getAnswer() == selectedAnswers[i]) {
                score++;
            }
        }
        return score;
    }
}
