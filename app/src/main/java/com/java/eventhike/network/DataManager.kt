package com.java.eventhike.network
import com.java.eventhike.model.EventListResponse
import io.reactivex.Observable

/**
 * Created by swapnil on 3/12/18.
 */
class DataManager(private val mApiService: ApiService) {
    fun getEvents( lat: Double, lng: Double, distance: Int, sort: String, limit: Int, token: String): Observable<EventListResponse> {
        return mApiService.getEvents(lat, lng, distance, sort, limit, token)
    }
}