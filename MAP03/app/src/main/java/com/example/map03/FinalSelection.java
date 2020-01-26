package com.example.map03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class FinalSelection extends AppCompatActivity {

    ArrayList<String> ekdamFinal = new ArrayList<String>();
    ListView my11List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_selection);

        my11List = (ListView) findViewById(R.id.my11List);

        Intent intent = getIntent();
        ekdamFinal.addAll(intent.getStringArrayListExtra("finalPlaying11"));

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(FinalSelection.this,R.layout.my_custom_list,ekdamFinal);
        my11List.setAdapter(adapter);
    }
}
