package com.example.da3_phamvanminh_101185;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;


public class customDapAn extends BaseAdapter {

    private  String [] mangDapAn;
    private Context context;

    public customDapAn(String[] mangDapAn, Context context) {
        this.mangDapAn = mangDapAn;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mangDapAn.length;
    }

    @Override
    public Object getItem(int i) {
        return mangDapAn[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Button button;
        if(view == null){
            // tạo mới button
            button = new Button(context);
            button.setLayoutParams(new GridView.LayoutParams(85,85));
            button.setPadding(8,8,8,8);
            button.setBackgroundColor(Color.DKGRAY);
            button.setTextColor(Color.YELLOW);
            button.setText(String.valueOf(mangDapAn[i]));
        }else{
            button = (Button)view;

        }

        return button;
    }
}
