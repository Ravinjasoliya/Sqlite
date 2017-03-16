package com.example.ravin.sqliteravin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ravin on 17/01/2017.
 */

public class Adpt extends BaseAdapter {
    Context context;
    ArrayList<MyBean> arrayList;

    public Adpt(Context context,ArrayList<MyBean> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=layoutInflater.inflate(R.layout.layout,null);


        TextView no= (TextView)view.findViewById(R.id.no);
        TextView name= (TextView)view.findViewById(R.id.name);
        TextView pwd= (TextView)view.findViewById(R.id.pwd);

        MyBean myBean=arrayList.get(position);
        no.setText(myBean.getNo());
        name.setText(myBean.getCity());
        pwd.setText(myBean.getPwd());

        return view;
    }
}
