package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends AppCompatActivity {
TextView tv1,tv2,tv3,tv4;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tv1 = findViewById(R.id.name);
        tv2 = findViewById(R.id.pno);
        tv3=findViewById(R.id.email);
        tv4=findViewById(R.id.college);
        String in = getIntent().getStringExtra("name");
        Toast.makeText(this, ""+in, Toast.LENGTH_SHORT).show();
        SQLiteDatabase sb=openOrCreateDatabase("phonebook",MODE_PRIVATE,null);
        Cursor cr =sb.rawQuery("select * from phonenumber1 WHERE name ='"+in+"'",null);
        if(cr.moveToFirst())
        {
            do {
                tv1.setText(cr.getString(0));
                tv2.setText(cr.getString(1));
                tv3.setText(cr.getString(2));
                tv4.setText(cr.getString(3));


            }while (cr.moveToNext());
        }
        else {
            tv1.setText("No Record Found");
            tv2.setText("No Record Found");
            tv3.setText("No Record Found");
            tv4.setText("No Record Found");

        }
        }
    }

