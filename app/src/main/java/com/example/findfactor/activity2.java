package com.example.findfactor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class activity2 extends AppCompatActivity {

    Button ans0, ans1, ans2;
    TextView timer, score, statement, result;
    ProgressBar progress;

    game g = new game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        Intent intent = getIntent();

        ans0 = findViewById(R.id.ans0);
        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);

        score = findViewById(R.id.score);
        result = findViewById(R.id.result);
        statement = findViewById(R.id.statement);
        timer = findViewById(R.id.timer);

        progress = findViewById(R.id.progress);

        timer.setText("0SEC");
        statement.setText("");
        score.setText("0pts");

        View.OnClickListener startButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked = (Button) v;

                int answerSelected = Integer.parseInt(buttonClicked.getText().toString());

                g.checkAnswer(answerSelected);

            }
        };

        ans0.setOnClickListener(answerButtonClickListener);
        ans1.setOnClickListener(answerButtonClickListener);
        ans2.setOnClickListener(answerButtonClickListener);


    }


    private void nextTurn() {

        g.makeNewQuestion();
        int [] answer = g.getCurrentQuestion().getOptions();

        ans0.setText(Integer.toString(answer[0]));
        ans1.setText(Integer.toString(answer[1]));
        ans2.setText(Integer.toString(answer[2]));

        ans0.setEnabled(true);
        ans1.setEnabled(true);
        ans2.setEnabled(true);

        statement.setText(g.getCurrentQuestion().getQuestionPhrase());

    }
}