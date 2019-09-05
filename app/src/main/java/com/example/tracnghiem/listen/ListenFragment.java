package com.example.tracnghiem.listen;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.example.tracnghiem.ListenActivitt;
import com.example.tracnghiem.MainActivity;
import com.example.tracnghiem.R;
import com.example.tracnghiem.activity.Part1Activity;
import com.example.tracnghiem.activity.Part2Activity;
import com.example.tracnghiem.activity.Part34Activity;
import com.example.tracnghiem.activity.Part5Activity;
import com.example.tracnghiem.monhoc.Exam;
import com.example.tracnghiem.monhoc.ExamAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListenFragment extends Fragment {

    ExamAdapter adapter;
    ListView gvExam;
    ArrayList<Exam> exams  = new ArrayList<>();

    public ListenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Listening");

        return inflater.inflate(R.layout.fragment_listen, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // set vào adapter
        gvExam = getActivity().findViewById(R.id.lvFace);
        exams.add(new Exam("Luyện nghe tiếng Anh cơ bản- 8 bài nghe ngắn thú vị_1",R.drawable.gt3));
        exams.add(new Exam("Luyện nghe tiếng Anh cơ bản- 8 bài nghe ngắn thú vị_2",R.drawable.a1));
        exams.add(new Exam("Luyện nghe tiếng Anh cơ bản- 8 bài nghe ngắn thú vị_3",R.drawable.a2));
        exams.add(new Exam("Luyện nghe tiếng Anh cơ bản- 8 bài nghe ngắn thú vị_4",R.drawable.a3));
        exams.add(new Exam("Luyện nghe tiếng Anh cơ bản- 8 bài nghe ngắn thú vị_5",R.drawable.a4));
        exams.add(new Exam("Luyện nghe tiếng Anh cơ bản- 8 bài nghe ngắn thú vị_6",R.drawable.a5));
        exams.add(new Exam("Luyện nghe tiếng Anh cơ bản- 8 bài nghe ngắn thú vị_7",R.drawable.a7));
        exams.add(new Exam("Luyện nghe tiếng Anh cơ bản- 8 bài nghe ngắn thú vị_8",R.drawable.a8));

        adapter = new ExamAdapter(getActivity(), exams);
        gvExam.setAdapter(adapter);
        gvExam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              if (position==0){
                  Intent intent = new Intent(getActivity(),ListenActivitt.class);
                  intent.putExtra("one",R.raw.bainghe1);
                  intent.putExtra("lit1","I love my mom. She took care of me when I was very young. She took care of me when I was sick.\n" +
                          "\n" +
                          "She taught me how to read. She taught me how to get dressed. She taught me how to button my shirt. She taught me how to tie my shoes. She taught me how to brush my teeth.\n" +
                          "\n" +
                          "She taught me to be kind to others. She taught me to tell the truth. She taught me to be polite. She took me to school on my first day of school. She held my hand. She helped me with my homework. She was nice to all my friends. She always cheered me up.\n" +
                          "\n" +
                          "Next year I will graduate from high school. I will go to college. I will do well in college. I will do well after college. My mom has taught me well.");
                  startActivity(intent);
              }
              else if (position==1){
                  Intent intent = new Intent(getActivity(),ListenActivitt.class);
                  intent.putExtra("one",R.raw.bainghe2);
                  intent.putExtra("lit1","Norma went to bed. It was eleven o’clock. She turned out the light.\n" +
                          "\n" +
                          "She lay in bed. It was dark. It was quiet. She couldn’t sleep. She closed her eyes. She tried to sleep, but she couldn’t.\n" +
                          "\n" +
                          "She turned the light back on. She opened her book. She started to read her book. It was a good book. She read one page. Then she read another page.\n" +
                          "\n" +
                          "After a while, she felt sleepy. She closed the book. She turned out the light. She closed her eyes. She went straight to sleep.");

                  startActivity(intent);
              }else if (position==2){
                  Intent intent = new Intent(getActivity(),ListenActivitt.class);
                  intent.putExtra("one",R.raw.bainghe3);
                  intent.putExtra("lit1","Tracy looked at the flag. The flag is red, white, and blue. It has 50 white stars.\n" +
                          "\n" +
                          "The white stars are on a blue square. The flag has six white stripes. It has seven red stripes. All the stripes are horizontal. They are not vertical. The stripes do not go up and down. They go from left to right.\n" +
                          "\n" +
                          "Tracy loves her flag. It is the flag of her country. It is a pretty flag. No other flag has 50 stars. No other flag has 13 stripes.");
                  startActivity(intent);
              }else if(position==3){
                  Intent intent = new Intent(getActivity(),ListenActivitt.class);
                  intent.putExtra("one",R.raw.apie);
                  intent.putExtra("lit1","Jimmy dropped a piece of paper on the floor. He bent over and picked it up. He folded the piece of paper in two. He put it on the table.\n" +
                          "\n" +
                          "He picked up a pencil. He wrote a phone number on the piece of paper. He put the pencil on the table.\n" +
                          "\n" +
                          "He picked up the scissors. He picked up the piece of paper. He cut the paper in half. He put one-half of the paper on the table. He put the other half with the phone number in his shirt pocket. He put the scissors on the table.");
                  startActivity(intent);
              }else if(position==4){
                  Intent intent = new Intent(getActivity(),ListenActivitt.class);
                  intent.putExtra("one",R.raw.athinman);
                  intent.putExtra("lit1","Richard is a light eater. He doesn’t eat much. He isn’t a heavy eater. He eats a light breakfast, a light lunch, and a light dinner.\n" +
                          "\n" +
                          "Richard is not fat. He is thin. He will always be thin, because he is a light eater.\n" +
                          "\n" +
                          "He eats a bowl of cereal for breakfast. He eats a bowl of cereal with milk. He eats a sandwich for lunch. Sometimes it’s a fish sandwich. He likes fish.\n" +
                          "\n" +
                          "He eats rice and vegetables for dinner. All he eats for dinner is rice and vegetables. He will never get fat.");
                  startActivity(intent);
              }else if(position==5){
                  Intent intent = new Intent(getActivity(),ListenActivitt.class);
                  intent.putExtra("one",R.raw.buya);
                  intent.putExtra("lit1","Linda wants to buy a new car. She has an old car. Her old car is a white Honda.\n" +
                          "\n" +
                          "Linda wants to buy a new Honda. She wants to buy a new red Honda. She has saved $1,000. She will use $1,000 to help buy the new car. She will give $1,000 to the Honda dealer.\n" +
                          "\n" +
                          "The Honda dealer will give her a contract to sign. The contract will require her to pay $400 a month for seven years. Her new red Honda will cost Linda a lot of money. But that’s okay, because Linda makes a lot of money.");
                  startActivity(intent);
              }else if(position==6){
                  Intent intent = new Intent(getActivity(),ListenActivitt.class);
                  intent.putExtra("one",R.raw.cold);
                  intent.putExtra("lit1","Thomas was not hot. He was not warm either. He was cold.\n" +
                          "\n" +
                          "The weather was not hot. The weather was not warm either. The weather was cold.\n" +
                          "\n" +
                          "Thomas did not like to be cold. He looked for his jacket. He found his jacket. He put on his jacket. But he was still cold.\n" +
                          "\n" +
                          "He looked at the windows. Were all the windows closed? Yes, they were. They were all closed. None of the windows were open.\n" +
                          "\n" +
                          "He looked at the door. The door wasn’t open. It was closed. He was still cold. He looked for a warmer jacket.");
                  startActivity(intent);
              }else if(position==7){
                  Intent intent = new Intent(getActivity(),ListenActivitt.class);
                  intent.putExtra("one",R.raw.water);
                  intent.putExtra("lit1","Susan likes to eat apples. She likes to eat big red apples.\n" +
                          "\n" +
                          "She likes to wear a blue hat. She wears a big blue hat on her head. She wears a hat and eats an apple.\n" +
                          "\n" +
                          "She drinks some water from a white cup. Susan drinks water and eats apples.\n" +
                          "\n" +
                          "She doesn’t cut the apple with a knife. A knife is sharp. She just eats the apple. She holds the apple in her hand. She bites into the apple with her teeth.\n" +
                          "\n" +
                          "She licks her lips. She drinks more water. She wipes her mouth with her hand.");
                  startActivity(intent);
              }
            }
        });




    }




}
