package com.example.tracnghiem.monhoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tracnghiem.R;

import java.util.ArrayList;

public class ExamAdapter extends ArrayAdapter<Exam> {


    public ExamAdapter(@NonNull Context context, ArrayList<Exam> exam) {
        super(context, 0, exam);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_gridview,parent,false);
        }
        TextView tvName = convertView.findViewById(R.id.tvNumExam);
        ImageView imgIcon = convertView.findViewById(R.id.imgIcon);

        Exam p = getItem(position);
        if (p!=null){
            tvName.setText(""+p.getName());
            imgIcon.setImageResource(p.getImg());
        }

        return convertView;
    }
}