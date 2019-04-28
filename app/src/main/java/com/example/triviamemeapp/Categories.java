package com.example.triviamemeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Categories extends AppCompatActivity {
    private Button general;
    private Button music;
    private Button video;
    private Button computer;
    private Button myth;
    private Button anime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        general = (Button) findViewById(R.id.cat1);
        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Categories.this, Levels.class));
            }
        });
        music = (Button) findViewById(R.id.cat2);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Categories.this, Levels.class));
            }
        });
        video = (Button) findViewById(R.id.cat3);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Categories.this, Levels.class));
            }
        });
        computer = (Button) findViewById(R.id.cat4);
        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Categories.this, Levels.class));
            }
        });
        myth = (Button) findViewById(R.id.cat5);
        myth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Categories.this, Levels.class));
            }
        });
        anime = (Button) findViewById(R.id.cat6);
        anime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Categories.this, Levels.class));
            }
        });
    }
}
