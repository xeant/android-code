package com.example.list_fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.list_fragment.R;


public class ColorFragment extends Fragment {
    private int mColor;
    public TextView mTextView;

    public ColorFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
/*
            View view = inflater.inflate(R.layout.activity_main, container, false);
            mTextView = view.findViewById(R.id.fragment_color);
            mColor = Color.GRAY;
            return view;
*/
        View view = inflater.inflate(R.layout.fragment_color, container, false);
        mTextView = view.findViewById(R.id.view_color);
        mColor = Color.GRAY;
        return view;

//            return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void setColor(int color) {
        mColor = color;
        if (mTextView != null) {
            mTextView.setBackgroundColor(mColor);
        }
//        getView().setBackgroundColor(color);
    }
}
