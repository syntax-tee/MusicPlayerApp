package com.ogunladetaiye.udux.ui.udux_discover

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ogunladetaiye.udux.data.remote.UduxApi
import com.ogunladetaiye.udux.data.remote.response.DiscoverApiResponseItem
import kotlinx.coroutines.launch
import timber.log.Timber


class DiscoverViewModel @ViewModelInject constructor(private val api: UduxApi) : ViewModel() {


    private val _udxModelItem = MutableLiveData<List<DiscoverApiResponseItem>>()
    val udxModelItem: LiveData<List<DiscoverApiResponseItem>>
        get() = _udxModelItem


    fun api() {
        viewModelScope.launch {
            val result = api.discoverMusic().get(1)
            Timber.d("Discover" + result.items)
            Log.d("Discover", "ViewModel"+ result)
        }
    }
}