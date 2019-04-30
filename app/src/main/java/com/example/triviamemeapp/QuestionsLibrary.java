package com.example.triviamemeapp;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import java.util.*;

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
    private static String URL;
    private static String[] incorrectAnswers;
    private static List<String> shuffledAnswers = new ArrayList<>();
    private static List<String> quest = new ArrayList<>();
    private static List<String> trueans = new ArrayList<>();
    private static List<List<String>> falso = new ArrayList<List<String>>();
    private static List<String> finalSet = new ArrayList<>();
    private static int a = Questions.getQuestionNumber();
    private static RequestQueue queue = Questions.getQueue();


    private static void setURL(String cat, String lvl) {
        if (cat.equals("general") && lvl.equals("easy")) {
            URL = "https://opentdb.com/api.php?amount=50&category=9&difficulty=easy&type=multiple";
        }
        if (cat.equals("general") && lvl.equals("medium")) {
            URL = "https://opentdb.com/api.php?amount=50&category=9&difficulty=medium&type=multiple";
        }
        if (cat.equals("general") && lvl.equals("hard")) {
            URL = "https://opentdb.com/api.php?amount=41&category=9&difficulty=hard&type=multiple";
        }
        if (cat.equals("music") && lvl.equals("easy")) {
            URL = "https://opentdb.com/api.php?amount=5&category=13&difficulty=easy&type=multiple";
        }
        if (cat.equals("music") && lvl.equals("medium")) {
            URL = "https://opentdb.com/api.php?amount=9&category=13&difficulty=medium&type=multiple";
        }
        if (cat.equals("music") && lvl.equals("hard")) {
            URL = "https://opentdb.com/api.php?amount=7&category=13&difficulty=hard&type=multiple";
        }
        if (cat.equals("video") && lvl.equals("easy")) {
            URL = "https://opentdb.com/api.php?amount=50&category=15&difficulty=easy&type=multiple";
        }
        if (cat.equals("video") && lvl.equals("medium")) {
            URL = "https://opentdb.com/api.php?amount=50&category=15&difficulty=medium&type=multiple";
        }
        if (cat.equals("video") && lvl.equals("hard")) {
            URL = "https://opentdb.com/api.php?amount=50&category=15&difficulty=hard&type=multiple";
        }
        if (cat.equals("computer") && lvl.equals("easy")) {
            URL = "https://opentdb.com/api.php?amount=29&category=18&difficulty=easy&type=multiple";
        }
        if (cat.equals("computer") && lvl.equals("medium")) {
            URL = "https://opentdb.com/api.php?amount=49&category=18&difficulty=medium&type=multiple";
        }
        if (cat.equals("computer") && lvl.equals("hard")) {
            URL = "https://opentdb.com/api.php?amount=22&category=18&difficulty=hard&type=multiple";
        }
        if (cat.equals("mythos") && lvl.equals("easy")) {
            URL = "https://opentdb.com/api.php?amount=12&category=20&difficulty=easy&type=multiple";
        }
        if (cat.equals("mythos") && lvl.equals("medium")) {
            URL = "https://opentdb.com/api.php?amount=14&category=20&difficulty=medium&type=multiple";
        }
        if (cat.equals("mythos") && lvl.equals("hard")) {
            URL = "https://opentdb.com/api.php?amount=8&category=20&difficulty=hard&type=multiple";
        }
        if (cat.equals("weebweebweeb") && lvl.equals("easy")) {
            URL = "https://opentdb.com/api.php?amount=37&category=31&difficulty=easy&type=multiple";
        }
        if (cat.equals("weebweebweeb") && lvl.equals("medium")) {
            URL = "https://opentdb.com/api.php?amount=50&category=31&difficulty=medium&type=multiple";
        }
        if (cat.equals("weebweebweeb") && lvl.equals("hard")) {
            URL = "https://opentdb.com/api.php?amount=31&category=31&difficulty=hard&type=multiple";
        }
    }

    public static void jsonParse(String subject, String level) {
        setURL(subject, level);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JsonParser parser = new JsonParser();
                            JsonObject result = parser.parse(response).getAsJsonObject();
                            JsonArray questions = result.getAsJsonArray("results");
                            for (JsonElement questionElement : questions) {
                                JsonObject elementAsObject = questionElement.getAsJsonObject();
                                quest.add(elementAsObject.get("question").getAsString());
                                trueans.add(elementAsObject.get("correct_answer").getAsString());
                                JsonArray incorrect = elementAsObject.get("incorrect_answers").getAsJsonArray();
                                incorrectAnswers = new String[incorrect.size()];
                                List<String> storage = new ArrayList<>();
                                for (int i = 0; i < incorrect.size(); i++) {
                                    storage.add(incorrectAnswers[i]);
                                }
                                falso.add(storage);

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
       queue.add(stringRequest);
    }

    public static String getQuestion(int a) {
        return quest.get(a);
    }

    public static String getCorrectAnswer(int a) {
        return trueans.get(a);
    }
    public static void setAnswers(int a, List<List<String>> falso , List<String> trueans) {
        finalSet.add(trueans.get(a));
        finalSet.add(falso.get(a).get(0));
        finalSet.add(falso.get(a).get(1));
        finalSet.add(falso.get(a).get(2));
    }

    public static List<String> getShuffledAnswers(List<String> finalSet) {
        shuffledAnswers = shuffleList(finalSet);
        return shuffledAnswers;
    }

    private static List<String> shuffleList(List<String> dummy) {
        Collections.shuffle(dummy);
        return dummy;
    }

    public static String getChoiceOne() {
        String choiceOne = shuffledAnswers.get(0);
        return choiceOne;
    }
    public static String getChoiceTwo() {
        String choiceTwo = shuffledAnswers.get(1);
        return choiceTwo;
    }
    public static String getChoiceThree() {
        String choiceThree = shuffledAnswers.get(2);
        return choiceThree;
    }
    public static String getChoiceFour() {
        String choiceFour = shuffledAnswers.get(3);
        return choiceFour;
    }

    public static List<String> getTrueans() {
        return trueans;
    }

    public static List<List<String>> getFalso() {
        return falso;
    }

    public static List<String> getQuestionsList() {
        return quest;
    }
}
