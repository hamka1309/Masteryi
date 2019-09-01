package com.example.tracnghiem.Add;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.tracnghiem.MainActivity;
import com.example.tracnghiem.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ThemPart1 extends AppCompatActivity {
    Button btnThem;
    EditText edtQuestion,edtA,edtB,edtC,edtD,edtResult,edtLevel,tvpart;
    ImageView imgFolder,image;

    int REQUEST_CODE_CAMERA = 1;
    int REQUEST_CODE_FOLDER = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themdovat);
        
        AnhXa();

        imgFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_FOLDER);
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // chuyen data image -> byte[]

                BitmapDrawable bitmapDrawable = (BitmapDrawable) image.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArray);
                byte[] hinhanh = byteArray.toByteArray();


                String question = edtQuestion.getText().toString().trim();
                String part = tvpart.getText().toString().trim();
                String a =   edtA.getText().toString().trim();
                String b =   edtB.getText().toString().trim();
                String c =   edtC.getText().toString().trim();
                String d = edtD.getText().toString().trim();
                String ans= edtResult.getText().toString().trim();
                String level = edtLevel.getText().toString().trim();
                MainActivity.database.INSERT_QUESTION(part,level,question,a,b,c,d,ans,hinhanh);

                Toast.makeText(ThemPart1.this,"Da them", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(ThemPart1.this,MainActivit.class));
            }
        });
    }

    private void AnhXa() {
        tvpart = findViewById(R.id.tvPart);
        btnThem = findViewById(R.id.btnThem);
        edtQuestion =findViewById(R.id.edtTen);
        edtA =findViewById(R.id.edtA);
        edtB =findViewById(R.id.edtB);
        edtC=findViewById(R.id.edtC);
        edtD=findViewById(R.id.edtD);
        edtResult=findViewById(R.id.edtResult);
        edtLevel =findViewById(R.id.edtLevel);
        imgFolder =findViewById(R.id.foder);
        image =findViewById(R.id.imageView);
    }


    // tra ve du lieu inten
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//

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
