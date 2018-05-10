package com.java.eventhike.di.module

import com.java.eventhike.network.ApiService
import com.java.eventhike.network.DataManager
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton



/**
 * Created by swapnil on 3/12/18.
 */
@Module(includes = arrayOf(NetModule::class))
class DataManagerModule {

    @Provides
    @Singleton
    fun getHomesAPIService(mRetrofit: Retrofit): ApiService {
        return mRetrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun getDataManager(mAPIService: ApiService): DataManager {
        return DataManager(mAPIService)
    }
}