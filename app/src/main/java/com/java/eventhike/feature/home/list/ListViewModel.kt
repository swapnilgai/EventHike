package com.java.eventhike.feature.home.list

import android.databinding.BaseObservable
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.java.eventhike.model.EventsItem
import com.java.eventhike.network.DataManager

/**
 * Created by swapnil on 3/12/18.
 */

internal open class ListViewModel(var mDataManager: DataManager?) : BaseObservable() {
    var eventsItem: EventsItem? = null
    val items: ObservableList<EventsItem> = ObservableArrayList()
}