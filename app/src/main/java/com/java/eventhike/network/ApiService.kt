package com.java.eventhike.network

import com.java.eventhike.model.temp1.EventsItem
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
            @Path("lat") lat: String,
            @Path("lng") lng: String,
            @Path("distance") distance: Int?=100,
            @Path("sort") sort: String? = "date",
            @Path("limit") limit: Int?=100,
            @Path("accessToken") token: String
     ): Observable<EventsItem>
}