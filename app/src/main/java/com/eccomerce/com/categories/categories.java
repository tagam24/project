package com.eccomerce.com.categories;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.eccomerce.com.R;
import com.eccomerce.com.constants;
import com.eccomerce.com.main.RecycleAdapter;

public class categories extends AppCompatActivity {
    RecycleAdaptercategories r;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        toolbar = (Toolbar) findViewById(R.id.toolbar_car_sahypa);
     //   setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        constants.categories.add(new modelcategories("1","food","1.jpg"));
        constants.categories.add(new modelcategories("2","wesd","1.jpg"));
        r = new RecycleAdaptercategories(constants.categories,this);
        recyclerView.setAdapter(r);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
