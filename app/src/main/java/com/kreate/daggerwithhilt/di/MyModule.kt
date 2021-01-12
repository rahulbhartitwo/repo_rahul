package com.kreate.daggerwithhilt.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kreate.daggerwithhilt.BuildConfig
import com.kreate.daggerwithhilt.api.ApiCall
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient

import okhttp3.Request

import okhttp3.logging.HttpLoggingInterceptor

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class MyModule {
    var BASE_URL_PRODUCTION = "http://14.142.224.133:1080/gailapi-dev/"
    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor?): OkHttpClient {
        return if (BuildConfig.DEBUG) OkHttpClient.Builder().addInterceptor(loggingInterceptor!!)
            .connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS).addNetworkInterceptor(StethoInterceptor())
            .addInterceptor(
                Interceptor { chain: Interceptor.Chain ->
                    val requestBuilder:  Request.Builder = chain.request().newBuilder()
                    requestBuilder.header("Content-Type", "application/json")
                    chain.proceed(requestBuilder.build())
                }).build() else OkHttpClient.Builder().addInterceptor(loggingInterceptor!!)
            .connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS).addInterceptor(
                Interceptor { chain: Interceptor.Chain ->
                    val requestBuilder:  Request.Builder = chain.request().newBuilder()
                    requestBuilder.header("Content-Type", "application/json")
                    chain.proceed(requestBuilder.build())
                }).build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson?, client: OkHttpClient?): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(
            if (BuildConfig.DEBUG) if (BuildConfig.ENABLE_PRODUCTION_MODE) BASE_URL_PRODUCTION else BuildConfig.BASE_URL else BuildConfig.BASE_URL
        ).addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
    }

    @Singleton
    @Provides
    fun provideApiCall(retrofit: Retrofit.Builder): ApiCall {
        return retrofit.build().create(ApiCall::class.java)
    } //    @Singleton
    //    @Provides
    //    public AuthRepository provideAuthRepository(ApiCall apiCall) {
    //        return new AuthRepository(apiCall);
    //    }
}