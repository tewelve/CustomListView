package com.project.customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by acer on 9/27/2017.
 */

public class CustomListView extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView list;
    String subjects[]=new String[]{
            "Jan", "Feb", "march", "April","may", "June", "July", "Aug", "Sept",    } ;
    ArrayList<CustomHandler> model= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list= (ListView)findViewById(R.id.list);
        for(int i=0; i<subjects.length; i++){
            CustomHandler handler= new CustomHandler();
            handler.setName(subjects[i]);
            handler.setDescription( subjects[i]);
            model.add(handler);
        }
        CustomAdapter adapter= new CustomAdapter(this, model);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,subjects[position], Toast.LENGTH_SHORT).show();
    }
}

