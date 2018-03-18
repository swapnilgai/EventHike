package com.java.eventhike.di.module

import android.app.FragmentManager
import com.java.eventhike.feature.home.event.EventViewModel
import com.java.eventhike.network.DataManager
import com.java.eventhike.util.ViewModelHolder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by swapnil on 3/17/18.
 */

@Module(includes = arrayOf(FragmentManagerModule::class, DataManagerModule::class))
class EventViewModelModule (){

    val EVENT_VIEW_MODEL : String =  "EVENT_VIEW_MODEL"

    @Provides
    @Singleton
    fun findOrCreateAutoSuggestViewModel(dataManager: DataManager, fragmentManager: FragmentManager): EventViewModel {
        // In a configuration change we might have a ViewModel present. It's retained using the
        // Fragment Manager.
        val retainedViewModel = fragmentManager
                .findFragmentByTag(EVENT_VIEW_MODEL) as ViewModelHolder<EventViewModel>

        return if (retainedViewModel != null && retainedViewModel.getViewModel() != null) {
            // If the model was retained, return it.
            retainedViewModel.getViewModel()!!
        } else {
            // There is no ViewModel yet, create it.
            // and bind it to this Activity's lifecycle using the Fragment Manager.
            EventViewModel(dataManager)
        }
    }
}