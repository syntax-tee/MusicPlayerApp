package com.ogunladetaiye.udux.ui.udux_discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ogunladetaiye.udux.databinding.FragmentDiscoverBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@AndroidEntryPoint
class DiscoverFragment : Fragment() {

    private val discoverViewModel: DiscoverViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDiscoverBinding.inflate(inflater)
//
//         GlobalScope.launch {
//             discoverViewModel.api()
//         }
        return  binding.root
    }

    fun observe() {
        discoverViewModel.udxModelItem.observe(viewLifecycleOwner, Observer {
            GlobalScope.launch {
                println("API $it")
            }
        })
    }


}