package com.example.tracnghiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class ListenActivitt extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    private TextView tvTime, tvTimeTotal, tvA;
    SeekBar skSong;
    ImageView imgStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_activitt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#141313")));
        getSupportActionBar().setTitle("LISTEN NING");
        initView();
        Intent intent = getIntent();
        int media = intent.getIntExtra("one",0);
        String x = intent.getStringExtra("lit1");
        tvA.setText(x);
        mediaPlayer = MediaPlayer.
                create(this,media);

        onClick();
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
        skSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(skSong.getProgress());
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
                        imgStart.setImageResource(R.drawable.play_button);


                    }
                });
            }
        }, 100);
    }

    private void initView() {
        tvA = findViewById(R.id.tvA);
        skSong = findViewById(R.id.seekBar);
        tvTime = findViewById(R.id.tvTime);
        tvTimeTotal = findViewById(R.id.tvTimeTotal);
        imgStart = findViewById(R.id.btnStart);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();

                mediaPlayer.stop();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}
