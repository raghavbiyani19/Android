package com.example.map02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button zero, one, two, three, four, five, six,
            seven, eight, nine, add, minus, div,
            mul, clear, equalto;

    EditText expression;

    static char[] express;
    static int len,addn=0,multn=0,divn=0,subn=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        add  = (Button) findViewById(R.id.add);
        minus = (Button) findViewById(R.id.minus);
        div = (Button) findViewById(R.id.div);
        mul = (Button) findViewById(R.id.mul);
        equalto = (Button) findViewById(R.id.equalto);
        clear = (Button) findViewById(R.id.clear);
        expression = (EditText) findViewById(R.id.expression);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.setText(expression.getText() + "9");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (expression == null) {
                    expression.setText("");
                } else {
                    expression.setText(expression.getText() + "+");
                    addn++;
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (expression == null) {
                    expression.setText("");
                } else {
                    expression.setText(expression.getText() + "-");
                    subn++;
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (expression == null) {
                    expression.setText("");
                } else {
                    expression.setText(expression.getText() + "/");
                    divn++;
                }
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (expression == null) {
                    expression.setText("");
                } else {
                    expression.setText(expression.getText() + "*");
                    multn++;
                }
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.setText("");
            }
        });

        equalto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String copy = expression.getText().toString();
                express = copy.toCharArray();
                len = express.length;
                int i=0,div,mult,add,sub;

                i=0;
                while(len!=1)
                {
                    while(divn!=0)
                    {
                        i++;
                        if(express[i]=='/')
                        {
                            divn--;
                            divide(i);
                            i=0;
                        }
                    }
                    while(multn!=0)
                    {
                        i++;
                        if(express[i]=='*')
                        {
                            multn--;
                            mult(i);
                            i=0;
                        }
                    }
                    while(addn!=0)
                    {
                        i++;
                        if(express[i]=='+')
                        {
                            addn--;
                            sum(i);
                            i=0;
                        }
                    }
                    while(subn!=0)
                    {
                        i++;
                        if(express[i]=='-')
                        {
                            subn--;
                            sub(i);
                            i=0;
                        }
                    }
                }
                System.out.println((int)(express[0]-48));
                //express[0]=(int)express[0]-48;
                expression.setText(""+ (int)(express[0]-48));
            }
        });



    }
    public static void divide(int i)
    {
        int result,j;
        result=((int)(express[i-1])-48)/((int)(express[i+1])-48);
        result=result+48;
        express[i-1]=(char)result;
        for(j=i;j<len-2;j++)
        {
            express[j]=express[j+2];
        }
        len=len-2;
    }

    public static void sum(int i)
    {
        int result,j;
        result=((int)express[i-1]-48)+(int)express[i+1]-48;
        result=result+48;
        express[i-1]=(char)result;
        for(j=i;j<len-2;j++)
        {
            express[j]=express[j+2];
        }
        len=len-2;
    }

    public static void sub(int i)
    {
        int result,j;
        result=(int)express[i-1]-(int)express[i+1];
        result=result+48;
        express[i-1]=(char)result;
        for(j=i;j<len-2;j++)
        {
            express[j]=express[j+2];
        }
        len=len-2;
    }

    public static void mult(int i)
    {
        int result,j;
        result=(((int)express[i-1]) -48)*(((int)express[i+1])-48);
        result=result+48;
        express[i-1]=(char)result;
        for(j=i;j<len-2;j++)
        {
            express[j]=express[j+2];
        }
        len=len-2;
    }
}
