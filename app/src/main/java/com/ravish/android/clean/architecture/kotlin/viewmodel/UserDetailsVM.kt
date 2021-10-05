package com.ravish.android.clean.architecture.kotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ravish.android.clean.architecture.domain.models.UserDetails
import com.ravish.android.clean.architecture.domain.usecases.UserInfoRepoUseCase
import com.ravish.android.clean.architecture.kotlin.mappers.UserMapper
import com.ravish.android.clean.architecture.kotlin.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailsVM @Inject constructor(
    private val userInfoRepoUseCase: UserInfoRepoUseCase,
    private val userMapper: UserMapper
) :
    ViewModel() {

    private val _userListData = MutableLiveData<List<User>>()
    val userListData: LiveData<List<User>>
        get() = _userListData

    fun fetchAllUsers() {
        viewModelScope.launch {
            val result = userInfoRepoUseCase.getUsersList()
            _userListData.postValue(result.map {
                it.toUser()
            })
        }
    }

    fun UserDetails.toUser() = User(id, name, username, email, imageUrl)
}