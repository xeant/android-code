package com.xeant.httpasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private  ListView mWeatherListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mWeatherListView = (ListView) findViewById(R.id.weather_list);
//        Log.d("onCreate", mWeatherListView.toString());
        // 검색
        new HttpAsyncTask().execute("https://goo.gl/eIXu9l");

    }

    private class HttpAsyncTask extends AsyncTask<String, Void, List<Weather>>{
        OkHttpClient client = new OkHttpClient();

        @Override
        public List<Weather> doInBackground(String... params) {
            List<Weather> weatherList = new ArrayList<>();
            String result = null;
            String strUrl = params[0];

            Request request = new Request.Builder()
                    .url(strUrl)
                    .build();
            Response response = null;
            try {
                response = client.newCall(request).execute();
                /*
                gson사용 예제
                 */
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<Weather>>(){}.getType();
                weatherList = gson.fromJson(response.body().string(), listType);

//                JSON ARray 사용시 예제
//                JSONArray jsonArray = new JSONArray(response.body().string());
//                for (int i = 0; i < jsonArray.length() ; i++) {
//                    JSONObject jsonObject = jsonArray.getJSONObject(i);
//                    String country = jsonObject.getString("country");
//                    String weather = jsonObject.getString("weather");
//                    String temperature = jsonObject.getString("temperature");
//                    Weather w = new Weather(country, weather, temperature);
//                    weatherList.add(w);
//                }

                Log.d(TAG, "OnCreate : " + weatherList.toString());
            } catch (IOException e) {
                e.printStackTrace();
//            } catch (JSONException e){
//
            }
            return weatherList;
        }

        @Override
        protected void onPostExecute(List<Weather> weatherList) {
            super.onPostExecute(weatherList);
            if(weatherList != null){
                WeatherAdapter adapter = new WeatherAdapter(weatherList);
                mWeatherListView.setAdapter(adapter);
                Log.d(TAG, weatherList.toString());
            }
            //super.onPostExecute(weatherList.toString());
        }
    }
}

//https://github.com/junsuk5/android-first-book/blob/master/OkHttpExam/src/main/java/com/example/okhttpexam/MainActivity.java