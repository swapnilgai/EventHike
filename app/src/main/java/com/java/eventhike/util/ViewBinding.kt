package com.java.eventhike.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.java.eventhike.feature.home.event.EventRecyclerAdapter
import com.java.eventhike.model.EventsItem


/**
 * Created by swapnil on 3/18/18.
 */
class ViewBinding {
    @BindingAdapter("items")
    fun setSchoolList(view: RecyclerView, list: List<EventsItem>) {
        val adapter = view.adapter as EventRecyclerAdapter
        if (adapter != null) {
            adapter.clear()
            adapter.addAll(list)
            adapter.notifyDataSetChanged()
        }
    }
}