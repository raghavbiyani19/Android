package com.example.map04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button shopbycategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shopbycategory = (Button) findViewById(R.id.shopbycategory);

        registerForContextMenu(shopbycategory);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_main, menu);
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.shop_context_menu, menu);
        menu.setHeaderTitle("Select Category.");
    }

    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==R.id.clothing){
            Intent intent = new Intent(MainActivity.this,Clothes.class);
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.electronics){
            Intent intent = new Intent(MainActivity.this,Electronics.class);
            startActivity(intent);
        }else{
            return false;
        }
        return true;
    }



    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cart:
                Intent optionintent = new Intent(MainActivity.this,Cart.class);
                startActivity(optionintent);
                return true;
            case R.id.logout:
                Toast.makeText(getApplicationContext(),"Logging out!!",Toast.LENGTH_SHORT).show();
                return true;

            case  R.id.share:
                Toast.makeText(getApplicationContext(),"Shared",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.aboutus:
                Toast.makeText(getApplicationContext(),"About us",Toast.LENGTH_SHORT).show();
            default:
                return super.onContextItemSelected(item);
        }
    }

}
