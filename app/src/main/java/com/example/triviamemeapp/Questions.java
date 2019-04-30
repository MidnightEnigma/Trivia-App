package com.example.triviamemeapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.VolleyError;
import org.json.JSONObject;
import java.util.Timer;
import java.util.TimerTask;
import com.android.volley.toolbox.Volley;
import java.util.List;

public class Questions extends AppCompatActivity {
    private TextView question;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private static int questionNumber = 0;
    private long score = 0;
    private String TAG;
    long totalSeconds = 30;
    long intervalSeconds = 1;
    private TextView fatality;
    private static int lives = 3;
    private TextView goal;
    private TextView timing;
    private static TextView winnersLabel;
    private static TextView losersLabel;
    private static RequestQueue queue;
    private static List<String> help = QuestionsLibrary.getQuestionsList();

    CountDownTimer timer = new CountDownTimer(totalSeconds * 30000,
            intervalSeconds * 1000) {
        public void onTick(long millisUntilFinished) {
            Log.d(TAG, "Elapsed: " + (totalSeconds * 1000 - millisUntilFinished) / 1000);
        }

        public void onFinish() {
            score += totalSeconds;
        }
    };

    static void startAPICall() {
        QuestionsLibrary.jsonParse(Categories.getCategory(), Levels.getDifficulty());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        queue = Volley.newRequestQueue(Questions.this);
        question = (TextView) findViewById(R.id.question);
        fatality = (TextView) findViewById(R.id.lives);
        goal = (TextView) findViewById(R.id.scoring);
        answer1 = (Button) findViewById(R.id.answer1);
        timing = (TextView) findViewById(R.id.timer);
        winnersLabel = (TextView) findViewById(R.id.winnerLabel);
        losersLabel = (TextView) findViewById(R.id.losingLabel);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                if (QuestionsLibrary.getChoiceOne().equals(QuestionsLibrary.getCorrectAnswer(questionNumber))) {
                    answer1.setBackgroundColor(Color.GREEN);
                    timer.cancel();
                   // updateScore();
                } else {
                    answer1.setBackgroundColor(Color.RED);
                    fatality.setText(lives--);

                }
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        updateQuestion();
                    }
                }, 3000);
            }
        });
        answer2 = (Button) findViewById(R.id.answer2);
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                if (QuestionsLibrary.getChoiceTwo().equals(QuestionsLibrary.getCorrectAnswer(questionNumber))) {
                    answer2.setBackgroundColor(Color.GREEN);
                    timer.cancel();
                   // updateScore();
                } else {
                    answer2.setBackgroundColor(Color.RED);

                }
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        updateQuestion();
                    }
                }, 3000);
            }
        });
        answer3 = (Button) findViewById(R.id.answer3);
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                if (QuestionsLibrary.getChoiceThree().equals(QuestionsLibrary.getCorrectAnswer(questionNumber))) {
                    answer3.setBackgroundColor(Color.GREEN);
                    timer.cancel();
                    //updateScore();
                } else {
                    answer3.setBackgroundColor(Color.RED);
                }
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        updateQuestion();
                    }
                }, 3000);
            }
        });
        answer4 = (Button) findViewById(R.id.answer4);
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                if (QuestionsLibrary.getChoiceFour().equals(QuestionsLibrary.getCorrectAnswer(questionNumber))) {
                    answer4.setBackgroundColor(Color.GREEN);
                    timer.cancel();
                   // updateScore();
                } else {
                    answer4.setBackgroundColor(Color.RED);
                }
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        updateQuestion();
                    }
                }, 3000);
            }
        });
    }
    private void updateQuestion() {
        QuestionsLibrary.setAnswers(questionNumber, QuestionsLibrary.getFalso(), QuestionsLibrary.getTrueans());
        question.setText(QuestionsLibrary.getQuestion(questionNumber));
        answer1.setText(QuestionsLibrary.getChoiceOne());
        answer2.setText(QuestionsLibrary.getChoiceTwo());
        answer3.setText(QuestionsLibrary.getChoiceThree());
        answer4.setText(QuestionsLibrary.getChoiceFour());
    }

    public static int getQuestionNumber() {
        return questionNumber;
    }

    public static RequestQueue getQueue() {
        return queue;
    }

    public void gameOver(List<String> help) {
        if (lives == 0) {
            losersLabel.setVisibility(View.VISIBLE);
        }
        if (help.get(questionNumber + 1) == null) {
            winnersLabel.setVisibility(View.VISIBLE);
        }
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity( new Intent(Questions.this, MainActivity.class));
            }
        }, 3000);
    }
}

