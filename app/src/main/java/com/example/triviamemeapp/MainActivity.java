package com.example.triviamemeapp;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Meme";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button single = findViewById(R.id.button);
        single.setOnClickListener(v -> {
            Log.d(TAG, "start the single player game");
            gameStart();
        });
        final Button multi = findViewById(R.id.button2);
        multi.setOnClickListener(v -> {
            Log.d(TAG, "start the multiplayer game");
            gameStart();
        });
        final Button bonus = findViewById(R.id.button3);
        bonus.setOnClickListener(v -> {
            Log.d(TAG, "start the bonus game");
            gameStart();
        });
    }
    public boolean gameStart() {
        return false;
    }
}
