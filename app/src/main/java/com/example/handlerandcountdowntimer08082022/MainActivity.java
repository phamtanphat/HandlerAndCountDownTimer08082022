package com.example.handlerandcountdowntimer08082022;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CountDownTimer countDownTimer;
    ImageView imageView;
    Button btnStart, btnPause;
    int[] arrImages = {
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4,
            R.drawable.image_5
    };
    int count = 1;
    boolean isRunning = false;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view_banner);
        btnStart = findViewById(R.id.button_start);
        btnPause = findViewById(R.id.button_pause);
        handler = new Handler();
        btnStart.setOnClickListener(this::onClick);
        btnPause.setOnClickListener(this::onClick);
    }

    private Runnable runnableStart = new Runnable() {
        @Override
        public void run() {
            count = count == arrImages.length ? 0 : count;
            imageView.setImageResource(arrImages[count++]);
            handler.postDelayed(this, 1000);
        }
    };

    private void startBanner() {
        if (!isRunning) {
            isRunning = true;
            countDownTimer = new CountDownTimer(1200, 1000) {
                @Override
                public void onTick(long l) {
                    if (l >= 1000) {
                        count = count == arrImages.length ? 0 : count;
                        imageView.setImageResource(arrImages[count++]);
                    }
                }

                @Override
                public void onFinish() {
                    countDownTimer.start();
                }
            };

            countDownTimer.start();
        } else {
            Toast.makeText(MainActivity.this, "Banner đang chạy", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_pause:
                handler.removeCallbacks(runnableStart);
                break;
            case R.id.button_start:
                handler.postDelayed(runnableStart, 1000);
                break;
        }
    }
}
