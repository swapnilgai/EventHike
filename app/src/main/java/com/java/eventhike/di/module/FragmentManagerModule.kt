package com.java.eventhike.di.module

import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by swapnil on 3/17/18.
 */

@Module
class FragmentManagerModule(var mFragmentManager: FragmentManager){

    @Provides
    @Singleton
    fun getFragmentManager(): FragmentManager {
        return mFragmentManager;
    }
}