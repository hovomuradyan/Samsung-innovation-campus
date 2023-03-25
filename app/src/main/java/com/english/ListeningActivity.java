package com.english;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ListeningActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listening);
        ListView cinemaView = findViewById(R.id.cinemaView);
        String[] names = new String[1];
        String[] links = new String[1];

        try {
            InputStream is = getApplicationContext().getAssets().open("movie.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);
            names = Arrays.copyOf(names, names.length + jsonObject.getJSONArray("names").length()-1);
            links = Arrays.copyOf(links, names.length + jsonObject.getJSONArray("names").length()-1);
            for (int i = 0; i < jsonObject.getJSONArray("names").length(); i++) {
                names[i] = (jsonObject.getJSONArray("names").getString(i));
                links[i] = (jsonObject.getJSONArray("links").getString(i));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            Log.d("JSON: ", "question: alo");
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this, R.layout.text_color_layout, R.id.text_view, names);
        cinemaView.setAdapter(arrayAdapter);

        String[] finalLinks = links;
        cinemaView.setOnItemClickListener((parent, view, position, id) -> {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLinks[position]));
            startActivity(i);
        });
    }
}
