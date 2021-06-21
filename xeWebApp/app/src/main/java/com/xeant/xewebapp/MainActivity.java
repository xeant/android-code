package com.xeant.xewebapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "XEWebPUSH APP";
    private WebView myWebView;
    private String postData;
    private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().getToken()
        .addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if(!task.isSuccessful()){
                    Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                    return;
                }
                token = task.getResult();

                String msg = "CREATE NEW TOKEN : " + token;
                Log.d(TAG, msg);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

            }
        });

        myWebView = (WebView) findViewById(R.id.web_view);

        // WebView의 설정
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());

//        setContentView(myWebView);

//        WebView webview = new WebView(this);
//        setContentView(webview);
//        String url = "http://www.example.com";
//        String postData = "username=" + URLEncoder.encode(my_username, "UTF-8") + "&password=" + URLEncoder.encode(my_password, "UTF-8");
//        webview.postUrl(url,postData.getBytes());
//

        String url = "https://gjworks.me";

        try {
            postData = "module=" + URLEncoder.encode("member", "UTF-8") + "&act=" + URLEncoder.encode("procMemberRegisterDevice", "UTF-8")+ "&id="+ URLEncoder.encode("xeant",
                    "UTF-8") + "&password="+ URLEncoder.encode("ajsj!gj0907A", "UTF-8") + "&token="+ URLEncoder.encode(token, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        myWebView.postUrl(url,postData.getBytes());
//        String postData = "module" + URLEncoder.encode("member", "UTF-8");
//        postData =  postData + "&act" + URLEncoder.encode("procMemberRegisterDevice", "UTF-8");
//        member.procMemberRegisterDevice
//        String postData = "username=" + URLEncoder.encode(my_username, "UTF-8") + "&password=" + URLEncoder.encode(my_password, "UTF-8");
//        webview.postUrl(url,postData.getBytes());


//        myWebView.loadUrl(MainActivity.ADDRESS);

    }


    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_back:
                // 뒤로 가기
                if (myWebView.canGoBack()) {
                    myWebView.goBack();
                }
                break;
            case R.id.action_forward:
                // 앞으로 가기
                if (myWebView.canGoForward()) {
                    myWebView.goForward();
                }
                break;
            case R.id.action_refresh:
                // 새로고침
                myWebView.reload();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}