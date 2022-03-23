package com.aravind.recyclerviewviewtype.remote

import com.aravind.recyclerviewviewtype.model.Platform
import com.aravind.recyclerviewviewtype.remote.impl.PlatformImpl

interface PlatformService {

    fun getPlatformData() : List<Platform>

    companion object{
        fun create() : PlatformService{
            return PlatformImpl()
        }
    }
}