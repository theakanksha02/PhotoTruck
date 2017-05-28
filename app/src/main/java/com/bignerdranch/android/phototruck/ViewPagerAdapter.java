package com.bignerdranch.android.phototruck;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akanksha on 5/28/2017.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {


    final int PAGE_COUNT = 5;
    private String tabTitles[] = new String[] { "Nature", "Abstract", "Spiritual","Cartoons","Gadgets" };
    private Context context;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return Nature.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}