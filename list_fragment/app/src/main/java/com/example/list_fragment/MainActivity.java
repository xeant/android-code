package com.example.list_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;


// Main ACTIVITY 오류 있음
public class MainActivity extends AppCompatActivity implements ColorListFragment.onColorSelectedListener{

    private ColorFragment mColorFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           mColorFragment = (ColorFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_color);

    }

    @Override
    public void onColorSelected(int color) {
        mColorFragment.setColor(color);
    }


}