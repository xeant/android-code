package com.example.fragmentexam;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ColorFragment extends Fragment {

    public TextView mHelloTextView;
    private int mColor; 

    public ColorFragment() {
        // Required empty public constructor
    }

    /*
    ColorFragment를 생성시마다 호출됨
    Layouts/fragment_color 레이아웃 요소에 있는 R.id.hello 요소를 찾아서 지역 변수로 할당
    추후 활용한다
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(" *1*2 사이* XEANT+ ONCREATE VIEW" , "정상 실행됨");
        View view = inflater.inflate(R.layout.fragment_color, container, false);
        mHelloTextView = view.findViewById(R.id.hello);
        mColor = Color.RED; 
        return view;
    }


    /*
    ColorFragment 요소의 setColor메소드 호출시 실행됨( 주의 할점은 객체 생성전 호출될수도 있다. 그래서 mHelloTextView 지역변수가 null인지 체크함
     */
    public void setColor(int color) {
        Log.d("XEANT COLOR", "setColor 실행됨");
        mColor = color;
        if (mHelloTextView != null) {
            mHelloTextView.setBackgroundColor(mColor);
        }
    }
}