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

public class Clothes extends AppCompatActivity implements View.OnClickListener{
    ViewFlipper v;
    int amount;
    String product;
    Intent intent ;
    Button addcartbutton;

    static ArrayList<String> finalClothItems = new ArrayList<>();
    ArrayList<String> productlist = new ArrayList<String>();
    ArrayList<Integer> amountlist = new ArrayList<Integer>();

    TextView countdowntext;

    CountDownTimer countdown;
    long timeleft=600000;

    ImageButton tshirt1,locket1,jeans1,bracelet1,glasses1,shoes1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);

        v = findViewById(R.id.flipper);
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

        tshirt1 = findViewById(R.id.tshirt1);
        locket1 = findViewById(R.id.locket1);
        jeans1 = findViewById(R.id.jeans1);
        shoes1 = findViewById(R.id.shoes1);
        bracelet1 = findViewById(R.id.bracelet1);
        glasses1 = findViewById(R.id.glasses1);
        addcartbutton = findViewById(R.id.addcartbutton);

        tshirt1.setOnClickListener(this);
        locket1.setOnClickListener(this);
        jeans1.setOnClickListener(this);
        shoes1.setOnClickListener(this);
        bracelet1.setOnClickListener(this);
        glasses1.setOnClickListener(this);
        intent= new Intent(Clothes.this,Cart.class);
        int images[] = {R.drawable.bracelet1,R.drawable.tshirt1,R.drawable.glasses1};
        for(int i=0; i<images.length;i++){
            flipper(images[i]);
        }


        addcartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clothes.this,Cart.class);
                for(int i=0; i<productlist.size();i++){
                    Clothes.finalClothItems.add(productlist.get(i)+" (Rs "+amountlist.get(i)+"/-)");
                }
                    startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Clothes.this);
                switch (view.getId()){
                    case R.id.tshirt1:
                        amount = 1199;
                        product = "White T-shirt";
                        break;
                    case R.id.locket1:
                        amount = 799;
                        product = "Locket";
                        break;
                    case R.id.jeans1:
                        amount = 2299;
                        product = "Blue Jeans";
                        break;
                    case R.id.shoes1:
                        amount = 2199;
                        product = "White Sneakers";
                        break;
                    case R.id.bracelet1:
                        amount = 599;
                        product = "Bracelet";
                        break;
                    case R.id.glasses1:
                        amount = 1099;
                        product = "Sunglasses";
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

    public static ArrayList<String> getClothItems(){
        return finalClothItems;
    }

            public void flipper(int images){
                ImageView iv = new ImageView(Clothes.this);
                iv.setBackgroundResource(images);
                v.addView(iv);
                v.setFlipInterval(2000);
                v.setAutoStart(true);
                v.setInAnimation(Clothes.this,android.R.anim.slide_in_left);
            }
    }