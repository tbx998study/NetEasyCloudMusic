package com.wyymusic.main.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wyymusic.main.R;
import com.wyymusic.main.model.SingerResponse;
import com.wyymusic.main.presenter.ISingerDetailPresenter;
import com.wyymusic.main.presenter.impl.SingerPresenterImpl;
import com.wyymusic.main.ui.fragment.SingerAlbumFragment;
import com.wyymusic.main.ui.fragment.SingerHomeFragment;
import com.wyymusic.main.ui.fragment.SingerSongsFragment;
import com.wyymusic.main.view.ISingerDetailCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SingerDetailActivity extends AppCompatActivity implements View.OnClickListener, ISingerDetailCallback, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.img_back)
    ImageView imgBack;

    @BindView(R.id.txtSingerName)
    TextView txtSingerName;

    @BindView(R.id.imgSingerPic)
    ImageView imgSingerPic;

    @BindView(R.id.txtSingerImgName)
    TextView txtSingerImgName;

    @BindView(R.id.txtSingerImgRankNum)
    TextView txtSingerImgRankNum;

    @BindView(R.id.singer_radio)
    RadioGroup singerRadio;

    private long id;
    private String name;
    private String imgUrl;
    private int rank;
    private int albumSize;
    private int musicSize;
    private ISingerDetailPresenter mSingerDetailPresenter;
    private SingerHomeFragment singerHomeFragment;
    private SingerAlbumFragment singerAlbumFragment;
    private SingerSongsFragment singerSongsFragment;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singer_detail);
        ButterKnife.bind(this);

        initIntent();
        initFragment();
        initPresenter();
        initViews();
        switchFragment(singerHomeFragment);
        mSingerDetailPresenter.getSingerDetail(id);
    }

    private void switchFragment(Fragment target) {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fl_singer, target);
        mFragmentTransaction.commit();
    }

    private void initFragment() {
        singerHomeFragment = new SingerHomeFragment();
        singerAlbumFragment = new SingerAlbumFragment();
        singerSongsFragment = new SingerSongsFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("id",id);
        singerHomeFragment.setArguments(bundle);
    }

    private void initPresenter() {
        mSingerDetailPresenter = new SingerPresenterImpl();
        mSingerDetailPresenter.registerCallback(this);
    }

    private void initIntent() {
        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);
        name = intent.getStringExtra("name");
        imgUrl = intent.getStringExtra("imgUrl");
        rank = intent.getIntExtra("rank", 0);
        albumSize = intent.getIntExtra("albumSize", 0);
        musicSize = intent.getIntExtra("musicSize", 0);
    }

    private void initViews() {
        Glide.with(this).load(imgUrl).into(imgSingerPic);
        txtSingerName.setText(name);
        txtSingerImgRankNum.setText(rank + "");
        txtSingerImgName.setText(name);
        imgBack.setOnClickListener(this);
        singerRadio.setOnCheckedChangeListener(this);
    }


    @Override
    public void onClick(View view) {
        finish();
    }

    @Override
    public void onLoadedSingerDetailData(SingerResponse.Data data) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checked) {
        switch (checked) {
            case R.id.singer_home:
                switchFragment(singerHomeFragment);
                break;
            case R.id.singer_album:
                switchFragment(singerAlbumFragment);
                break;
            case R.id.singer_song:
                switchFragment(singerSongsFragment);
                break;
        }
    }
}