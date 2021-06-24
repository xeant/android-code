package com.xeant.retrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.xeant.retrofit.json.ResultModel;
import com.xeant.retrofit.json.RetrofitUtil;
import com.xeant.retrofit.json.UserApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ProgressBar loadingProgressBar;
    private UserApi mUserApi;

    private RetrofitUtil mRetrofitUtil;
    private TextView mConsole;
    private String mStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        loadingProgressBar = findViewById(R.id.loading);
        mConsole = findViewById(R.id.console);

        mUserApi = new RetrofitUtil().getUserApi();
        loginButton.setOnClickListener(this);
        mStr = "asdfasdf";
        mRetrofitUtil = new RetrofitUtil();
    }

    @Override
    public void onClick(View v) {
        Call<ResultModel> call = mUserApi.get_config("sendcore", "getSendcoreConfig");

        Toast.makeText(this, "Call REsponse", Toast.LENGTH_SHORT).show();
        loadingProgressBar.setVisibility(View.VISIBLE);
        // 비동기 네트워크 처리
        call.enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                // 네트워크 통신 성공
                loadingProgressBar.setVisibility(View.GONE);
                ResultModel result_sendcore = response.body();
                mConsole.setText(response.toString());

                Log.d("response다!!!!", response.body().toString());

//                result_sendcore.getConfig().getApi_key();
                Log.d("XEANTj----------------------", result_sendcore.toString());

                Log.d("SENDCORE : ::::   ----------------------", result_sendcore.getSendcore().toString());
//                Log.d("XEANT ::::::::::::", result_sendcore.getMessage().toString());

                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "네트워크 실패1", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                } else {
//                    result_sendcore.getResult().equals("OK")
                }
            }

            @Override
            public void onFailure(Call<ResultModel> call, Throwable t) {
                // 네트워크 통신 실패
                Toast.makeText(MainActivity.this, "네트워크 실패2", Toast.LENGTH_SHORT).show();
                Log.d("나다 : onFailure", t.toString());
            }
        });
    }
}