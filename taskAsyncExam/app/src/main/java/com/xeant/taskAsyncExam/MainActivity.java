package com.xeant.taskAsyncExam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private ProgressBar mProgressBar;
    private DownLoadTask mDownLoadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.percent_view);
        mProgressBar = findViewById(R.id.progressBar);

    }

    public void download(View view) {
        mDownLoadTask = new DownLoadTask();
        mDownLoadTask.execute();
    }

    public void cancel(View view) {
        if(mDownLoadTask != null && !mDownLoadTask.isCancelled()){
            mDownLoadTask.cancel(true);
        }

    }

    private class DownLoadTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final int percent = i;
                publishProgress(percent);
                if(isCancelled()){
                    break;
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mTextView.setText(values[0]+ "%");
            mProgressBar.setProgress(values[0]);
        }
    }

}