package com.english.questions;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class questionsForUnits extends AppCompatActivity {
	public ArrayList<String> Questions = new ArrayList<>();
	public ArrayList<String> answer1 = new ArrayList<>();
	public ArrayList<String> answer2 = new ArrayList<>();
	public ArrayList<String> answer3 = new ArrayList<>();
	public ArrayList<String> answer4 = new ArrayList<>();
	public ArrayList<String> correct = new ArrayList<>();
	public ArrayList<String> example = new ArrayList<>();

	public void question() {
		try {
			InputStream is = getApplicationContext().getAssets().open("questions.json");
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();
			String json = new String(buffer, StandardCharsets.UTF_8);
			JSONObject jsonObject = new JSONObject(json);
			for (int i = 0; i < jsonObject.getJSONArray("question").length(); i++) {
				Questions.add(jsonObject.getJSONArray("question").getString(i));
				answer1.add(jsonObject.getJSONArray("answer1").getString(i));
				answer2.add(jsonObject.getJSONArray("answer2").getString(i));
				answer3.add(jsonObject.getJSONArray("answer3").getString(i));
				answer4.add(jsonObject.getJSONArray("answer4").getString(i));
				correct.add(jsonObject.getJSONArray("correct").getString(i));
				example.add(jsonObject.getJSONArray("example").getString(i));
			}
		} catch (IOException | JSONException e) {
			e.printStackTrace();
			Log.d("JSON: ", "question: question list isn't working");
		}
	}
}
