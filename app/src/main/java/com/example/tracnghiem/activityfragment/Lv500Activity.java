package com.example.tracnghiem.activityfragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tracnghiem.MainActivity;
import com.example.tracnghiem.activity.Part1Activity;
import com.example.tracnghiem.activity.Part2Activity;
import com.example.tracnghiem.activity.Part34Activity;
import com.example.tracnghiem.activity.Part5Activity;
import com.example.tracnghiem.R;
import com.example.tracnghiem.monhoc.Exam;
import com.example.tracnghiem.monhoc.ExamAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Lv500Activity extends Fragment {

    ExamAdapter adapter;
    GridView gvExam;
    ArrayList<Exam> exams  = new ArrayList<>();

    public Lv500Activity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // setActionbar
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Level 500- 750");
        return inflater.inflate(R.layout.fragment_toanhoc, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // set vào adapter
        gvExam = getActivity().findViewById(R.id.gvExam);
        gvExam = getActivity().findViewById(R.id.gvExam);
        exams.add(new Exam("Part 1: Photo \n",R.drawable.part1));
        exams.add(new Exam("Part 2: Question - Response",R.drawable.iiiii));
        exams.add(new Exam("Part 3: Short Conversation",R.drawable.uuuuu));
        exams.add(new Exam("Part 4: Short Talks \n ",R.drawable.oppppppppp));
        exams.add(new Exam("Part 5: Incomplete Sentences",R.drawable.part5));
        exams.add(new Exam("Part 6: Text Completion \n",R.drawable.part6));
        exams.add(new Exam("Part 7: Comprehension",R.drawable.part7));

        adapter = new ExamAdapter(getActivity(), exams);
        gvExam.setAdapter(adapter);
        gvExam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0){
                    Intent intent  = new Intent(getActivity(), Part1Activity.class);
                    intent.putExtra("number_part","1");
                    intent.putExtra("number_p","500");
                    intent.putExtra("media",R.raw.p1_500);

                    startActivity(intent);
                }else if (position == 1){
                    Intent intent  = new Intent(getActivity(), Part2Activity.class);
                    intent.putExtra("number_part","2");
                    intent.putExtra("number_p","500");
                    intent.putExtra("text","Part 2: Question - Responce");

                    intent.putExtra("media",R.raw.p2_500);

                    startActivity(intent);
                }else if (position == 2){
                    Intent intent  = new Intent(getActivity(), Part34Activity.class);
                    intent.putExtra("number_part","3");
                    intent.putExtra("number_p","500");
                    intent.putExtra("text","Part 3: Short Conversation");
                    intent.putExtra("media",R.raw.p3_500);

                    startActivity(intent);
                }else if (position == 3){
                    Intent intent  = new Intent(getActivity(), Part34Activity.class);
                    intent.putExtra("number_part","4");
                    intent.putExtra("number_p","500");
                    intent.putExtra("text","Part 4: Short Talk");
                    intent.putExtra("media",R.raw.p4_500);

                    startActivity(intent);
                }
                else if (position == 4){
                    Intent intent  = new Intent(getActivity(), Part5Activity.class);
                    intent.putExtra("number_part","5");
                    intent.putExtra("number_p","500");
                    intent.putExtra("text","Part 5: Incomplete Sentences");
                    startActivity(intent);
                }
            }
        });




    }
}
