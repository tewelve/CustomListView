package com.project.customlistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by acer on 9/27/2017.
 */

public class ListActivityExample extends ListActivity {

    String subjects[]=new String[]{
            "Sept","Aug","July","may","march", "April","Feb", "Jan",     } ;

    ArrayList<CustomHandler> model= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity_example);
        for(int i=0; i<subjects.length; i++){
            CustomHandler handler= new CustomHandler();
            handler.setName(subjects[i]);
            handler.setDescription( subjects[i]);
            model.add(handler);
        }
        CustomAdapter adapter= new CustomAdapter(this, model);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this,subjects[position] + "\n "+ model.get(position).getDescription(), Toast.LENGTH_SHORT).show();
    }
}
