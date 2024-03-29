package com.example.tracnghiem.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.example.tracnghiem.CheckPointActivity;
import com.example.tracnghiem.Question.Question;
import com.example.tracnghiem.R;
import com.example.tracnghiem.database.Database;


import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class Part5Activity extends AppCompatActivity {

    private ImageView imgExit;
    private CountDownTimer timer;
    private RadioButton rdA,rdB,rdC,rdD;
    private RadioGroup radioGroup;
    private TextView tvQuestion, tvCheck,tvXemdiem,tvAnswer,tvScore,tvTimer,tvcount;
    List<Question> questionList;
    private int position = 0;
    private Button btnNext;
    public int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part5);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#141313")));


        // dong ho dem

        initView();
        Database database = new Database(this);
        // nhan du lieu
        Intent intent = getIntent();
        String y;
        String x,text;
        x = intent.getStringExtra("number_part");
        y = intent.getStringExtra("number_p");
        text = intent.getStringExtra("text");
        questionList = database.getQuestion(x, y);
        getSupportActionBar().setTitle(text);
        initGetData();
        onClick();
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
        }
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
                Intent intent = new Intent(Part5Activity.this,CheckPointActivity.class);
                intent.putExtra("Score",tvScore.getText()+"");
                intent.putExtra("time",tvTimer.getText()+"");
                finish();
                startActivity(intent);
            }
        });

        imgExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position>=questionList.size()-1)
                {
                    position=questionList.size()-1;
                    tvcount.setText((position+1)+" / "+questionList.size());

                    String Question = questionList.get(position).get_Question();
                    tvQuestion.setText(position+1+". "+Question);
                    rdA.setText(questionList.get(position).get_A());
                    rdB.setText(questionList.get(position).get_B());
                    rdC.setText(questionList.get(position).get_C());
                    rdD.setText(questionList.get(position).get_D());
                    tvAnswer.setText(getItem(position).get_Answer());
                    rdA.setClickable(true);
                    rdB.setClickable(true);
                    rdC.setClickable(true);
                    rdD.setClickable(true);
                    if (position==questionList.size()){
                        btnNext.setEnabled(false);
                    }else {
//                        radioGroup.clearCheck();
                    }
                }
                else {
                    position++;
                    tvcount.setText((position+1)+" / "+questionList.size());

                    String Question = questionList.get(position).get_Question();
                    tvQuestion.setText(position+1+". "+Question);
                    rdA.setText(questionList.get(position).get_A());
                    rdB.setText(questionList.get(position).get_B());
                    rdC.setText(questionList.get(position).get_C());
                    rdD.setText(questionList.get(position).get_D());
                    tvAnswer.setText(getItem(position).get_Answer());
                    radioGroup.clearCheck();
                    openClick();
                    rdA.setTextColor(Color.BLACK);
                    rdB.setTextColor(Color.BLACK);
                    rdC.setTextColor(Color.BLACK);
                    rdD.setTextColor(Color.BLACK);
                }
            }
        });


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
        final Dialog dialog = new Dialog(Part5Activity.this);
        dialog.setContentView(R.layout.check_answer_dialog);
        dialog.setTitle("Thoát CT");

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
                Intent intent = new Intent(Part5Activity.this, CheckPointActivity.class);
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


    // xây dựng tối giản

    public Question getItem(int i){
        return questionList.get(i);
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

    private void initGetData() {
        tvcount.setText((position+1)+" / " + questionList.size());

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

        timer = new CounterClass(24*10000,1000);
        timer.start();

    }

    private void initView() {

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
        tvcount = findViewById(R.id.count);
        imgExit = findViewById(R.id.imgExit);
    }

}
