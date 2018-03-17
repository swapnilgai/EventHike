package com.java.eventhike.feature.home.list

import com.java.eventhike.network.DataManager

/**
 * Created by swapnil on 3/12/18.
 */
internal open class ListItemViewModel(mDataManager: DataManager?): ListViewModel(mDataManager) {
    var listNavigator : ListNavigator?= null
}