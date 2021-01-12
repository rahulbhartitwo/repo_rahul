package com.kreate.daggerwithhilt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kreate.daggerwithhilt.api.AuthRepository
import javax.inject.Inject

class ViewModelFactory @Inject internal constructor() : ViewModelProvider.Factory {

    @JvmField
    @Inject
    var authRepository: AuthRepository? = null
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MyViewModel::class.java) -> return MyViewModel(authRepository!!) as T
            else -> return MyViewModel(authRepository!!) as T
        }
    }
}