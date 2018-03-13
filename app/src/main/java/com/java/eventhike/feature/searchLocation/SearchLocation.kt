package com.java.eventhike.feature.searchLocation

import android.app.Activity
import android.os.Bundle
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment
import com.google.android.gms.location.places.ui.PlaceSelectionListener
import com.java.eventhike.R

class SearchLocation : Activity() {


    private var autocompleteFragment: PlaceAutocompleteFragment? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_location)
        autocompleteFragment = fragmentManager.findFragmentById(R.id.placeAutocompleteFragment) as PlaceAutocompleteFragment
        addPlaceAutoCompleteListener()
    }

    fun addPlaceAutoCompleteListener(){

        autocompleteFragment?.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
            }

            override fun onError(status: Status) {
                // TODO: Handle the error.
                //  Log.i(TAG, "An error occurred: " + status);
            }
        })
    }
}
