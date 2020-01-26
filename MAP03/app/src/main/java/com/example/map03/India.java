package com.example.map03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class India extends AppCompatActivity {

    private  final String CHANNEL_ID = "Personal Notification";
    private final int NOTIFICATION_ID = 001;
    ListView indiaList;
    int count=0;
    Button done;
    ArrayList<String> indiaPlayers = new ArrayList<String>();
    ArrayList<String> selectedPlayers = new ArrayList<String>();
    String[] players = {"Rohit","Dhawan","VIRAT (C)","KL RAHUL","MS DHONI","Pandya","Jadeja","Chahal","Kuldeep","Bumrah","Bhuvneshwar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india);

        indiaList = (ListView) findViewById(R.id.indialist);
        done = (Button) findViewById(R.id.done);

        for (int i=0; i<players.length; i++){
            indiaPlayers.add(players[i]);
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.my_custom_list,indiaPlayers);
        indiaList.setAdapter(adapter);

        Intent countIntent = getIntent();
        count = countIntent.getIntExtra("Count",0);

        indiaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(count == 11){
                    Toast.makeText(getApplicationContext(),"MAX LIMIT REACHED",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(count==10){
                        createNotifChannel();

                        NotificationCompat.Builder builder = new NotificationCompat.Builder(India.this,CHANNEL_ID);
                        builder.setSmallIcon(R.drawable.cric2);
                        builder.setContentTitle("PLAYERS SELECTION!!");
                        builder.setContentText("Your XI is ready");
                        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

                        NotificationManagerCompat notifManager = NotificationManagerCompat.from(India.this);
                        notifManager.notify(NOTIFICATION_ID,builder.build());
                    }
                    if (selectedPlayers.contains(adapter.getItem(i))) {
                        Toast.makeText(getApplicationContext(), "Already Selected", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Selection: " + adapter.getItem(i), Toast.LENGTH_SHORT).show();
                        selectedPlayers.add(adapter.getItem(i));
                        count++;
                    }
                }
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("Count",count);
                resultIntent.putStringArrayListExtra("partialSelection",selectedPlayers);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });

    }
    private void createNotifChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            CharSequence name = "Personal Notification";
            String description ="Include personal notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notifChannel = new NotificationChannel(CHANNEL_ID,name,importance);
            notifChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notifChannel);

        }
    }
}
