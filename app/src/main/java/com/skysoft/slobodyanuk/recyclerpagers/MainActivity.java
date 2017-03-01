package com.skysoft.slobodyanuk.recyclerpagers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.skysoft.slobodyanuk.recyclerpagers.adapters.HorizontalRecyclerAdapter;
import com.skysoft.slobodyanuk.recyclerpagers.adapters.VerticalRecyclerAdapter;
import com.skysoft.slobodyanuk.recyclerpagers.models.HorizontalListData;
import com.skysoft.slobodyanuk.recyclerpagers.models.ListData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list_f)
    RecyclerView fList;

    @BindView(R.id.list_s)
    RecyclerView sList;

    @BindView(R.id.list_t)
    RecyclerView tList;

    @BindView(R.id.base_list)
    RecyclerView mainList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<HorizontalListData> fListData = new ArrayList<>();
        List<HorizontalListData> sListData = new ArrayList<>();
        List<HorizontalListData> tListData = new ArrayList<>();
        List<ListData> mainListData = new ArrayList<>();

        for (int i = 0; i <= 20; i++ ) {
            fListData.add(new HorizontalListData("Title f # " + i, "SubTitle f # " + i, "url"));
        }

        for (int i = 0; i <= 15; i++ ) {
            sListData.add(new HorizontalListData("Title s # " + i, "SubTitle s # " + i, "url"));
        }

        for (int i = 0; i <= 30; i++ ) {
            tListData.add(new HorizontalListData("Title t # " + i, "SubTitle t # " + i, "url"));
        }

        for (int i = 0; i <= 15; i++ ) {
            mainListData.add(new ListData("Title b # " + i, "SubTitle t # " + i));
        }

        HorizontalRecyclerAdapter fAdapter = new HorizontalRecyclerAdapter(fListData);
        HorizontalRecyclerAdapter sAdapter = new HorizontalRecyclerAdapter(sListData);
        HorizontalRecyclerAdapter tAdapter = new HorizontalRecyclerAdapter(tListData);
        VerticalRecyclerAdapter mainAdapter = new VerticalRecyclerAdapter(mainListData);

        fList.setAdapter(fAdapter);
        fList.setNestedScrollingEnabled(false);
        fList.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false));

        sList.setAdapter(sAdapter);
        sList.setNestedScrollingEnabled(false);
        sList.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false));

        tList.setAdapter(tAdapter);
        tList.setNestedScrollingEnabled(false);
        tList.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false));

        mainList.setAdapter(mainAdapter);
        mainList.setNestedScrollingEnabled(false);
        mainList.setLayoutManager(new LinearLayoutManager(this));
    }
}
