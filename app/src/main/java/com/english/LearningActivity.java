package com.english;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.english.questions.questionsForUnits;

public class LearningActivity extends questionsForUnits {
    TextView word, description, sentence, positionInt;
    Button prev, next;
    int position = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learning);
        word = findViewById(R.id.word);
        description = findViewById(R.id.synonym);
        sentence = findViewById(R.id.example);
        prev = findViewById(R.id.prevBtn);
        next = findViewById(R.id.nextBtn);
        positionInt = findViewById(R.id.position);



        prev.setEnabled(false);
        question();
        description.setText(correct.get(position));
        word.setText(Questions.get(position));
        sentence.setText(example.get(position));
        positionInt.setText("Current Position: " + position);

        next.setOnClickListener(v -> {
            position++;
            prev.setEnabled(position != 0);
            next.setEnabled(position<180);
            question();
            description.setText(correct.get(position));
            word.setText(Questions.get(position));
            sentence.setText(example.get(position));
            positionInt.setText("Current Position: " + position);
        });

        prev.setOnClickListener(v -> {
            position--;
            prev.setEnabled(position != 0);
            next.setEnabled(position<180);
            question();
            description.setText(correct.get(position));
            word.setText(Questions.get(position));
            sentence.setText(example.get(position));
            positionInt.setText("Current Position: " + position);
        });
    }

}
