package com.example.fragmentexam;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class DialogFragment extends androidx.fragment.app.DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("종료?");
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setMessage("정말 종료할꺼임? ");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "종료되었다 ", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("취소", null);
        return builder.create();
    }
}