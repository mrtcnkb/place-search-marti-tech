package com.muratcan.placesearchmartitech.ui.view.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.muratcan.model.search.Result
import com.muratcan.placesearchmartitech.R
import com.muratcan.placesearchmartitech.databinding.FragmentSearchResultMapBinding
import com.muratcan.placesearchmartitech.util.ViewBindingHolder
import com.muratcan.placesearchmartitech.util.ViewBindingHolderImpl
import com.muratcan.placesearchmartitech.util.observeNonNull
import com.muratcan.placesearchmartitech.viewmodel.VMSearchResultMap
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchResultMapFragment : Fragment(), ViewBindingHolder<FragmentSearchResultMapBinding> by ViewBindingHolderImpl(), OnMapReadyCallback {

    private val viewModel: VMSearchResultMap by viewModel()
    private lateinit var mMap: GoogleMap
    private lateinit var mapInfo: MapInfo

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = initBinding(FragmentSearchResultMapBinding.inflate(layoutInflater), this) {
        observeOperation()
        getBundleArguments()
    }

    private fun observeOperation() {
        with(viewModel) {
            searchData.observeNonNull(this@SearchResultMapFragment) {
                mapInfo = MapInfo(
                    LatLng(it.geometry.location.lat, it.geometry.location.lng),
                    it.name,
                    it.formatted_address
                )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(requireBinding().mapView) {
            onCreate(savedInstanceState)
            getMapAsync(this@SearchResultMapFragment)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.apply {
            addMarker(MarkerOptions().position(mapInfo.latLng).title(mapInfo.title).snippet(mapInfo.snipped))
            moveCamera(CameraUpdateFactory.newLatLng(mapInfo.latLng))

            CameraPosition.Builder().target(mapInfo.latLng).zoom(15f).build().also {
                animateCamera(CameraUpdateFactory.newCameraPosition(it))
            }

            setOnInfoWindowClickListener {
                findNavController().navigate(R.id.action_searchResultMapFragment_to_markerDetailFragment, bundleOf("markerResult" to viewModel.searchData.value))
            }
        }
    }
    override fun onResume() {
        super.onResume()
        requireBinding().mapView.onResume()
    }

    override fun onStart() {
        super.onStart()
        requireBinding().mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        requireBinding().mapView.onStop()
    }

    override fun onPause() {
        requireBinding().mapView.onPause()
        super.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        requireBinding().mapView.onLowMemory()
    }

    private fun getBundleArguments() {
        arguments?.getParcelable<Result>("searchResult")?.let {
            viewModel.searchData.value = it
        }
    }

}