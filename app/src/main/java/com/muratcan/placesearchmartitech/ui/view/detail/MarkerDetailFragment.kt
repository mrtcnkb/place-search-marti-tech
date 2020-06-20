package com.muratcan.placesearchmartitech.ui.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.muratcan.model.search.Result
import com.muratcan.placesearchmartitech.R
import com.muratcan.placesearchmartitech.databinding.FragmentMarkerDetailBinding
import com.muratcan.placesearchmartitech.viewmodel.VMMarkerDetail
import org.koin.androidx.viewmodel.ext.android.viewModel

class MarkerDetailFragment : Fragment() {

    private val  viewModel: VMMarkerDetail by viewModel()
    private lateinit var binding: FragmentMarkerDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_marker_detail, container, false)
        binding.lifecycleOwner = this@MarkerDetailFragment
        binding.viewModel = viewModel
        getBundleArguments()
        return binding.root
    }

    private fun getBundleArguments() {
        arguments?.getParcelable<Result>("markerResult")?.let {
            viewModel.markerData.value = it
        }
    }

}