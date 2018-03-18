package com.java.eventhike.feature.home.event

import android.databinding.BaseObservable
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.java.eventhike.model.EventsItem
import com.java.eventhike.network.DataManager

/**
 * Created by swapnil on 3/12/18.
 */

open class EventViewModel(var mDataManager: DataManager?) : BaseObservable() {
    var eventsItem: EventsItem? = null
    var lat: Double = 0.0
    var lng: Double = 0.0
    val items: ObservableList<EventsItem> = ObservableArrayList()


    fun loadEvent(){

    }

    private fun updateLatLng(lat: Double, lng: Double){
        this.lat = lat
        this.lng = lng
    }

   private fun calculateLatLng(){

   }

    fun addEventItems(eventsItem: List<EventsItem>){

    }
}