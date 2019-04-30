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
    private static String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        general = (Button) findViewById(R.id.cat1);
        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent general = new Intent(Categories.this, Levels.class);
                category = "general";
                startActivity(general);
            }
        });
        music = (Button) findViewById(R.id.cat2);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent music = new Intent(Categories.this, Levels.class);
                category = "music";
                startActivity(music);
            }
        });
        video = (Button) findViewById(R.id.cat3);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent video = new Intent(Categories.this, Levels.class);
                category = "video";
                startActivity(video);
            }
        });
        computer = (Button) findViewById(R.id.cat4);
        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent comp = new Intent(Categories.this, Levels.class);
                category = "computer";
                startActivity(comp);
            }
        });
        myth = (Button) findViewById(R.id.cat5);
        myth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mythos = new Intent(Categories.this, Levels.class);
                category = "mythos";
                startActivity(mythos);
            }
        });
        anime = (Button) findViewById(R.id.cat6);
        anime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent weeb = new Intent(Categories.this, Levels.class);
                category = "weebweebweeb";
                startActivity(weeb);
            }
        });
    }
    public static String getCategory() {
        return category;
    }
}
