package com.example.mytimepass;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar) findViewById(R.id.pb);
        pb.setProgress(0);
        new Thread(new Task()).start();

    }

    class Task implements Runnable{
        @Override
        public void run() {

        }
    }
}

