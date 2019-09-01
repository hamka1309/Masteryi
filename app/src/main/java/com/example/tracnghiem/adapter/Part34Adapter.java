package com.example.tracnghiem.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tracnghiem.Question.Question;
import com.example.tracnghiem.Question.Score;
import com.example.tracnghiem.R;
import com.example.tracnghiem.activity.Part34Activity;

import java.util.List;

public class Part34Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Question> questions;
    public boolean submit = false;

    public void setSubmit(boolean submit) {
        this.submit = submit;
        notifyDataSetChanged();

    }

    public Part34Adapter(Context context, int layout, List<Question> questions) {
        this.context = context;
        this.layout = layout;
        this.questions = questions;
    }

    @Override
    public int getCount() {
        return questions.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView tvQuestion,tvScore,tvAnswer;
        RadioButton rdA,rdB,rdC,rdD;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {

            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.tvQuestion = convertView.findViewById(R.id.tvQuestion);
            holder.tvScore = convertView.findViewById(R.id.tvScore);
            holder.tvAnswer = convertView.findViewById(R.id.tvAnswer);
            holder.rdA = convertView.findViewById(R.id.rdA);
            holder.rdB = convertView.findViewById(R.id.rdB);
            holder.rdC = convertView.findViewById(R.id.rdC);
            holder.rdD = convertView.findViewById(R.id.rdD);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Question question = questions.get(position);
        holder.tvAnswer.setText(question.get_Answer());
        holder.tvQuestion.setText((position+1)+" . "+question.get_Question());
        holder.rdA.setText(question.get_A());
        holder.rdB.setText(question.get_B());
        holder.rdC.setText(question.get_C());
        holder.rdD.setText(question.get_D());


        if (submit){

            holder.rdA.setClickable(false);
            holder.rdB.setClickable(false);
            holder.rdC.setClickable(false);
            holder.rdD.setClickable(false);
        }
        return convertView;
    }
}
