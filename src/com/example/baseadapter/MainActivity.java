package com.example.baseadapter;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView list = (ListView)findViewById(R.id.list);
        
        BaseAdapter adapter = new BaseAdapter() {
            
            //重写该方法，该方法返回的View将作为列表框
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout line = new LinearLayout(MainActivity.this);
                line.setOrientation(LinearLayout.VERTICAL);
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.ic_launcher);
                TextView textView = new TextView(MainActivity.this);
                textView.setText("The" + (position+1)  + " Item");
                textView.setTextSize(20);
                textView.setTextColor(Color.GREEN);
                line.addView(imageView);
                line.addView(textView);

                return line;
            }
            
            @Override
            public long getItemId(int position) {
                return position;
            }
            
            @Override
            public Object getItem(int position) {
                return null;
            }
            
            @Override
            public int getCount() {
                return 40;
            }
        };
        
        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
