package com.kreate.daggerwithhilt.api

import com.kreate.daggerwithhilt.entity.LoginEntity
import com.kreate.daggerwithhilt.entity.request.RequestEntity
import com.kreate.daggerwithhilt.entity.response.ResponseEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiCall {
//    @FormUrlEncoded   remove whenever used body
    @POST()
    suspend fun getFetchData(@Body requestEntity: RequestEntity): ResponseEntity

    @FormUrlEncoded
    @POST("api/LineInformation/GetVulnerableLocation")
    suspend fun getLogin(): ResponseEntity

    @GET("todos/1")
    suspend fun getData(): LoginEntity
}