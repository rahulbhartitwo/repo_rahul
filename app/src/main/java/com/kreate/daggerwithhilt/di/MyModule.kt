package com.kreate.daggerwithhilt.di

import android.content.Context
import androidx.room.Room
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kreate.daggerwithhilt.BuildConfig
import com.kreate.daggerwithhilt.SomeInterface
import com.kreate.daggerwithhilt.SomeInterfaceImp
import com.kreate.daggerwithhilt.api.ApiCall
import com.kreate.daggerwithhilt.db.AppDatabase
import com.kreate.daggerwithhilt.entity.room.DummyUserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object MyModule {
    var BASE_URL_PRODUCTION = "https://jsonplaceholder.typicode.com/"

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
                    val requestBuilder: Request.Builder = chain.request().newBuilder()
                    requestBuilder.header("Content-Type", "application/json; charset=utf-8")
                    requestBuilder.header("Accept", "application/json")
                    chain.proceed(requestBuilder.build())
                }).build() else OkHttpClient.Builder().addInterceptor(loggingInterceptor!!)
            .connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS).addInterceptor(
                Interceptor { chain: Interceptor.Chain ->
                    val requestBuilder: Request.Builder = chain.request().newBuilder()
                    requestBuilder.header("Content-Type", "application/json; charset=utf-8")
                    requestBuilder.header("Accept", "application/json")
                    chain.proceed(requestBuilder.build())
                }).build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .enableComplexMapKeySerialization()
            .serializeNulls()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .setVersion(1.0)
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, gsonFactor: GsonConverterFactory): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(
                if (BuildConfig.DEBUG)
                    if (BuildConfig.ENABLE_PRODUCTION_MODE) BASE_URL_PRODUCTION else BuildConfig.BASE_URL
                else BuildConfig.BASE_URL
            )
            .client(client)
            .addConverterFactory(gsonFactor)
    }

    @Singleton
    @Provides
    fun provideApiCall(retrofit: Retrofit.Builder): ApiCall {
        return retrofit.build().create(ApiCall::class.java)
    }

//    @Singleton
//    @Provides
//    public fun provideAuthRepository() : AuthRepository{
//        return  AuthRepository()
//    }

    //============== DB ===================
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "mydb")
            .fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }

    @Singleton
    @Provides
    fun provideDbDao(appDatabase: AppDatabase): DummyUserDao {
        return appDatabase.userDao()
    }

    // ================================
    @Singleton
    @Provides
    @provideSomeInterface1
    fun provideSomeInterface1(): SomeInterface {
        return SomeInterfaceImp("1")
    }

    @Singleton
    @Provides
    @provideSomeInterface2
    fun provideSomeInterface2(): SomeInterface {
        return SomeInterfaceImp("2")
    }


}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class provideSomeInterface1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class provideSomeInterface2

