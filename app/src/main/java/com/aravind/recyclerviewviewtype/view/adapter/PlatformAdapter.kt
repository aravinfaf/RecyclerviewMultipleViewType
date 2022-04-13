package com.aravind.recyclerviewviewtype.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aravind.recyclerviewviewtype.databinding.ItemAndroidBinding
import com.aravind.recyclerviewviewtype.databinding.ItemIosBinding
import com.aravind.recyclerviewviewtype.databinding.ItemWindowsBinding
import com.aravind.recyclerviewviewtype.model.Android
import com.aravind.recyclerviewviewtype.model.IOS
import com.aravind.recyclerviewviewtype.model.Platform
import com.aravind.recyclerviewviewtype.model.Windows

class PlatformAdapter(private val list : List<Platform>, val listener : RecyclerviewClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    inner class AndroidViewHolder(private val binding : ItemAndroidBinding) : RecyclerView.ViewHolder(binding.root){
        fun setAndroidData(androidPlatform : Android){
            binding.androidImage.setImageResource(androidPlatform.image)
            binding.androidTitle.text = androidPlatform.os
            binding.androidVersion.text = androidPlatform.version

            binding.androidTitle.setOnClickListener {
                listener.clickedPosition(androidPlatform.version)
            }
        }
    }

    inner class IOSViewHolder(private val binding : ItemIosBinding) : RecyclerView.ViewHolder(binding.root){

        fun setIOSData(iosPlatform : IOS){
            binding.iosImage.setImageResource(iosPlatform.image)
            binding.iosTitle.text = iosPlatform.os
            binding.iosVersion.text = iosPlatform.version
        }
    }
    inner class WindowsViewHolder(private val binding: ItemWindowsBinding) : RecyclerView.ViewHolder(binding.root){
         fun setWindowsData(windowsPlatform : Windows){
             binding.windowsTitle.text = windowsPlatform.os
             binding.windowsVersion.text = windowsPlatform.version
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            VIEW_TYPE_ONE ->
                AndroidViewHolder(ItemAndroidBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            VIEW_TYPE_TWO ->
                IOSViewHolder(ItemIosBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            else ->  WindowsViewHolder(ItemWindowsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(list[position].type){
            VIEW_TYPE_ONE -> (holder as AndroidViewHolder).setAndroidData(list[position].obj as Android)
            VIEW_TYPE_TWO -> (holder as IOSViewHolder).setIOSData(list[position].obj as IOS)
            else -> (holder as WindowsViewHolder).setWindowsData(list[position].obj as Windows)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    interface RecyclerviewClickListener{
        fun clickedPosition(value : String)
    }
}