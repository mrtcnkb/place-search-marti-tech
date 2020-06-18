package com.muratcan.placesearchmartitech.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.muratcan.placesearchmartitech.databinding.FragmentSearchResultMapBinding
import com.muratcan.placesearchmartitech.util.ViewBindingHolder
import com.muratcan.placesearchmartitech.util.ViewBindingHolderImpl

class SearchResultMapFragment : Fragment(), ViewBindingHolder<FragmentSearchResultMapBinding> by ViewBindingHolderImpl() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = initBinding(FragmentSearchResultMapBinding.inflate(layoutInflater), this) {

    }

}