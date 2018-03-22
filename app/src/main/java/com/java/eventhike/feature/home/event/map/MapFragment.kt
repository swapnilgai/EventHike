package com.java.eventhike.feature.home.event.map


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.java.eventhike.databinding.ListFragmentBinding
import com.java.eventhike.databinding.MapFragmentBinding
import com.java.eventhike.feature.home.HomeActivity
import com.java.eventhike.feature.home.event.EventRecyclerAdapter
import com.java.eventhike.feature.home.event.EventViewModel
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class MapFragment() : Fragment() {

    @Inject lateinit var mEventViewModel: EventViewModel

    @Inject lateinit  var mEventRecyclerAdapter: EventRecyclerAdapter

    lateinit var mMapFragmentBinding: MapFragmentBinding

    lateinit var mActivity : HomeActivity

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mMapFragmentBinding = ListFragmentBinding.inflate(inflater!!, container, false) as MapFragmentBinding

        mActivity = activity as HomeActivity
        mActivity.mHomeComponent.inject(this)

        mMapFragmentBinding.viewModel = mEventViewModel

        mMapFragmentBinding.mapRecyclerView.layoutManager = LinearLayoutManager(context)
        mMapFragmentBinding.mapRecyclerView.adapter = mEventRecyclerAdapter

        return mMapFragmentBinding.root
    }
}
