package com.example.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edit extends AppCompatActivity {

    EditText name,college,email,pno;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        name=(EditText)findViewById(R.id.et1);
        pno=(EditText)findViewById(R.id.et2);
        email=(EditText)findViewById(R.id.et3);
        college=(EditText)findViewById(R.id.et4);
        update=(Button)findViewById(R.id.bt1);
        final String in = getIntent().getStringExtra("name");
        Toast.makeText(getApplicationContext(), ""+in, Toast.LENGTH_SHORT).show();

        final SQLiteDatabase sb=openOrCreateDatabase("phonebook",MODE_PRIVATE,null);
        Cursor cr =sb.rawQuery("select * from phonenumber1 WHERE name ='"+in+"'",null);
        if(cr.moveToFirst())
        {
            do {
                name.setText(cr.getString(0));
                pno.setText(cr.getString(1));
                email.setText(cr.getString(2));
                college.setText(cr.getString(3));


            }while (cr.moveToNext());
        }
        else {
            name.setText("No Record Found");
            pno.setText("No Record Found");
            email.setText("No Record Found");
            college.setText("No Record Found");

        }
        update.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sb.execSQL("Update phonenumber1 set pno='"+pno.getText().toString()+"',email='"+email.getText().toString()+"' where name='"+in+"'");
                sb.close();
                Toast.makeText(getApplicationContext(), "Data Updated", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
