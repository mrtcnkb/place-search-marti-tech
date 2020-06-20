package com.muratcan.placesearchmartitech.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.muratcan.model.search.Result
import com.muratcan.placesearchmartitech.R
import com.muratcan.placesearchmartitech.databinding.RowSearchResultBinding
import com.muratcan.placesearchmartitech.util.ItemClickListener
import hari.bounceview.BounceView

/**
 * Created by MuratCan on 19.06.2020.
 */
class SearchResultListAdapter(private val listener: ItemClickListener): RecyclerView.Adapter<SearchResultListAdapter.SearchResultListViewHolder>() {
    private var results: MutableList<Result> = mutableListOf()
    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultListViewHolder {
        parent.inflate<RowSearchResultBinding>(R.layout.row_search_result, false).run { return SearchResultListViewHolder(this) }
    }

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: SearchResultListViewHolder, position: Int) {
        with(holder) {
            bind(position)
            BounceView.addAnimTo(itemView).setScaleForPopOutAnim(1f, 0f)
            setAnimation(itemView, position)
        }
    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > lastPosition) {
            AnimationUtils.loadAnimation(viewToAnimate.context, android.R.anim.slide_in_left).apply {
                duration = 300
                viewToAnimate.startAnimation(this)
                lastPosition = position
            }
        }
    }

    fun clearList() {
        results.clear()
        notifyDataSetChanged()
    }

    fun setPostItemList(list: List<Result>) {
        results.run {
            clearList()
            addAll(list)
        }
        notifyDataSetChanged()

    }

    inner class SearchResultListViewHolder(private val binding: RowSearchResultBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.apply {
                results[position].also {
                    title.text = it.name
                    desc.text = it.formatted_address
                    root.setOnClickListener {view ->
                        listener.onItemClick(view, it)
                    }
                }
            }
        }
    }

    private fun <T : ViewDataBinding> ViewGroup?.inflate(@LayoutRes layoutId: Int, attachToParent: Boolean = true): T {
        return DataBindingUtil.inflate(LayoutInflater.from(this!!.context), layoutId, this, attachToParent)
    }


}