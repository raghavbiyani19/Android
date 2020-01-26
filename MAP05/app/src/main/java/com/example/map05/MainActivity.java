package com.example.map05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView levelsList;
    String[] levels = {"LEVEL 01","LEVEL 02","LEVEL 03"};
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        levelsList = (ListView) findViewById(R.id.levelsList);
        adapter = new ArrayAdapter<String>(this,R.layout.mainlist,levels);
        levelsList.setAdapter(adapter);

        levelsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                        Toast.makeText(getApplicationContext(),"Selection: "+adapter.getItem(0),Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this,Level1.class);
                        intent.putExtra("LEVEL","**LEVEL 01**");
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"Selection: "+adapter.getItem(1),Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this,Level1.class);
                        intent.putExtra("LEVEL","**LEVEL 02**");
                        startActivity(intent);
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"Selection: "+adapter.getItem(2),Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this,Level1.class);
                        intent.putExtra("LEVEL","**LEVEL 03**");
                        startActivity(intent);
                        break;
                }
            }
        });

    }
}
