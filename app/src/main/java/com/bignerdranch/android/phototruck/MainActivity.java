package com.bignerdranch.android.phototruck;

import android.app.WallpaperManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.android.phototruck.utility.ItemClickSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView rvGrid,rvCategory;
    private RecyclerView.LayoutManager mLayoutManager;
    private MainAdapter mAdapter;
    private WallpaperAdapter adapter;
    TextView tvRandom ;
    private RecyclerView.LayoutManager layoutManager;

    ArrayList<String> mCategoryList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        Log.d("bla-blah", "this is just a log");
        rvGrid = (RecyclerView) findViewById(R.id.rv_grid);
        rvCategory = (RecyclerView) findViewById(R.id.rv_category);


        mCategoryList = new ArrayList<String>();
        mCategoryList.add("Nature");
        mCategoryList.add("Abstract");
        mCategoryList.add("Spiritual");
        mCategoryList.add("Cartoons");
        mCategoryList.add("Gadgets");


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



        adapter = new WallpaperAdapter(wallList, this);
        layoutManager = new GridLayoutManager(MainActivity.this, 2);
        rvGrid.setLayoutManager(layoutManager);
        rvGrid.setAdapter(adapter);
        rvGrid.setHasFixedSize(true);

        // for category
        rvCategory.setAdapter(new MainAdapter(this, mCategoryList));
        rvCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                List<Integer> wallpaperList = getWallpaperList(mCategoryList.get(position));
                // TODO: 5/21/2017 set this wallpaperList to the rvGrid  
            }
        });




        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        ItemClickSupport.addTo(rvGrid).setOnItemClickListener(
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


    /**
     * this method will retun wallpaper list based on
     * category selected.
     * */
    public List<Integer> getWallpaperList(String category){
        if (category.equalsIgnoreCase("spiritual")){
            // TODO: 5/21/2017 make a list of wallpaper based on category and return 
            final List<Integer> wallList = new ArrayList<>();
            wallList.add(R.drawable.wall1);
            wallList.add(R.drawable.wall2);
            wallList.add(R.drawable.wall3);
            wallList.add(R.drawable.wall4);
            wallList.add(R.drawable.wall7);
            return  wallList;
        } else if(category.equalsIgnoreCase("nature")){
            return null;
        }

        return null;
    }

}
