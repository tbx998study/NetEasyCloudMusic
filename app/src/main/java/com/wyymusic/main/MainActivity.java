package com.wyymusic.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wyymusic.main.ui.fragment.AccountFragment;
import com.wyymusic.main.ui.fragment.FoundFragment;
import com.wyymusic.main.ui.fragment.MyFragment;
import com.wyymusic.main.ui.fragment.RadioFragment;
import com.wyymusic.main.ui.fragment.VideoFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mNavigationView;
    private FoundFragment mFoundFragment;
    private VideoFragment mVideoFragment;
    private MyFragment mMyFragment;
    private RadioFragment mRadioFragment;
    private AccountFragment mAccountFragment;
    private boolean isExit;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListener();
        initFragment();

        switchFragment(mFoundFragment);
    }

    private void switchFragment(Fragment target) {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.ly_content,target);
        mFragmentTransaction.commit();
    }

    private void initFragment() {
        mFoundFragment = new FoundFragment();
        mVideoFragment = new VideoFragment();
        mMyFragment = new MyFragment();
        mRadioFragment = new RadioFragment();
        mAccountFragment = new AccountFragment();
    }

    private void initListener() {
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.found) {
                    switchFragment(mFoundFragment);
                } else if (item.getItemId() == R.id.video) {
                    switchFragment(mVideoFragment);
                } else if (item.getItemId() == R.id.my) {
                    switchFragment(mMyFragment);
                } else if (item.getItemId() == R.id.radio) {
                    switchFragment(mRadioFragment);
                } else if (item.getItemId() == R.id.account) {
                    switchFragment(mAccountFragment);
                }
                return true;
            }
        });
    }

    private void initViews() {
        mNavigationView = this.findViewById(R.id.mNavigationView);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!isExit) {
                isExit = true;

                Toast.makeText(getApplicationContext(), "再按一次退出应用", Toast.LENGTH_SHORT).show();
                handler.sendEmptyMessageDelayed(0, 2000);
            } else {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}