package com.kreate.daggerwithhilt.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kreate.daggerwithhilt.entity.request.RequestEntity
import com.kreate.daggerwithhilt.entity.response.ResponseEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor() {

    @JvmField
    @Inject
    var apiCall: ApiCall? = null

    suspend fun getFetchData() =  apiCall!!.getData()

}