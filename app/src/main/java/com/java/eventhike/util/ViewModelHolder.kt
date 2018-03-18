package com.java.eventhike.util

import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * Created by swapnil on 3/17/18.
 */


internal class ViewModelHolder<VM> : Fragment() {

    var mViewModel: VM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    companion object {
        fun <M> createContainer(viewModel: M): ViewModelHolder<*> {
            val viewModelContainer = ViewModelHolder<M>()
            viewModelContainer.mViewModel = viewModel
            return viewModelContainer
        }
    }

    fun getViewModel(): VM? {
        return mViewModel
    }

    fun setViewModel(viewModel: VM?) {
        mViewModel = viewModel
    }
}