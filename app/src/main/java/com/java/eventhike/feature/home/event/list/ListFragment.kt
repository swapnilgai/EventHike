package com.java.eventhike.feature.home.event.list


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.java.eventhike.databinding.ListFragmentBinding
import com.java.eventhike.feature.home.EndlessScrollListener
import com.java.eventhike.feature.home.HomeActivity
import com.java.eventhike.feature.home.event.EventViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    @Inject lateinit  var mEventRecyclerAdapter: ListEventRecyclerAdapter

    @Inject lateinit var mEventViewModel: EventViewModel

    lateinit var mActivity : HomeActivity

    lateinit var mListFragmentBinding: ListFragmentBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mListFragmentBinding = ListFragmentBinding.inflate(inflater!!, container, false) as ListFragmentBinding

        mActivity = activity as HomeActivity
        mActivity.mHomeComponent.inject(this)

        mListFragmentBinding.viewModel = mEventViewModel

        mListFragmentBinding.listRecyclerView.layoutManager = LinearLayoutManager(context)
        mListFragmentBinding.listRecyclerView.adapter = mEventRecyclerAdapter

        val endlessScrollListener = object : EndlessScrollListener(mListFragmentBinding.listRecyclerView.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

        mListFragmentBinding.listRecyclerView.addOnScrollListener(endlessScrollListener)

        return mListFragmentBinding.root
    }

    fun loadEvent(page: Int) {

    }


}// Required empty public constructor
