package com.aravind.recyclerviewviewtype.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aravind.recyclerviewviewtype.R
import com.aravind.recyclerviewviewtype.model.Android
import com.aravind.recyclerviewviewtype.model.IOS
import com.aravind.recyclerviewviewtype.model.Platform
import com.aravind.recyclerviewviewtype.model.Windows

class PlatformAdapter(private val list : List<Platform>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
        const val VIEW_TYPE_THREE = 3
    }

    inner class AndroidViewHolder(private val view : View) : RecyclerView.ViewHolder(view){
        private val image : ImageView = view.findViewById(R.id.androidImage)
        private val title : TextView = view.findViewById(R.id.androidTitle)
        private val version : TextView = view.findViewById(R.id.androidVersion)

        fun setAndroidData(androidPlatform : Android){
            image.setImageResource(androidPlatform.image)
            title.text = androidPlatform.os
            version.text = androidPlatform.version
        }
    }

    inner class IOSViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        private val image : ImageView = view.findViewById(R.id.iosImage)
        private val title : TextView = view.findViewById(R.id.iosTitle)
        private val version : TextView = view.findViewById(R.id.iosVersion)

        fun setIOSData(iosPlatform : IOS){
            image.setImageResource(iosPlatform.image)
            title.text = iosPlatform.os
            version.text = iosPlatform.version
        }
    }
    inner class WindowsViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        private val title : TextView = view.findViewById(R.id.windowsTitle)
        private val version : TextView = view.findViewById(R.id.windowsVersion)

        fun setWindowsData(windowsPlatform : Windows){
            title.text = windowsPlatform.os
            version.text = windowsPlatform.version
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when(viewType){
            VIEW_TYPE_ONE ->  AndroidViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_android,parent,false)
            )
            VIEW_TYPE_TWO ->  IOSViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_ios,parent,false)
            )
            else ->  WindowsViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_windows,parent,false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (list[position].type == VIEW_TYPE_ONE){
                val androidData = list[position].obj as Android
            (holder as AndroidViewHolder).setAndroidData(androidData)
        }else if (list[position].type == VIEW_TYPE_TWO){
            val iosData : IOS = list[position].obj as IOS
            (holder as IOSViewHolder).setIOSData(iosData)
        }
//        else{
//            val windowsData : Windows = list[position].obj as Windows
//            (holder as WindowsViewHolder).setWindowsData(windowsData)
//        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }
}