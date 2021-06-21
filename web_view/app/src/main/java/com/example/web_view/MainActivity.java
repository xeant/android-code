package com.example.web_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {


    private EditText mAddressEdit;
    private WebView myWebView;
    private Button mMoveButton;
    public static final String ADDRESS = "http://xeant.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.web_view);

        // WebView의 설정
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());

        myWebView.loadUrl(MainActivity.ADDRESS);
        
        mAddressEdit = (EditText) findViewById(R.id.address_edit);
        mMoveButton = (Button) findViewById(R.id.move_button);
        
        // SOFRT
//        mAddressEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                    mMoveButton.callOnClick();
//                    return true;
//                }
//                return false;
//            }
//        });

        // 소프트키보드의 돋보기를 클릭했을 때 이동 버튼을 클릭하도록 함
        mAddressEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    mMoveButton.callOnClick();

                    // 키보드 내리기
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });
    }

    public void onClick(View view) {
        String address = mAddressEdit.getText().toString();
        if (address.startsWith("http://") == false) {
            address = "http://" + address;
        }
        myWebView.loadUrl(address);

//        WebView webview = new WebView(this);
//        setContentView(webview);
//        String url = "http://www.example.com";
//        String postData = "username=" + URLEncoder.encode(my_username, "UTF-8") + "&password=" + URLEncoder.encode(my_password, "UTF-8");
//        webview.postUrl(url,postData.getBytes());

//````````````````````````````````````````
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
        inflater.inflate(R.menu.menu_main, menu);
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