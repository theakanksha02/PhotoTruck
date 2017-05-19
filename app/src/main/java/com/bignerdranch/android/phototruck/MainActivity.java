package com.bignerdranch.android.phototruck;

import android.app.WallpaperManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.android.phototruck.utility.ItemClickSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MainAdapter mAdapter;
    private WallpaperAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        ArrayList<String> categoryList =new ArrayList<String>();
        categoryList.add("Nature");
        categoryList.add("Abstract");
        categoryList.add("Spiritual");
        categoryList.add("Cartoons");
        categoryList.add("Gadgets");


        final List<Integer> wallList = new ArrayList<>();
        wallList.add(R.drawable.wall1);
        wallList.add(R.drawable.wall2);
        wallList.add(R.drawable.wall3);
        wallList.add(R.drawable.wall4);
        wallList.add(R.drawable.wall7);
        wallList.add(R.drawable.wall8);
        wallList.add(R.drawable.wall9);
        wallList.add(R.drawable.wall10);
        wallList.add(R.drawable.wall11);
        wallList.add(R.drawable.wall12);
        wallList.add(R.drawable.wall13);
        wallList.add(R.drawable.wall15);
        wallList.add(R.drawable.wall16);
        wallList.add(R.drawable.wall17);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MainAdapter(this, categoryList);
        mRecyclerView.setAdapter(mAdapter);

        adapter = new WallpaperAdapter(wallList, this);
        layoutManager = new GridLayoutManager(MainActivity.this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);


        ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(
                new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        // here you handle what you want to do on the click of item.
                        // set the wallpaper here.
                        int imageResource = wallList.get(position);
                        setThisAsWallpaper(imageResource);

                    }
                }
        );


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    void setThisAsWallpaper(int imageResource){
        WallpaperManager wallmgr= WallpaperManager.getInstance(getApplicationContext());
        try
        {
            wallmgr.setResource(imageResource);
            Toast.makeText(MainActivity.this, "Yolo, Your wallpaper updated", Toast.LENGTH_SHORT).show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
