package com.java.eventhike.feature.home.event.map


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.java.eventhike.R
import com.java.eventhike.databinding.MapFragmentBinding
import com.java.eventhike.feature.home.HomeActivity
import com.java.eventhike.feature.home.event.EventViewModel
import com.java.eventhike.model.EventsItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class MapFragment() : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener{
    @Inject lateinit var mEventViewModel: EventViewModel

    @Inject lateinit  var mEventRecyclerAdapter: MapEventRecyclerAdapter

    private lateinit var mMapFragmentBinding: MapFragmentBinding

    private lateinit var mActivity : HomeActivity

    private lateinit var mGoogleMap: GoogleMap

    private val mSubscriptions = CompositeSubscription()

    private var builder = LatLngBounds.builder()

    private var count: Int = 0

    private val mMarkerMap: LinkedHashMap<Marker, Pair<Int, EventsItem>> =  LinkedHashMap<Marker, Pair<Int, EventsItem>>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mMapFragmentBinding = MapFragmentBinding.inflate(inflater!!, container, false) as MapFragmentBinding

        mActivity = activity as HomeActivity
        mActivity.mHomeComponent.inject(this)

        mMapFragmentBinding.viewModel = mEventViewModel

        mMapFragmentBinding.mapRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mMapFragmentBinding.mapRecyclerView.adapter = mEventRecyclerAdapter

        subscribeToEventList()

        val mapFragment = childFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment?

        mapFragment?.getMapAsync(this)

        return mMapFragmentBinding.root
    }

    override fun onMapReady(mGoogleMap: GoogleMap?) {
           mGoogleMap?.let {
               this.mGoogleMap = it
               this.mGoogleMap.setOnMarkerClickListener(this);
           }
    }

    private fun subscribeToEventList(){

    mEventViewModel.getSourceObservable()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe {
                    updateMap(it);
                    updateError(Throwable())
                }
    }

        private  fun updateMap(mEventList: List<EventsItem>){
                mEventList.forEach {
                   if( it.place?.location?.latitude !=null &&  it.place?.location?.longitude !=null){
                       var marker = mGoogleMap?.addMarker(MarkerOptions()
                                .position(LatLng(it.place?.location?.latitude,  it.place?.location?.longitude))
                                .title(it.name)) as Marker
                       builder.include(marker.position)
                       mMarkerMap.put(marker, Pair(count++, it))
                   }
                }
            mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 150));
        }

    private fun updateError(mThrowable: Throwable){
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        if(mMarkerMap.containsKey(marker)){
              var pair = mMarkerMap.get(marker) as Pair
              mMapFragmentBinding.mapRecyclerView.smoothScrollToPosition(pair.first-1)
        }
        return true
    }

    private fun setOnScrollChangeListener() {
        mMapFragmentBinding.mapRecyclerView.viewTreeObserver.addOnScrollChangedListener {
            fun onScrollChanged(){

            }
        }
    }
}

