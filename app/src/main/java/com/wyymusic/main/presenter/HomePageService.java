package com.wyymusic.main.presenter;

import com.wyymusic.main.model.HomePageBannerResponse;
import com.wyymusic.main.model.HomeRoundResponse;
import com.wyymusic.main.model.RecommendSongsResponse;
import com.wyymusic.main.model.SongResponse;
import com.wyymusic.main.model.TopArtistResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author tbx
 * @date 2021/1/7
 * target:
 * time: 2021/1/7
 * God Bless my code!
 **/
public interface HomePageService {

    @GET("banner")
    Call<HomePageBannerResponse> getHomePageBanner();

    @GET("homepage/dragon/ball")
    Call<HomeRoundResponse> getHomeRound();

    @GET("recommend/resource")
    Call<RecommendSongsResponse> getRecommendSongs();

    @GET("toplist/artist")
    Call<TopArtistResponse> getTopArtists();

}
