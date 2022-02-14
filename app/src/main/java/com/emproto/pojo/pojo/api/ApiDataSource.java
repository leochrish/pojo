package com.emproto.pojo.pojo.api;

import com.emproto.pojo.pojo.model.ScreenResponse;
import com.emproto.pojo.pojo.model.ScreensRequest;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiDataSource {
    ApiService apiService;

    public ApiDataSource() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(1000, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS);
        httpClient.addInterceptor(loggingInterceptor);
        apiService = new Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJava3CallAdapterFactory.create()).
                client(httpClient.build()).
                baseUrl("http://10.0.2.2:3000/").
                build().create(ApiService.class);
    }

    public Single<ScreenResponse> getScreens(ScreensRequest screensRequest) {
        return apiService.getScreens(screensRequest);
    }
}
