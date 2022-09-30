package com.example.handlerandcountdowntimer08082022;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

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
    int count = 0;
    boolean isRunning = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view_banner);
        btnStart = findViewById(R.id.button_start);
        btnPause = findViewById(R.id.button_pause);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Đã chờ 1s", Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
            }
        });

        // Requirement : Nếu đang chạy thì dừng không thì thông báo chưa start
    }

    private void startBanner() {
        if (!isRunning) {
            isRunning = true;
            countDownTimer = new CountDownTimer(1200, 1000) {
                @Override
                public void onTick(long l) {
                    if (l >= 1000) {
                        count = count == arrImages.length - 1 ? 0 : count;
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
}
