package com.kreate.daggerwithhilt.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.kreate.daggerwithhilt.api.AuthRepository
import com.kreate.daggerwithhilt.api.Resource
import com.kreate.daggerwithhilt.entity.request.RequestEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyViewModel  @ViewModelInject constructor(var authRepository: AuthRepository) : ViewModel() {

    fun getFetchData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = authRepository.getFetchData()))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred!"))
        }
    }
}