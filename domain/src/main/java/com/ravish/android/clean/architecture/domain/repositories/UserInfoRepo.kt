package com.ravish.android.clean.architecture.domain.repositories

import com.ravish.android.clean.architecture.domain.models.UserDetails

interface UserInfoRepo {
    suspend fun getUsersList(): List<UserDetails>
    suspend fun getUserInfo(id: String): UserDetails
}