package com.wyymusic.main.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.wyymusic.main.R;
import com.wyymusic.main.model.ExistResponse;
import com.wyymusic.main.model.SendResponse;
import com.wyymusic.main.presenter.ISendCodePresenter;
import com.wyymusic.main.presenter.IUserIsExistPresenter;
import com.wyymusic.main.presenter.impl.SendCodePresenterImpl;
import com.wyymusic.main.presenter.impl.UserIsExistPresenterImpl;
import com.wyymusic.main.view.ISendCodeCallback;
import com.wyymusic.main.view.IUserIsExistCallback;

public class LoginOrRegisterActivity extends AppCompatActivity implements View.OnClickListener, IUserIsExistCallback, ISendCodeCallback {

    private Button btnNext;
    private EditText editPhone;
    private ImageView imgBackLogin;
    private String phone;
    private IUserIsExistPresenter mPresenter;

    private int exist;
    private String hasPassword;
    private String nickName;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {

        }
    };
    private ISendCodePresenter mSendCodePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);
        initViews();
        initPresenter();
    }

    private void initPresenter() {
        mPresenter = new UserIsExistPresenterImpl();
        mSendCodePresenter = new SendCodePresenterImpl();
        mPresenter.registerCallback(this);
        mSendCodePresenter.registerCallback(this);
    }

    private void initViews() {
        imgBackLogin = this.findViewById(R.id.img_back_login);
        editPhone = this.findViewById(R.id.edit_phone);
        btnNext = this.findViewById(R.id.btn_next);
        imgBackLogin.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        // 获取用户输入的手机号
        editPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                phone = editable.toString();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back_login:
                this.finish();
                break;
            case R.id.btn_next:
                // 如果输入的内容不为空，发起请求
                if (!TextUtils.isEmpty(phone)) {
                    if (phone.length() == 11) {
                        //1、输入手机号
                        // 2、判断该用户的账号信息
                        mPresenter.judgeIsExist(phone);
                    } else {
                        Toast.makeText(this, "手机号应该是11位数字", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    @Override
    public void isExist(ExistResponse exist) {
        /**
         * 1、注册过了，提示输入密码
         * 2、注册过了，没有设置密码
         * 2、没有注册过，发送验证码=====>验证码正确，添加用户
         */

        // 判断是否注册 1(注册) -1(未注册)
        if (exist.getExist() == 1) { // 已注册
            if (exist.getHasPassword().equals("true")) { // 有密码
                Intent intent = new Intent(LoginOrRegisterActivity.this, LoginWithPassActivity.class); // 跳转输入密码的页面
                intent.putExtra("phoneNum", phone); // 携带手机号跳转
                startActivity(intent);
            } else { // 无密码
                Intent intent = new Intent(this,InputPassActivity.class);
                intent.putExtra("phoneNum",phone);
                startActivity(intent);
            }
        } else if (exist.getExist() == -1) { // 未注册
            // 发送验证码请求
            mSendCodePresenter.sendCode(phone);
            // 跳转输入验证码的页面
            Intent intent = new Intent(LoginOrRegisterActivity.this, ValidateActivity.class);
            intent.putExtra("phoneNum", phone);
            startActivity(intent);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unRegisterCallback(this);
        mSendCodePresenter.unRegisterCallback(this);
    }

    @Override
    public void isSendSuccess(SendResponse sendResponse) {

    }
}