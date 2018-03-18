package com.java.eventhike.feature.home.event.list

import com.java.eventhike.model.EventsItem


/**
 * Created by swapnil on 3/16/18.
 */
interface ListNavigator{
     fun onEventItemClick(eventsItem: EventsItem);
}