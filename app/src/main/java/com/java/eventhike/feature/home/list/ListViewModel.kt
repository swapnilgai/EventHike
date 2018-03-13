package com.java.eventhike.feature.home.list

import android.databinding.BaseObservable
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.java.eventhike.model.EventsItem
import com.java.eventhike.network.DataManager

/**
 * Created by swapnil on 3/12/18.
 */

internal open class ListViewModel(private val mDataManager: DataManager) : BaseObservable() {
    var eventsItem: EventsItem? = null
    val items: ObservableList<EventsItem> = ObservableArrayList()

    fun getPublicGist() {
//        mDataManager.makeLocalGistApiCall("1").enqueue(object : Callback<List<Gists>>() {
//            fun onResponse(call: Call<List<Gists>>, response: Response<List<Gists>>) {
//                val gistList = response.body() as List<Gists>
//                items.addAll(gistList)
//            }
//
//            fun onFailure(call: Call<List<Gists>>, throwable: Throwable) {}
//        })
    }
}