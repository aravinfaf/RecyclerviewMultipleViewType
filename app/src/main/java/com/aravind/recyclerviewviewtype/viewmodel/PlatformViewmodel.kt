package com.aravind.recyclerviewviewtype.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aravind.recyclerviewviewtype.R
import com.aravind.recyclerviewviewtype.model.*
import com.aravind.recyclerviewviewtype.remote.PlatformService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlatformViewmodel @Inject constructor(private val data : PlatformService) : ViewModel() {

    private val listData : MutableLiveData<List<Platform>> = MutableLiveData()
    val listValue : LiveData<List<Platform>> = listData

    fun getPlatform() {
            listData.value = data.getPlatformData()
    }
}