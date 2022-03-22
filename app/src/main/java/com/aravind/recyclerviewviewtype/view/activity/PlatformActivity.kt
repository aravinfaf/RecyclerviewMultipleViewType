package com.aravind.recyclerviewviewtype.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aravind.recyclerviewviewtype.R
import com.aravind.recyclerviewviewtype.model.Android
import com.aravind.recyclerviewviewtype.model.IOS
import com.aravind.recyclerviewviewtype.model.Platform
import com.aravind.recyclerviewviewtype.model.Windows
import com.aravind.recyclerviewviewtype.view.adapter.PlatformAdapter

class PlatformActivity : AppCompatActivity() {

    var list : ArrayList<Platform> = arrayListOf()
    private lateinit var recyclerview : RecyclerView
    lateinit var adapter : PlatformAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview = findViewById(R.id.recyclerview)

        recyclerview.apply {
            layoutManager = LinearLayoutManager(applicationContext)
        }

        list.add(Platform(1, Android("Noughat","7.0", R.drawable.whatsapp)))
        list.add(Platform(1, Android("Oreo","8.0", R.drawable.facebook)))
        list.add(Platform(1, Android("Noughat","7.0", R.drawable.twitter)))

        list.add(Platform(2, IOS("IOS","12.0", R.drawable.instagram)))
        list.add(Platform(2, IOS("IOS","13.0", R.drawable.facebook)))

        list.add(Platform(3, Windows("Windows","10.0")))
        list.add(Platform(3, Windows("Windows","7.0")))

        recyclerview.adapter = PlatformAdapter(list)
    }
}