package com.example.map05;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class Level1 extends AppCompatActivity {

    TextView leveltxt,timer,equation,pointstxt;
    EditText answer;
    Button done;
    int points = 0;
    String rightAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        leveltxt = findViewById(R.id.leveltxt);
        timer = findViewById(R.id.timer);
        equation = findViewById(R.id.equation);
        answer =  findViewById(R.id.answer);
        done = findViewById(R.id.done);
        pointstxt = findViewById(R.id.pointstxt);


        ExampleAsync task = new ExampleAsync();

        Intent intent = getIntent();
        final String level = intent.getStringExtra("LEVEL");

        if(level.equalsIgnoreCase("**LEVEL 01**")){
            leveltxt.setText("**LEVEL 01**");
            timer.setText("60");
            task.execute(60);
            String question[] = frameQuestion(level);
            equation.setText(question[0]);
            rightAns = question[1];

        }
        else if(level.equalsIgnoreCase("**LEVEL 02**")){
            leveltxt.setText("**LEVEL 02**");
            timer.setText("80");
            task.execute(80);
            String question[] = frameQuestion(level);
            equation.setText(question[0]);
            rightAns = question[1];
        }
        else if(level.equalsIgnoreCase("**LEVEL 03**")){
            leveltxt.setText("**LEVEL 03**");
            timer.setText("100");
            task.execute(100);
            String question[] = frameQuestion(level);
            equation.setText(question[0]);
            rightAns = question[1];
        }
        else{

        }

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userAnswer = answer.getText().toString();
                System.out.println(""+userAnswer);
                System.out.println(""+rightAns);
                if(rightAns.equalsIgnoreCase((String) userAnswer)){
                    points = points + 1;
                    Toast.makeText(getApplicationContext(),"CORRECT!!",Toast.LENGTH_SHORT).show();
                    pointstxt.setText("Score: "+points);
                    String question[] = frameQuestion(level);
                    equation.setText(question[0]);
                    rightAns= question[1];
                    answer.setText("");
                }
                else {
                    Toast.makeText(getApplicationContext(), "INCORRECT!! TRY AGAIN..", Toast.LENGTH_SHORT).show();
                    answer.setText("");
                }

            }
        });

    }

    public String[] frameQuestion(String level){

        Random r = new Random();
        int num1 = r.nextInt(99);
        int num2 = r.nextInt(99);
        int num3 = r.nextInt(99);
        int num4 = r.nextInt(99);

        String operator[]={"","","",""};
        for(int i=0; i<3;i++){
            int n = r.nextInt(4);
            switch(n){
                case 0:
                    operator[i] = "+";
                    break;
                case 1:
                    operator[i] = "-";
                    break;
                case 2:
                    operator[i] = "*";
                    break;
                case 3:
                    operator[i] = "/";
                    break;
            }
        }

        String question[]={"",""};
        String Myquestion="";
        int MyAnswer=0;

        if(level.equalsIgnoreCase("**LEVEL 01**")){
            Myquestion = ""+num1+" "+operator[0]+" "+num2+"";
            MyAnswer= EvaluateString.evaluate(Myquestion);
        }
        else if(level.equalsIgnoreCase("**LEVEL 02**")){
            Myquestion = ""+num1+" "+operator[0]+" "+num2+" "+operator[1]+" "+num3+"";
            MyAnswer=EvaluateString.evaluate(Myquestion);
        }
        else if(level.equalsIgnoreCase("**LEVEL 03**")){
            Myquestion = ""+num1+" "+operator[0]+" "+num2+" "+operator[1]+" "+num3+" "+operator[2]+" "+num4+"";
            MyAnswer=EvaluateString.evaluate(Myquestion);
        }
        else{
            Myquestion = ""+num1+" "+operator[0]+" "+num2+"";
            MyAnswer=EvaluateString.evaluate(Myquestion);
        }
        question[0]=Myquestion;
        question[1]=Integer.toString(MyAnswer);
        return question;
    }


    private class  ExampleAsync extends AsyncTask<Integer, Integer, String>{

        private int seconds;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            seconds = integers[0];
            while(seconds!=0) {
                try {
                    Thread.sleep(1000);
                    seconds--;
                    publishProgress(seconds);
                } catch (Exception e) {

                }
            }
            return "Finished";
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            timer.setText("TIME OVER");
            done.setEnabled(false);
            AlertDialog.Builder builder = new AlertDialog.Builder(Level1.this);
            builder.setMessage("Score:"+points);
            AlertDialog alert = builder.create();
            alert.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            timer.setText(""+seconds);
        }
    }
}
