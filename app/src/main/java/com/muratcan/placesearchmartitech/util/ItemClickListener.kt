package com.muratcan.placesearchmartitech.util

import android.view.View
import com.muratcan.model.search.Result

/**
 * Created by MuratCan on 6.05.2020.
 */
interface ItemClickListener {
    fun onItemClick(view: View, item: Result)
}