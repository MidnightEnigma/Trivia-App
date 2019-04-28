package com.example.triviamemeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.CountDownTimer;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.VolleyError;
import org.json.JSONObject;

public class Questions extends AppCompatActivity {
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private int score = 0;
    private String TAG;
    long totalSeconds = 30;
    long intervalSeconds = 1;

    CountDownTimer timer = new CountDownTimer(totalSeconds * 1000,
            intervalSeconds * 1000) {
        public void onTick(long millisUntilFinished) {
            Log.d(TAG, "Elapsed: " + (totalSeconds * 1000 - millisUntilFinished) / 1000);
        }

        public void onFinish() {
            score += totalSeconds;
        }
    };

    void startAPICall() {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://opentdb.com/api.php?amount=50&category=9&difficulty=easy&type=multiple",
                    null,
                        response ->  {
                            Log.d(TAG, response.toString());
                    }, error -> Log.w(TAG, error.toString())
            );
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        answer1 = (Button) findViewById(R.id.answer1);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                timer.cancel();
                startActivity(new Intent(Levels.this, Questions.class));
            }
        });
        answer2 = (Button) findViewById(R.id.answer2);
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                timer.cancel();
                startActivity(new Intent(Levels.this, Questions.class));
            }
        });
        answer3 = (Button) findViewById(R.id.answer3);
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                timer.cancel();
                startActivity(new Intent(Levels.this, Questions.class));
            }
        });
        answer4 = (Button) findViewById(R.id.easy);
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                timer.cancel();
                startActivity(new Intent(Levels.this, Questions.class));
            }
        });
    }
}

