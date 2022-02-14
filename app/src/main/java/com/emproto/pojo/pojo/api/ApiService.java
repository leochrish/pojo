package com.emproto.pojo.pojo.api;

import com.emproto.pojo.pojo.model.ScreenResponse;
import com.emproto.pojo.pojo.model.ScreensRequest;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("getScreens")
    Single<ScreenResponse> getScreens(@Body ScreensRequest screensRequest);
}
