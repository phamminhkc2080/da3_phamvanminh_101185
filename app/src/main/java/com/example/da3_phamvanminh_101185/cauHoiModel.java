package com.example.da3_phamvanminh_101185;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;

public class cauHoiModel {
    VaoChoi choi;
    final String Database_Name = "da3phamminh.db";
    SQLiteDatabase database;
    ArrayList<CauHoi> arr = new ArrayList<>();
    int causo = 0;
     public NguoiDung nguoiDung;


    public cauHoiModel(VaoChoi choi) {
        this.choi = choi;
        nguoiDung = new NguoiDung();
        Events();
    }

    private void Events() {
        database = Database.initDatabase(choi, Database_Name);
        Cursor cursor = database.rawQuery("Select * from cauhoi", null);
        String CauHoi = "";
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            CauHoi = cursor.getString(1);
            String DapAn = cursor.getString(2);
            String CauTraLoi = cursor.getString(3);
            arr.add(new CauHoi(id, CauHoi, DapAn, CauTraLoi));
        }
        Collections.shuffle(arr);

    }

    public CauHoi layCauHoi() {
        causo++;
        if (causo >= arr.size()) {
            causo = arr.size() - 1;
        }
        return arr.get(causo);
    }
    public void layThongtin(){
        nguoiDung.getTT(choi);
    }
    public void luuThongTin(){
        nguoiDung.saveTT(choi);
    }
}
