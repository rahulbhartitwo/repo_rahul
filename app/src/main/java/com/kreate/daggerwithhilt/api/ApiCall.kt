package com.kreate.daggerwithhilt.api;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.kreate.daggerwithhilt.BuildConfig;
import com.kreate.daggerwithhilt.entity.request.RequestEntity;
import com.kreate.daggerwithhilt.entity.response.ResponseEntity;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiCall {

    // Demo for the API
    @POST("api/LineInformation/GetVulnerableLocation")
    Call<ResponseEntity> getFetchData(@Body RequestEntity requestEntity);

//      Base api Stuff
//    static ApiCall create() {
//        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
//        logger.setLevel(HttpLoggingInterceptor.Level.BASIC);
//        logger.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient client = new OkHttpClient.Builder().
//                addInterceptor(logger).
//                connectTimeout(60, TimeUnit.SECONDS).
//                readTimeout(60, TimeUnit.SECONDS).
//                writeTimeout(60, TimeUnit.SECONDS).
//                addNetworkInterceptor(new StethoInterceptor()).
//                addInterceptor(chain -> {
//                    Request.Builder requestBuilder = chain.request().newBuilder();
//                    requestBuilder.header("Content-Type", "application/json");
////            todo for future            requestBuilder.header("Authorizaton", "serverkey");
//                    return chain.proceed(requestBuilder.build());
//                }).
//                build();
//        String BASE_URL_PRODUCTION = "http://14.142.224.133:1080/gailapi-dev/";
//        return new Retrofit.Builder().baseUrl(
//                (BuildConfig.DEBUG) ?
//                        (BuildConfig.ENABLE_PRODUCTION_MODE) ? BASE_URL_PRODUCTION : BuildConfig.BASE_URL
//                        : BuildConfig.BASE_URL
//
//        ).
//                client(client).
//                addConverterFactory(GsonConverterFactory.create()).
//                build().
//                create(ApiCall.class);
//
//    }
}
