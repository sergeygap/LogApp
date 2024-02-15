package com.gap.logapp.data

import com.gap.logapp.domain.CoreRepository
import com.gap.logapp.domain.entities.Core

class RepositoryImpl: CoreRepository {
    override suspend fun increaseValue(core: Core) : Core {
        return Core(core.value.plus(1))
    }

    override suspend fun squareNumber(core: Core) {
        TODO("Not yet implemented")
    }

}