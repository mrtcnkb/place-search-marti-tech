package com.muratcan.placesearchmartitech.ui.view.search

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.muratcan.model.search.Result
import com.muratcan.placesearchmartitech.R
import com.muratcan.placesearchmartitech.databinding.FragmentSearchBinding
import com.muratcan.placesearchmartitech.ui.adapter.SearchResultListAdapter
import com.muratcan.placesearchmartitech.util.ItemClickListener
import com.muratcan.placesearchmartitech.util.ViewBindingHolder
import com.muratcan.placesearchmartitech.util.ViewBindingHolderImpl
import com.muratcan.placesearchmartitech.util.observeNonNull
import com.muratcan.placesearchmartitech.viewmodel.VMSearchFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment(),
    ViewBindingHolder<FragmentSearchBinding> by ViewBindingHolderImpl() {

    private val viewModel: VMSearchFragment by viewModel()
    private lateinit var searchResultAdapter: SearchResultListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        initBinding(FragmentSearchBinding.inflate(layoutInflater), this) {
            initRecycler()
            observeOperations()
            listenerOperations()
        }

    private fun listenerOperations() {
        requireBinding {
            searchInput.addTextChangedListener(textChangeListener)
        }
    }

    private fun observeOperations() {
        with(viewModel) {
            searchResult.observeNonNull(this@SearchFragment) {
                searchResultAdapter.setPostItemList(it.results)
                checkForEmptyResultScreen(it.results.isEmpty())
            }
        }
    }

    private fun checkForEmptyResultScreen(isempty: Boolean) {
        requireBinding{
            emptyScreen.root.visibility = if (isempty) View.VISIBLE else View.GONE
        }
    }

    private fun initRecycler() {
        searchResultAdapter = SearchResultListAdapter(object: ItemClickListener {
            override fun onItemClick(view: View, item: Result) {
                findNavController().navigate(R.id.action_searchFragment_to_searchResultMapFragment, bundleOf("searchResult" to item))
            }
        })
        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false).let {
            requireBinding().rvSearch.apply {
                adapter = searchResultAdapter
                layoutManager = it
            }
        }
    }

    private val textChangeListener = object: TextWatcher{
        override fun afterTextChanged(p0: Editable?) {
            requireBinding {
                p0?.let {
                    checkForEmptyResultScreen(it.isBlank())
                    if (it.isBlank()) {
                        searchResultAdapter.clearList()
                    } else {
                        viewModel.fetchResult(it.toString())
                    }
                }
            }

        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

}