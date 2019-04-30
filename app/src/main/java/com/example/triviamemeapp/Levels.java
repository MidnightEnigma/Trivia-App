package com.example.triviamemeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Levels extends AppCompatActivity {
    private Button easy;
    private Button medium;
    private Button hard;
    private static String difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        easy = (Button) findViewById(R.id.easy);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                difficulty = "easy";
                startActivity( new Intent(Levels.this, Questions.class));
            }
        });
        medium = (Button) findViewById(R.id.medium);
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                difficulty = "medium";
                startActivity( new Intent(Levels.this, Questions.class));
            }
        });
        hard = (Button) findViewById(R.id.hard);
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                difficulty = "hard";
                startActivity( new Intent(Levels.this, Questions.class));
            }
        });
    }
    public static String getDifficulty() {
        return difficulty;
    }
}
