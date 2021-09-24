package com.ravish.android.clean.architecture.data.apis

import com.ravish.android.clean.architecture.data.models.UserDataModel
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("/v1/user")
    suspend fun getUsersList(): List<UserDataModel>

    @GET("/v1/user/{id}")
    suspend fun getUserInfo(@Path("id") id: String): UserDataModel
}