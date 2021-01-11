package com.wyymusic.main.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.wyymusic.main.MainActivity;
import com.wyymusic.main.R;
import com.wyymusic.main.model.UserResponse;
import com.wyymusic.main.presenter.ILoginPresenter;
import com.wyymusic.main.presenter.impl.LoginPresenterImpl;
import com.wyymusic.main.view.ILoginCallback;

public class LoginWithPassActivity extends AppCompatActivity implements View.OnClickListener, ILoginCallback {

    private ImageView imgBack;
    private EditText editPass;
    private String pass;
    private String phoneNum;
    private ILoginPresenter mPresenter;
    private Button btnLogin;
    private SharedPreferences preferences;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_pass);
        initViews();
        initIntent();
        initPresenter();
        preferences = getSharedPreferences("login_token",MODE_PRIVATE);
        edit = preferences.edit();
        edit.putString("token","");
        edit.commit();
    }

    private void initPresenter() {
        mPresenter = new LoginPresenterImpl();
        mPresenter.registerCallback(this);
    }

    private void initIntent() {
        Intent intent = getIntent();
        phoneNum = intent.getStringExtra("phoneNum");
    }

    private void initViews() {
        imgBack = this.findViewById(R.id.img_back_login);
        editPass = this.findViewById(R.id.edit_pass);
        btnLogin = this.findViewById(R.id.btn_login);
        imgBack.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
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
        switch (view.getId()) {
            case R.id.img_back_login:
                this.finish();
                break;
            case R.id.btn_login:
                // 登录请求
                if (!TextUtils.isEmpty(pass) && !phoneNum.equals("")) {
                    // 发起请求
                    mPresenter.login(phoneNum,pass);
                }
                break;
        }

    }

    @Override
    public void loginInfo(UserResponse response) {
        if (response.getToken() != null) {
            edit.putString("token",response.getToken());
            edit.putString("username",response.getAccount().getUserName());
            edit.putString("nickname",response.getProfile().getNickname());
            edit.commit();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "密码错误,登录失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unRegisterCallback(this);
    }
}