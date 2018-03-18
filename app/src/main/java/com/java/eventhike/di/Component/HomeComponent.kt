package com.java.eventhike.di.Component

import com.java.eventhike.di.module.*
import com.java.eventhike.feature.home.HomeActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by swapnil on 3/12/18.
 */

@Singleton
@Component(modules = arrayOf(DataManagerModule::class, NetModule::class, HomeFragmentModule::class,
                            EventViewModelModule::class, FragmentManagerModule::class))
interface HomeComponent {
    fun inject(mHomeActivity: HomeActivity)
}
