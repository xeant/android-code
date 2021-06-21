package com.xeant.excutorexam;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.provider.AlarmClock;

import androidx.core.os.HandlerCompat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App extends Application {
    // 현재 실행중 프로세스가 사용할 수 있는 프로세스 수를 리턴해줌.
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    // Executor (쓰레드 관리 하는 객체)
    ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_CORES);
    // 메인 쓰레드 핸들러 만들어주기
    Handler mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());

    
}
