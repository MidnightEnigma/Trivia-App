package com.example.triviamemeapp;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This is the API for easy questions for general knowledge;
 */

//import;

/**
 * This is the API for medium questions for general knowledge;
 */
//import;

/**
 * This is the API for hard questions for general knowledge;
 */
//import;

/**
 * This is the API for easy questions for Musicals and Theatres;
 */
//import;

/**
 * This is the API for medium questions for Musicals and Theatres;
 */
//import;

/**
 * This is the API for hard questions for Musicals and Theatres;
 */
//import;

/**
 * This is the API for easy questions for Video Games;
 */
//import;

/**
 * This is the API for medium questions for Video Games;
 */
//import;

/**
 * This is the API for hard questions for Video Games;
 */
//import;

/**
 * This is the API for easy questions for Computer Science;
 */
//import;

/**
 * This is the API for medium questions for Computer Science;
 */
//import;

/**
 * This is the API for hard questions for Computer Science;
 */
//import;

/**
 * This is the API for easy questions for Mythology;
 */
//import;

/**
 * This is the API for medium questions for Mythology;
 */
//import;

/**
 * This is the API for hard questions for Mythology;
 */
//import;

/**
 * This is the API for easy questions for Japanese Anime and Manga:
 */
//import;

/**
 * This is the API for medium questions for Japanese Anime and Manga:
 */
//import;import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.Queue;

/**
 * This is the API for hard questions for Japanese Anime and Manga:
 */
public class QuestionsLibrary {
    private static final String TAG = "triviagame";
    private static String URL = "";
    private static String category;
    private static String type;
    private static String difficult;
    private static String question;
    private static String correct;
    private static String[] answers = new String[4];
    private void jsonParse() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(String json) {
                        try {
                            JsonParser parser = new JsonParser();
                            JsonObject result = parser.parse(json).getAsJsonObject();
                            JsonArray questions = result.getAsJsonArray("results");
                            for (JsonElement questionElement : questions) {
                                JsonObject elementAsObject = questionElement.getAsJsonObject();
                                String category = elementAsObject.get("category").getAsString();
                                String type = elementAsObject.get("type").getAsString();
                                String difficult = elementAsObject.get("difficulty").getAsString();
                                String question = elementAsObject.get("question").getAsString();
                                String correct = elementAsObject.get("correct_answer").getAsString();
                                JsonArray incorrect = elementAsObject.get("incorrect_answers").getAsJsonArray();
                                String[] incorrectAnswers = new String[incorrect.size()];
                                for (int i = 0; i < incorrect.size(); i++) {
                                    String wrong = incorrect.get(i).getAsString();
                                    incorrectAnswers[i] = wrong;
                                }
                                /*
                                 * need to create a question method in the Question java file.
                                 */
                                //Question finalQuestion = new Question(category, type, difficult, question, correct, incorrectAnswers);
                               // this.questions.add(finalQuestion);
                               // Log.d(TAG, "parseJSON: " + finalQuestion);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Queue.add(request);
    }
    public String getQuestion(String a) {
        return question;
    }
    public void getAnswers(String[] one, String two) {
        answers[0] = two;
        answers[1] = one[0];
        answers[2] = one[1];
        answers[3] = one[2];
    }
    public static void main(String args[]) {
        shuffleArray(answers);
    }
    private static void shuffleArray(String[] dummy) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = dummy.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = dummy[index];
            dummy[index] = dummy[i];
            dummy[i] = a;
        }
    }
    public String getQuestions;
}
