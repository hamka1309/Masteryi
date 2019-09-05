package com.example.tracnghiem;

import android.content.Intent;
import android.os.Bundle;

import com.example.tracnghiem.Add.ThemPart1;
import com.example.tracnghiem.activityfragment.ListScoreFragment;
import com.example.tracnghiem.activityfragment.TuvungFragment;
import com.example.tracnghiem.database.Database;
import com.example.tracnghiem.listen.ListenFragment;
import com.example.tracnghiem.monhoc.HomeFragment;
import com.example.tracnghiem.activityfragment.Lv250Activity;
import com.example.tracnghiem.activityfragment.Lv500Activity;
import com.example.tracnghiem.activityfragment.Lv750Activity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.view.Menu;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemPart1.class);
                startActivity(intent);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        // bat đầu
        HomeFragment homeFragment = new HomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.conten_main, homeFragment, homeFragment.getTag()).commit();

        // khởi tạo database luôn
        database = new Database(this);

//        // tao bảng
//        database.QueryData("CREATE TABLE QUESTION(Id INTEGER primary key autoincrement, PART INTEGER,LEVEL TEXT,QUESTION TEXT, A TEXT,B TEXT, C TEXT, D TEXT, ANSWER TEXT,IMAGE BLOB)");
//        database.QueryData("CREATE TABLE USER(Id integer primary key autoincrement,name text,score text, anh blob)");
        // INSERT DỮ LIỆU


        //LV 250
        // part 2:
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','250',null,'A','B','C','.','A',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','250',null,'A','B','C','.','B',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','250',null,'A','B','C','.','C',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','250',null,'A','B','C','.','B',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','250',null,'A','B','C','.','C',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','250',null,'A','B','C','.','A',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','250',null,'A','B','C','.','C',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','250',null,'A','B','C','.','B',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','250',null,'A','B','C','.','A',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','250',null,'A','B','C','.','B',null)");

        // part 3:
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'3','250','What is needed in the man is office?','A computer','A fax machine ',' A coffee machine ',' A scanner ','A fax machine ',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'3','250','Where does the woman get her office equipment?','From the office supply store','From her friends','From an online retail supplier','From an online wholesale supplier','From her friends',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,3,'250','What is said about the shipping?','It is very quick.','It may be cheap','It takes a long time','It may be expensive.','It is very quick.',null)");
//

//         part 4:
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'4','250','Where is the fire now?','At the fire department','On the tenth floor','In the elevators','In the staircase','On the tenth floor',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'4','250','What should employees NOT do?','Leave the building immediately','Walk to the staircase','Run','Not use the elevators','Run',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,4,'250','Who will you report to if any employee is missing?','The fire department’s manager','The building manager','The elevator operator','Your immediate supervisor','Your immediate supervisor',null)");


        // part 5:
//                database.QueryData("INSERT INTO QUESTION VALUES(null,5,'250'," +
//                "'Puppet shows, entertainers, and a giant sand pit will keep toddlers ............ until they fall asleep!.'" +
//                ",' amuse '," +
//                "'amusing '," +
//                "' amused '," +
//                "' amusement '," +
//                "'amusing '" +
//                ",null)");
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,5,'250'," +
//                "'They are allowed to gossip about everything, and the writers have the knack of making the merest trifles seem ...........'" +
//                ",' amusing '," +
//                "' amuse '," +
//                "'amused '," +
//                "'amusement '," +
//                "'amused '" +
//                ",null)");
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,5,'250'," +
//                "'As a normal person, you may sometimes feel ............., tearful, angry or anxious for no apparent reason.'" +
//                ",' depress '," +
//                "'depressing '," +
//                "'depressed '," +
//                "'depression'," +
//                "'depression'" +
//                ",null)");
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,5,'250'," +
//                "'He had resisted the seductions which always beset solitary men with restless brains overwrought by ............. agencies.'" +
//                ",' depress '," +
//                "'depressed '," +
//                "'depression '," +
//                "'depressing '," +
//                "'depressed '" +
//                ",null)");
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,5,'250'," +
//                "'Going barefoot through security at the airport is not only ............. but can be dangerous for your health.'" +
//                ",'disgusting '," +
//                "'disgusted '," +
//                "'disgust '," +
//                "' disgusts '," +
//                "'disgust '" +
//                ",null)");



        //LV 500
        // part 2:
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','500',null,'A','B','C','.','A',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','500',null,'A','B','C','.','B',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','500',null,'A','B','C','.','C',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','500',null,'A','B','C','.','D',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','500',null,'A','B','C','.','A',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','500',null,'A','B','C','.','D',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','500',null,'A','B','C','.','D',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','500',null,'A','B','C','.','A',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','500',null,'A','B','C','.','B',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','500',null,'A','B','C','.','A',null)");
//


        // part 3:
////
//                database.QueryData("INSERT INTO QUESTION VALUES(null,'3','500'," +
//                "'Where is the conversation mostly taking place?'," +
//                "' In a department store '," +
//                "'In a restaurant '," +
//                "'At an airport '," +
//                "' In a customer service office'," +
//                "' In a department store '" +
//                ",null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'3','500'," +
//                "'Where is the conversation mostly taking place?'," +
//                "' In a department store '," +
//                "'In a restaurant '," +
//                "'At an airport '," +
//                "' In a customer service office'," +
//                "' In a department store '" +
//                ",null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'3','500'," +
//                "'What does the man want?'," +
//                "'To check his account balance '," +
//                "' To get information about a discount '," +
//                "' To register for a course '," +
//                "'To inquire about a discount '," +
//                "' To register for a course '" +
//                ",null)");
        // part 4:
////
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'4','500', 'What will the weather be this week?', 'Rainy ', 'Sunny ', 'Cloudy ', 'Cold ', 'Cold ', null)");
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'4','500', 'When will it begin to get hotter?','On Wednesday ', 'After the middle of the week ', 'On the weekend ', 'After the weekend ', 'On the weekend ',null)");
//
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,4,'500', 'When will it rain?', ' Not until the middle of the week', ' Late next week ', ' Not until after the weekend', ' Next Wednesday ', ' Not until after the weekend', null)");

////        // part 5:
//           database.QueryData("INSERT INTO QUESTION VALUES(null,5,'500'," +
//                "'So they neared each other, the challenger and the ............., the champion and the invader, and quickly the village emptied itself out to see.'" +
//                ",'challenge '," +
//                "' challenger '," +
//                "' challenging '," +
//                "' challenged '," +
//                "' challenged '" +
//                ",null)");
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,5,'500'," +
//                "'When the mountaineers get back to the base, they .......... in the snowstorm for two days.'" +
//                ",'will be '," +
//                "'will have been '," +
//                "' are going to be '," +
//                "' are being '," +
//                "'will have been '" +
//                ",null)");
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,5,'500'," +
//                "'After graduating from an economic university, she suddenly changed her mind and chose a ........... career as a teacher.'" +
//                ",'challenge '," +
//                "'challenging '," +
//                "' challenger '," +
//                "' challenged '," +
//                "'challenge '" +
//                ",null)");
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,5,'500'," +
//                "'Though she is quite a strict teacher, she takes a fairly ............ attitude towards what the kids wear to school.'" +
//                ",'relax '," +
//                "'relaxed '," +
//                "'relaxing '," +
//                "'relaxes '," +
//                "'relaxes '" +
//                ",null)");
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,5,'500'," +
//                "'The coachman was evidently ............. with his task, and growled in a helpless kind of way.'" +
//                ",' will stay '," +
//                "' will have been staying '," +
//                "'will be staying '," +
//                "' am going to stay '," +
//                "' will stay '" +
//                ",null)");


        //LV750

        // PART 2
////
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','750',null,'A','B','C','.','A',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','750',null,'A','B','C','.','A',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','750',null,'A','B','C','.','C',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','750',null,'A','B','C','.','B',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','750',null,'A','B','C','.','C',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','750',null,'A','B','C','.','B',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','750',null,'A','B','C','.','A',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','750',null,'A','B','C','.','A',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','750',null,'A','B','C','.','B',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'2','750',null,'A','B','C','.','C',null)");

        // PART 3
////
//                database.QueryData("INSERT INTO QUESTION VALUES(null,'3','750'," +
//                "'What does Richard want to do?'," +
//                "'Make an advance booking '," +
//                "'Ask for some flight information '," +
//                "'Buy some furniture '," +
//                "'Make some changes to a reservation '," +
//                "'Buy some furniture '" +
//                ",null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'3','750'," +
//                "'What does the woman suggest doing?'," +
//                "'Keeping the former arrangement '," +
//                "'Buying a table to put on the balcony '," +
//                "' Taking another table instead '," +
//                "' Talking to the shop owner '," +
//                "'Keeping the former arrangement '" +
//                ",null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'3','750'," +
//                "'Where most likely are they?'," +
//                "'In a department store '," +
//                "' In a supermarket '," +
//                "' In a restaurant '," +
//                "'At a grocery store '," +
//                "' In a restaurant '" +
//                ",null)");

        // PART 4
////
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'4','750', 'What did the weather do to the departure?', 'Made it 10 minutes later ', 'Made it 30 minutes later ', 'Made it 10 minutes earlier ', 'Made it 30 minutes earlier ', 'Made it 30 minutes later ', null)");
//
//
//                database.QueryData("INSERT INTO QUESTION VALUES(null,4,'750', 'What is the flight’s destination?', 'San Diego', ' San Antonio ', ' San Francisco ', 'San Mateo ', 'San Mateo ', null)");
//
//
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'4','750', 'What is offered to those who are willing to wait for a later flight?', 'Some meal tickets ', ' A couple of round-trip domestic tickets ', 'Some movie tickets ', 'Some free seats ', 'Some movie tickets ', null)");
//


////         //PART 5
//        database.QueryData("INSERT INTO QUESTION VALUES(null,5,'750'," +
//                "'If I am elected President of the United States, I .......... sure everyone has access to inexpensive health insurance.'" +
//                ",' will make'," +
//                "' is going to make '," +
//                "' is making '," +
//                "'will have made '," +
//                "'will have made '" +
//                ",null)");
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,5,'750'," +
//                "'When the mountaineers get back to the base, they .......... in the snowstorm for two days.'" +
//                ",'will be '," +
//                "'will have been '," +
//                "' are going to be '," +
//                "' are being '," +
//                "'will have been '" +
//                ",null)");
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,5,'750'," +
//                "'You look really great! ........ you ....... out at the fitness center recently?'" +
//                ",'Do...work '," +
//                "'Have...worked '," +
//                "'Are...working '," +
//                "' Have...been working '," +
//                "'Are...working '" +
//                ",null)");
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,5,'750'," +
//                "'When you arrive in Stockholm, call my friend Gustav, he .......... you around the city and help you get situated.'" +
//                ",' will show '," +
//                "' will have shown '," +
//                "'is going to show '," +
//                "'will be showing '," +
//                "' will have shown '" +
//                ",null)");
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,5,'750'," +
//                "'I will go home on 20 June, by then I .......... at this hotel for a fortnight.'" +
//                ",' will stay '," +
//                "' will have been staying '," +
//                "'will be staying '," +
//                "' am going to stay '," +
//                "' will stay '" +
//                ",null)");


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
            HomeFragment homeFragment = new HomeFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.conten_main, homeFragment, homeFragment.getTag()).commit();
        } else if (id == R.id.lv250) {
            Lv250Activity toanhocFragment = new Lv250Activity();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.conten_main, toanhocFragment, toanhocFragment.getTag()).commit();
        }else if (id == R.id.lv500){
            Lv500Activity toanhocFragment = new Lv500Activity();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.conten_main, toanhocFragment, toanhocFragment.getTag()).commit();

        }else if (id == R.id.lv750){
            Lv750Activity toanhocFragment = new Lv750Activity();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.conten_main, toanhocFragment, toanhocFragment.getTag()).commit();
        }else if (id == R.id.LISTUSER){
            ListScoreFragment list = new ListScoreFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.conten_main, list, list.getTag()).commit();
        }else if (id == R.id.listen){
            ListenFragment list = new ListenFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.conten_main, list, list.getTag()).commit();
        }else if (id == R.id.tuvung){
            TuvungFragment list = new TuvungFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.conten_main, list, list.getTag()).commit();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
