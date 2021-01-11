package com.wyymusic.main.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wyymusic.main.R;

public class InputNicknameActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNick;
    private Button btnFinish;
    private String code;
    private String pass;
    private String nickName;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nickname);
        initViews();
        initIntent();
    }

    private void initIntent() {
        Intent intent = getIntent();
        // 获取传递过来的验证码
        code = intent.getStringExtra("code");
        // 获取传递过来的密码
        pass = intent.getStringExtra("pass");
        phone = intent.getStringExtra("phone");
    }

    private void initViews() {
        editNick = this.findViewById(R.id.edit_nick);
        btnFinish = this.findViewById(R.id.btn_finish);
        editNick.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                nickName = editable.toString();
            }
        });

        btnFinish.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // 完成注册的请求 验证码 密码 昵称 手机号
        if (!TextUtils.isEmpty(nickName)) {
            // 发起请求
        }
    }
}