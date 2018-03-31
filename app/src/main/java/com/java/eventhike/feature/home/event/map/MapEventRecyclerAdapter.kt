package com.java.eventhike.feature.home.event.map

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.java.eventhike.R
import com.java.eventhike.databinding.EventMapItemBinding
import com.java.eventhike.feature.home.event.EventItemViewModel
import com.java.eventhike.feature.home.event.EventNavigator
import com.java.eventhike.model.EventsItem
import com.java.eventhike.util.ArrayRecyclerAdapter

/**
 * Created by swapnil on 3/25/18.
 */
class MapEventRecyclerAdapter(var mEventNavigator: EventNavigator): ArrayRecyclerAdapter<EventsItem, RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {

        val viewBinding = DataBindingUtil.inflate<EventMapItemBinding>(
                LayoutInflater.from(parent?.context),
                R.layout.map_event_item,
                parent,
                false)
        return DataResultHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is DataResultHolder) {
            val mEventItemViewModel = EventItemViewModel(null);
            mEventItemViewModel.eventsItem = getItem(position)
            mEventItemViewModel.mEventNavigator = mEventNavigator
            holder.binding.viewModel = mEventItemViewModel
        }

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class DataResultHolder(val binding: EventMapItemBinding) : RecyclerView.ViewHolder(binding.root )
}