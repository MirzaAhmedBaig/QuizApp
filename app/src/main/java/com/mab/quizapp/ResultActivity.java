package com.mab.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView name, score, correctAnswers;
    private Button goHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        setIds();
        setResult();
    }

    private void setIds() {
        name = findViewById(R.id.name);
        score = findViewById(R.id.score);
        correctAnswers = findViewById(R.id.correct_answers);
        goHome = findViewById(R.id.restart);

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoHome();
            }
        });
    }

    private void setResult() {
        name.setText(getIntent().getStringExtra("name"));
        int percent = getIntent().getIntExtra("score", 0) * 10;
        score.setText(percent + "%");
        correctAnswers.setText("" + getIntent().getIntExtra("score", 0));
    }

    private void gotoHome() {
        startActivity(new Intent(this, MainActivity.class));
        finishAffinity();
    }
}
