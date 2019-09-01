package com.example.tracnghiem.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tracnghiem.Question.Question;
import com.example.tracnghiem.R;
import com.example.tracnghiem.adapter.Part34Adapter;
import com.example.tracnghiem.adapter.ScoreAdapter;
import com.example.tracnghiem.database.Database;

import java.util.List;

public class Part34Activity extends AppCompatActivity {
    private ListView lv;
    private List<Question> questionList;
    Part34Adapter adapter;
    private Button btnsubmit,btnPoint;
    public static int score = 0;
    private TextView tvscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#141313")));



        Database database = new Database(this);
        // nhan du lieu
        Intent intent = getIntent();
        String y;
        String x;
        String text;
        x = intent.getStringExtra("number_part");
        y = intent.getStringExtra("number_p");
        text = intent.getStringExtra("text");
        getSupportActionBar().setTitle(text);
        lv = findViewById(R.id.lvpart34);
//        tvscore = findViewById(R.id.score);
        btnsubmit = findViewById(R.id.submit);
        btnPoint = findViewById(R.id.poin);
        questionList = database.getQuestion(x,y);
        adapter = new Part34Adapter(Part34Activity.this,R.layout.item_part34,questionList);
        lv.setAdapter(adapter);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setSubmit(true);
//                btnsubmit.setVisibility(View.GONE);
//                btnPoint.setVisibility(View.VISIBLE);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }


    public static void congDiem(){
        score +=10;
    }
}
