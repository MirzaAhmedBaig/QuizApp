package com.mab.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private Button startQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setIds();
        setListeners();
    }

    private void setIds() {
        userName = findViewById(R.id.name);
        startQuiz = findViewById(R.id.start_quiz);
    }

    private void setListeners() {
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
    }

    private void startQuiz() {
        if (userName.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("name", userName.getText().toString());
        startActivity(intent);

    }
}
