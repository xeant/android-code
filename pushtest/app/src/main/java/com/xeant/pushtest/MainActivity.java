package com.xeant.pushtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "PUSHTEST - ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
//                        String msg = getString(R.string.msg_token_fmt, token);
                        String msg = "CREATE NEW TOKEN: "+token;
                        Log.d(TAG, msg);

                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

//        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener( MyActivity.this,  new OnSuccessListener<InstanceIdResult>() {
//        @Override
//        public void onSuccess(InstanceIdResult instanceIdResult) {
//            String newToken = instanceIdResult.getToken();
//            Log.e("newToken", newToken);
//
//        }
//    });

    }
}