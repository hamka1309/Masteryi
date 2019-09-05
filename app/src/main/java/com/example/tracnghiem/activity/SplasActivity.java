package com.example.tracnghiem.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.tracnghiem.MainActivity;
import com.example.tracnghiem.R;

public class SplasActivity extends AppCompatActivity {

    Button btnSart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splas);
        btnSart = findViewById(R.id.btnStart);
        btnSart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplasActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
