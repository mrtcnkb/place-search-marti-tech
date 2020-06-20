package com.muratcan.placesearchmartitech.ui.view.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.muratcan.model.search.Result
import com.muratcan.placesearchmartitech.databinding.FragmentMarkerDetailBinding
import com.muratcan.placesearchmartitech.util.ViewBindingHolder
import com.muratcan.placesearchmartitech.util.ViewBindingHolderImpl
import com.muratcan.placesearchmartitech.util.observeNonNull
import com.muratcan.placesearchmartitech.viewmodel.VMMarkerDetail
import org.koin.androidx.viewmodel.ext.android.viewModel

class MarkerDetailFragment : Fragment(),
    ViewBindingHolder<FragmentMarkerDetailBinding> by ViewBindingHolderImpl() {

    private val  viewModel: VMMarkerDetail by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = initBinding(FragmentMarkerDetailBinding.inflate(layoutInflater), this) {
        observeOperation()
        getBundleArguments()
    }

    private fun observeOperation() {
        with(viewModel) {
            markerData.observeNonNull(this@MarkerDetailFragment) {
                Log.e("muro", "--> Marker isim : ${it.name}")
            }
        }
    }

    private fun getBundleArguments() {
        arguments?.getParcelable<Result>("markerResult")?.let {
            viewModel.markerData.value = it
        }
    }

}