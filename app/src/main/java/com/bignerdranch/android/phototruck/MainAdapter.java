package com.bignerdranch.android.phototruck;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.android.phototruck.utility.FontsFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akanksha on 5/15/2017.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {


    private List<String> categoryList;
    Context mContext;
    public MainAdapter(Context c, List<String> categoryList) {
        this.categoryList = categoryList;
        this.mContext = c;
    }
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {
        holder.mTitle.setText(categoryList.get(position));

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mTitle.setTypeface(FontsFactory.fontBold(mContext));
        }
    }
}
