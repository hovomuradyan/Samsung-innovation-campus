package com.english;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MenuActivity extends AppCompatActivity {
	private final Intent i = new Intent();
	private TextView textView;

	@Override
	protected void onCreate(Bundle  _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.menu);

		textView = (TextView) findViewById(R.id.animtext);
		Typeface costomFont = Typeface.createFromAsset(getAssets(), "fonts/HeyJackFreeVersion-d9yR6.otf");
		textView.setTypeface(costomFont);
		Button learnBtn = findViewById(R.id.exitBtn);
		Button startBtn = findViewById(R.id.startBtn);
		Button listeningBtn = findViewById(R.id.listeningBtn);

		listeningBtn.setOnClickListener(v -> {
			i.setClass(getApplicationContext(), ListeningActivity.class);
			startActivity(i);
		});


		learnBtn.setOnClickListener(v -> {
			i.setClass(getApplicationContext(), LearningActivity.class);
			startActivity(i);
		});

		startBtn.setOnClickListener(view -> {
			i.setClass(getApplicationContext(), ChapActivity.class);
			startActivity(i);
		});
	}

	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int[] _location = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int[] _location = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
