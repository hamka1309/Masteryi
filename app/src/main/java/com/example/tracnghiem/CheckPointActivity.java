package com.example.tracnghiem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tracnghiem.activity.Part5Activity;
import com.example.tracnghiem.database.Database;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class CheckPointActivity extends AppCompatActivity {
    int REQUEST_CODE_FOLDER = 2;
    private TextView tvScore,tvTime;
    private Button btnSave;
    private ImageView imgExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_point);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#141313")));
        getSupportActionBar().setTitle("YOUR SCORE");
        tvScore = findViewById(R.id.tvScore);
        tvTime = findViewById(R.id.tvTimer);
        btnSave = findViewById(R.id.btnSave);
        imgExit = findViewById(R.id.imgExit);
        Intent intent = getIntent();
        String x = intent.getStringExtra("Score");
        String y = intent.getStringExtra("time");
        tvScore.setText(x);
        tvTime.setText(y);
        onclick();


    }

    private void onclick() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openSave();
            }
        });
        imgExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public static Dialog dialog ;
    public static ImageView imgFolder,image;
    public static EditText edtName,edtEmail,edtPhone;
    public static Database database;

    public void openSave(){
        dialog  = new Dialog(CheckPointActivity.this);
        dialog.setContentView(R.layout.activity_saveus);
        dialog.setTitle("Kiểm Tra");

        final TextView tvscore,tvtime;
        Button btnSave;
        btnSave = dialog.findViewById(R.id.btnSave);
        tvscore = dialog.findViewById(R.id.tvsss);
        tvtime = dialog.findViewById(R.id.tvtmm);
        tvscore.setText(tvScore.getText());
        tvtime.setText(tvTime.getText());
        image = dialog.findViewById(R.id.imageView);
        edtName = dialog.findViewById(R.id.edtName);

        imgFolder = dialog.findViewById(R.id.foder);


        imgFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_FOLDER);
            }
        });

        dialog.show();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) image.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArray);
                byte[] hinhanh = byteArray.toByteArray();

                String name = edtName.getText().toString();
                String score = tvscore.getText().toString().trim();
                MainActivity.database.INSERT_SCORE(name,score, hinhanh);

                Toast.makeText(CheckPointActivity.this,"Save success",Toast.LENGTH_SHORT).show();
                finish();
                dialog.dismiss();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data!= null){
            // doc duong dan do du lieu ra
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                image.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}
