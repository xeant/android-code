package com.xeant.xewebapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFireBaseMsgService extends FirebaseMessagingService {
    public static final String TAG = "XEWebPUSH APP";
    private String messageBody, messageTitle;

    @Override
    public void onNewToken(@NonNull String token) {
        Log.e(TAG, "onNewToken 메소드 실행");
        super.onNewToken(token);
        Log.e(TAG, token);
        /* DB서버로 새토큰을 업데이트시킬수 있는 부분 */
//        INSTANCE_ID_EVENT
//        FirebaseInstanc
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        /* 새메세지를 알림기능을 적용하는 부분 */
        if(remoteMessage.getNotification() != null){
            Log.d(TAG, "From: " + remoteMessage.getFrom());
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            Log.d(TAG, "왔다고?????" + remoteMessage.getNotification().getTitle() );
            messageBody = remoteMessage.getNotification().getBody();
            messageTitle = remoteMessage.getNotification().getTitle();

            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
            NotificationCompat.Builder mBuilder =  new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(messageTitle)
                    .setContentText(messageBody)
                    .setAutoCancel(true)
                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                    .setVibrate(new long[]{1, 1000});
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, mBuilder.build());

            mBuilder.setContentIntent(contentIntent);
        }else {
            Log.d(TAG, "왔다고?????" + "실패" );
            Log.d(TAG, String.valueOf(remoteMessage.getNotification()));
        }

    }


}
