package com.app.androidev.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.app.androidev.databinding.ActivityMainBinding

import com.app.androidev.ui.adapter.RandomAdapter
import com.app.androidev.ui.mvvm.RandomViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<RandomViewModel>()
    private lateinit var adapter : RandomAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RandomAdapter(mutableListOf())
        binding.sectionList.adapter = adapter

        for (i in 0 until 20) {
            viewModel.itemRandoms()
        }

        viewModel.listLive.observe(this) {
            it.getContentIfNotHandled()?.let { list ->
                adapter.addItems(list)
            }
        }

        binding.rotateView.setIsXRotationAllowed(true)
        binding.rotateView.setIsYRotationAllowed(true)
        binding.rotateView.setAnimationDuration(1000)
    }
}