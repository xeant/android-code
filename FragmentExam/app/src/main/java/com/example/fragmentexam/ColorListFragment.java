package com.example.fragmentexam;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.Arrays;
import java.util.List;

public class ColorListFragment extends ListFragment {
    private OnColorSelectedListener mListener;

    interface OnColorSelectedListener {
        void onColorSelected(int color);
    }


    // onColorSelected 메소드 기능을 강제함 (해당 인터페이스 구현안할시 오류 발생시킴)
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener = (OnColorSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(((Activity) context)
                    .getLocalClassName() + " 는 OnColorSelectedListener를 구현해야 합니다");
        }

    }

//    해당 클래스를 생성할때마다 실행되는 메소드
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> colorList = Arrays.asList("Red", "Green", "Blue");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, colorList);
        setListAdapter(adapter);
    }


    /*
    아이템 클릭스 실행되는 메소드
    mListener 의 onColorSelected메소드를 통해서 해당 기능을 Main메소드에서 구현시킴
     */
    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) l.getAdapter();
        String colorString = adapter.getItem(position);
        int color = Color.RED;
        switch (colorString) {
            case "Red":
                color = Color.RED;
                break;
            case "Green":
                color = Color.GREEN;
                break;
            case "Blue":
                color = Color.BLUE;
                break;
        }
        if (mListener != null) {
            mListener.onColorSelected(color);
        }
    }
}
