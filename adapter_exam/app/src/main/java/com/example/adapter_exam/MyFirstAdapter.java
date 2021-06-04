package com.example.adapter_exam;

import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFirstAdapter  extends BaseAdapter {
    private final List mData;
    private Map<String, Integer> mWeatherImageMap;


    public MyFirstAdapter(List<Weather> data) {
        mData = data;
        mWeatherImageMap = new HashMap<>();
        mWeatherImageMap.put("맑음", R.drawable.sunny);
        mWeatherImageMap.put("폭설", R.drawable.blizzard);
        mWeatherImageMap.put("구름", R.drawable.cloudy);
        mWeatherImageMap.put("비", R.drawable.rainy);
        mWeatherImageMap.put("눈", R.drawable.snow);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

//        처음 들어올때는 convertView 값이 null 임
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_weather, parent, false);

            ImageView weatherImage = convertView.findViewById(R.id.icon_image);
            TextView cityText = convertView.findViewById(R.id.city_text);
            TextView tempText = convertView.findViewById(R.id.temp_text);
            holder.weatherImage = weatherImage;
            holder.cityText = cityText;
            holder.tempText = tempText;
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Weather weather = (Weather) mData.get(position);
        holder.cityText.setText(weather.getCity());
        holder.tempText.setText(weather.getTemp());
        holder.weatherImage.setImageResource(mWeatherImageMap.get(weather.getWeather()));

        String text = weather.getCity();
        text = "생성" + text;
        Log.d("XEANT", text);
        return convertView;
    }

    static class ViewHolder {
        ImageView weatherImage;
        TextView cityText;
        TextView tempText;
    }
}
