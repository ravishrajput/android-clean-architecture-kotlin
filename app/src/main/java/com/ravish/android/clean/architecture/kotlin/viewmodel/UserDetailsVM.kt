package com.ravish.android.clean.architecture.kotlin.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ravish.android.clean.architecture.domain.usecases.UserInfoRepoUseCase
import com.ravish.android.clean.architecture.kotlin.mappers.toUser
import com.ravish.android.clean.architecture.kotlin.models.User
import com.ravish.coroutines.networking.callCatching
import com.ravish.coroutines.networking.onFailure
import com.ravish.coroutines.networking.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailsVM @Inject constructor(
    private val userInfoRepoUseCase: UserInfoRepoUseCase
) : ViewModel() {

    private val _userListData = MutableLiveData<List<User>>()
    val userListData: LiveData<List<User>>
        get() = _userListData

    fun fetchAllUsers() {
        viewModelScope.launch {
            callCatching { userInfoRepoUseCase.getUsersList() }
                .onSuccess { response ->
                    _userListData.postValue(response.map {
                        it.toUser()
                    })
                }
                .onFailure {
                    Log.e("error", "fetchAllUsers: ${it.error?.message} : ${it.code}")
                }
        }
    }
}