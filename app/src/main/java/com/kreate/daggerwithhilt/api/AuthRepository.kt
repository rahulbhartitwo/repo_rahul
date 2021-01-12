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

    //     Login API, As consider
    fun getLogin(requestEntity: RequestEntity?): MutableLiveData<Resource<ResponseEntity?>> {
        val mutableLiveData = MutableLiveData<Resource<ResponseEntity?>>()
        mutableLiveData.value = Resource.loading(ResponseEntity())
        (apiCall!!.getFetchData(requestEntity) as Call<ResponseEntity?>).enqueue(object :
            Callback<ResponseEntity?> {
            override fun onResponse(
                call: Call<ResponseEntity?>,
                response: Response<ResponseEntity?>
            ) {
                try {
                    val entity = response.body()
                    when (response.code()) {
                        200 -> mutableLiveData.setValue(Resource.success(entity, entity!!.message))
                        201 -> mutableLiveData.setValue(Resource.success(entity, entity!!.message))
                        else -> mutableLiveData.setValue(
                            Resource.error(
                                response.toString(),
                                ResponseEntity()
                            )
                        )
                    }
                } catch (e: Exception) {
                    mutableLiveData.setValue(Resource.error(e.message, ResponseEntity()))
                }
            }

            override fun onFailure(call: Call<ResponseEntity?>, t: Throwable) {
                mutableLiveData.value = Resource.error(t.toString(), ResponseEntity())
            }
        })
        return mutableLiveData
    }
}