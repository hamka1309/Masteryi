package com.example.tracnghiem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tracnghiem.Question.Question;

import java.util.ArrayList;

public class CheckAnswerAdapter extends BaseAdapter {

    ArrayList lisData;
    LayoutInflater inflater;


    @Override
    public int getCount() {
        return lisData.size();
    }

    @Override
    public Object getItem(int position) {
        return lisData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Question data  = (Question) getItem(position);
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_gridview_list_answer,null);
            holder.tvNumswer = convertView.findViewById(R.id.tvNumAnswer);
            holder.tvYouAnser = convertView.findViewById(R.id.tvAnswer);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        int i = position+1;
        holder.tvNumswer.setText("Cau "+i+":");
        holder.tvYouAnser.setText(data.getResult());
        return convertView;
    }

    private static class ViewHolder{
        private TextView tvNumswer, tvYouAnser;

    }
}
