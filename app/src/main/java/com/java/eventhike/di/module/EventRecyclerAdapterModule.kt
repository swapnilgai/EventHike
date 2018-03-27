package com.java.eventhike.di.module

import com.java.eventhike.feature.home.event.EventNavigator
import com.java.eventhike.feature.home.event.list.ListEventRecyclerAdapter
import com.java.eventhike.feature.home.event.map.MapEventRecyclerAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by swapnil on 3/18/18.
 */

@Module
class EventRecyclerAdapterModule(var mEventNavigator: EventNavigator) {

    @Provides
    @Singleton
    fun getListEventRecyclerAdapter(): ListEventRecyclerAdapter {
        return ListEventRecyclerAdapter(mEventNavigator)
    }

    @Provides
    @Singleton
    fun getMapEventRecyclerAdapter(): MapEventRecyclerAdapter {
        return MapEventRecyclerAdapter(mEventNavigator)
    }
}