package com.english;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class ListeningActivity extends AppCompatActivity {

    private ListView cinemaView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listening);
        cinemaView = findViewById(R.id.cinemaView);
        String[] names = {"Alexandr the Great", "Fishes"};
        String[] links = {"https://www.youtube.com/watch?v=5bsqJ4AW6GM","https://www.youtube.com/watch?v=fDIJqV7KXM8" };
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, R.layout.text_color_layout, R.id.text_view, names);
        cinemaView.setAdapter(arrayAdapter);
        cinemaView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(links[position]));
                startActivity(i);
            }
        });
    }
}
