package com.java.eventhike.di.Component

import com.java.eventhike.di.module.*
import com.java.eventhike.feature.home.HomeActivity
import com.java.eventhike.feature.home.event.list.ListFragment
import com.java.eventhike.feature.home.event.map.MapFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by swapnil on 3/12/18.
 */

@Singleton
@Component(modules = arrayOf(DataManagerModule::class, NetModule::class, HomeFragmentModule::class,
                            EventViewModelModule::class, FragmentManagerModule::class, EventRecyclerAdapterModule::class))
interface HomeComponent {
    fun inject(mHomeActivity: HomeActivity)

    fun inject(mListFragment: ListFragment)

    fun inject(mMapFragment: MapFragment)
}
