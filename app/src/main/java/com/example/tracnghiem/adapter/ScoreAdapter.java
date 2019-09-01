package com.example.tracnghiem.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.tracnghiem.Question.Score;
import com.example.tracnghiem.R;

import java.util.List;

public class ScoreAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Score> scoreList;

    public ScoreAdapter(Context context, int layout, List<Score> scoreList) {
        this.context = context;
        this.layout = layout;
        this.scoreList = scoreList;
    }

    @Override
    public int getCount() {
        return scoreList.size();
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
        TextView tvName,tvScore;
        ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.tvScore = convertView.findViewById(R.id.tvScore);
            holder.imageView = convertView.findViewById(R.id.imgIcon);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        Score score = scoreList.get(position);
        holder.tvName.setText(score.getNaMe());
        holder.tvScore.setText(score.getScore());

        // lấy ảnh
        byte[] hinhanh = score.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhanh,0,hinhanh.length);
        holder.imageView.setImageBitmap(bitmap);
        return convertView;
    }


}
