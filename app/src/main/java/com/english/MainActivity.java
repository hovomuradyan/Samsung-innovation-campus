package com.english;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
	private final Timer _timer = new Timer();
	private final Intent j = new Intent();

	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		finish();
		Intent intent = new Intent(this, SignInActivity.class);
		startActivity(intent);
		//initializeLogic();
	}

	private void initializeLogic() {
		TimerTask nex = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(() -> {
					j.setClass(getApplicationContext(), MenuActivity.class);
					startActivity(j);
					finish();
				});
			}
		};
		_timer.schedule(nex, 5000);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
	}

}
