package com.java.eventhike.network
import com.java.eventhike.model.EventsItem
import rx.Observable

/**
 * Created by swapnil on 3/12/18.
 */
class DataManager(private val mApiService: ApiService) {
    fun makeBatchRequest(token: String, latLanArray: ArrayList<String>): Observable<EventsItem> {
        return mApiService.getEvents(latLanArray, token)
    }
}