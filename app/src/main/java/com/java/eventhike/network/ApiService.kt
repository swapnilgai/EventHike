package com.java.eventhike.network

import com.java.eventhike.model.EventListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


/**
 * Created by swapnil on 3/12/18.
 */

interface ApiService{
    @Headers("Content-Type: application/json")
    @GET("events")
    fun getEvents(
            @Query("lat") lat: Double,
            @Query("lng") lng: Double,
            @Query("distance") distance: Int?=100,
            @Query("sort") sort: String? = "date",
            @Query("limit") limit: Int?=100,
            @Query("accessToken") token: String
     ): Observable<EventListResponse>
}