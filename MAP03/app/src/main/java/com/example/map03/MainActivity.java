package com.example.map03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView teamsList;
    TextView playersLeft;
    ArrayList<String> teams = new ArrayList<String>();
    ArrayList<String> finalSelection = new ArrayList<String>();
    int count=0;
    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playersLeft = (TextView) findViewById(R.id.playersLeft);
        teamsList = (ListView) findViewById(R.id.teamsList);
        show = (Button) findViewById(R.id.show);

        teams.add("1. INDIA");
        teams.add("2. AUSTRALIA");
        teams.add("3. ENGLAND");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.my_custom_list,teams);
        teamsList.setAdapter(adapter);


        teamsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch(i){
                    case 0:
                           Toast.makeText(getApplicationContext(),"Selection: "+adapter.getItem(0),Toast.LENGTH_SHORT).show();
                           intent = new Intent(MainActivity.this,India.class);
                           intent.putExtra("Count",count);
                           startActivityForResult(intent,99);
                           break;
                    case 1:
                           Toast.makeText(getApplicationContext(),"Selection: "+adapter.getItem(1),Toast.LENGTH_SHORT).show();
                           intent = new Intent(MainActivity.this,Australia.class);
                           intent.putExtra("Count",count);
                           startActivityForResult(intent,99);
                           break;
                    case 2:
                           Toast.makeText(getApplicationContext(),"Selection: "+adapter.getItem(2),Toast.LENGTH_SHORT).show();
                           intent = new Intent(MainActivity.this,England.class);
                           intent.putExtra("Count",count);
                           startActivityForResult(intent,99);
                           break;
                }
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("View final XI?").setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this,FinalSelection.class);
                        intent.putStringArrayListExtra("finalPlaying11",finalSelection);
                        startActivity(intent);
                    }
                }).setNegativeButton("NO", null);

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==99 && data!=null){
                finalSelection.addAll(data.getStringArrayListExtra("partialSelection"));
                count =data.getIntExtra("Count",0);
                playersLeft.setText("Players Left: "+ (11-count));
            }
        }
    }
}

