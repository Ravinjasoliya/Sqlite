package com.example.ravin.sqliteravin;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends AppCompatActivity {
    EditText no,pwd,city;
    Button inserta;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
            no=(EditText)findViewById(R.id.txtno);
            pwd=(EditText)findViewById(R.id.txtname);
            city=(EditText)findViewById(R.id.txtcity);

            inserta=(Button)findViewById(R.id.btnInsert);
            inserta .setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SqlHelper sqlHelper=new SqlHelper(Insert.this);
                    MyBean myBean =new MyBean();
                    myBean.setNo(no.getText().toString());
                    myBean.setPwd(pwd.getText().toString());
                    myBean.setCity(city.getText().toString());
                    sqlHelper.insertData(myBean);
                    Toast.makeText(Insert.this, "Data Inserted succse..", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Insert.this,Display.class));

                }
            });
    }
}
