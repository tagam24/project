package com.eccomerce.com.liked;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.eccomerce.com.R;
import com.eccomerce.com.constants;
import com.eccomerce.com.main.RecycleAdapter;
import com.eccomerce.com.network.getitems;

public class liked extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    RecycleAdapter recycleAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    Toolbar toolbar;
    public  static Handler s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        toolbar = (Toolbar) findViewById(R.id.toolbar_car_sahypa);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        constants.size=0;
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(this);
        recycleAdapter = new RecycleAdapter(constants.allitem,this);
        recyclerView.setAdapter(recycleAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        s1=new Handler(){
            @Override
            public void handleMessage(Message msg) {


                swipeRefreshLayout.setRefreshing(false);
                recycleAdapter.setData(constants.allitem);
            }
        };
        s2=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                swipeRefreshLayout.setRefreshing(true);
            }
        };

        getitems.get_Data();
    }

    @Override
    public void onRefresh() {

    }
}
