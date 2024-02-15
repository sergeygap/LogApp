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
        workingWithViewModel()
        workingWithUI()
    }


    private fun workingWithViewModel() {
        viewModel.increaseValue()
        viewModel.valueLD.observe(this) { value ->
            binding.tvMain.text = value.value.toString()
        }
    }

    private fun workingWithUI() {
        binding.btnToSquare.setOnClickListener {
            startActivity(SquareActivity.getSquareIntent(this@MainActivity, viewModel.getValue()))
        }
    }


    companion object {
        private const val TAG = "MainActivityWorking"
    }
}
