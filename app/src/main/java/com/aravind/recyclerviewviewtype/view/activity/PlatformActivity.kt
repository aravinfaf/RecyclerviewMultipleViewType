package com.aravind.recyclerviewviewtype.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aravind.recyclerviewviewtype.R
import com.aravind.recyclerviewviewtype.databinding.ActivityMainBinding
import com.aravind.recyclerviewviewtype.model.Android
import com.aravind.recyclerviewviewtype.model.IOS
import com.aravind.recyclerviewviewtype.model.Platform
import com.aravind.recyclerviewviewtype.model.Windows
import com.aravind.recyclerviewviewtype.view.adapter.PlatformAdapter
import com.aravind.recyclerviewviewtype.viewmodel.PlatformViewmodel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class PlatformActivity : AppCompatActivity(), PlatformAdapter.RecyclerviewClickListener {

    lateinit var binding : ActivityMainBinding
    private  val viewModel : PlatformViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(applicationContext)
        }
        viewModel.getPlatform()
        viewModel.listValue.observeForever{
            binding.recyclerview.adapter = PlatformAdapter(it,this)
        }
    }

    override fun clickedPosition(value: String) {
        Toast.makeText(applicationContext,value,Toast.LENGTH_LONG).show()
    }
}