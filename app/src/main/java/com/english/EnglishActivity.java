package com.english;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.english.questions.questionsForUnits;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class EnglishActivity extends questionsForUnits {
    private final Timer _timer = new Timer();
    public int num1 = 0;
    public double tim = 0;
    public double total_question = 0;
    public double total_true = 0;
    public double total_divide = 0;
    public double total_finish = 0;
    public Animation animMove, animSlideDown, animLeft;
    public ArrayList<String> rev = new ArrayList<>();
    public LinearLayout linear7, linear6, linear11, linear12, linear2, linear9, linear4, linear10, linear5;
    public ImageView imageview1;
    public Button button1, button3, button4, button2;
    public LinearLayout linear15, linear14, linear13;
    public TextView textview3, textview4, textview5, textview6, textview2, textview1;
    public TimerTask t;
    public ObjectAnimator sho = new ObjectAnimator();
    public TimerTask count;
    public SharedPreferences total;
    public Intent go = new Intent();
    public MediaPlayer click, congr, pla;
    public ObjectAnimator sno = new ObjectAnimator();
    public int settingsWrongAnswer;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.english);
        settingsWrongAnswer = getIntent().getIntExtra("settingsWrongAnswer", 3);
        initialize();
        initializeLogic();
    }



    private void initialize() {
        linear7 = findViewById(R.id.linear7);
        linear6 = findViewById(R.id.linear6);
        linear11 = findViewById(R.id.linear11);
        linear12 = findViewById(R.id.linear12);
        linear2 = findViewById(R.id.linear2);
        textview1 = findViewById(R.id.textview1);
        linear9 = findViewById(R.id.linear9);
        linear4 = findViewById(R.id.linear4);
        linear10 = findViewById(R.id.linear10);
        linear5 = findViewById(R.id.linear5);
        button2 = findViewById(R.id.button2);
        button4 = findViewById(R.id.button4);
        imageview1 = findViewById(R.id.imageview1);
        textview2 = findViewById(R.id.textview2);
        button1 = findViewById(R.id.button1);
        button3 = findViewById(R.id.button3);
        linear15 = findViewById(R.id.linear15);
        linear14 = findViewById(R.id.linear14);
        linear13 = findViewById(R.id.linear13);
        textview3 = findViewById(R.id.textview3);
        textview4 = findViewById(R.id.textview4);
        textview5 = findViewById(R.id.textview5);
        textview6 = findViewById(R.id.textview6);
        total = getSharedPreferences("total", AppCompatActivity.MODE_PRIVATE);

        animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        animMove = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        animLeft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left);

        button1.setOnClickListener(view -> { click.start(); _btn1_que1(); });
        button2.setOnClickListener(view -> { click.start(); _btn2_que1(); });
        button3.setOnClickListener(view -> { click.start(); _btn3_que1(); });
        button4.setOnClickListener(view -> { click.start(); _btn4_que1(); });

        textview4.setOnClickListener(view -> {
            if (total_true != 0) {
                total_true = total_true - 0.5d;
            }
            _get();
        });

        sho.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator _param1) {}

            @Override
            public void onAnimationEnd(Animator _param1) {
                button2.setEnabled(true);
                button1.setEnabled(true);
                button3.setEnabled(true);
                button4.setEnabled(true);
                _timer();
            }

            @Override
            public void onAnimationCancel(Animator _param1) {}

            @Override
            public void onAnimationRepeat(Animator _param1) {}
        });
    }

    @SuppressLint("SetTextI18n")
    private void initializeLogic() {
        pla = MediaPlayer.create(getApplicationContext(), R.raw.cir);
        congr = MediaPlayer.create(getApplicationContext(), R.raw.atada);
        click = MediaPlayer.create(getApplicationContext(), R.raw.cliuck);
        imageview1.setVisibility(View.GONE);
        total_question = 0;
        total_true = 0;
        switch (getIntent().getStringExtra("cha")) {
            case "cha1":
                textview3.setText("Lesson 1");
                _que1();
                break;
            case "cha2":
                textview3.setText("Lesson 2");
                _que1();
                break;
            case "cha3":
                textview3.setText("lesson3");
                _que1();
                break;
            case "cha4":
                textview3.setText("lesson4");
                _que1();
                break;
            case "cha5":
                textview3.setText("lesson 5");
                _que1();
                break;
            case "cha6":
                textview3.setText("lesson 6");
                _que1();
                break;
            case "cha7":
                textview3.setText("lesson 7");
                _que1();
                break;
            case "cha8":
                textview3.setText("lesson 8");
                _que1();
                break;
            case "cha9":
                textview3.setText("lesson 9");
                _que1();
                break;
            case "cha10":
                textview3.setText("lesson 10");
                _que1();
                break;
            case "cha11":
                textview3.setText("lesson 11");
                _que1();
                break;
            case "cha12":
                textview3.setText("lesson 12");
                _que1();
                break;
            case "cha13":
                textview3.setText("lesson 13");
                _que1();
                break;
            case "cha14":
                textview3.setText("lesson 14");
                _que1();
                break;
            case "cha15":
                textview3.setText("lesson 15");
                _que1();
                break;
            case "cha16":
                textview3.setText("lesson 16");
                _que1();
                break;
            case "cha17":
                textview3.setText("lesson 17");
                _que1();
                break;
            case "cha18":
                textview3.setText("lesson 18");
                _que1();
                break;
            case "all":
                textview5.setText("60 /");
                textview3.setText("Revision");
                _que1();
                break;
        }
        _all_false();
    }

    @Override
    protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
        super.onActivityResult(_requestCode, _resultCode, _data);
    }

    @Override
    public void onBackPressed() {
        if (total_true != 0) {
            total_true = total_true - 0.5d;
        }
        _get();
    }

    @Override
    public void onStop() {
        super.onStop();
        rev.clear();
        total_question = 0;
        if (tim != 30) {
            count.cancel();
        }
    }

    private void _btn1_que1() {
        count.cancel();
        button1.setBackgroundResource(R.drawable.wait_btn);
        _all_false();
        t = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    if (answer1.get(num1).equals(correct.get(num1))) {
                        button1.setBackgroundResource(R.drawable.right_answer_btn);
                        _true_();
                    } else {
                        button1.setBackgroundResource(R.drawable.wrong_answer_btn);
                        if (settingsWrongAnswer == 1) {
                            _false_();
                        }
                        else{
                            _true_();
                        }
                    }
                });
            }
        };
        _timer.schedule(t, 3000);
    }

    private void _btn2_que1() {
        count.cancel();
        button2.setBackgroundResource(R.drawable.wait_btn);
        _all_false();
        t = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    if (answer2.get(num1).equals(correct.get(num1))) {
                        button2.setBackgroundResource(R.drawable.right_answer_btn);
                        _true_();
                    } else {
                        button2.setBackgroundResource(R.drawable.wrong_answer_btn);
                        if (settingsWrongAnswer == 1) {
                            _false_();
                        }
                        else{
                            _true_();
                        }
                    }
                });
            }
        };
        _timer.schedule(t, 3000);
    }

    private void _btn3_que1() {
        count.cancel();
        button3.setBackgroundResource(R.drawable.wait_btn);
        _all_false();
        t = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    if (answer3.get(num1).equals(correct.get(num1))) {
                        button3.setBackgroundResource(R.drawable.right_answer_btn);
                        _true_();
                    } else {
                        button3.setBackgroundResource(R.drawable.wrong_answer_btn);
                        if (settingsWrongAnswer == 1) {
                            _false_();
                        }
                        else{
                            _true_();
                        }
                    }
                });
            }
        };
        _timer.schedule(t, 3000);
    }

    private void _btn4_que1() {
        count.cancel();
        button4.setBackgroundResource(R.drawable.wait_btn);
        _all_false();
        t = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    if (answer4.get(num1).equals(correct.get(num1))) {
                        button4.setBackgroundResource(R.drawable.right_answer_btn);
                        _true_();
                    } else {
                        button4.setBackgroundResource(R.drawable.wrong_answer_btn);
                        if (settingsWrongAnswer == 1) {
                            _false_();
                        }
                        else{
                            _true_();
                        }
                    }
                });
            }
        };
        _timer.schedule(t, 3000);
    }
    @SuppressLint("SetTextI18n")
//    public void openDialog() {
////        final Dialog dialog = new Dialog(this);
////        dialog.setContentView(R.layout.dialog_demo);
////        TextView a = findViewById(R.id.dialog_info);
////        //a.setText("You have" + total_true + " points");
////        dialog.setTitle("Total Points");
////        dialog.show();
//    }
    private void _true_() {
        pla.start();
        total_true++;
        //openDialog();
        textview6.setText(String.valueOf((long) (total_true)));
        if (getIntent().getStringExtra("cha").equals("all")) {
            if (total_true == 60) {
                t = new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(() -> {
                            //openDialog();
                            congr.start();
                            _get();
                        });
                    }
                };
            } else {
                t = new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(() -> {
                            button1.setBackgroundResource(R.drawable.btn);
                            button2.setBackgroundResource(R.drawable.btn);
                            button3.setBackgroundResource(R.drawable.btn);
                            button4.setBackgroundResource(R.drawable.btn);
                            _que1();
                        });
                    }
                };
            }
        } else {
            if (total_true == 30) {
                t = new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(() -> {
                            //openDialog();
                            congr.start();
                            _get();
                        });
                    }
                };
            } else {
                t = new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(() -> {
                            button1.setBackgroundResource(R.drawable.btn);
                            button2.setBackgroundResource(R.drawable.btn);
                            button3.setBackgroundResource(R.drawable.btn);
                            button4.setBackgroundResource(R.drawable.btn);
                            _que1();
                        });
                    }
                };
            }
        }
        _timer.schedule(t, 3000);
    }


    private void _false_() {
        t = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    _num1_core();
                    t = new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(EnglishActivity.this::_get);
                        }
                    };
                    _timer.schedule(t, 3000);
                });
            }
        };
        _timer.schedule(t, 3000);
    }

    private void _all_false() {
        button2.setEnabled(false);
        button1.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
    }

    private void _text_show() {
        textview1.startAnimation(animSlideDown);
        button1.startAnimation(animMove);
        button2.startAnimation(animLeft);
        button3.startAnimation(animMove);
        button4.startAnimation(animLeft);

        sho.setTarget(textview1);
        sho.setPropertyName("alpha");
        sho.setFloatValues((float) (0), (float) (1));
        sho.setDuration(1500);
        sho.start();
    }

    private void _timer() {
        tim = 30;
        if ((num1 == 0)) {
            imageview1.setVisibility(View.VISIBLE);
            textview2.setVisibility(View.GONE);
            textview2.setText(String.valueOf((long) (tim)));
            sno.setTarget(imageview1);
            sno.setPropertyName("alpha");
            sno.setFloatValues((float) (0), (float) (1));
            sno.setDuration(1500);
            sno.start();
        } else {
            imageview1.setVisibility(View.GONE);
            textview2.setVisibility(View.VISIBLE);
            count = new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(() -> {
                        tim--;
                        textview2.setText(String.valueOf((long) (tim)));
                        if (tim == 0) {
                            _all_false();
                            count.cancel();
                            _false_();
                        }
                    });
                }
            };
            _timer.scheduleAtFixedRate(count, 0, 1000);
        }
    }

    //this is the corrector of questions
    private void _num1_core() {
        if (button1.getText().equals(correct.get(num1))) {
            button1.setBackgroundResource(R.drawable.right_answer_btn);
        } else if (button2.getText().equals(correct.get(num1))) {
            button2.setBackgroundResource(R.drawable.right_answer_btn);
        } else if (button3.getText().equals(correct.get(num1))) {
            button3.setBackgroundResource(R.drawable.right_answer_btn);
        } else if (button4.getText().equals(correct.get(num1))) {
            button4.setBackgroundResource(R.drawable.right_answer_btn);
        }
    }

    private void _get() {
        total_divide = total_true / 30;
        total_finish = total_divide * 100;
        switch (getIntent().getStringExtra("cha")) {
            case "cha1":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha1", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha1", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high1", "").equals("")) {
                    total.edit().putString("cha_high1", total.getString("cha1", "")).apply();
                } else if (Double.parseDouble(total.getString("cha1", "")) > Double.parseDouble(total.getString("cha_high1", ""))) {
                    total.edit().putString("cha_high1", total.getString("cha1", "")).apply();
                }
                break;
            case "cha2":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha2", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha2", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high2", "").equals("")) {
                    total.edit().putString("cha_high2", total.getString("cha2", "")).apply();
                } else if (Double.parseDouble(total.getString("cha2", "")) > Double.parseDouble(total.getString("cha_high2", ""))) {
                    total.edit().putString("cha_high2", total.getString("cha2", "")).apply();
                }
                break;
            case "cha3":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha3", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha3", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high3", "").equals("")) {
                    total.edit().putString("cha_high3", total.getString("cha3", "")).apply();
                } else if (Double.parseDouble(total.getString("cha3", "")) > Double.parseDouble(total.getString("cha_high3", ""))) {
                    total.edit().putString("cha_high3", total.getString("cha3", "")).apply();
                }
                break;
            case "cha4":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha4", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha4", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high4", "").equals("")) {
                    total.edit().putString("cha_high4", total.getString("cha4", "")).apply();
                } else if (Double.parseDouble(total.getString("cha4", "")) > Double.parseDouble(total.getString("cha_high4", ""))) {
                    total.edit().putString("cha_high4", total.getString("cha4", "")).apply();
                }
                break;
            case "cha5":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha5", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha5", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high5", "").equals("")) {
                    total.edit().putString("cha_high5", total.getString("cha5", "")).apply();
                } else if (Double.parseDouble(total.getString("cha5", "")) > Double.parseDouble(total.getString("cha_high5", ""))) {
                    total.edit().putString("cha_high5", total.getString("cha5", "")).apply();
                }
                break;
            case "cha6":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha6", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha6", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high6", "").equals("")) {
                    total.edit().putString("cha_high6", total.getString("cha6", "")).apply();
                } else if (Double.parseDouble(total.getString("cha6", "")) > Double.parseDouble(total.getString("cha_high6", ""))) {
                    total.edit().putString("cha_high6", total.getString("cha6", "")).apply();
                }
                break;
            case "cha7":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha7", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha7", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high7", "").equals("")) {
                    total.edit().putString("cha_high7", total.getString("cha7", "")).apply();
                } else if (Double.parseDouble(total.getString("cha7", "")) > Double.parseDouble(total.getString("cha_high7", ""))) {
                    total.edit().putString("cha_high7", total.getString("cha7", "")).apply();
                }
                break;
            case "cha8":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha8", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha8", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high8", "").equals("")) {
                    total.edit().putString("cha_high8", total.getString("cha8", "")).apply();
                } else if (Double.parseDouble(total.getString("cha8", "")) > Double.parseDouble(total.getString("cha_high8", ""))) {
                    total.edit().putString("cha_high8", total.getString("cha8", "")).apply();
                }
                break;
            case "cha9":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha9", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha9", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high9", "").equals("")) {
                    total.edit().putString("cha_high9", total.getString("cha9", "")).apply();
                } else if (Double.parseDouble(total.getString("cha9", "")) > Double.parseDouble(total.getString("cha_high9", ""))) {
                    total.edit().putString("cha_high9", total.getString("cha9", "")).apply();
                }
                break;
            case "cha10":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha10", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha10", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high10", "").equals("")) {
                    total.edit().putString("cha_high10", total.getString("cha10", "")).apply();
                } else if (Double.parseDouble(total.getString("cha10", "")) > Double.parseDouble(total.getString("cha_high10", ""))) {
                    total.edit().putString("cha_high10", total.getString("cha10", "")).apply();
                }
                break;
            case "cha11":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha11", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha11", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high11", "").equals("")) {
                    total.edit().putString("cha_high11", total.getString("cha11", "")).apply();
                } else if (Double.parseDouble(total.getString("cha11", "")) > Double.parseDouble(total.getString("cha_high11", ""))) {
                    total.edit().putString("cha_high11", total.getString("cha11", "")).apply();
                }
                break;
            case "cha12":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha12", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha12", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high12", "").equals("")) {
                    total.edit().putString("cha_high12", total.getString("cha12", "")).apply();
                } else if (Double.parseDouble(total.getString("cha12", "")) > Double.parseDouble(total.getString("cha_high12", ""))) {
                    total.edit().putString("cha_high12", total.getString("cha12", "")).apply();
                }
                break;
            case "cha13":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha13", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha13", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high13", "").equals("")) {
                    total.edit().putString("cha_high13", total.getString("cha13", "")).apply();
                } else if (Double.parseDouble(total.getString("cha13", "")) > Double.parseDouble(total.getString("cha_high13", ""))) {
                    total.edit().putString("cha_high13", total.getString("cha13", "")).apply();
                }
                break;
            case "cha14":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha14", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha14", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high14", "").equals("")) {
                    total.edit().putString("cha_high14", total.getString("cha14", "")).apply();
                } else if (Double.parseDouble(total.getString("cha14", "")) > Double.parseDouble(total.getString("cha_high14", ""))) {
                    total.edit().putString("cha_high14", total.getString("cha14", "")).apply();
                }
                break;
            case "cha15":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha15", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha15", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high15", "").equals("")) {
                    total.edit().putString("cha_high15", total.getString("cha15", "")).apply();
                } else if (Double.parseDouble(total.getString("cha15", "")) > Double.parseDouble(total.getString("cha_high15", ""))) {
                    total.edit().putString("cha_high15", total.getString("cha15", "")).apply();
                }
                break;
            case "cha16":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha16", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha16", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high16", "").equals("")) {
                    total.edit().putString("cha_high16", total.getString("cha16", "")).apply();
                } else if (Double.parseDouble(total.getString("cha16", "")) > Double.parseDouble(total.getString("cha_high16", ""))) {
                    total.edit().putString("cha_high16", total.getString("cha16", "")).apply();
                }
                break;
            case "cha17":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha17", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha17", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high17", "").equals("")) {
                    total.edit().putString("cha_high17", total.getString("cha17", "")).apply();
                } else if (Double.parseDouble(total.getString("cha17", "")) > Double.parseDouble(total.getString("cha_high17", ""))) {
                    total.edit().putString("cha_high17", total.getString("cha17", "")).apply();
                }
                break;
            case "cha18":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("cha18", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("cha18", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_high18", "").equals("")) {
                    total.edit().putString("cha_high18", total.getString("cha18", "")).apply();
                } else if (Double.parseDouble(total.getString("cha18", "")) > Double.parseDouble(total.getString("cha_high18", ""))) {
                    total.edit().putString("cha_high18", total.getString("cha18", "")).apply();
                }
                break;
            case "all":
                if (String.valueOf(total_finish).length() > 3) {
                    total.edit().putString("all", String.valueOf(total_finish).substring(0, 4)).apply();
                } else {
                    total.edit().putString("all", String.valueOf((long) (total_finish))).apply();
                }
                go.putExtra("settingsWrongAnswer", settingsWrongAnswer);
                go.setClass(getApplicationContext(), ChapActivity.class);
                startActivity(go);
                finish();
                if (total.getString("cha_all", "").equals("")) {
                    total.edit().putString("cha_all", total.getString("all", "")).apply();
                } else if (Double.parseDouble(total.getString("all", "")) > Double.parseDouble(total.getString("cha_all", ""))) {
                    total.edit().putString("cha_all", total.getString("all", "")).apply();
                }
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    private void _check_cha() {
        switch (getIntent().getStringExtra("cha")) {
            case "cha1":
                num1 = Help.getRandom(1, 10);
                break;
            case "cha2":
                num1 = Help.getRandom(11, 20);
                break;
            case "cha3":
                num1 = Help.getRandom(21, 30);
                break;
            case "cha4":
                num1 = Help.getRandom(31, 40);
                break;
            case "cha5":
                num1 = Help.getRandom(41, 50);
                break;
            case "cha6":
                num1 = Help.getRandom(51, 60);
                break;
            case "cha7":
                num1 = Help.getRandom(61, 70);
                break;
            case "cha8":
                num1 = Help.getRandom(71, 80);
                break;
            case "cha9":
                num1 = Help.getRandom(81, 90);
                break;
            case "cha10":
                num1 = Help.getRandom(91, 100);
                break;
            case "cha11":
                num1 = Help.getRandom(101, 110);
                break;
            case "cha12":
                num1 = Help.getRandom(111, 120);
                break;
            case "cha13":
                num1 = Help.getRandom(121, 130);
                break;
            case "cha14":
                num1 = Help.getRandom(131, 140);
                break;
            case "cha15":
                num1 = Help.getRandom(141, 150);
                break;
            case "cha16":
                num1 = Help.getRandom(151, 160);
                break;
            case "cha17":
                num1 = Help.getRandom(161, 170);
                break;
            case "cha18":
                num1 = Help.getRandom(171, 180);
                break;
            case "all":
                num1 = Help.getRandom(1, 180);
                break;
        }
        _all_false();
    }

    @SuppressLint("SetTextI18n")
    private void _que1() {
        _text_show();
        textview2.setText("30");
        _check_cha();
        question();
        textview1.setText(Questions.get(num1));
        button1.setText(answer1.get(num1));
        button2.setText(answer2.get(num1));
        button3.setText(answer3.get(num1));
        button4.setText(answer4.get(num1));
    }

}
