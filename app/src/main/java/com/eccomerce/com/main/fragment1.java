package com.eccomerce.com.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eccomerce.com.R;
import com.eccomerce.com.constants;
import com.eccomerce.com.network.getitems;


public class fragment1 extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    Context context;
SwipeRefreshLayout swipeRefreshLayout;
    public fragment1() {
    }
public  static Handler s1,s2;
    @SuppressLint("ValidFragment")

 RecycleAdapter recycleAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        context = view.getContext();
        constants.size=0;
     swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.swipe);
     swipeRefreshLayout.setOnRefreshListener(this);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recycleAdapter = new RecycleAdapter(constants.vip,context);
        recyclerView.setAdapter(recycleAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        constants.status="2";
        s1=new Handler(){
            @Override
            public void handleMessage(Message msg) {


                swipeRefreshLayout.setRefreshing(false);
           recycleAdapter.setData(constants.vip);
            }
        };

        s2=new Handler(){
            @Override
            public void handleMessage(Message msg) {
              swipeRefreshLayout.setRefreshing(true);
            }
        };
        getitems.get_Data();
        return view;

    }

    @Override
    public void onRefresh() {
        constants.vip.clear();
        constants.size=0;
        constants.iter=true;
        recycleAdapter.setData(constants.vip);
        constants.idfd.clear();
        getitems.get_Data();
    }
}
