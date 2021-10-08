package com.ravish.android.clean.architecture.data.apis

import com.ravish.android.clean.architecture.data.models.UserDataModel
import com.ravish.android.clean.architecture.data.models.UsersData
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("/v1/user")
    suspend fun getUsersList(): UsersData

    @GET("/v1/user/{id}")
    suspend fun getUserInfo(@Path("id") id: String): UserDataModel
}