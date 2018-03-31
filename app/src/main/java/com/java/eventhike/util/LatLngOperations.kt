package com.java.eventhike.util

/**
 * Created by swapnil on 3/17/18.
 */
class LatLngOperations {


    fun MaxLatLngOnBearing(centerLat: Double, centerLong: Double, bearing: Double, distance: Double) {

        val lonRads = Math.toRadians(centerLong)
        val latRads = Math.toRadians(centerLat)
        val bearingRads = Math.toRadians(bearing)
        val maxLatRads = Math.asin(Math.sin(latRads) * Math.cos(distance / 6371) + Math.cos(latRads) * Math.sin(distance / 6371) * Math.cos(bearingRads))
        val maxLonRads = lonRads + Math.atan2(Math.sin(bearingRads) * Math.sin(distance / 6371) * Math.cos(latRads), Math.cos(distance / 6371) - Math.sin(latRads) * Math.sin(maxLatRads))
        val maxLat = Math.toDegrees(maxLatRads)
        val maxLong = Math.toDegrees(maxLonRads)
    }

}