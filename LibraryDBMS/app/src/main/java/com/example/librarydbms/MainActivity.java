package com.example.librarydbms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.done);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send send = new send();
                send.execute();
            }
        });

    }
}

class send extends AsyncTask<Void,Void,Void>{

    Socket s;
    PrintWriter pw;
    BufferedReader input;

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            s= new Socket("192.168.43.178",8000);
            pw=new PrintWriter(s.getOutputStream());
            pw.write("HEYYYYYY");
            pw.flush();
            pw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}