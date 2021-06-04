package com.example.fragmentexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements ColorListFragment.OnColorSelectedListener {
    private  ColorFragment mColorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mColorFragment = (ColorFragment) getSupportFragmentManager()
                .findFragmentById(R.id.color_fragment);
    }

    /*
    버튼을 클릭시 마다 발생하는 메소드
    R.id.container는 Fragment의 부모 요소(일반적으로 Frame 레이아웃을 활용)
    기존 객체를 가지고 setColor실행한다 이후 Fragment변경을 실행한다.
     */
    public void change(View view) {
        ColorFragment fragment = new ColorFragment();
        int red = new Random().nextInt(256);
        int green = new Random().nextInt(256);
        int blue = new Random().nextInt(256);

        mColorFragment.setColor(Color.rgb(red, green, blue));

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    /*
    뒤로가기 버튼 처리 (Fragment처리시, 화면 회전에 관계 없이 유지된다 )
     */
    @Override
    public void onBackPressed() {
        DialogFragment fragment = new DialogFragment();
        fragment.show(getSupportFragmentManager(), "exit");
    }

    /*
    Colorfragment의 선택된 요소에 대한 처리
     */
    @Override
    public void onColorSelected(int color) {
        mColorFragment.setColor(color);
    }
}
