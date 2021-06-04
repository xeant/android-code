package com.example.adapter_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Weather> data = new ArrayList<>();
        data.add(new Weather("울산1", "25도", "비"));
        data.add(new Weather("울산2", "22도", "맑음"));
        data.add(new Weather("울산3", "25도", "눈"));
        data.add(new Weather("울산4", "25도", "구름"));
        data.add(new Weather("울산5", "21도", "눈"));
        data.add(new Weather("울산6", "25도", "맑음"));
        data.add(new Weather("울산7", "25도", "맑음"));
        data.add(new Weather("울산8", "27도", "비"));
        data.add(new Weather("울산9", "25도", "맑음"));
        data.add(new Weather("울산10", "25도", "구름"));
        data.add(new Weather("울산11", "25도", "맑음"));
        data.add(new Weather("울산12", "35도", "맑음"));

        MyFirstAdapter adapter = new MyFirstAdapter(data);

        ListView listView = findViewById(R.id.List_view);
        listView.setAdapter(adapter);
    }
}