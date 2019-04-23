package com.example.triviamemeapp;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button single;
    Button multi;
    Button bonus;
    private static final String TAG = "Meme";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        single = (Button) findViewById(R.id.button);
        single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, directions.xml.class ));
            }
        });

    }
    public boolean gameStart() {
        return false;
    }
    public void sendMessage(View view) {

    }

}
