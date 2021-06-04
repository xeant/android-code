package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> mData = new ArrayList<>();

    public MyPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
        mData.add(new Color2Flagment());
        mData.add(new ColorFlagment());

    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mData.get(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
