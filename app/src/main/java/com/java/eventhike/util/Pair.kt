package com.java.eventhike.util

/**
 * Created by swapnil on 3/25/18.
 */
internal class Pair<A, B>(first: A, second: B) {
    var first: A? = null
    var second: B? = null

    init {
        this.first = first
        this.second = second
    }
}