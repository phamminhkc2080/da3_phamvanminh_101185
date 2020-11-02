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
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.Random;

public class VaoChoi extends AppCompatActivity {
    TextView tvCauHoi;
    final String Database_Name = "da3_gameGiaiDo.db";
    SQLiteDatabase database;
    public String[] da;
    public String[] ctl;
    public customCauTraLoi customCauTraLoi;
    public customDapAn customDapAn;
    public GridView gridViewDapAn,gridViewCauTraLoi;
    String correct_da;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vao_choi);
        Init();
        Events();
    }

    private void Events() {

        database = Database.initDatabase(VaoChoi.this, Database_Name);
        Cursor cursor = database.rawQuery("Select * from cauhoi", null);
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            tvCauHoi.setText(cursor.getString(1));
            String DapAn = cursor.getString(3).trim();
            String CauTraLoi = cursor.getString(2).trim();
            da = DapAn.split("");
            ctl = CauTraLoi.split("");
        }
        da = shuffleArray(da);

    }


    private String[] shuffleArray(String[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }
    private void setupList() {
        Random random= new Random();

        Common.user_submit_answer=new String[da.length];

//        ctl.clear();
//        for(String item : da){
//            //add logo name to lisst
//            ctl.add(String.valueOf(item));
//        }
        //random add some character to list
        for(int i = da.length;i<da.length*2;i++){
//            ctl.add(Common.alphabet_character[random.nextInt(Common.alphabet_character.length)]);

            // sort random
//            Collections.shuffle(suggestSource);

            //set for GridView
            customDapAn = new customDapAn(setupNullList(),this);
            customCauTraLoi = new customCauTraLoi(ctl,this,this);
            customDapAn.notifyDataSetChanged();
            customCauTraLoi.notifyDataSetChanged();

            gridViewCauTraLoi.setAdapter(customCauTraLoi);
            gridViewDapAn.setAdapter(customDapAn);
        }
    }

    private String[] setupNullList() {
        String result[] = new String[da.length];
        for(int i=0;i<da.length;i++){
            result[i]=" ";
        }
        return result;
    }

//    public void addView(final LinearLayout linearLayout, final String text,int id) {
//
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
//        layoutParams.rightMargin = 30;
//        final TextView tvCauTL = new TextView(this);
//        tvCauTL.setLayoutParams(layoutParams);
//
//        tvCauTL.setTextColor(this.getResources().getColor(R.color.trang));
//        tvCauTL.setGravity(Gravity.CENTER);
//        tvCauTL.setText(text);
//        tvCauTL.setHeight(40);
//
//        tvCauTL.setBackground(this.getResources().getDrawable(R.color.black));
//        tvCauTL.setWidth(100);
//        tvCauTL.setClickable(true);
//        tvCauTL.setFocusable(true);
//        tvCauTL.setTextSize(32);
//        tvCauTL.setId(id);
//        tvCauTL.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 CauHoi a= new CauHoi();
//                addView((LinearLayout) findViewById(R.id.layoutParentctl), tvCauTL.getText().toString(),200);
//                TextView t=(TextView)findViewById(R.id.100);
//                cautl = cautl + tvCauTL.getText().toString();
//                Toast.makeText(VaoChoi.this, cautl, Toast.LENGTH_SHORT).show();
//                tvCauTL.setText("");
//                tvCauTL.setEnabled(false);
//            }
//        });
//        linearLayout.addView(tvCauTL);
//    }

    private void Init() {
        tvCauHoi = (TextView) findViewById(R.id.tvcauhoi);
        gridViewDapAn = (GridView)findViewById(R.id.gridViewda);
        gridViewCauTraLoi = (GridView)findViewById(R.id.gridViewctl);
    }
}