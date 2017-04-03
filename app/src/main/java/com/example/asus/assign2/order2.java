package com.example.asus.assign2;

/**
 * Created by ASUS on 02-04-2017.
 */
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;



public class order2 extends AppCompatActivity {

    TextView totaltext;
    String n[]=new String[100];
    String q[]=new String[100];
    String p[]=new String[100];
    LeafyDBhelper helper;
    Cursor cursor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.neworder2);
        totaltext=(TextView)findViewById(R.id.total);
        ScrollView sv=(ScrollView)findViewById(R.id.sv);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        helper=new LeafyDBhelper(this);
        sv.addView(ll);



        cursor=helper.getAllData();
        int i;
        if(cursor.getCount()==0)
            Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show();
            //inserting data into the array
        else{
            i=0;
            while(cursor.moveToNext() && i<100){
                n[i]=cursor.getString(1);
                p[i]=cursor.getString(4);
                q[i]=cursor.getString(5);
                ++i;
            }
        }
        int total=0;
        for(i=0;i<100;++i){
            total+=Integer.parseInt(q[i])*Integer.parseInt(p[i]);
            if(Integer.parseInt(q[i])>0){
                LinearLayout l2 = new LinearLayout(this);
                l2.setOrientation(LinearLayout.HORIZONTAL);
                ll.addView(l2);
                TextView nametext = new TextView(this);
                nametext.setTextSize(20);
                nametext.setText("          "+n[i]+"          ");
                l2.addView(nametext);
                TextView pricetext = new TextView(this);
                pricetext.setTextSize(20);
                pricetext.setText("         "+(p[i])+"          ");
                l2.addView(pricetext);
                TextView qtytext = new TextView(this);
                qtytext.setTextSize(20);
                qtytext.setText("           "+(q[i]));
                l2.addView(qtytext);


            }
        }
        totaltext.setText(Integer.toString(total));

    }
}