package com.xeant.glideexam;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MyCursorAdapter extends CursorAdapter {
    public MyCursorAdapter(Context context, Cursor c) {
        super(context, c, false);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_photo, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView imageView = (ImageView) view.findViewById(R.id.photo_image);

        // 사진 경로 가지고 오기 (URI)
        String uri = cursor.getString
                (cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));

        // 사진을 이미지뷰에 표시하기
//         imageView.setImageURI(Uri.parse(uri));
        Glide.with(context).load(uri).into(imageView);
    }
}