package com.example.bai8;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Hoahong> {
    Activity context;
    int IdLayout;
    ArrayList<Hoahong> mylist;


    public MyArrayAdapter(Activity context, int idLayout,
                          ArrayList<Hoahong> mylist) {
        super(context, idLayout, mylist);

        this.context = context;

        IdLayout = idLayout;
        this.mylist = mylist;
    }


    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater myflactor = context.getLayoutInflater();
        convertView = myflactor.inflate(IdLayout, null);

        Hoahong myHoahong = mylist.get(position); //Khai báo và hiển thị hình ảnh

        ImageView img_Hoahong = convertView.findViewById(R.id.img_Hoahong);

        img_Hoahong.setImageResource(myHoahong.getImage());

        TextView txt_hoahong = convertView.findViewById(R.id.txt_hoahong);

        txt_hoahong.setText(myHoahong.getName()); //Khai báo và hiển thị giá Điện thoại

        TextView txt_price = convertView.findViewById(R.id.txt_price);

        txt_price.setText(myHoahong.getPrice() + " VND");
        return convertView;
    }
}