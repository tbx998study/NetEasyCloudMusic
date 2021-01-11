package com.wyymusic.main.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wyymusic.main.R;
import com.wyymusic.main.model.SendResponse;
import com.wyymusic.main.presenter.ISendCodePresenter;
import com.wyymusic.main.presenter.IValidateCodePresenter;
import com.wyymusic.main.presenter.impl.SendCodePresenterImpl;
import com.wyymusic.main.presenter.impl.ValidateCodePresenterImpl;
import com.wyymusic.main.view.ISendCodeCallback;
import com.wyymusic.main.view.IValidateCodeCallback;

public class ValidateActivity extends AppCompatActivity implements View.OnClickListener, IValidateCodeCallback, ISendCodeCallback {

    private ImageView imgBack;
    private TextView resendCode;
    private TextView phoneNum;
    private EditText editCode;
    private String code;
    private IValidateCodePresenter mPresenter;
    private String phone;
    private ISendCodePresenter mSendPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate);
        initPresenter();
        initIntent();
        initViews();


    }

    private void initPresenter() {
        mPresenter = new ValidateCodePresenterImpl();
        mSendPresenter = new SendCodePresenterImpl();
        mSendPresenter.registerCallback(this);
        mPresenter.registerCallback(this);
    }

    private void initIntent() {
        Intent intent = getIntent();
        phone = intent.getStringExtra("phoneNum");
        // 渲染手机号到页面
        if (phone != null) {
            phoneNum.setText(phone.substring(0, 3) + "****" + phone.substring(7));
        }

    }

    private void initViews() {
        imgBack = this.findViewById(R.id.img_back_login);
        resendCode = this.findViewById(R.id.resend_code);
        phoneNum = this.findViewById(R.id.phone_num);
        editCode = this.findViewById(R.id.edit_validate_code);
        imgBack.setOnClickListener(this);
        resendCode.setOnClickListener(this);
        // 获取用户输入的验证码
        editCode.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                code = editable.toString();
                // 发起验证验证码的请求
                mPresenter.validateCode(phone, code);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back_login:
                this.finish();
                break;
            case R.id.resend_code:
                // 重新发起验证码发送的请求
                mSendPresenter.sendCode(phone);
                break;
        }
    }

    @Override
    public void isValidate(SendResponse response) {
        if (response.isData()) {
            Intent intent = new Intent(this, InputPassActivity.class);
            intent.putExtra("validate_code",code);
            intent.putExtra("phone",phone);
            startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unRegisterCallback(this);
        mSendPresenter.unRegisterCallback(this);
    }

    @Override
    public void isSendSuccess(SendResponse sendResponse) {

    }
}