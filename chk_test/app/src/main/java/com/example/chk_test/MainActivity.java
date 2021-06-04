package com.example.chk_test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_main;
    TextView t_view;

    private  DialogInterface.OnClickListener dialog_listener = new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which==DialogInterface.BUTTON_POSITIVE){
                showToast("Come In Dialog & positive");

                t_view.setText("선택됨");
            }

        }
    };


    private void showToast(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_main = findViewById(R.id.show_btn);

        t_view = findViewById(R.id.text_view);
        btn_main.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    final String[] vs_array = new String[]{"C#", "C++", "Java"};
                    final boolean[] chk_array = new boolean[]{false, false, true};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 언어는?");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setMultiChoiceItems(vs_array, chk_array,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(MainActivity.this, vs_array[which] + " 선택" , Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg.setPositiveButton("확인", dialog_listener);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });
    }
}