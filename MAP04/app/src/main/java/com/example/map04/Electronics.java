package com.example.map04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Electronics extends AppCompatActivity implements View.OnClickListener{

    ViewFlipper v;
    int amount;
    String product;

    ArrayList<String> productlist = new ArrayList<String>();
    ArrayList<Integer> amountlist = new ArrayList<Integer>();

    TextView countdowntext;
    static  ArrayList<String> finalElecItems = new ArrayList<>();
    Button addcartbutton;

    CountDownTimer countdown;
    long timeleft=600000;

    ImageButton mouse1,headphone1,charger1,phone1,mouse2,television1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);

        v = findViewById(R.id.flipper);
        addcartbutton = findViewById(R.id.addcartbutton);

        countdowntext = findViewById(R.id.timer);
        countdown = new CountDownTimer(timeleft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countdowntext.setText("Offer ends in- "+(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)))+":"
                        +(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))+"");
            }

            @Override
            public void onFinish() {

            }
        }.start();

        mouse1 = findViewById(R.id.mouse1);
        headphone1 = findViewById(R.id.headphone1);
        charger1 = findViewById(R.id.charger1);
        phone1 = findViewById(R.id.phone1);
        mouse2 = findViewById(R.id.mouse2);
        television1 = findViewById(R.id.television1);

        mouse1.setOnClickListener(this);
        headphone1.setOnClickListener(this);
        charger1.setOnClickListener(this);
        phone1.setOnClickListener(this);
        mouse2.setOnClickListener(this);
        television1.setOnClickListener(this);

        int images[] = {R.drawable.electronicsback,R.drawable.earphone1,R.drawable.laptop1};
        for(int i=0; i<images.length;i++){
            flipper(images[i]);
        }

        addcartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Electronics.this,Cart.class);
                for(int i=0; i<productlist.size();i++){
                    Electronics.finalElecItems.add(productlist.get(i)+" (Rs "+amountlist.get(i)+"/-)");
                }
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Electronics.this);
        switch (view.getId()){
            case R.id.mouse1:
                amount = 1199;
                product = "Mouse-1";
                break;
            case R.id.headphone1:
                amount = 999;
                product = "Headphones";
                break;
            case R.id.charger1:
                amount = 299;
                product = "Charger";
                break;
            case R.id.phone1:
                amount = 21999;
                product = "iPhone X";
                break;
            case R.id.mouse2:
                amount = 599;
                product = "Mouse-2";

                break;
            case R.id.television1:
                amount = 10999;
                product = "Television";
                break;

        }

        builder.setMessage("Add item to cart?"+"\nCOST:Rs."+amount).setPositiveButton("YES",  new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                productlist.add(product);
                amountlist.add(amount);
            }
        }).setNegativeButton("NO",null);
        AlertDialog alert = builder.create();
        alert.show();

    }

    public static ArrayList<String> getElecItems(){
        return finalElecItems;
    }

    public void flipper(int images){
        ImageView iv = new ImageView(Electronics.this);
        iv.setBackgroundResource(images);
        v.addView(iv);
        v.setFlipInterval(2000);
        v.setAutoStart(true);
        v.setInAnimation(Electronics.this,android.R.anim.slide_in_left);
    }
}
