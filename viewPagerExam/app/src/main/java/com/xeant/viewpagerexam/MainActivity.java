package com.xeant.viewpagerexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<PageItem>  pageItemList;
    private ViewPager2 mRecyclerView;
    private ListAdapter mListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (ViewPager2) findViewById(R.id.my_intro_view_pager);

        pageItemList = new ArrayList<>();
        pageItemList.add(new PageItem(R.color.colorOrange, R.drawable.ic_pager_item_1, "안녕하세요 1 페이지 입니다!!"));
        pageItemList.add(new PageItem(R.color.colorBlue, R.drawable.ic_pager_item_2, "안녕하세요 2 페이지 입니다!!"));
        pageItemList.add(new PageItem(R.color.colorAccent, R.drawable.ic_pager_item_3, "안녕하세요 3 페이지 입니다!!"));

//        mRecyclerView.setAdapter(new ViewPagerAdapter(pageItemList));
        mRecyclerView.setAdapter(new MyIntroPagerRecyclerAdapter(pageItemList));




//        mRecyclerView = MyIntroPagerRecyclerAdapter(pageItemList);
//                MyIntroPagerRecyclerAdapter(pageItemList);
//        myIntroPagerRecyclerAdapter = MyIntroPagerRecyclerAdapter(pageItemList)
//        pageItemList.add(PageItem(R.color.colorOrange, R.drawable.ic_pager_item_1, "안녕하세요!\n개발하는 정대리입니다!"));


    }

    public void next_action(View view) {
        Toast.makeText(this, "click NEXT " , Toast.LENGTH_SHORT).show();
    }

    public void pre_action(View view) {
        Toast.makeText(this, "click Pre " , Toast.LENGTH_SHORT).show();
    }
}