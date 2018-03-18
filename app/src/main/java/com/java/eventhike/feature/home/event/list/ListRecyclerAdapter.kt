package com.java.eventhike.feature.home.event.list

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import com.java.eventhike.R
import com.java.eventhike.databinding.EventItemBinding
import com.java.eventhike.feature.home.event.EventItemViewModel
import com.java.eventhike.model.EventsItem
import com.java.eventhike.util.ArrayRecyclerAdapter


/**
 * Created by swapnil on 3/12/18.
 */
class ListRecyclerAdapter(var listNavigator: ListNavigator): ArrayRecyclerAdapter<EventsItem, ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder{
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val viewBinding = DataBindingUtil.inflate<EventItemBinding>(
                LayoutInflater.from(parent?.context),
                R.layout.event_item,
                parent,
                false)
        return DataResultHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is DataResultHolder) {
            val mEventItemViewModel = EventItemViewModel(null);
            mEventItemViewModel.eventsItem = getItem(position)
            mEventItemViewModel.listNavigator = listNavigator
            holder.binding.viewModel = mEventItemViewModel
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class DataResultHolder(val binding: EventItemBinding) : RecyclerView.ViewHolder(binding.eventItemConstraintLayout)
}