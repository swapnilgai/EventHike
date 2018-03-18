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
import com.java.eventhike.feature.home.event.EventViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    @Inject
    val mListRecyclerAdapter: ListRecyclerAdapter? = null

    @Inject
    val  mEventViewModel: EventViewModel? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        listRecyclerView.layoutManager = LinearLayoutManager(context)
        listRecyclerView.adapter = mListRecyclerAdapter

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
