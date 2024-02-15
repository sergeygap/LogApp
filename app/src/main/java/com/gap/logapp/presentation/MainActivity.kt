package com.gap.logapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.gap.logapp.databinding.ActivityMainBinding
import com.gap.logapp.presentation.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.increaseValue()
        workWithLiveData()
    }

    private fun workWithLiveData() {
        viewModel.valueLD.observe(this) {
            binding.tvMain.text = it.value.toString()
        }
    }

    companion object {
        private const val TAG = "MainActivityWorking"
    }
}