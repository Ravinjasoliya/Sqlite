package com.example.ravin.sqliteravin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Display extends AppCompatActivity {

    ListView listView;
    ArrayList<MyBean> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        listView=(ListView)findViewById(R.id.list1);
        final SqlHelper sqlHelper=new SqlHelper(Display.this);


        arrayList=new ArrayList<>();
        arrayList=sqlHelper.displayData();

         Adpt adpt=new Adpt(Display.this,arrayList);

       // ArrayAdapter arrayAdapter=new ArrayAdapter(Display.this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adpt);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              //  Toast.makeText(Display.this, "val="+arrayList.get(position).getCity(), Toast.LENGTH_SHORT).show();
                sqlHelper.delete(arrayList.get(position).getCity());
                Toast.makeText(Display.this, "Deleted", Toast.LENGTH_SHORT).show();
                arrayList=sqlHelper.displayData();
                Adpt adpt=new Adpt(Display.this,arrayList);
                listView.setAdapter(adpt);
            }
        });


    }
}
