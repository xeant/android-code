package com.xeant.loginexam.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.xeant.loginexam.R;
import com.xeant.loginexam.login.ResultModel;
import com.xeant.loginexam.login.RetrofitUtil;
import com.xeant.loginexam.login.UserApi;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private LoginViewModel loginViewModel;
    private EditText usernameEditText ;
    private EditText passwordEditText ;
    private Button loginButton;
    private ProgressBar loadingProgressBar;
    private UserApi mUserApi;

    private RetrofitUtil mRetrofitUtil;
    private TextView mConsole ;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        loadingProgressBar = findViewById(R.id.loading);
        mConsole = findViewById(R.id.console);

        mUserApi = new RetrofitUtil().getUserApi();
        loginButton.setOnClickListener(this);

        mRetrofitUtil = new RetrofitUtil();
    }

    @Override
    public void onClick(View v) {
//        Call<ResultModel> call =  mUserApi.login(usernameEditText.getText().toString(), passwordEditText.getText().toString());
        Call<ResultModel> call =  mUserApi.get_config("sendcore","getSendcoreConfig");

        Toast.makeText(this, "Call REsponse", Toast.LENGTH_SHORT).show();
        // 비동기 네트워크 처리
        call.enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                // 네트워크 통신 성공
                ResultModel result = response.body();
                mConsole.setText(response.toString());

                Log.d("response다!!!!", response.body().toString());

//                result.getConfig().getApi_key();
                Log.d("XEANTj----------------------", result.toString());

                Log.d("SENDCORE : ::::   ----------------------",result.getSendcore().toString() );
//                Log.d("XEANT ::::::::::::", result.getMessage().toString());

                if (!response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "네트워크 실패1", Toast.LENGTH_SHORT).show();
                }else{
//                    result.getResult().equals("OK")

                }
            }
            @Override
            public void onFailure(Call<ResultModel> call, Throwable t) {
                // 네트워크 통신 실패
                Toast.makeText(LoginActivity.this, "네트워크 실패2", Toast.LENGTH_SHORT).show();
                Log.d("나다 : onFailure", t.toString());
            }
        });

    }

}