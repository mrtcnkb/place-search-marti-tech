package com.muratcan.placesearchmartitech.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.muratcan.placesearchmartitech.R
import com.muratcan.placesearchmartitech.databinding.FragmentSearchBinding
import com.muratcan.placesearchmartitech.util.ViewBindingHolder
import com.muratcan.placesearchmartitech.util.ViewBindingHolderImpl

class SearchFragment : Fragment(), ViewBindingHolder<FragmentSearchBinding> by ViewBindingHolderImpl() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = initBinding(FragmentSearchBinding.inflate(layoutInflater), this) {

        requireBinding {
            searchButton.setOnClickListener {
                findNavController().navigate(R.id.action_searchFragment_to_searchResultMapFragment)
            }
        }

    }

}