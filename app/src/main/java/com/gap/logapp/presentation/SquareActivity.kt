package com.gap.logapp.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.gap.logapp.databinding.ActivitySquareBinding
import com.gap.logapp.presentation.viewModels.SquareViewModel

class SquareActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySquareBinding
    private var receivedValue: Int = 0

    private val viewModel by lazy {
        ViewModelProvider(this)[SquareViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        binding = ActivitySquareBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntValue()

        if (savedInstanceState == null) {
            workWithUI(receivedValue)
        } else {
            workWithUI(savedInstanceState.getInt(BundleTag))
        }
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

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(BundleTag, receivedValue)
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
    }

    private fun getIntValue() {
        receivedValue = intent.getIntExtra(ExtraIntTag, 0)
    }

    private fun workWithUI(value: Int) {
        binding.tvSquareMain.text = viewModel.squareValue(value)
    }

    companion object {
        private const val ExtraIntTag = "myIntValue"
        private const val BundleTag = "myRestoreValue"
        private const val TAG = "SquareActivityWorking"

        fun getSquareIntent(context: Context, intValue: Int): Intent {
            return Intent(context, SquareActivity::class.java).apply {
                putExtra(ExtraIntTag, intValue)
            }
        }
    }
}
