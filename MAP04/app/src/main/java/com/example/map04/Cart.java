package com.example.map04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    ArrayList<String> listElec = new ArrayList<String>();
    ArrayList<String> listCloth = new ArrayList<>();
    ListView cartlist;
    ArrayList<String> finallist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartlist = (ListView) findViewById(R.id.cartlist);

        listCloth = Clothes.getClothItems();
        listElec = Electronics.getElecItems();

        for(int i =0; i<listElec.size();i++){
            if(!(finallist.contains(listElec.get(i)))){
                finallist.add(listElec.get(i));
            }
        }

        for(int i =0; i<listCloth.size();i++){
            if(!(finallist.contains(listCloth.get(i)))){
                finallist.add(listCloth.get(i));
            }
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.cartlistview,finallist);
        cartlist.setAdapter(adapter);
    }
}
