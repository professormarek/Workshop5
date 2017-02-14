package com.example.mareklaskowski.workshop5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by marek.laskowski on 2/14/2017.
 */

public class MyCustomAdapter extends BaseAdapter {
    //let's declare some instance variables to hold essential data
    String[] desciptions;
    int [] images;
    Context context;

    //constructor to set up our instance variables
    public MyCustomAdapter(MainActivity c, String[] d, int[] i){
        context = c;
        desciptions = d;
        images = i;
    }
    @Override
    public int getCount() {
        return desciptions.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /*
    the android framework will call getView every time it needs to draw you ListView
    int position indicates which row the framework is trying to draw
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row; //a reference to refer to each row
        //LayoutInflater is a class that creates a Java object from the xml layout
        //we get a LayoutInflater from the framework by calling getSystemService
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //use the LayoutInflater to create a new View of the correct type (custom_list)
        row = inflater.inflate(R.layout.custom_list, null);
        //get the TextView and set its text!
        TextView textView = (TextView) row.findViewById(R.id.textView);
        textView.setText(desciptions[position]);
        //get the ImageView and set its image icon
        ImageView imageView = (ImageView) row.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        //we need to add an OnClickListener to respond to user clicks!
        row.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //for now show a toast.. later you will broadcast an intent to start the Web Browser
                Toast.makeText(context, desciptions[position], Toast.LENGTH_LONG).show();
            }
        });
        //don't forget to return a view!
        return row;
    }
}
