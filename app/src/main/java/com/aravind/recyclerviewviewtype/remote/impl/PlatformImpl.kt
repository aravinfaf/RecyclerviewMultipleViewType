package com.aravind.recyclerviewviewtype.remote.impl

import com.aravind.recyclerviewviewtype.R
import com.aravind.recyclerviewviewtype.model.Android
import com.aravind.recyclerviewviewtype.model.IOS
import com.aravind.recyclerviewviewtype.model.Platform
import com.aravind.recyclerviewviewtype.model.Windows
import com.aravind.recyclerviewviewtype.remote.PlatformService

class PlatformImpl : PlatformService {
    override fun getPlatformData(): List<Platform> {
        var list : ArrayList<Platform> = arrayListOf()

        list.add(Platform(1, Android("Noughat","7.0", R.drawable.whatsapp)))
        list.add(Platform(1, Android("Oreo","8.0", R.drawable.facebook)))
        list.add(Platform(1, Android("Noughat","7.0", R.drawable.twitter)))

        list.add(Platform(2, IOS("IOS","12.0", R.drawable.instagram)))
        list.add(Platform(2, IOS("IOS","13.0", R.drawable.facebook)))

        list.add(Platform(3, Windows("Windows","10.0")))
        list.add(Platform(3, Windows("Windows","7.0")))

        return list
    }
}