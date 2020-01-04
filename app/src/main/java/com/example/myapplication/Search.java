package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import static com.example.myapplication.R.id.et1;

public class Search extends AppCompatActivity implements View.OnClickListener {


    EditText et1;
    Button bt2;
    LinearLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        et1=(EditText)findViewById(R.id.et1);
        bt2=(Button)findViewById(R.id.bt2);
        l1 = findViewById(R.id.l1);
        bt2.setOnClickListener(this);



    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater mi=this.getMenuInflater();
        mi.inflate(R.menu.holdmenu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.det)
        {
            Intent in =new Intent(Search.this,Details.class);
            in.putExtra("name",et1.getText().toString());
            startActivity(in);
        }
       // if(item.getItemId()==R.id.ac){
         //   Intent n =new Intent(FirstActivity.this, MainActivity.class);
           // startActivity(n);



        else if(item.getItemId()==R.id.ed)
        {

            Intent in =new Intent(Search.this,Edit.class);
            in.putExtra("name",et1.getText().toString());
            startActivity(in);

        }
        else
        {

            Intent in =new Intent(Search.this,Delete.class); ;
            startActivity(in);
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase sb=openOrCreateDatabase("phonebook",MODE_PRIVATE,null);

//        db.execSQL("insert into phonenumber1 values('"+et1.getText().toString()+"','"+et2.getText().toString()+"','"+et3.getText().toString()+"','"+et4.getText().toString()+"')");

        Cursor cr =sb.rawQuery("select * from phonenumber1 WHERE name ='"+et1.getText().toString()+"'",null);
        if(cr.moveToFirst())
        {
            do {
                TextView tv =new TextView(Search.this);  //
                tv.setText(cr.getString(0)+"-"+cr.getString(1)+"-"+cr.getString(2)+"-"+cr.getString(3));
                l1.addView(tv);
                registerForContextMenu(tv); //tv ko register kiya for long press
            }while (cr.moveToNext());
        }
        else {
            TextView tv=new TextView(Search.this);
            tv.setText("No Record Found");
            l1.addView(tv);
        }
    }

}
