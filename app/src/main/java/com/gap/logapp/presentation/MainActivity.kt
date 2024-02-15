package com.gap.logapp.presentation

import android.os.Bundle
import android.util.Log
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
        Log.d(TAG, "onCreate")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        workingWithViewModel()
        workingWithUI()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
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
