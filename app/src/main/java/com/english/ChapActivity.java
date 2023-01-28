package com.english;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

public class ChapActivity extends Activity {

    private final Intent i = new Intent();
    private MediaPlayer clk;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.chap);
        initialize();
        initializeLogic();
    }

    private void initialize() {

        Button unit1Btn = findViewById(R.id.unit1Btn);
        Button unit2Btn = findViewById(R.id.unit2Btn);
        Button unit3Btn = findViewById(R.id.unit3Btn);
        Button unit4Btn = findViewById(R.id.unit4Btn);
        Button unit5Btn = findViewById(R.id.unit5Btn);
        Button unit6Btn = findViewById(R.id.unit6Btn);
        Button unit7Btn = findViewById(R.id.unit7Btn);
        Button unit8Btn = findViewById(R.id.unit8Btn);
        Button unit9Btn = findViewById(R.id.unit9Btn);
        Button unit10Btn = findViewById(R.id.unit10Btn);
        Button unit11Btn = findViewById(R.id.unit11Btn);
        Button unit12Btn = findViewById(R.id.unit12Btn);
        Button unit13Btn = findViewById(R.id.unit13Btn);
        Button button46 = findViewById(R.id.Button46);
        Button button47 = findViewById(R.id.Button47);
        Button button48 = findViewById(R.id.Button48);
        Button button49 = findViewById(R.id.Button49);
        Button button50 = findViewById(R.id.Button50);
        Button button51 = findViewById(R.id.Button51);

        unit1Btn.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha1");
            startActivity(i);
            finish();
        });

        unit2Btn.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha2");
            startActivity(i);
            finish();
        });

        unit3Btn.setOnClickListener(view -> {
            clk.start();

            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha3");
            startActivity(i);
            finish();
        });

        unit4Btn.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha4");
            startActivity(i);
            finish();
        });

        unit5Btn.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha5");
            startActivity(i);
            finish();
        });

        unit6Btn.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha6");
            startActivity(i);
            finish();
        });

        unit7Btn.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha7");
            startActivity(i);
            finish();
        });

        unit8Btn.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha8");
            startActivity(i);
            finish();
        });


        unit9Btn.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha9");
            startActivity(i);
            finish();
        });

        unit10Btn.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha10");
            startActivity(i);
            finish();
        });

        unit11Btn.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha11");
            startActivity(i);
            finish();
        });

        unit12Btn.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha12");
            startActivity(i);
            finish();
        });

        unit13Btn.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha13");
            startActivity(i);
            finish();
        });

        button46.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha14");
            startActivity(i);
            finish();
        });

        button47.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha15");
            startActivity(i);
            finish();
        });


        button48.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha16");
            startActivity(i);
            finish();
        });


        button49.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha17");
            startActivity(i);
            finish();
        });

        button50.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "cha18");
            startActivity(i);
            finish();
        });

        button51.setOnClickListener(view -> {
            clk.start();
            i.setClass(getApplicationContext(), EnglishActivity.class);
            i.putExtra("cha", "all");
            startActivity(i);
            finish();
        });


    }

    private void initializeLogic() {
        clk = MediaPlayer.create(getApplicationContext(), R.raw.cliuck);
    }

    @Override
    protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
        super.onActivityResult(_requestCode, _resultCode, _data);

    }
}
