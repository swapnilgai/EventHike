package com.java.eventhike.feature.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.ui.PlaceAutocomplete
import com.google.android.gms.maps.model.LatLng
import com.java.eventhike.R
import com.java.eventhike.di.Component.DaggerHomeComponent
import com.java.eventhike.di.Component.HomeComponent
import com.java.eventhike.di.module.EventRecyclerAdapterModule
import com.java.eventhike.di.module.FragmentManagerModule
import com.java.eventhike.di.module.NetModule
import com.java.eventhike.feature.home.event.EventNavigator
import com.java.eventhike.feature.home.event.EventViewModel
import com.java.eventhike.feature.home.event.list.ListFragment
import com.java.eventhike.feature.home.event.map.MapFragment
import com.java.eventhike.model.EventsItem
import com.java.eventhike.util.BottomNavigationViewBehavior
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject




class HomeActivity : AppCompatActivity(), EventNavigator {

    @Inject lateinit var mListFragment: ListFragment

    @Inject lateinit var mMapFragment: MapFragment

    @Inject lateinit var mEventViewModel: EventViewModel

    lateinit var mHomeComponent : HomeComponent

    val PLACE_AUTOCOMPLETE_REQUEST_CODE = 1

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_list -> {
                supportFragmentManager.beginTransaction().hide(mMapFragment).commit()
                supportFragmentManager.beginTransaction().show(mListFragment).commit()

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_map -> {
                supportFragmentManager.beginTransaction().hide(mListFragment).commit()
                supportFragmentManager.beginTransaction().show(mMapFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_setting -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mHomeComponent = DaggerHomeComponent.builder().netModule(NetModule(getString(R.string.Base_Url)))
                .fragmentManagerModule(FragmentManagerModule(supportFragmentManager))
                .eventRecyclerAdapterModule(EventRecyclerAdapterModule(this))
                .build()

        mHomeComponent.inject(this)

        supportFragmentManager.beginTransaction().add(R.id.fragment_content, mMapFragment)
                                                 .add(R.id.fragment_content, mListFragment)
                                                 .commit()


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        autoSuggestHomeTextView.setOnClickListener { searchBarOnClick() }

        val layoutParams = navigation.getLayoutParams() as CoordinatorLayout.LayoutParams
        layoutParams.behavior = BottomNavigationViewBehavior()

        val collapsingToolbarLayout = findViewById<View>(R.id.toolbar_layout) as CollapsingToolbarLayout
        val appBarLayout = findViewById<View>(R.id.app_bar) as AppBarLayout
        appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            internal var isShow = true
            internal var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.title = autoSuggestHomeTextView.text
                    isShow = true
                } else if (isShow) {
                    collapsingToolbarLayout.title = " "//carefull there should a space between double quote otherwise it wont work
                    isShow = false
                }
            }
        })
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
        mEventViewModel.loadEvent(latLng)
    }

    override fun onEventItemClick(eventsItem: EventsItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
