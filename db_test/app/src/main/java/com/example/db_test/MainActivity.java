package com.example.db_test;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.Realm.Transaction.OnSuccess;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements RealmChangeListener<Realm> {
    //    REAlM
    private Realm mRealm;
    private Button btn_del;
    private Button btn_login;
    private Button btn_update;
    private Button btn_sign;

    private TextView console;
    private EditText mEmail;
    private EditText mPassword;
    private EditText mNewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRealm = Realm.getDefaultInstance();
        mRealm.addChangeListener(this);

        btn_del = findViewById(R.id.del_btn);
        btn_login = findViewById(R.id.login_btn);
        btn_sign = findViewById(R.id.sign_up_btn);
        btn_update = findViewById(R.id.update_btn);
        console = findViewById(R.id.console);

        mEmail = findViewById(R.id.email);
        mNewPassword = findViewById(R.id.new_password);
        mPassword = findViewById(R.id.password);
        showResult();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }

    public void login(View view) {
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        User user = mRealm.where(User.class)
                .equalTo("email", email)
                .equalTo("password", password)
                .findFirst();
        if (user != null) {
            Toast.makeText(MainActivity.this, "성공", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "실패", Toast.LENGTH_SHORT).show();
        }
    }

    public void sign_up(View view) {
        if (mRealm.where(User.class)
                .equalTo("email", mEmail.getText().toString())
                .count() == 0) {
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    // 중복 값일때 취소
                    User user = realm.createObject(User.class);
                    user.setEmail(mEmail.getText().toString());
                    user.setPassword(mPassword.getText().toString());
                }
            });
        }else{
            Toast.makeText(MainActivity.this, "중복", Toast.LENGTH_SHORT).show();
        }
    }

    public void updatePassword(View view) {
        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                User user = realm.where(User.class)
                        .equalTo("email", mEmail.getText().toString())
                        .findFirst();
                    user.setPassword(mNewPassword.getText().toString());
            }
        });

         /*
            }, new Realm.Transaction.OnSuccess(){
                @Override
                public void onSuccess() {
                    Toast.makeText(MainActivity.this, "성공", Toast.LENGTH_SHORT).show();
                }
            }, new Realm.Transaction.OnError(){

                @Override
                public void onError(Throwable error) {
                    Toast.makeText(MainActivity.this, "실패", Toast.LENGTH_SHORT).show();
                    Log.d("XEANT_update", error.toString());
                }
            });
            */
    }

    public void deleteAccount(View view) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<User> results = realm.where(User.class)
                        .equalTo("email", mEmail.getText().toString())
                        .equalTo("password", mPassword.getText().toString())
                        .findAll();
                results.deleteAllFromRealm();
            }
        });
                /*
            }, new Realm.Transaction.OnSuccess(){
                @Override
                public void onSuccess() {
                    Toast.makeText(MainActivity.this, "성공", Toast.LENGTH_SHORT).show();
                }
            }, new Realm.Transaction.OnError(){

                @Override
                public void onError(Throwable error) {
                    Toast.makeText(MainActivity.this, "실패", Toast.LENGTH_SHORT).show();
                    Log.d("XEANT_Del", error.toString());
                }
            });
            */
    }

    public void showResult() {
        RealmResults<User> userList = mRealm.where(User.class).findAll();
        console.setText(userList.toString());

    }

    @Override
    public void onChange(Realm realm) {
        Log.d("XEANT_CHANGE", realm.toString());
        showResult();
    }
}