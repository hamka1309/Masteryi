package com.example.tracnghiem.activityfragment;


import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.tracnghiem.MainActivity;
import com.example.tracnghiem.Question.Score;
import com.example.tracnghiem.R;
import com.example.tracnghiem.adapter.ScoreAdapter;
import com.example.tracnghiem.database.Database;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListScoreFragment extends Fragment {
    public static Database database;

    ListView lvList;
    List<Score> arrayList;
    ScoreAdapter adapter;


    public ListScoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("List Score");

        return inflater.inflate(R.layout.fragment_list_score, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        database = new Database(getActivity());
        lvList = getActivity().findViewById(R.id.lvScore);
        arrayList = database.getUser();
        adapter = new ScoreAdapter(getActivity(),R.layout.item_user,arrayList);
        lvList.setAdapter(adapter);

    }
}
