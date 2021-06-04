package com.example.vibrate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button alert_btn;
    Button alert2_btn;
    Button list_btn;
    Button cal_btn;
    Button time_btn;
    Button vibrate_btn;
    Button sound_btn;

    AlertDialog alertDialog;
    AlertDialog customDialog;
    AlertDialog listDialog;
    DatePickerDialog dateDialog;
    CheckBox chk_box;

    protected DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(dialog ==alertDialog && which==DialogInterface.BUTTON_POSITIVE ){
                showToast("종료 했다.");
            }else if(dialog == customDialog ){
                if(which == DialogInterface.BUTTON_POSITIVE ){
                    if(chk_box.isChecked()){
                        showToast("계속 디버깅을 승인을 하였습니다.");
                    }else{
                        showToast("1회성 디버깅 승인을 하였습니다.");
                    }
                }else if(which == DialogInterface.BUTTON_NEGATIVE){
                    showToast("정상 종료");
                }
                
            }else if(dialog == listDialog){
                if(which == DialogInterface.BUTTON_POSITIVE ){

                    showToast("확인");
                }else if(which == DialogInterface.BUTTON_NEGATIVE){
                    showToast("Cancel");
                }

            }else if(dialog == listDialog){

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

        // View 객체 획득
        alert_btn = findViewById(R.id.btn_alert);
        alert2_btn = findViewById(R.id.btn_alert2);
        list_btn = findViewById(R.id.btn_list);
        cal_btn = findViewById(R.id.btn_cal);
        time_btn = findViewById(R.id.btn_time);
        vibrate_btn = findViewById(R.id.btn_vibrate);
        sound_btn = findViewById(R.id.btn_sound);


        alert_btn.setOnClickListener(this);
        alert2_btn.setOnClickListener(this);
        list_btn.setOnClickListener(this);
        cal_btn.setOnClickListener(this);
        time_btn.setOnClickListener(this);
        vibrate_btn.setOnClickListener(this);
        sound_btn.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(v==alert_btn){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setIcon(android.R.drawable.ic_dialog_dialer);
//            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setTitle("알림");
            builder.setMessage("리얼 종료각임?");
            builder.setPositiveButton("Ok", dialogListener);
            builder.setNegativeButton("No", null);

            alertDialog=builder.create();
            alertDialog.show();

//    커스텀 Alert Msg 띄우기
        }else if (v==alert2_btn){
//            showToast("커스텀 알트창 띄우기");
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            View vi = inflater.inflate(R.layout.dialog_custom, null);
            builder.setView(vi);
            builder.setPositiveButton("확인", dialogListener);
            builder.setNegativeButton("Cancel", dialogListener);
            customDialog=builder.create();
            customDialog.show();
            chk_box = (CheckBox) customDialog.findViewById(R.id.alway_true);

        }else if (v==list_btn){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("알람 밸소리");
            builder.setSingleChoiceItems(R.array.walkup_array, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    showToast(String.valueOf(which));

                }
            });
            builder.setPositiveButton("Comfirm",dialogListener );
            builder.setNegativeButton("Cancel",dialogListener );
            listDialog = builder.create();
            listDialog.show();

        }else if (v==cal_btn){
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month  = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dateDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int years, int months, int days) {
                            showToast(years + "년" + (months + 1) + "월" + days + "일 선택됨");
                        }
                    }, year, month, day);
            dateDialog.show();

        }else if (v==time_btn){
           Calendar c = Calendar.getInstance();
           int hour = c.get(Calendar.HOUR);
           int minute = c.get(Calendar.MINUTE);

            TimePickerDialog timeDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            showToast(hourOfDay + "시 " + minute + " 분 선택됨");
                        }
                    }, hour, minute, false);
            timeDialog.show();
        }else if (v == vibrate_btn){
            Vibrator vib=(Vibrator)getSystemService(VIBRATOR_SERVICE);
//            vib.vibrate(new long[]{500,1000,500,1000}, -1);
            vib.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));

        }else if(v == sound_btn){
            MediaPlayer player = MediaPlayer.create(this, R.raw.katalk);
            player.start();
        }

    }
}