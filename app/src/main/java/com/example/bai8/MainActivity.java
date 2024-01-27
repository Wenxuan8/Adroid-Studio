package com.example.bai8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String name[] = {"Hoa hồng 1", "Hoa hồng 2", "Hoa hồng 3", "Hoa hồng 4", "Hoa hồng 5", "Hoa hồng 6" };

    int image[] = {R.drawable.hoahong1, R.drawable.hoahong2, R.drawable.hoahong3, R.drawable.hoahong4, R.drawable.hoahong5, R.drawable.hoahong6};


    int price[] = {300000,500000,170000, 20000,50000,150000,300000,11000};

    ArrayList<Hoahong> mylist;

    GridView lv;

    MyArrayAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mylist = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {
            mylist.add(new Hoahong(image[i], name[i], price[i]));
        }

        myadapter = new
                MyArrayAdapter(this, R.layout.layout_item, mylist);

        lv = findViewById(R.id.lv);

        lv.setAdapter(myadapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(MainActivity.this, SubActivity.class);

                intent1.putExtra("image", image[i]);
                intent1.putExtra("name", name[i]);
                intent1.putExtra("price", price[i]);

                startActivity(intent1);
            }


        });
    }

}