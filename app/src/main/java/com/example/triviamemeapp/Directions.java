package com.example.triviamemeapp;

import android.content.Intent;
import android.icu.text.RelativeDateTimeFormatter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Directions extends AppCompatActivity {
    private Button start;
    private TextView directionstomulti;
    private TextView directionstosingle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);
        start = (Button) findViewById(R.id.starting);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Directions.this, Categories.class));
            }
        });
    }
}
