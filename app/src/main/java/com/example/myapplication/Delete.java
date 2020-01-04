package com.example.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Delete extends AppCompatActivity implements View.OnClickListener {

    TextView name,email,pno,college;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        name = (TextView) findViewById(R.id.tv1);
        email = (TextView) findViewById(R.id.tv2);
        pno = (TextView) findViewById(R.id.tv3);
        college = (TextView) findViewById(R.id.tv4);
        delete = (Button) findViewById(R.id.bt1);


        final String in = getIntent().getStringExtra("name");
        Toast.makeText(getApplicationContext(), "" + in, Toast.LENGTH_SHORT).show();

        final SQLiteDatabase sb = openOrCreateDatabase("phonebook", MODE_PRIVATE, null);
        Cursor cr = sb.rawQuery("select * from phonenumber1 WHERE name ='" + in + "'", null);
        if (cr.moveToFirst()) {
            do {
                name.setText(cr.getString(0));
                pno.setText(cr.getString(1));
                email.setText(cr.getString(2));
                college.setText(cr.getString(3));


            } while (cr.moveToNext());
        } else {
            name.setText("No Record Found");
            pno.setText("No Record Found");
            email.setText("No Record Found");
            college.setText("No Record Found");

        }


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }