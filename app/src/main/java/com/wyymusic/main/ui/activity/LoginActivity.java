package com.wyymusic.main.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.wyymusic.main.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";
    private AppCompatButton btnLogin;
    private CheckBox chkService;
    private boolean isChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        btnLogin = this.findViewById(R.id.btn_login);
        chkService = this.findViewById(R.id.chk_service);


        btnLogin.setOnClickListener(this);
        chkService.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    isChecked = true;
                } else {
                    isChecked = false;
                }

            }
        });
    }

    @Override
    public void onClick(View view) {
        // 点击登录按钮
        if (isChecked) {
            Intent intent = new Intent(LoginActivity.this, LoginOrRegisterActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, getResources().getString(R.string.check_service), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        chkService.setChecked(false);
    }
}