package com.gap.logapp.domain.usecases

import com.gap.logapp.domain.CoreRepository
import com.gap.logapp.domain.entities.Core

class IncreaseValue(
    private val repository: CoreRepository
) {
    suspend operator fun invoke(core: Core): Core {
       return repository.increaseValue(core)
    }
}