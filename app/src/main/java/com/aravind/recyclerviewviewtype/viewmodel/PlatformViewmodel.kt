package com.aravind.recyclerviewviewtype.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aravind.recyclerviewviewtype.R
import com.aravind.recyclerviewviewtype.model.Android
import com.aravind.recyclerviewviewtype.model.IOS
import com.aravind.recyclerviewviewtype.model.Platform
import com.aravind.recyclerviewviewtype.model.Windows
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class PlatformViewmodel : ViewModel() {

    private val listData : MutableLiveData<List<Platform>> = MutableLiveData()
    val listValue : LiveData<List<Platform>> = listData
    var list : ArrayList<Platform> = arrayListOf()

    fun getPlatform(){
        list.add(Platform(1, Android("Noughat","7.0", R.drawable.whatsapp)))
        list.add(Platform(1, Android("Oreo","8.0", R.drawable.facebook)))
        list.add(Platform(1, Android("Noughat","7.0", R.drawable.twitter)))

        list.add(Platform(2, IOS("IOS","12.0", R.drawable.instagram)))
        list.add(Platform(2, IOS("IOS","13.0", R.drawable.facebook)))

        list.add(Platform(3, Windows("Windows","10.0")))
        list.add(Platform(3, Windows("Windows","7.0")))

        listData.value = list
    }
}