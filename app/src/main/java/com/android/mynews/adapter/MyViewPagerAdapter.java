package com.android.mynews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> mFragmentList = new ArrayList<Fragment>();
    FragmentManager mfragmentManager;
    public MyViewPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        mfragmentManager = fm;
        mFragmentList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
