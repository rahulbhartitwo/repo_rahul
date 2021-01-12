package com.kreate.daggerwithhilt.api

import androidx.lifecycle.ViewModel
import com.kreate.daggerwithhilt.viewmodel.ViewModelFactory
import javax.inject.Inject

class InjectorUtils @Inject internal constructor() {
    @JvmField
    @Inject
    var viewModelFactory: ViewModelFactory? = null
    fun <T : ViewModel?> providerViewModelFactory(): ViewModel {
        return viewModelFactory!!.create(ViewModel::class.java)
    }
}