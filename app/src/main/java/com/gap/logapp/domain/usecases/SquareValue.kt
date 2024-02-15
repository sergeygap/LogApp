package com.gap.logapp.domain.usecases

import com.gap.logapp.domain.CoreRepository

class SquareValue(
    private val repository: CoreRepository
) {
     operator fun invoke(value: Int): String {
        return repository.squareNumber(value)
    }
}