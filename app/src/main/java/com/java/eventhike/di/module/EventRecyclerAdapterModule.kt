package com.java.eventhike.di.module

import com.java.eventhike.feature.home.event.EventNavigator
import com.java.eventhike.feature.home.event.EventRecyclerAdapter
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
    fun getEventRecyclerAdapter(): EventRecyclerAdapter {
        return EventRecyclerAdapter(mEventNavigator)
    }
}