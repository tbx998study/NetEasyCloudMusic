package com.wyymusic.main.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.wyymusic.main.R;
import com.wyymusic.main.model.HotSearchDetailResponse;
import com.wyymusic.main.model.SearchResponse;
import com.wyymusic.main.model.SongResponse;
import com.wyymusic.main.presenter.IHotSearchDetailPresenter;
import com.wyymusic.main.presenter.ISearchPresenter;
import com.wyymusic.main.presenter.ISongPresenter;
import com.wyymusic.main.presenter.impl.HotSearchDetailPresenterImpl;
import com.wyymusic.main.presenter.impl.SearchPresenterImpl;
import com.wyymusic.main.presenter.impl.SongPresenterImpl;
import com.wyymusic.main.ui.adapter.HotSearchAdapter;
import com.wyymusic.main.ui.adapter.SearchAdapter;
import com.wyymusic.main.util.HideInputUtil;
import com.wyymusic.main.util.MusicUtil;
import com.wyymusic.main.view.IHotSearchDetailCallback;
import com.wyymusic.main.view.ISearchCallback;
import com.wyymusic.main.view.ISongCallback;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoundSearchActivity extends HideInputUtil implements View.OnClickListener, IHotSearchDetailCallback, ISearchCallback, SearchAdapter.onItemClick, ISongCallback {

    private static final String TAG = "FoundSearchActivity";
    @BindView(R.id.edit_search)
    EditText editSearch;

    @BindView(R.id.txtCancel)
    TextView txtCancel;

    @BindView(R.id.txtHotsearch)
    TextView txtHotsearch;

    @BindView(R.id.rcHotSearch)
    RecyclerView rcHotSearch;

    @BindView(R.id.rcSearchResult)
    RecyclerView rcSearchResult;

    @BindView(R.id.hotSearchSlide)
    View hotSearchSlide;

    private IHotSearchDetailPresenter mPresenter;
    private HotSearchAdapter mAdapter;
    private ISearchPresenter mSearchPresenter;
    private SearchAdapter mSearchAdapter;
    private ISongPresenter mSongPresenter;
    private String keyWord;
    private String songName;
    private String singerName;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_search);
        ButterKnife.bind(this);

        initPresenter();
        initViews();

        mPresenter.getHotSearchList();
    }

    private void initPresenter() {
        mPresenter = new HotSearchDetailPresenterImpl();
        mSearchPresenter = new SearchPresenterImpl();
        mSongPresenter = new SongPresenterImpl();
        mPresenter.registerCallback(this);
        mSearchPresenter.registerCallback(this);
        mSongPresenter.registerCallback(this);
    }

    private void initViews() {
        txtCancel.setOnClickListener(this);

        // 自动获取输入框焦点
        editSearch.setFocusable(true);
        editSearch.requestFocus();
        editSearch.setFocusableInTouchMode(true);

        // 1、创建适配器
        mAdapter = new HotSearchAdapter();
        //2、设置布局管理器 , 将布局设置成纵向
        rcHotSearch.setLayoutManager(new GridLayoutManager(this, 2));
        // 设置列间距
        rcHotSearch.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                int position = parent.getChildAdapterPosition(view);
                int space = 15;
                //根据position确定item需要留出的位置
                switch (position % 2) {
                    case 0:
                        //位于左侧的item
                        outRect.right = space;
                        break;
                    case 1:
                        //位于右侧的item
                        outRect.left = space;
                        break;
                    default:
                        break;
                }
                //底部间距
                outRect.bottom = 12;
            }
        });
        // 3、设置适配器
        rcHotSearch.setAdapter(mAdapter);

        // 监听用户的输入信息
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                keyWord = editable.toString();
                if (!keyWord.equals("")) {
                    mSearchPresenter.getSearchList(keyWord);
                } else {
                    rcHotSearch.setVisibility(View.VISIBLE);
                    rcSearchResult.setVisibility(View.INVISIBLE);
                    hotSearchSlide.setVisibility(View.VISIBLE);
                    txtHotsearch.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtCancel:
                this.finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unRegisterCallback(this);
        mSearchPresenter.unRegisterCallback(this);
    }

    @Override
    public void onLoadedData(List<HotSearchDetailResponse.Data> data) {
        if (data != null) {
            mAdapter.setData(this, data);
        }
    }

    /**
     * 隐藏软键盘
     **/
    private void hideSoft() {

        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onLoadedSearchData(List<SearchResponse.Result.Songs> responses) {
        if (responses != null) {
            mSearchAdapter = new SearchAdapter();
            mSearchAdapter.setData(this, responses);
            LinearLayoutManager manager = new LinearLayoutManager(FoundSearchActivity.this);
            rcSearchResult.setLayoutManager(manager);
            rcSearchResult.setAdapter(mSearchAdapter);
            rcSearchResult.setVisibility(View.VISIBLE);
            rcHotSearch.setVisibility(View.INVISIBLE);
            txtHotsearch.setVisibility(View.INVISIBLE);
            hotSearchSlide.setVisibility(View.INVISIBLE);
            mSearchAdapter.setOnItemClick(this);
        }
    }

    @Override
    public void setOnItemClickListener(SearchResponse.Result.Songs song) {
        if (song != null) {
            mSongPresenter.getSongData(song.getId());
        }
        songName = song.getName();
        for (SearchResponse.Result.Songs.Artists artist : song.getArtists()) {
            singerName = artist.getName() + " ";
        }

    }

    @Override
    public void onLoadedSongData(List<SongResponse.Data> data) {
        Log.d("FoundSearchActivity", "song data ==========================>" + data);
        if (data != null) {
            for (SongResponse.Data song : data) {
                url = song.getUrl();
            }
        }
        Intent intent = new Intent(FoundSearchActivity.this, MusicActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("songName", songName);
        intent.putExtra("singerName", singerName);
        new Thread(new Runnable() {
            @Override
            public void run() {
                MusicUtil.downloadMusic(url,songName);
                MusicUtil.out(songName,FoundSearchActivity.this);
            }
        }).start();
        MusicUtil.save(songName,this);
        startActivity(intent);
    }
}