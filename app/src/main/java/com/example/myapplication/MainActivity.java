package com.example.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   EditText et1,et2,et3,et4;
   Button bt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        bt1=(Button)findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        SQLiteDatabase db=openOrCreateDatabase("phonebook",MODE_PRIVATE,null);
        db.execSQL("Create table if not exists phonenumber1(name varchar,pno varchar,email varchar,college varchar)");
        db.execSQL("insert into phonenumber1 values('"+et1.getText().toString()+"','"+et2.getText().toString()+"','"+et3.getText().toString()+"','"+et4.getText().toString()+"')");
        db.close();
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }
}
