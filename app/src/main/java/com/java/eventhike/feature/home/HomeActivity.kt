package com.java.eventhike.feature.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.ui.PlaceAutocomplete
import com.google.android.gms.maps.model.LatLng
import com.java.eventhike.R
import com.java.eventhike.feature.home.event.list.ListFragment
import com.java.eventhike.feature.home.event.list.ListNavigator
import com.java.eventhike.feature.home.event.map.MapFragment
import com.java.eventhike.model.EventsItem
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject


class HomeActivity : AppCompatActivity(), ListNavigator {

    @Inject lateinit var mListFragment: ListFragment

    @Inject lateinit var mMapFragment: MapFragment

    val PLACE_AUTOCOMPLETE_REQUEST_CODE = 1

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        autoSuggestHomeTextView.setOnClickListener { searchBarOnClick() }
    }

    private fun searchBarOnClick(){
        val intent = PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                .build(this@HomeActivity)
        startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                setLocationText(PlaceAutocomplete.getPlace(this, data))
                getEvents(PlaceAutocomplete.getPlace(this, data).latLng)
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                val status = PlaceAutocomplete.getStatus(this, data)
            } else if (resultCode == Activity.RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }
    }

    private fun setLocationText(place: Place){
        autoSuggestHomeTextView.setText(place.address)
    }

    private fun getEvents(latLng: LatLng){

    }

    override fun onEventItemClick(eventsItem: EventsItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
