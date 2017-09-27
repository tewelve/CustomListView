package com.project.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by acer on 9/27/2017.
 */
public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<CustomHandler> data;
    LayoutInflater inflater;


    public CustomAdapter(Context context, ArrayList<CustomHandler> data){
        this.context=context;
        this.data= data;
        inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return data.size();
    }


    @Override
    public Object getItem(int position) {
        return data.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView= inflater.inflate(R.layout.custom_row, parent, false);
            holder= new ViewHolder();
            holder.view= (TextView)convertView.findViewById(R.id.view);
            holder.text= (TextView)convertView.findViewById(R.id.text);
           holder.description= (TextView)convertView.findViewById(R.id.description);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder)convertView.getTag();
        }
        holder.text.setText(data.get(position).getName());
        holder.description.setText(data.get(position).getDescription());
        return convertView;
    }


    public class ViewHolder{
        TextView view;
        TextView text, description;
    }
}
