package com.example.asus.assign2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.content.Intent;
import android.database.Cursor;



public class MainActivity extends AppCompatActivity {

    //Declaring the textviews
    TextView newOrder,orderPlaced,button1;
    LeafyDBhelper helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newOrder = (TextView)findViewById(R.id.textView);
        orderPlaced=(TextView)findViewById(R.id.textView2);


        helper = new LeafyDBhelper(this);

        Cursor cursor=helper.getAllData();
        if(cursor.getCount()==0) {

            //setting up the database by inserting values
            for (int i = 1; i <= 100; ++i) {
                int randprice = (int) (Math.random() * 100 + 1);   // random function

                if (i <= 17) {
                    helper.insertData("A" + i, "1", "A", Integer.toString(randprice), "0");
                } else if (i <= 34) {
                    helper.insertData("A" + i, "2", "A", Integer.toString(randprice), "0");
                } else if (i <= 17 * 3) {
                    helper.insertData("A" + i, "1", "B", Integer.toString(randprice), "0");
                } else if (i <= 17 * 4) {
                    helper.insertData("A" + i, "2", "B", Integer.toString(randprice), "0");
                } else if (i <= 17 * 5) {
                    helper.insertData("A" + i, "1", "C", Integer.toString(randprice), "0");
                } else {
                    helper.insertData("A" + i, "2", "C", Integer.toString(randprice), "0");
                }

            }
        }


        newOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderPlaced.setClickable(true);
                Intent intent=new Intent(MainActivity.this,category.class);
                startActivity(intent);
            }
        });
        orderPlaced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,order2.class);
                startActivity(intent);
            }
        });




    }
}