package com.example.da3_phamvanminh_101185;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;

public class ChoiGame extends AppCompatActivity {
    ImageButton imgbtChoiGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi_game);

        init();
        events();
    }

    private void events() {
        imgbtChoiGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChoiGame.this,VaoChoi.class));
            }
        });
    }

    private void init() {
        imgbtChoiGame = (ImageButton)findViewById(R.id.imgbtchoi);
    }
}