package com.wyymusic.main.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wyymusic.main.R;
import com.wyymusic.main.model.SingerHomeResponse;
import com.wyymusic.main.model.SingerHotSongsResponse;
import com.wyymusic.main.presenter.ISingerHomePresenter;
import com.wyymusic.main.presenter.ISingerHotSongsPresenter;
import com.wyymusic.main.presenter.impl.SingerHomePresenterImpl;
import com.wyymusic.main.presenter.impl.SingerHotSongsPresenterImpl;
import com.wyymusic.main.ui.adapter.HotSongsAdapter;
import com.wyymusic.main.view.ISingerHomeCallback;
import com.wyymusic.main.view.ISingerHotSongsCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author tbx
 * @date 2021/1/10
 * target:
 * time: 2021/1/10
 * God Bless my code!
 **/
public class SingerHomeFragment extends Fragment implements ISingerHomeCallback, ISingerHotSongsCallback {

    @BindView(R.id.txtRecentSongs)
    TextView mTxtRecentSongs;

    @BindView(R.id.singer_home_more)
    TextView mSingerHomeMore;

    @BindView(R.id.singer_home_hot_songs)
    RecyclerView mSingerHomeHotSongs;

    @BindView(R.id.imgLatestSong)
    ImageView mImgLatestSong;

    @BindView(R.id.txtSongName)
    TextView mTxtSongName;

    @BindView(R.id.txtSingerName)
    TextView mTxtSingerName;

    @BindView(R.id.txtSingerInfoMore)
    TextView mSingerInfoMore;

    @BindView(R.id.txtSingerBaseName)
    TextView mTxtSingerBaseName;

    @BindView(R.id.txtSingerBaseSex)
    TextView mTxtSingerSex;

    @BindView(R.id.txtSingerBaseLocation)
    TextView mTxtSingerBaseLocation;

    @BindView(R.id.txtSingerBaseSummary)
    TextView mTxtSingerBaseSummary;
    private long id;
    private ISingerHomePresenter mSingerHomePresenter;
    private ISingerHotSongsPresenter mSingerHotSongsPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_singer_home, container, false);
        ButterKnife.bind(this, view);
        initBundle();
        initPresenter();


        mSingerHomePresenter.getSingerHome(id);
        mSingerHotSongsPresenter.getSingerHotSongs(id);
        return view;
    }

    private void initPresenter() {
        mSingerHomePresenter = new SingerHomePresenterImpl();
        mSingerHotSongsPresenter = new SingerHotSongsPresenterImpl();
        mSingerHomePresenter.registerCallback(this);
        mSingerHotSongsPresenter.registerCallback(this);
    }

    private void initBundle() {
        Bundle arguments = getArguments();
        id = arguments.getLong("id");
    }

    @Override
    public void onLoadedSingerHomeData(SingerHomeResponse.Data data) {
        Log.d("SingerHomeFragment", "SingerData is =====================>" + data);
        Glide.with(getContext()).load(data.getArtist().getCover()).into(mImgLatestSong);
        mTxtSingerBaseName.setText(data.getArtist().getName());
        mTxtSingerSex.setText("男");
        mTxtSingerName.setText(data.getArtist().getName());
        mTxtSingerBaseSummary.setText(data.getArtist().getBriefDesc());
    }

    @Override
    public void onLoadedHotSongsData(List<SingerHotSongsResponse.Songs> data) {
        HotSongsAdapter mAdapter = new HotSongsAdapter();
        mAdapter.setData(data);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mSingerHomeHotSongs.setLayoutManager(manager);
        mSingerHomeHotSongs.setAdapter(mAdapter);
        mTxtSongName.setText(data.get(0).getName());
    }
}
