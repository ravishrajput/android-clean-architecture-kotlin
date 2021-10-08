package com.ravish.android.clean.architecture.data.repo

import com.ravish.android.clean.architecture.data.apis.UserApi
import com.ravish.android.clean.architecture.data.mappers.UserMapper
import com.ravish.android.clean.architecture.domain.models.UserDetails
import com.ravish.android.clean.architecture.domain.repositories.UserInfoRepo
import javax.inject.Inject

class UserInfoRepoImpl @Inject constructor(
    private val userApi: UserApi,
    private val userMapper: UserMapper
) : UserInfoRepo {
    override suspend fun getUsersList(): List<UserDetails> = userApi.getUsersList().users.map {
        userMapper.toUserDetails(it)
    }

    override suspend fun getUserInfo(id: String): UserDetails =
        userMapper.toUserDetails(userApi.getUserInfo(id))
}