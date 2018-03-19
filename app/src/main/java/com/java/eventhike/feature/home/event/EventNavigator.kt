package com.java.eventhike.feature.home.event

import com.java.eventhike.model.EventsItem


/**
 * Created by swapnil on 3/16/18.
 */
interface EventNavigator{
     fun onEventItemClick(eventsItem: EventsItem);
}