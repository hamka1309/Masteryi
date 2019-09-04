package com.example.tracnghiem.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tracnghiem.CheckPointActivity;
import com.example.tracnghiem.Question.Question;
import com.example.tracnghiem.R;
import com.example.tracnghiem.database.Database;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Part1Activity extends AppCompatActivity  {
    private TextView tvTime, tvTimeTotal;
    SeekBar skSong;
    private CountDownTimer timer;
    private RadioButton rdA,rdB,rdC,rdD;
    private RadioGroup radioGroup;
    private TextView tvQuestion, tvCheck,tvXemdiem,tvAnswer,tvScore,tvTimer;
    List<Question> questionList;
    private int position = 0;
    private Button btnNext;
    public int score = 0;
    ImageView imgImage, imgStart, imgExit;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#141313")));
        getSupportActionBar().setTitle("Part 1: PHOTO");
        // dong ho dem

        initView();
        Database database = new Database(this);
        // nhan du lieu
        Intent intent = getIntent();
        String x,y;
        int media;
        x = intent.getStringExtra("number_part");
        y = intent.getStringExtra("number_p");
        media = intent.getIntExtra("media",0);

        mediaPlayer = MediaPlayer.
                create(this,media);

        questionList = database.getQuestion(x, y);

        initGetData();
        onClick();
        // 2 250
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

    private void onClick() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                getItem(position).choiceId =checkedId;
                getItem(position).setResult(getChoice(checkedId));

            }
        });
        tvCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickable();
                if (result()==true){
                    if (rdA.isChecked()){
                        if (rdA.getText().equals(tvAnswer.getText())) {
                            congdiem();
                        }else ;
                    }else if (rdB.isChecked()){
                        if (rdB.getText().equals(tvAnswer.getText())){
                            congdiem();

                        }else ;
                    }else if (rdC.isChecked()){
                        if (rdC.getText().equals(tvAnswer.getText())){
                            congdiem();

                        }else ;
                    }else if (rdD.isChecked()){
                        if (rdD.getText().equals(tvAnswer.getText())){
                            congdiem();
                        }else ;
                    }
                }

            }
        });
        tvXemdiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Part1Activity.this, CheckPointActivity.class);
                intent.putExtra("Score",tvScore.getText()+"");
                intent.putExtra("time",tvTimer.getText()+"");
                finish();
                startActivity(intent);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position>=questionList.size()-1)
                {
                    position=questionList.size()-1;
                    String Question = questionList.get(position).get_Question();
                    tvQuestion.setText(position+1+" . "+Question);
                    rdA.setText(questionList.get(position).get_A());
                    rdB.setText(questionList.get(position).get_B());
                    rdC.setText(questionList.get(position).get_C());
                    rdD.setText(questionList.get(position).get_D());
                    tvAnswer.setText(getItem(position).get_Answer());
                    byte[] hinhanh = questionList.get(position).getImage();
                    Bitmap bitmap = BitmapFactory.decodeByteArray(hinhanh,0,hinhanh.length);
                    imgImage.setImageBitmap(bitmap);
                    rdA.setClickable(true);
                    rdB.setClickable(true);
                    rdC.setClickable(true);
                    rdD.setClickable(true);
                    if (position==questionList.size()){
                        btnNext.setEnabled(false);
                    }
                }
                else if (position== questionList.size()){

                }
                else {
                    position++;
                    String Question = questionList.get(position).get_Question();
                    tvQuestion.setText(position+1+". "+Question);
                    rdA.setText(questionList.get(position).get_A());
                    rdB.setText(questionList.get(position).get_B());
                    rdC.setText(questionList.get(position).get_C());
                    rdD.setText(questionList.get(position).get_D());
                    tvAnswer.setText(getItem(position).get_Answer());
                    radioGroup.clearCheck();
                    byte[] hinhanh = questionList.get(position).getImage();
                    Bitmap bitmap = BitmapFactory.decodeByteArray(hinhanh,0,hinhanh.length);
                    imgImage.setImageBitmap(bitmap);
                    openClick();
                    rdA.setTextColor(Color.BLACK);
                    rdB.setTextColor(Color.BLACK);
                    rdC.setTextColor(Color.BLACK);
                    rdD.setTextColor(Color.BLACK);
                }
            }
        });

        imgStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mediaPlayer = MediaPlayer.
//                        create(this,R.raw.part1);
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
                // seekTo: nhay đến đoạn mình kéo
                mediaPlayer.seekTo(skSong.getProgress());

            }
        });

        imgExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
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
    private void initGetData() {
        String question = getItem(position).get_Question();
        String A = getItem(position).get_A();
        String B = getItem(position).get_B();
        String C = getItem(position).get_C();
        String D = getItem(position).get_D();
        tvAnswer.setText(getItem(position).get_Answer());
        tvQuestion.setText(1+"."+question);
//        tvScore.setText(0+"");
        rdA.setText(A);
        rdB.setText(B);
        rdC.setText(C);
        rdD.setText(D);
        byte[] hinhanh = questionList.get(position).getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhanh,0,hinhanh.length);
        imgImage.setImageBitmap(bitmap);
        timer = new CounterClass(6*10000,1000);
        timer.start();

    }
    public Question getItem(int i){
        return questionList.get(i);
    }

    public void congdiem(){
        score = score+10;
        tvScore.setText(score+"");
    }

    public boolean result(){
        if (rdA.getText().equals(tvAnswer.getText())){
            rdA.setTextColor(Color.GREEN);
            return true;
        }else if (rdB.getText().equals(tvAnswer.getText())){
            rdB.setTextColor(Color.GREEN);
            return true;
        }
        else if (rdC.getText().equals(tvAnswer.getText())){
            rdC.setTextColor(Color.GREEN);
            return true;
        }else if (rdD.getText().equals(tvAnswer.getText())){
            rdD.setTextColor(Color.GREEN);
            return true;
        }else return false;
    }


    public void clickable(){
        rdA.setClickable(false);
        rdB.setClickable(false);
        rdC.setClickable(false);
        rdD.setClickable(false);
    }
    public void checkAnswer(){
        final Dialog dialog = new Dialog(Part1Activity.this);
        dialog.setContentView(R.layout.check_answer_dialog);
        dialog.setTitle("Thoát Chương Trình");

        dialog.show();
        Button btnCancel,btnFinish;
        btnCancel = dialog.findViewById(R.id.btnKiemTra);
        btnFinish = dialog.findViewById(R.id.btnFinish);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                dialog.dismiss();
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Part1Activity.this, CheckPointActivity.class);
                intent.putExtra("Score",tvScore.getText()+"");
                intent.putExtra("time",tvTimer.getText()+"");
                finish();
                startActivity(intent);
                dialog.dismiss();
            }
        });

    }

    public void openClick(){
        rdA.setClickable(true);
        rdB.setClickable(true);
        rdC.setClickable(true);
        rdD.setClickable(true);

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
            imgStart.setEnabled(false);
            mediaPlayer.stop();
            imgStart.setImageResource(R.drawable.pl);
            tvCheck.setVisibility(View.GONE);
            tvXemdiem.setVisibility(View.VISIBLE);
            clickable();
        }
    }

    private String getChoice(int Id){
        if (Id == R.id.rdA){
            return "A";
        }else if (Id == R.id.rdB){
            return "B";
        }else if (Id == R.id.rdC){
            return "C";
        }else if (Id == R.id.rdD){
            return "D";
        }else return "";
    }
    private void initView() {
        skSong = findViewById(R.id.seekBar);
        tvTime = findViewById(R.id.tvTime);
        tvTimeTotal = findViewById(R.id.tvTimeTotal);
        imgStart = findViewById(R.id.btnStart);
        imgImage = findViewById(R.id.imgView);
        radioGroup = findViewById(R.id.rdGroup);
        rdA = findViewById(R.id.rdA);
        rdB = findViewById(R.id.rdB);
        rdC = findViewById(R.id.rdC);
        rdD = findViewById(R.id.rdD);
        tvQuestion = findViewById(R.id.tvQuestion);
        tvScore = findViewById(R.id.tvScore);
        tvXemdiem = findViewById(R.id.tvXemDiem);
        tvAnswer = findViewById(R.id.tvAnswer);
        tvTimer = findViewById(R.id.tvTimer);
        tvCheck = findViewById(R.id.tvCheck);
        btnNext  = findViewById(R.id.btnNext);
        imgExit  = findViewById(R.id.imgExit);
    }

}
