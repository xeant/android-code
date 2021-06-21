package com.xeant.viewpagerexam;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class MyIntroPagerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ImageView itemImage;
    private LinearLayout itemBg;
    private TextView itemContent;
    private static String TAG = "XEANT";
//    pager_item_bg

    public MyIntroPagerViewHolder(@NonNull View itemView) {
        super(itemView);
        itemImage = itemView.findViewById(R.id.pager_item_image);
        itemContent = itemView.findViewById(R.id.pager_item_text);
        itemBg = itemView.findViewById(R.id.pager_item_bg);

        itemView.setOnClickListener(this);
    }
    public void bindWithView(PageItem pageItem){
        Log.d(TAG, pageItem.getBgColor().toString());
        Log.d(TAG, "변경 발생!");
        itemImage.setImageResource(pageItem.getImageSrc());
        itemContent.setText(pageItem.getContent());
        itemBg.setBackgroundColor(pageItem.getBgColor());

        if(pageItem.getBgColor() != R.color.colorWhite){
            itemContent.setTextColor(Color.WHITE);
        }
    }

    @Override
    public void onClick(View v) {
       Log.d("XEANT " , "Click This ITEM" + v.toString());
    }
}

