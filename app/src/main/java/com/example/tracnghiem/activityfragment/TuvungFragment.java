package com.example.tracnghiem.activityfragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tracnghiem.MainActivity;
import com.example.tracnghiem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuvungFragment extends Fragment {


    public TuvungFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Tu vung");
        return inflater.inflate(R.layout.fragment_tuvung, container, false);
    }

}
