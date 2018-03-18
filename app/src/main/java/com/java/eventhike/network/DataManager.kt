package com.java.eventhike.network
import com.java.eventhike.model.EventsItem
import rx.Observable

/**
 * Created by swapnil on 3/12/18.
 */
class DataManager(private val mApiService: ApiService) {
    fun getEvents( lat: String, lng: String, distance: Int, sort: String, limit: Int, token: String): Observable<EventsItem> {
        return mApiService.getEvents(lat, lng, distance, sort, limit, token)
    }
}