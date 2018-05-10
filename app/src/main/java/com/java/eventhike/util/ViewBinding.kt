package com.java.eventhike.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.java.eventhike.R
import com.java.eventhike.model.EventsItem


/**
 * Created by swapnil on 3/18/18.
 */

    @BindingAdapter("items")
     fun  setSchoolList(view: RecyclerView, list: List<EventsItem>) {
     var adapter = view.adapter as ArrayRecyclerAdapter<EventsItem, *>
            adapter.clear()
            adapter.addAll(list)
            adapter.notifyDataSetChanged()
    }

    @BindingAdapter("imageUrl")
    fun loadNetworkImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageView)
    }

    @BindingAdapter("android:text")
    fun setText(view: TextView, value: Int) {
           if(view.id==R.id.event_time) {
               val textStr = view.resources.getQuantityString(R.plurals.start_date, value, value)
               view.text = textStr
           }
           else
               view.text = value.toString()
    }