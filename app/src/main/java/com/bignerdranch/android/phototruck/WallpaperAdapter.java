package com.bignerdranch.android.phototruck;

/**
 * Created by akanksha on 5/19/2017.
 */

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.RecyclerViewHolder>  {

    List<Integer> wallList;
    Context c;



    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView ivWallpaper;
        RecyclerViewHolder(View view) {
            super(view);
            ivWallpaper = (ImageView) view.findViewById(R.id.iv_wallpaper);
        }
    }

    public WallpaperAdapter(List<Integer> wallList, Context c) {
        this.wallList = wallList;
        this.c = c;
    }


    @Override
    public WallpaperAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wallpaper_row,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(WallpaperAdapter.RecyclerViewHolder viewHolder, int position) {
        viewHolder.ivWallpaper.setImageResource(wallList.get(position));
    }


    @Override
    public int getItemCount() {
        return wallList.size();
    }
}
