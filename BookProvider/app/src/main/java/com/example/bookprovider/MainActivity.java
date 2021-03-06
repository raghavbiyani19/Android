package com.example.bookprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;
import android.net.Uri;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnUpdate = (Button) findViewById(R.id.btnUpdate);
        final EditText etTitle=findViewById(R.id.txtTitle);
        final EditText etISBN=findViewById(R.id.txtISBN);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ContentValues editedValues = new ContentValues();
                Uri allTitles = Uri.parse("content://com.example.bookscontentprovider/books");
                editedValues.put("title", etTitle.getText().toString());
                getContentResolver().update(allTitles,editedValues,"isbn= '"+etISBN.getText().toString() +"' ",null);
            }
        });

        Button btnDelete = (Button) findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //---retrieve the titles---
                Uri allTitles = Uri.parse("content://com.example.user.bookscontentprovider/books");
                int i=getContentResolver().delete(allTitles,"isbn= '"+etISBN.getText().toString() +"' ", null);
                Toast.makeText(MainActivity.this,String.valueOf(i),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
