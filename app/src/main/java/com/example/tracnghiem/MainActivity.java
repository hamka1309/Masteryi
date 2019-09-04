package com.example.tracnghiem;

import android.content.Intent;
import android.os.Bundle;

import com.example.tracnghiem.Add.ThemPart1;
import com.example.tracnghiem.activityfragment.ListScoreFragment;
import com.example.tracnghiem.database.Database;
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
//        // INSERT DỮ LIỆU
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'3','250','What is needed in the man is office?','A computer','A coffee machine','A fax machine','A scanner','A scanner',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'3','250','Where does the woman get her office equipment?','From the office supply store','From her friends','From an online retail supplier','From an online wholesale supplier','From her friends',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,3,'250','What is said about the shipping?','It is very quick.','It may be cheap','It takes a long time','It may be expensive.','It is very quick.',null)");
//
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'4','250','Where is the fire now?','At the fire department','On the tenth floor','In the elevators','In the staircase','On the tenth floor',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,'4','250','What should employees NOT do?','Leave the building immediately','Walk to the staircase','Run','Not use the elevators','Run',null)");
//        database.QueryData("INSERT INTO QUESTION VALUES(null,4,'250','Who will you report to if any employee is missing?','The fire department’s manager','The building manager','The elevator operator','Your immediate supervisor','Your immediate supervisor',null)");




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
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
