package com.example.da3_phamvanminh_101185;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    final Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it= new Intent(MainActivity.this,ChoiGame.class);
                startActivity(it);
                finish();
                handler.removeCallbacks(this);
            }
        },1000);
    }
}