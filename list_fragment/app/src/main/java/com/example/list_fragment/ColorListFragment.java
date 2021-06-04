package com.example.list_fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.Arrays;
import java.util.List;

public class ColorListFragment extends ListFragment {
    private onColorSelectedListener mListener;
//    public void setOnColorSelectedListener (onColorSelectedListener listener){
//        mListener = listener;
//    }

    interface onColorSelectedListener{
        void onColorSelected(int color);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) l.getAdapter();
        String colorString = adapter.getItem(position);
        int color = Color.RED;

        switch (colorString){
            case "RED" :
                color = Color.RED;
                break;
            case "GREEN" :
                color = Color.GREEN;
                break;
            case "BLUE":
                color = Color.BLUE;
                break;
        }
        if(mListener != null){
            mListener.onColorSelected(color);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener = (onColorSelectedListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(((Activity)context).getLocalClassName() + "구현하라" );
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<String> colorList = Arrays.asList("RED", "GREEN", "BLUE");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, colorList);
        setListAdapter(adapter);
    }
}
