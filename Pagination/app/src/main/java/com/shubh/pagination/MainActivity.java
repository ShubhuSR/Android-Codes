package com.shubh.pagination;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    LinearLayoutManager manager;
    Adapter adapter;
    ArrayList list;
    Boolean isScrolling = false;
    int currentItems, totalItems, scrolledOutItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progress);
        Context context;
        manager = new LinearLayoutManager(this);

        String[] str = {"56", "35", "35", "352", "64", "45", "96", "989", "565", "656", "656", "650", "03", "98"};
        list = new ArrayList(Arrays.asList(str));

        adapter = new Adapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            //start Scrolling
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }

            @Override
            //end Scrolling
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                currentItems = manager.getChildCount(); //currently visible item count
                totalItems = manager.getItemCount();    //total items in adapter
                scrolledOutItem = manager.findFirstVisibleItemPosition();   //scrolled out of screen count

                //total item = currently visible item + scrolled out item
                //e.g. 10 = 6 + 2 ......., if both are equals then fetch new items
                if (isScrolling && (currentItems + scrolledOutItem == totalItems)) {
                    //data fetch
                    isScrolling = false;
                    fetchData();
                }
            }
        });
    }

    private void fetchData() {

        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 6; i++) {
                    list.add(Math.floor(Math.random() + 1609) + "");
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }
        }, 2000);
    }
}