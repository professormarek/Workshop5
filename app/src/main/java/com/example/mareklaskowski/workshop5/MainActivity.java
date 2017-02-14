package com.example.mareklaskowski.workshop5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //just to mix things up let's declare an array of icons that matches the order of descriptions
    public static int[] images = {R.drawable.facebook, R.drawable.google, R.drawable.seneca};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //let's get an array of descriptions from xml (string-array resource)
        String[] descriptions = getResources().getStringArray(R.array.description_array);
        //in order to set up our listview we also need an ArrayAdaptor
        //this array Adaptor needs to use our custom_list layout.
        //Therefore we need to create a custom ArrayAdaptor class

        //get a reference to our ListView so that we can associate it with our custom ArrayAdapter
        ListView listView = (ListView) findViewById(R.id.listView);
        //create a new MyCustomAdapter
        MyCustomAdapter myCustomAdapter = new MyCustomAdapter(this, descriptions, images);
        //connect the ListView with myCustomAdapter
        listView.setAdapter(myCustomAdapter);
    }
}
