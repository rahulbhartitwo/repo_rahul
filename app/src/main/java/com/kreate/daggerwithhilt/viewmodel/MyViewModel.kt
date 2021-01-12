package com.kreate.daggerwithhilt.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kreate.daggerwithhilt.api.AuthRepository
import com.kreate.daggerwithhilt.api.Resource
import com.kreate.daggerwithhilt.entity.request.RequestEntity
import com.kreate.daggerwithhilt.entity.response.ResponseEntity

class MyViewModel @ViewModelInject constructor(var authRepository: AuthRepository) : ViewModel() {
    fun getLogin(entity: RequestEntity?): MutableLiveData<Resource<ResponseEntity?>> {
        return authRepository.getLogin(entity)
    }
}