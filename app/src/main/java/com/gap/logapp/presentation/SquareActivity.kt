package com.gap.logapp.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
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
        binding = ActivitySquareBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntValue()
        if (savedInstanceState == null) {
            workWithUI(receivedValue)
        } else {
            workWithUI(savedInstanceState.getInt(BundleTag))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(BundleTag, receivedValue)
        super.onSaveInstanceState(outState)
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
        fun getSquareIntent(context: Context, intValue: Int): Intent {
            return Intent(context, SquareActivity::class.java).apply {
                putExtra(ExtraIntTag, intValue)
            }
        }
    }
}