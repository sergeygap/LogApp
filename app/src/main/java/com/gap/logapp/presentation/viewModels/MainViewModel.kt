package com.gap.logapp.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gap.logapp.data.RepositoryImpl
import com.gap.logapp.domain.entities.Core
import com.gap.logapp.domain.usecases.IncreaseValue
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val repository = RepositoryImpl()
    private val increaseValue = IncreaseValue(repository)
    private var value = Core()
    private val _valueLD = MutableLiveData<Core>()
    val valueLD: LiveData<Core>
        get() = _valueLD

    fun increaseValue() {
        viewModelScope.launch {
            value = increaseValue(value)
            _valueLD.postValue(value)
        }
    }

}