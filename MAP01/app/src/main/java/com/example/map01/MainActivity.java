package com.example.map01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    Button rbutton,bbutton,gbutton;
    LinearLayout mylayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbutton = (Button) findViewById(R.id.rbutton);
        bbutton = (Button) findViewById(R.id.bbutton);
        gbutton = (Button) findViewById(R.id.gbutton);
        mylayout = (LinearLayout) findViewById(R.id.mylayout);

        rbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylayout.setBackgroundColor(Color.RED);
                rbutton.setTextColor(Color.RED);
                rbutton.setTextSize(40);
                bbutton.setTextSize(20);
                gbutton.setTextSize(20);
                bbutton.setTextColor(Color.BLACK);
                gbutton.setTextColor(Color.BLACK);
            }
        });

        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylayout.setBackgroundColor(Color.BLUE);
                bbutton.setTextColor(Color.BLUE);
                bbutton.setTextSize(40);
                rbutton.setTextSize(20);
                gbutton.setTextSize(20);
                rbutton.setTextColor(Color.BLACK);
                gbutton.setTextColor(Color.BLACK);
            }
        });

        gbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylayout.setBackgroundColor(Color.GREEN);
                gbutton.setTextColor(Color.GREEN);
                gbutton.setTextSize(40);
                bbutton.setTextSize(20);
                rbutton.setTextSize(20);
                bbutton.setTextColor(Color.BLACK);
                rbutton.setTextColor(Color.BLACK);
            }
        });
    }
}
