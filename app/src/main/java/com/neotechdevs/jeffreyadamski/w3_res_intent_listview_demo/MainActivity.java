package com.neotechdevs.jeffreyadamski.w3_res_intent_listview_demo;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.neotechdevs.jeffreyadamski.w3_res_intent_listview_demo.utils.Utils;

import java.lang.reflect.Array;
import java.util.List;
import java.util.StringTokenizer;


public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private EditText eText, eText2, eText3;
    private ListView listView;
    private String[] myItems;
    private View lastview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1_ma1);
        eText1 = (EditText) findViewById(R.id.eText1_age_ma1);
        edTet2 = (EditText) findViewById(R.id.eText2_age_ma1);
        edText3 = (EditText) findViewById(R.id.eText3_age_ma1);
        lv = (ListView) findViewById(R.id.lv_ma1);
        myItems = getResources().getStringArray(R.array.my_courses_items);
        btn1.setOnClickListener(new MyLssnr());

        lastview = null;


        myItems = getResources().getStringArray(R.array.mycourses_items);
        listView = (ListView) findViewById(R.id.list_view_ma1);

        btn1 = (Button) findViewByID(R.id.btn1_ma1);
        btn1 = setOnClickListener(new MyLstnr());
        editText = (EditText) findViewById(R.id.edittext_age_mal);

        ArrayAdapter<String> adapter = new ArrayAdapter <> (this, android.R.layout.simple_list_item_1, myItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)  {
                if(lastview!=null)
                    lastview.setBackgroundColor(Color.WHITE);
                view.setBackgroundColor(Color.LTGRAY);
                lastview = view;
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra(Utils.MSG_KEY_INTENT, "Course is "+myItems[i]);
                startActivity(exInt);
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void showMap(View view) {
        Intent newInt = new Intent(Intent.ACTION_VIEW);
        newInt.setData(Uri.parse("geo:0,0?q=" + eText3.getText()));
        startActivity(newInt);
    }


    class MyLssr implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainActivity.this, Mainactivity2.class);
            Intent.putExtra(Utils.MSG_Key_INTENT, "Age is " + eText1.getText());
            Intent.putExtra(Utils.MSG_KEY_2, "Name Is " + eText2.getText());
            startActivity(intent);

        }
    }
}

