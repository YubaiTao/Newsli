package com.yubaitao.newsli.retrofit;

import com.yubaitao.newsli.retrofit.response.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsRequestAPI {
    @GET("top-headlines")
    Observable<BaseResponse> getNewsByCountry(@Query("country")String country);
}
