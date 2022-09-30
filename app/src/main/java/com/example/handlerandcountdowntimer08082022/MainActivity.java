package com.example.handlerandcountdowntimer08082022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Count down
        countDownTimer = new CountDownTimer(5000, 500) {
            @Override
            public void onTick(long l) {
                if (l >= 1000) {
                    Log.d("BBB", l + "");
                }
            }

            @Override
            public void onFinish() {
                countDownTimer.start();
                Log.d("BBB", "onFinish");
            }
        };
        countDownTimer.start();
    }
}
