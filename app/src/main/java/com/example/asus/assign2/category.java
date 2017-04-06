package com.example.asus.assign2;

/**
 * Created by ASUS on 02-04-2017.
 */
import android.app.TabActivity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class category extends AppCompatActivity implements View.OnClickListener {

    TextView cat1,cat2,button1;
    LeafyDBhelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen2);

        cat1 = (TextView) findViewById(R.id.textView3);
        cat2 = (TextView) findViewById(R.id.textView4);
        button1 = (TextView)findViewById(R.id.textView9);

        cat1.setOnClickListener(this);
        cat2.setOnClickListener(this);

        helper = new LeafyDBhelper(this);



    }


    @Override
    public void onClick(View view) {
        String message=null;
        Intent intent=new Intent(category.this,tab_act.class);
        switch(view.getId()){
            case R.id.textView3:
                message="1";
                intent.putExtra("message", message);
                startActivity(intent);
                break;
            case R.id.textView4:
                message="2";
                intent.putExtra("message", message);
                startActivity(intent);
                break;
        }
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {               // this is for the refresh button in screen 2
                for(int i=1;i<=100;++i){
                    helper.updateQty(i+"",0+"");        // updating the quantities to 0

                }
                Toast.makeText(getApplicationContext(),"done",Toast.LENGTH_SHORT).show();
            }
        });

    }

}