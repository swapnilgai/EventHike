package com.java.eventhike.feature.home.event

import com.java.eventhike.feature.home.event.list.ListNavigator
import com.java.eventhike.network.DataManager

/**
 * Created by swapnil on 3/12/18.
 */
open class EventItemViewModel(mDataManager: DataManager?): EventViewModel(mDataManager) {
    var listNavigator : ListNavigator?= null
}