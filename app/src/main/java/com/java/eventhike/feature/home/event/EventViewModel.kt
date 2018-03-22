package com.java.eventhike.feature.home.event

import android.databinding.BaseObservable
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.google.android.gms.maps.model.LatLng
import com.java.eventhike.model.EventListResponse
import com.java.eventhike.model.EventsItem
import com.java.eventhike.network.DataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers



/**
 * Created by swapnil on 3/12/18.
 */

open class EventViewModel(var mDataManager: DataManager?) : BaseObservable() {
    var eventsItem: EventsItem? = null
    private var lat: Double = 0.0
    private var lng: Double = 0.0
    open val items: ObservableList<EventsItem> = ObservableArrayList()


    fun loadEvent(mLatLng: LatLng){
        //TODO load data from shared preference
        updateLatLng(mLatLng.latitude, mLatLng.longitude)
        mDataManager?.getEvents(mLatLng.latitude, mLatLng.longitude, 100,"venue", 100, "250414581969875%7Cdt5jSQD2oOs8MM32Blvh-YbvG0I")
                ?.subscribeOn(Schedulers.computation())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(
                        this::postProcess,

                        this::onError
                )
    }

    private fun updateLatLng(lat: Double, lng: Double){
        this.lat = lat
        this.lng = lng
    }

   private fun calculateLatLng(){

   }

    private fun postProcess(mEventListResponse: EventListResponse){
        items.clear()
        mEventListResponse.events?.let { items.addAll(it) };
    }

    fun onError(mThrowable: Throwable){
    }
}