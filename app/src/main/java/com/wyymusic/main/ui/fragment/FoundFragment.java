package com.wyymusic.main.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wyymusic.main.R;
import com.wyymusic.main.model.HomePageBannerResponse;
import com.wyymusic.main.model.HomeRoundResponse;
import com.wyymusic.main.model.RecommendSongsResponse;
import com.wyymusic.main.model.TopArtistResponse;
import com.wyymusic.main.presenter.IHomePageBannerPresenter;
import com.wyymusic.main.presenter.IHomeRoundPresenter;
import com.wyymusic.main.presenter.IRecommendSongsPresenter;
import com.wyymusic.main.presenter.ITopArtistsPresenter;
import com.wyymusic.main.presenter.impl.HomePageBannerPresenterImpl;
import com.wyymusic.main.presenter.impl.HomeRoundPresenterImpl;
import com.wyymusic.main.presenter.impl.RecommendSongsPresenterImpl;
import com.wyymusic.main.presenter.impl.TopArtistPresenterImpl;
import com.wyymusic.main.ui.activity.FoundSearchActivity;
import com.wyymusic.main.ui.activity.SingerDetailActivity;
import com.wyymusic.main.ui.adapter.HomeRoundAdapter;
import com.wyymusic.main.ui.adapter.RecommendSongsAdapter;
import com.wyymusic.main.ui.adapter.TopArtistAdapter;
import com.wyymusic.main.view.IHomePageBannerCallback;
import com.wyymusic.main.view.IHomeRoundCallback;
import com.wyymusic.main.view.IRecommendSongsCallback;
import com.wyymusic.main.view.ITopArtistsCallback;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import com.youth.banner.loader.ImageLoader;;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public class FoundFragment extends Fragment implements View.OnClickListener, IHomePageBannerCallback, IHomeRoundCallback, IRecommendSongsCallback, ITopArtistsCallback, TopArtistAdapter.onItemClickListener {

    private static final String TAG = "FoundFragment";
    @BindView(R.id.edit_search)
    EditText mEditSearch;

    @BindView(R.id.homeBanner)
    Banner homeBanner;

    @BindView(R.id.rcHomeRound)
    RecyclerView rcHomeRound;

    @BindView(R.id.rcRecommendSongs)
    RecyclerView rcRecommendSongs;

    @BindView(R.id.rcTopArtist)
    RecyclerView rcTopArtist;


    private List<String> list = new ArrayList<>();
    private IHomePageBannerPresenter mHomePageBannerPresenter;
    private IHomeRoundPresenter mHomeRoundPresenter;
    private HomeRoundAdapter mAdapter;
    private IRecommendSongsPresenter mRecommendSongsPresenter;
    private RecommendSongsAdapter mRecommendAdapter;
    private ITopArtistsPresenter mTopPresenter;
    private TopArtistAdapter mTopAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_found, container, false);
        ButterKnife.bind(this, view);

        initView();
        initPresenter();
        mHomePageBannerPresenter.getHomePageBanner();
        homeBanner.setImageLoader(new ImageLoaderBanner());
        mHomeRoundPresenter.getHomeRoundData();
        mRecommendSongsPresenter.getRecommendSongsData();
        mTopPresenter.getTopArtistData();
        return view;
    }

    private void initPresenter() {
        mHomePageBannerPresenter = new HomePageBannerPresenterImpl();
        mHomeRoundPresenter = new HomeRoundPresenterImpl();
        mRecommendSongsPresenter = new RecommendSongsPresenterImpl();
        mTopPresenter = new TopArtistPresenterImpl();
        mTopPresenter.registerCallback(this);
        mHomePageBannerPresenter.registerCallback(this);
        mHomeRoundPresenter.registerCallback(this);
        mRecommendSongsPresenter.registerCallback(this);
    }

    private void initView() {
        mEditSearch.setOnClickListener(this);
        mEditSearch.setFocusableInTouchMode(false);
        mEditSearch.setCursorVisible(false);
        mAdapter = new HomeRoundAdapter();
        mRecommendAdapter = new RecommendSongsAdapter();
        mTopAdapter = new TopArtistAdapter();
        mTopAdapter.setOnItemClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_search:
                Intent intent = new Intent(getContext(), FoundSearchActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onLoadedBannerData(List<HomePageBannerResponse.Banners> banners) {
        if (banners != null) {
            for (HomePageBannerResponse.Banners banner : banners) {
                String imageUrl = banner.getImageUrl();
                list.add(imageUrl);
            }

            homeBanner.setImages(list);
            homeBanner.start();
        }

    }

    @Override
    public void onLoadedHomeRoundData(List<HomeRoundResponse.Data> data) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rcHomeRound.setLayoutManager(manager);
        rcHomeRound.setAdapter(mAdapter);
        if (data != null) {
            mAdapter.setData(getContext(), data);
        }

    }

    @Override
    public void onLoadedRecommendSongsData(List<RecommendSongsResponse.Result> data) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rcRecommendSongs.setLayoutManager(manager);
        rcRecommendSongs.setAdapter(mRecommendAdapter);
        if (data != null) {
            mRecommendAdapter.setData(getContext(), data);
        }
    }

    @Override
    public void onLoadedTopArtist(List<TopArtistResponse.AList.Artists> data) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rcTopArtist.setLayoutManager(manager);
        rcTopArtist.setAdapter(mTopAdapter);
        if (data != null) {
            mTopAdapter.setData(getContext(), data);
        }
    }

    @Override
    public void setOnClick(TopArtistResponse.AList.Artists data) {
        Log.d(TAG, "data =====================>" + data);
        Intent intent = new Intent(getContext(), SingerDetailActivity.class);
        intent.putExtra("id", data.getId());
        intent.putExtra("name", data.getName());
        intent.putExtra("rank", data.getLastRank() +1);
        intent.putExtra("albumSize", data.getAlbumSize());
        intent.putExtra("musicSize", data.getMusicSize());
        intent.putExtra("imgUrl",data.getPicUrl());
        startActivity(intent);
    }


    public class ImageLoaderBanner extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
