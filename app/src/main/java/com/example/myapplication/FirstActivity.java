package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class FirstActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi=this.getMenuInflater();
        mi.inflate(R.menu.mymenu,menu);
        //inflate means lagana ,or resourse(R) me menu me jakar mymenu menu type ka bana do
       //inflate means xml file ko java file me link krne ke liye use krte h
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.ac){
            Intent n =new Intent(FirstActivity.this, MainActivity.class);
            startActivity(n);
        }
        if(item.getItemId()==R.id.sc){
            Intent n=new Intent(FirstActivity.this,Search.class);
            startActivity(n);
        }


        return super.onOptionsItemSelected(item);
    }
}
