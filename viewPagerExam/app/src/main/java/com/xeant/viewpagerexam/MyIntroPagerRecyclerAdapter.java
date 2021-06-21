package com.xeant.viewpagerexam;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// MyIntroPagerRecyclerAdapter
// Adapter 클래스는 Viewholder 객체를 생성하고, 데이터와 Viewholder 를 결합해서, 화면으로 뿌려주는 역할을 담당
public class MyIntroPagerRecyclerAdapter extends RecyclerView.Adapter<MyIntroPagerViewHolder>{
    private ArrayList<PageItem> mPageItems;
    private Context mContext;
    private static String TAG = "XEANT ";
    public MyIntroPagerRecyclerAdapter(Context context, ArrayList<PageItem> mPageItems) {
        this.mPageItems = mPageItems;
        this.mContext = context;
    }

    // ViewHolder 객체 생성후 생성된 객체를 리턴
    @NonNull
    @Override
    public MyIntroPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_intro_pager_item, parent, false);
        return new MyIntroPagerViewHolder(view);
    }

    // 페이지 넘길때, 발생하는 이벤트
    @Override
    public void onBindViewHolder(@NonNull MyIntroPagerViewHolder holder, int position) {
        // 데이터와 뷰를 묶는다
        Log.d(TAG, "onBindViewHOlder 실행"+ position);
//        PageItem pageItem = mPageItems.get(position);
        holder.bindWithView(mPageItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mPageItems.size();
    }
}
