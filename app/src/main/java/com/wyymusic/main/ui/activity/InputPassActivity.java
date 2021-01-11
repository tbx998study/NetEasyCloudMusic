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
import android.widget.Toast;

import com.wyymusic.main.R;

public class InputPassActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnNext;
    private EditText editPass;
    private String pass;
    private String code;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_pass);
        initViews();
        initIntent();
    }

    private void initIntent() {
        Intent intent = getIntent();
        code = intent.getStringExtra("validate_code");
        phone = intent.getStringExtra("phone");
    }

    private void initViews() {
        btnNext = this.findViewById(R.id.btn_next);
        editPass = this.findViewById(R.id.edit_pass);
        btnNext.setOnClickListener(this);
        editPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                pass = editable.toString();
            }
        });
    }

    @Override
    public void onClick(View view) {
       if (!TextUtils.isEmpty(pass)) {
           Intent intent = new Intent(this,InputNicknameActivity.class);
           intent.putExtra("pass",pass);
           intent.putExtra("code",code);
           intent.putExtra("phone",phone);
           startActivity(intent);
       } else {
           Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
       }
    }
}