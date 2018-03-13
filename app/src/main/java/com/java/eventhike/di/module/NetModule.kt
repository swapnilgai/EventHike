package com.java.eventhike.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by swapnil on 3/12/18.
 */

@Module
class NetModule(internal var mBaseUrl: String) {

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder()
                .create()
    }

    @Provides
    @Singleton
    internal fun getGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory
                .create(gson)
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(GsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory)
                .build()
    }
}