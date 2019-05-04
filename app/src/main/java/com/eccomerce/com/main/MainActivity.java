package com.eccomerce.com.main;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;




import com.eccomerce.com.R;
import com.eccomerce.com.categories.categories;


public class MainActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {
    ViewPager viewPager;
    SectionsPagerAdapter sectionsPagerAdapter;
    TabLayout tabLayout;
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    public  static Handler s1=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        toolbar = (Toolbar) findViewById(R.id.toolbar_car_sahypa);
        setSupportActionBar(toolbar);
        bottomNavigationView=(  BottomNavigationView )findViewById(R.id.navigationView);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        sectionsPagerAdapter.AddFragment(new fragment1(),"best" );
        sectionsPagerAdapter.AddFragment(new fragment2(), "new");
        sectionsPagerAdapter.AddFragment(new fragment3(), "all");
        viewPager.setAdapter(sectionsPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        s1=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                bottomNavigationView.setSelectedItemId(R.id.uslugi);
            }};
 bottomNavigationView.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
     @Override
     public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
         switch (menuItem.getItemId()) {
             case R.id.home1:
                 Log.d("post","1");
              //   menuItem.setTitle(R.string.app_name);
            //     bottomNavigationView.setSelectedItemId(R.id.home1);
                 updateNavigationBarState("home");
                 break;
             case R.id.uslugi:
                 Log.d("post","2");
                //
                 updateNavigationBarState( "uslugi");

                 //  bottomNavigationView.setSelectedItemId(R.id.uslugi);
                 break;
             case R.id.favorite:
                 Log.d("post","3");
                 updateNavigationBarState("liked");
              //   bottomNavigationView.setSelectedItemId(R.id.home1);
                 break;
             case R.id.person:
                 Log.d("post","4");
                 updateNavigationBarState("user");
                 break;
             default:
                 break;
         }
       // s1.sendEmptyMessage(1);
         return false;
     }
 });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.se, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent = new Intent(MainActivity.this, categories.class);
        startActivity(intent);
        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
    private void updateNavigationBarState(  String actionId){
        Menu menu = bottomNavigationView.getMenu();
        Log.d("post",""+actionId);
        for (int i = 0, size = menu.size(); i < size; i++) {

            MenuItem item = menu.getItem(i);
            Log.d("post1",""+item.toString().equals(actionId));
            if (item.toString().equals(actionId))item.setChecked(true);

        }
    }
}