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
                Intent ez = new Intent(Levels.this, Questions.class);
                difficulty = "easy";
                startActivity(ez);
            }
        });
        medium = (Button) findViewById(R.id.medium);
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent medium = new Intent(Levels.this, Questions.class);
                difficulty = "medium";
                startActivity(medium);
            }
        });
        hard = (Button) findViewById(R.id.hard);
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent hard = new Intent(Levels.this, Questions.class);
                difficulty = "hard";
                startActivity(hard);
            }
        });
    }
    public static String getDifficulty() {
        return difficulty;
    }
}
