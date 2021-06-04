package com.xeant.viewpagerexam;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    
    
    // Fragment 교체를 보여주는 처리를 구현
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return FragMonday.newInstance();
            case 1:
                return FragTuesday.newInstance();
            case 2:
                return FragWensday.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    // 상단 탭 레이아웃 텍스트 설정
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "월요일";
            case 1:
                return "화요일";
            case 2:
                return "수요일";
            default:
                return super.getPageTitle(position);
        }
    }
}
