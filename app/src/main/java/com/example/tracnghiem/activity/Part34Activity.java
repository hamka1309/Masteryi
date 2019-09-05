package com.example.tracnghiem.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.tracnghiem.CheckPointActivity;
import com.example.tracnghiem.Question.Question;
import com.example.tracnghiem.R;
import com.example.tracnghiem.adapter.Part34Adapter;
import com.example.tracnghiem.adapter.ScoreAdapter;
import com.example.tracnghiem.database.Database;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Part34Activity extends AppCompatActivity {
    private ListView lv;
    private List<Question> questionList;
    Part34Adapter adapter;
    private Button btnsubmit,btnPoint;
    public static int score = 0;
    private TextView tvscore;
    MediaPlayer mediaPlayer;
    ImageView imgStart;
    private TextView tvTime, tvTimeTotal,tvTimer;
    SeekBar skSong;
    private CountDownTimer timer;



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
        int media;
        x = intent.getStringExtra("number_part");
        y = intent.getStringExtra("number_p");
        media = intent.getIntExtra("media",0);
        mediaPlayer = MediaPlayer.
                create(this,media);
        text = intent.getStringExtra("text");
        getSupportActionBar().setTitle(text);
        lv = findViewById(R.id.lvpart34);
//        tvscore = findViewById(R.id.score);
        btnsubmit = findViewById(R.id.submit);
        imgStart = findViewById(R.id.btnStart);
        btnPoint = findViewById(R.id.poin);
        tvscore = findViewById(R.id.tvScore);
        skSong = findViewById(R.id.seekBar);
        tvTime = findViewById(R.id.tvTime);
        tvTimeTotal = findViewById(R.id.tvTimeTotal);
        tvTimer = findViewById(R.id.tvTimer);
        questionList = database.getQuestion(x,y);
        adapter = new Part34Adapter(Part34Activity.this,R.layout.item_part34,questionList);
        lv.setAdapter(adapter);
        timer = new CounterClass(24*10000,1000);

        timer.start();

        onClick();
    }


    public void congdiem(){
        score +=20;
        tvscore.setText(score+"%");
    }
    private void onClick() {
        imgStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    // neu dang phat ->>> đỏi hinh ->> pause
                    mediaPlayer.pause();
                    imgStart.setImageResource(R.drawable.play_button);
                }else {
                    // đang dừng ->> phát ->>   start
                    mediaPlayer.start();
                    imgStart.setImageResource(R.drawable.pause);
                }
                SettimeTotal();
                UpdateTimeSong();
            }
        });

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setSubmit(true);
                btnsubmit.setVisibility(View.GONE);
                btnPoint.setVisibility(View.VISIBLE);
                timer.cancel();
            }
        });
        skSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // seekTo: nhay đến đoạn mình kéo
                mediaPlayer.seekTo(skSong.getProgress());

            }
        });

        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPoint.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Part34Activity.this, CheckPointActivity.class);
                        intent.putExtra("Score",tvscore.getText()+"");
                        intent.putExtra("time",tvTimer.getText()+"");
                        finish();
                        startActivity(intent);
                    }
                });
            }
        });
    }

    private void SettimeTotal(){
        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
        tvTimeTotal.setText(dinhDangGio.format(mediaPlayer.getDuration()) + "");  // getduration tra ra time
        // gan' max cua skSong la  mediaplayer.getduration
        skSong.setMax(mediaPlayer.getDuration());
    }
    private void UpdateTimeSong(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                tvTime.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition())); //getCurrentPosition() vị trí hiện tại đang dc phát
                // update progress skSong
                skSong.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this,500);

                // kiểm tra thời gian bài hát kết thúc  thì -> next
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if (mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        imgStart.setImageResource(R.drawable.pl);


                    }
                });
            }
        }, 100);
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




    public class CounterClass extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            tvTimer.setText(countTime); //SetText cho textview hiện thị thời gian.
        }

        @Override
        public void onFinish() {
            tvTimer.setText("00:00");  //SetText cho textview hiện thị thời gian.
            btnsubmit.setVisibility(View.GONE);
            btnPoint.setVisibility(View.VISIBLE);
            mediaPlayer.stop();
            imgStart.setImageResource(R.drawable.play_button);


        }
    }
}
