package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager ;
    ColorFlagment colorFlagment;
    Color2Flagment color2Flagment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2  viewPager = findViewById(R.id.pager);

        MyPagerAdapter adapter = new MyPagerAdapter(colorFlagment);
        viewPager.setAdapter(adapter);


    }
}