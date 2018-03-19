package com.java.eventhike.di.module

import com.java.eventhike.feature.home.event.list.ListFragment
import com.java.eventhike.feature.home.event.map.MapFragment
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by swapnil on 3/17/18.
 */

@Module
class HomeFragmentModule {
    @Provides
    @Singleton
    fun getListFragment(): ListFragment {
       return ListFragment()
    }

    @Provides
    @Singleton
    fun getMapFragment(): MapFragment {
        return MapFragment()
    }
}