package com.java.eventhike.network

import com.java.eventhike.model.EventsItem
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import rx.Observable


/**
 * Created by swapnil on 3/12/18.
 */

interface ApiService{
    @Headers("Content-Type: application/json")
    @POST("events/")
    fun getEvents(
            @Path("latLanArray") latLanArray: ArrayList<String>,
            @Path("accessToken") token: String
     ): Observable<EventsItem>
}