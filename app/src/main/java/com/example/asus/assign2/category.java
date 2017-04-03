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

    TextView cat1,cat2;
    LeafyDBhelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen2);

        cat1=(TextView)findViewById(R.id.textView3);
        cat2=(TextView)findViewById(R.id.textView4);

        cat1.setOnClickListener(this);
        cat2.setOnClickListener(this);
        //this constructor creates the data base in our phone
        helper=new LeafyDBhelper(this);
        //delete all data previously present in the table so that repetion doesn't occur
        helper.deleteAll();
        //inserting the data in the database
        for(int i=1;i<100;++i){
            int randprice=(int )(Math. random() * 100 + 1);

            if(i<=17)
                helper.insertData("A"+i,"1","A",Integer.toString(randprice),"0");
            else if(i<=34)
                helper.insertData("A"+i,"1","B",Integer.toString(randprice),"0");
            else if(i<=51)
                helper.insertData("A"+i,"1","C",Integer.toString(randprice),"0");
            else if(i<=68)
                helper.insertData("A"+i,"2","A",Integer.toString(randprice),"0");
            else if(i<=85)
                helper.insertData("A"+i,"2","B",Integer.toString(randprice),"0");
            else
                helper.insertData("A"+i,"2","C",Integer.toString(randprice),"0");

        }
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
    }
}