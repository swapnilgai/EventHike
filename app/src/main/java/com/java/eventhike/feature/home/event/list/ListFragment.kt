package com.java.eventhike.feature.home.event.list


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.java.eventhike.R
import com.java.eventhike.feature.home.EndlessScrollListener
import com.java.eventhike.feature.home.HomeActivity
import com.java.eventhike.feature.home.event.EventRecyclerAdapter
import com.java.eventhike.feature.home.event.EventViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    @Inject lateinit  var mEventRecyclerAdapter: EventRecyclerAdapter

    @Inject lateinit var mEventViewModel: EventViewModel

    lateinit var mActivity : HomeActivity

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        mActivity = activity as HomeActivity
        mActivity.mHomeComponent.inject(this)

        listRecyclerView.layoutManager = LinearLayoutManager(context)
        listRecyclerView.adapter = mEventRecyclerAdapter

        val endlessScrollListener = object : EndlessScrollListener(listRecyclerView.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

        listRecyclerView.addOnScrollListener(endlessScrollListener)

        return inflater!!.inflate(R.layout.fragment_list, container, false)
    }

    fun loadEvent(page: Int) {

    }


}// Required empty public constructor
