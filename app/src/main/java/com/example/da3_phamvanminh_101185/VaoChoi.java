package com.example.da3_phamvanminh_101185;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.opengl.ETC1;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class VaoChoi extends AppCompatActivity {
    public TextView tvCauHoi,tvTienNguoiDung;
    ArrayList<String> arrDapAn;
    GridView gvDapAn;


    ArrayList<CauHoi> arrCauHoi;
    CauHoi cauHoi;
    int pos=0;

    String CauTraLoi = "";

    ArrayList<String> arrCauTraLoi;
    GridView gvCauTraLoi;
     cauHoiModel model;

     Button btnGoiY;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vao_choi);
        Init();
        setOnclick();
        hienCauHoi();
    }

    private void HienThiDapAn() {
        gvDapAn.setAdapter(new DapAnAdapter(VaoChoi.this, 0, arrDapAn));
    }

    private void HienThiCauTraLoi() {
        gvCauTraLoi.setAdapter(new DapAnAdapter(VaoChoi.this, 0, arrCauTraLoi));
    }


    public void setOnclick() {
        gvCauTraLoi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = (String) adapterView.getItemAtPosition(i);
                if (s.length() != 0 && pos < arrDapAn.size()) {
                    for(int j=0;j<arrDapAn.size();j++){
                        if(arrDapAn.get(j).length()==0){
                            pos=j;
                            break;
                        }

                    }
                    arrCauTraLoi.set(i, "");
                    arrDapAn.set(pos, s);
                    pos++;
                    HienThiCauTraLoi();
                    HienThiDapAn();
                    checkDapAn();
                }
            }
        });
        gvDapAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = (String) adapterView.getItemAtPosition(i);
                if (s.length() != 0) {
                    pos = i;
                    arrDapAn.set(i, "");
                    for (int j = 0; j < arrCauTraLoi.size(); j++) {
                        if (arrCauTraLoi.get(j).length() == 0) {
                            arrCauTraLoi.set(j, s);
                            break;
                        }
                    }
                    HienThiCauTraLoi();
                    HienThiDapAn();

                }
            }
        });
    }
    public void hienCauHoi(){
        cauHoi = model.layCauHoi();
        tvCauHoi.setText(cauHoi.getCauHoi());
        CauTraLoi=cauHoi.getDapAn();
        daoCauTraLoi();
        HienThiDapAn();
        HienThiCauTraLoi();
        model.layThongtin();
        tvTienNguoiDung.setText(model.nguoiDung.tien+"$");
    }
    private void Init() {
        model = new cauHoiModel(this);
        cauHoi = new CauHoi();
        tvCauHoi = (TextView) findViewById(R.id.tvcauhoi);
        tvTienNguoiDung = (TextView) findViewById(R.id.txttiennguoidung);
        gvDapAn = (GridView) findViewById(R.id.gridViewdapan);
        arrDapAn = new ArrayList<>();

        gvCauTraLoi = (GridView) findViewById(R.id.gridViewcautraloi);
        arrCauTraLoi = new ArrayList<>();

        arrCauHoi= new ArrayList<>();

        btnGoiY=(Button)findViewById(R.id.btngoiy);
    }

    public void daoCauTraLoi() {
        pos=0;
        arrDapAn.clear();
        arrCauTraLoi.clear();
        Random r = new Random();
        for (int i = 0; i < CauTraLoi.length(); i++) {
            arrDapAn.add("");
            String s = "" + (char) (r.nextInt(26) + 65);
            arrCauTraLoi.add(s);
            String s1 = "" + (char) (r.nextInt(26) + 65);
            arrCauTraLoi.add(s1);


        }

        for (int i = 0; i < CauTraLoi.length(); i++) {
            String da = "" + CauTraLoi.charAt(i);
            arrCauTraLoi.set(i, da.toUpperCase());
        }

        for (int i = 0; i < arrCauTraLoi.size(); i++) {
            String s = arrCauTraLoi.get(i);
            int vt = r.nextInt(arrCauTraLoi.size());
            arrCauTraLoi.set(i, arrCauTraLoi.get(vt));
            arrCauTraLoi.set(vt, s);
        }
    }
    public void checkDapAn(){
        String s="";
        for(String s1 : arrDapAn){
            s=s+s1;
        }
        s.toUpperCase();
        if(s.equals(CauTraLoi.toUpperCase())){
            Toast.makeText(VaoChoi.this,"Ban da chien thang",Toast.LENGTH_LONG).show();
            model.layThongtin();
            model.nguoiDung.tien=model.nguoiDung.tien+10;

            model.luuThongTin();
            hienCauHoi();
        }
    }

    public void moGoiY(View view) {
        int index=-1;
        for(int i=0;i<arrDapAn.size();i++){
            if(arrDapAn.get(i).length()==0){
                index=i;
                break;
            }
        }
        if(index==-1){
            for(int i=0;i<arrDapAn.size();i++){
                String s1 = CauTraLoi.charAt(i)+"";
                if(arrDapAn.get(i).toUpperCase().equals(s1)){
                    index=i;
                    break;
                }
            }

        }
        for(int i=0;i<arrCauTraLoi.size();i++){
            if(arrCauTraLoi.get(i).length()==0){
                arrCauTraLoi.set(i,arrDapAn.get(index));
                break;
            }

        }
        String s=""+CauTraLoi.charAt(index);
        s = s.toUpperCase();
        for(int i =0;i<arrDapAn.size();i++){
            if(arrDapAn.get(i).toUpperCase().equals(s)){
                arrDapAn.set(i,"");
                break;
            }
        }
        for(int i=0;i<arrCauTraLoi.size();i++){
            if(s.equals(arrCauTraLoi.get(i))){
                arrCauTraLoi.set(i,"");
                break;
            }

        }
        arrDapAn.set(index,s);
        HienThiDapAn();
        HienThiCauTraLoi();

    }
}