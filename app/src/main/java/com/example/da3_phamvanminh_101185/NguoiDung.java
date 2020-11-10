package com.example.da3_phamvanminh_101185;

import android.content.Context;
import android.content.SharedPreferences;

public class NguoiDung {
    private String nameData="appData";
    public int tien;
    public void saveTT(Context ct){
        SharedPreferences setting = ct.getSharedPreferences(nameData,0);
        SharedPreferences.Editor editor = setting.edit();
        editor.commit();
    }
    public void getTT(Context context){
        SharedPreferences settings = context.getSharedPreferences(nameData,0);
        tien = settings.getInt("tien",20);
    }
}
