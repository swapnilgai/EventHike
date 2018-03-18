package com.java.eventhike.feature.home

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView


/**
 * Created by swapnil on 3/17/18.
 */
internal abstract class EndlessScrollListener(var mLayoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {
    private val mVisibleThreshold = 6
    private var mCurrentPage = 0
    private var mPreviousTotalItemCount = 0
    private var mLoading = true
    private val mStartingPageIndex = 0

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {

        val lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition()
        val totalItemCount = mLayoutManager.itemCount

        if (totalItemCount < mPreviousTotalItemCount) {
            this.mCurrentPage = this.mStartingPageIndex
            this.mPreviousTotalItemCount = totalItemCount
            if (totalItemCount == 0) {
                this.mLoading = true
            }
        }

        if (mLoading && totalItemCount > mPreviousTotalItemCount) {
            mLoading = false
            mPreviousTotalItemCount = totalItemCount
        }

        if (!mLoading && lastVisibleItemPosition + mVisibleThreshold > totalItemCount) {
            mCurrentPage++
            onLoadMore(mCurrentPage, totalItemCount, recyclerView)
            mLoading = true
        }
    }

    fun resetState() {
        this.mCurrentPage = this.mStartingPageIndex
        this.mPreviousTotalItemCount = 0
        this.mLoading = true
    }

    abstract fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?)
}
