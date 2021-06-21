package com.xeant.viewpagerexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<PageItem>  pageItemList;
    private ViewPager2 mRecyclerView;
    private MyIntroPagerRecyclerAdapter my_recycler_adapter;
    private DotsIndicator dotsIndicator ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (ViewPager2) findViewById(R.id.my_intro_view_pager);

        // 데이터 배열
        pageItemList = new ArrayList<>();
        int purple_700 = Color.parseColor("#FF018786");
        int teal_200 = Color.parseColor("#03DAC5");
        int teal_700 = Color.parseColor("#018786");

        pageItemList.add(new PageItem(Color.RED, R.drawable.ic_pager_item_1, "안녕하세요 1 페이지 입니다!!"));
        pageItemList.add(new PageItem(Color.BLUE, R.drawable.ic_pager_item_2, "안녕하세요 2 페이지 입니다!!"));
        pageItemList.add(new PageItem(purple_700, R.drawable.ic_pager_item_3, "안녕하세요 3 페이지 입니다!!"));
        pageItemList.add(new PageItem(R.color.colorAccent, R.drawable.ic_pager_item_1, "안녕하세요 4 페이지 입니다!!"));
        pageItemList.add(new PageItem(R.color.black_ss, R.drawable.ic_pager_item_2, "안녕하세요 5 페이지 입니다!!"));
        pageItemList.add(new PageItem(R.color.colorWhite, R.drawable.ic_pager_item_3, "안녕하세요 6 페이지 입니다!!"));
        pageItemList.add(new PageItem(teal_200, R.drawable.ic_pager_item_1, "안녕하세요 7 페이지 입니다!!"));
        pageItemList.add(new PageItem(teal_700, R.drawable.ic_pager_item_2, "안녕하세요 8 페이지 입니다!!"));
        //pageItemList.add(new PageItem(R.color.teal_700, R.drawable.ic_pager_item_3, "안녕하세요 9 페이지 입니다!!"));
        pageItemList.add(new PageItem(R.color.colorOrange, R.drawable.ic_pager_item_3, "안녕하세요 9 페이지 입니다!!"));

        my_recycler_adapter = new MyIntroPagerRecyclerAdapter(this, pageItemList);
        mRecyclerView.setAdapter(my_recycler_adapter);

        // 가로로 페이지 이동
        mRecyclerView.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        dotsIndicator = (DotsIndicator) findViewById(R.id.dots_indicator);
        dotsIndicator.setViewPager2(mRecyclerView);
    }

    public void next_action(View view) {
        Toast.makeText(this, "click NEXT " , Toast.LENGTH_SHORT).show();
        mRecyclerView.setCurrentItem(mRecyclerView.getCurrentItem()+1);
    }

    public void pre_action(View view) {
        Toast.makeText(this, "click Pre " , Toast.LENGTH_SHORT).show();
        mRecyclerView.setCurrentItem(mRecyclerView.getCurrentItem()-1);
    }
}