package com.tutorials180.simplearrayadapterproejctwithlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView objectListView;
    private String [] weekDays={"Monday","Tuesday","Wednesday"
    ,"Thursday","Friday","Saturday","Sunday",
            "Monday","Tuesday","Wednesday"
            ,"Thursday","Friday","Saturday","Sunday",
            "Monday","Tuesday","Wednesday"
            ,"Thursday","Friday","Saturday","Sunday",
            "Monday","Tuesday","Wednesday"
            ,"Thursday","Friday","Saturday","Sunday"};

    private ArrayAdapter<String> objectStringArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connectXMLViewsWithJavaViews();
        customizedLayoutWithSimpleArrayAdapter();
    }

    private void connectXMLViewsWithJavaViews()
    {
      try
      {
          objectListView=findViewById(R.id.LV);
          objectStringArrayAdapter=new ArrayAdapter<>(
                  this,
                  android.R.layout.simple_list_item_1,
                  weekDays
          );


          objectListView.setAdapter(objectStringArrayAdapter);
          objectListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> adapterView, View view, int listPosition, long l) {

                  Toast.makeText(MainActivity.this, "Position Clicked:"
                          +listPosition, Toast.LENGTH_SHORT).show();
              }
          });
      }
      catch (Exception e)
      {
          Toast.makeText(this, "connectXMLViewsWithJavaViews" +
                  ":"+e.getMessage(), Toast.LENGTH_SHORT).show();
      }
    }

    private void customizedLayoutWithSimpleArrayAdapter()
    {
        try
        {
            objectListView=findViewById(R.id.LV);
            objectStringArrayAdapter=new ArrayAdapter<>(
                    this,
                    R.layout.single_row,
                    R.id.singleRow_TV
                    ,
                    weekDays
            );


            objectListView.setAdapter(objectStringArrayAdapter);
            objectListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int listPosition, long l) {

                    TextView tempTV=view.findViewById(R.id.singleRow_TV);
                    Toast.makeText(MainActivity.this, "Text is:"
                            +tempTV.getText().toString()
                            +" and position is:"
                            +listPosition, Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(this, "connectXMLViewsWithJavaViews" +
                    ":"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
