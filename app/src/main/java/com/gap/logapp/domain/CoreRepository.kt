package com.gap.logapp.domain

import com.gap.logapp.domain.entities.Core

interface CoreRepository {
    suspend fun increaseValue(core: Core): Core
     fun squareNumber(value: Int): String
}