package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView timerText;

    private SimpleDateFormat dataFormat =
            new SimpleDateFormat("mm:ss.SSS", Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long countNumber = 5000;
        long interval = 10;

        Button startButton = findViewById(R.id.start_button);
        Button stopButton = findViewById(R.id.stop_button);

        timerText = findViewById(R.id.timer);
        timerText.setText(dataFormat.format(0));

        final CountDown countDown = new CountDown(countNumber, interval);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDown.start();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                countDown.cancel();
                timerText.setText(dataFormat.format(0));
            }
        });
    }

    class CountDown extends CountDownTimer {
        CountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
            timerText.setText(dataFormat.format(0));
        }



        @Override
        public void onTick(long millisUntilFinished) {
            timerText.setText(dataFormat.format(millisUntilFinished));

        }
    }
}