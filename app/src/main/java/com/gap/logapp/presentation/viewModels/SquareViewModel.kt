package com.gap.logapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import com.gap.logapp.data.RepositoryImpl
import com.gap.logapp.domain.usecases.SquareValue

class SquareViewModel : ViewModel() {
    private val repository = RepositoryImpl()
    private val squareValueUseCase = SquareValue(repository)

    fun squareValue(value: Int): String {
        return squareValueUseCase(value)
    }
}