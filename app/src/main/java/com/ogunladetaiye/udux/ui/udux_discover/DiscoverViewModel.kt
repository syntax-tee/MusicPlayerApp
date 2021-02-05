package com.ogunladetaiye.udux.ui.udux_discover

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ogunladetaiye.udux.data.remote.UduxApi
import com.ogunladetaiye.udux.data.remote.response.DiscoverApiResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class DiscoverViewModel @Inject constructor(private val api: UduxApi) : ViewModel() {


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