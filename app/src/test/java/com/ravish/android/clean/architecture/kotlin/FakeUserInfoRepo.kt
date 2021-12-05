package com.ravish.android.clean.architecture.kotlin

import com.ravish.android.clean.architecture.domain.models.UserDetails
import com.ravish.android.clean.architecture.domain.repositories.UserInfoRepo

class FakeUserInfoRepo: UserInfoRepo {
    override suspend fun getUsersList(): List<UserDetails> {
        return listOf(
            UserDetails(21,"Ravish","ttgsdh","fdfsd","vfdvdf")
        )
    }

    override suspend fun getUserInfo(id: String): UserDetails {
        TODO("Not yet implemented")
    }

}