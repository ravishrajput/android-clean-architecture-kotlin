package com.ravish.android.clean.architecture.kotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ravish.android.clean.architecture.domain.usecases.UserInfoRepoUseCase
import com.ravish.android.clean.architecture.kotlin.mappers.UserMapper
import com.ravish.android.clean.architecture.kotlin.models.User
import kotlinx.coroutines.launch

class UserDetailsVM constructor(private val userInfoRepoUseCase: UserInfoRepoUseCase) :
    ViewModel() {

    private val _userListData = MutableLiveData<List<User>>()
    val userListData: LiveData<List<User>>
        get() = _userListData

    fun fetchAllUsers() {
        viewModelScope.launch {
            val result = userInfoRepoUseCase.getUsersList()
            _userListData.postValue(result.map { UserMapper().toUserDetails(it) })
        }
    }
}