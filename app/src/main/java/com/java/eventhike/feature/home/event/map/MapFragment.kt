package com.java.eventhike.feature.home.event.map


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.java.eventhike.R
import com.java.eventhike.feature.home.event.EventViewModel
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class MapFragment() : Fragment() {

    @Inject lateinit var mEventViewModel: EventViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_map, container, false)
    }
}
