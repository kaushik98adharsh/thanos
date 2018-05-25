package com.example.kaushikadharsh.gauntlet;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Delayed;

public class MainActivity extends AppCompatActivity {
    int a=0,b=0,c=0,d=0,e=0,f=0;
     ArrayList<String> arrayList;
     ArrayAdapter<String> adapter;
    String stones;
    ListView mylist;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.textView);
        mylist = (ListView) findViewById(R.id.list);
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        mylist.setAdapter(adapter);
        final int stonearray[] = {R.drawable.power_stone, R.drawable.mind_stone, R.drawable.reality_stone, R.drawable.time_stone, R.drawable.space_stone, R.drawable.soul_stone},
                colorarray[] = {Color.rgb(128, 0, 128), Color.rgb(255, 255, 0), Color.rgb(220, 20, 60), Color.rgb(46, 139, 87), Color.rgb(0, 0, 225), Color.rgb(255, 165, 0)};
        final RelativeLayout mylayout = (RelativeLayout) findViewById(R.id.motherlayout);
        final ImageView imagee = (ImageView) findViewById(R.id.img);
        Button btn = (Button) findViewById(R.id.button);
        Button btn2 = (Button)findViewById(R.id.button2);
        load(getApplicationContext());


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.clear();
                a=b=c=d=e=f=0;
                adapter.notifyDataSetChanged();
                mylayout.setBackgroundColor(Color.WHITE);
                imagee.setImageResource(R.drawable.what_will_you_get);
                txt.setText(null);
                save();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // int i = 0;
                Log.d("hello", "itd working");
                Random num = new Random();
                int ran = num.nextInt(6);
                Log.d("Delta", "also working");
                imagee.setImageResource(stonearray[ran]);
                Log.d("color", String.valueOf(ran));
                mylayout.setBackgroundColor(colorarray[ran]);
                updatelist(ran);
                save();


            }

        });
    }
        public void updatelist(int ran)
        {
            switch(ran)
            {
                case 0: a++;
                if(a==1)
                {
                    stones = "power stone";
                    arrayList.add(stones);
                    adapter.notifyDataSetChanged();
                    txt.setText("you have got the power stone");
                }
                break;
                case 1: b++;
                    if(b==1)
                    {
                        stones = "mind stone";
                        arrayList.add(stones);
                        adapter.notifyDataSetChanged();
                        txt.setText("you have got the mind stone");
                    }
                    break;
                case 2: c++;
                    if(c==1)
                    {
                        stones = " reality stone";
                        arrayList.add(stones);
                        adapter.notifyDataSetChanged();
                        txt.setText("you have got the reality stone");
                    }
                    break;
                case 3: d++;
                    if(d==1)
                    {
                        stones = "time stone";
                        arrayList.add(stones);
                        adapter.notifyDataSetChanged();
                        txt.setText("you have got the time stone");
                    }
                    break;
                case 4: e++;
                    if(e==1)
                    {
                        stones = "space stone";
                        arrayList.add(stones);
                        adapter.notifyDataSetChanged();
                        txt.setText("you have got the space stone");
                    }
                    break;
                case 5: f++;
                    if(f==1)
                    {
                        stones = " soul stone";
                        arrayList.add(stones);
                        adapter.notifyDataSetChanged();
                        txt.setText("you have got the soul stone");
                    }
                   allstones(); break;
            }
        }
        public void save()
        {
            SharedPreferences sharepref = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharepref.edit();
            editor.putInt("size",arrayList.size());
            Log.d("savesize","it is");
            for(int i=0; i<arrayList.size();i++)
            {
                editor.remove("stonenote"+i);
                editor.putString("stonenote"+i,arrayList.get(i));
                //editor.remove("stonenote"+i);
                Log.d("save","A ok" );

            }
            editor.commit();

        }

        public  void load(Context context)
        {
            SharedPreferences sharedpref2 = PreferenceManager.getDefaultSharedPreferences(context);
            arrayList.clear();
            int size = sharedpref2.getInt("size",0);
                Log.d("size","haha"+size);
            for(int i=0;i<size;i++)
            {
                arrayList.add(sharedpref2.getString("stonenote"+i,null));

            }
        }

        public void allstones() {
            if (a != 0 && b != 0 && c != 0 && d != 0 && e != 0 && f != 0) {
                Toast.makeText(MainActivity.this, "you have got all stones", Toast.LENGTH_LONG).show();
                //Thread.sleep(2000);
                arrayList.clear();
                a = b = c = d = e = f = 0;
                RelativeLayout layout = (RelativeLayout) findViewById(R.id.motherlayout);
                adapter.notifyDataSetChanged();
                layout.setBackgroundColor(Color.WHITE);
                ImageView imagee = (ImageView) findViewById(R.id.img);
                imagee.setImageResource(R.drawable.what_will_you_get);
                txt.setText(null);

            }
        }
}
