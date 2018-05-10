package com.java.eventhike.feature.home.event

import com.java.eventhike.network.DataManager
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

/**
 * Created by swapnil on 3/12/18.
 */
open class EventItemViewModel(mDataManager: DataManager?): EventViewModel(mDataManager) {
    lateinit var mEventNavigator: EventNavigator
    var format = DateTimeFormat.forPattern("yyyy-mm-dd'T'HH:mm:ss") as DateTimeFormatter

    fun getDateTime(): Int {
            var time = 0
            time = eventsItem?.timeFromNow?.div(86400) ?:0
            if(time <= 24)
                return 1
            else if(time <=48)
                return 2;
            else{
                var newTime =  time.div(24) as Int
                return newTime
            }
    }
}