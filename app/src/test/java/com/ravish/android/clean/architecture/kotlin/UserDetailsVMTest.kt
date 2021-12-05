package com.ravish.android.clean.architecture.kotlin

import android.os.Build
import android.os.Looper
import com.ravish.android.clean.architecture.domain.models.UserDetails
import com.ravish.android.clean.architecture.domain.repositories.UserInfoRepo
import com.ravish.android.clean.architecture.domain.usecases.UserInfoRepoUseCase
import com.ravish.android.clean.architecture.kotlin.viewmodel.UserDetailsVM
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@LooperMode(LooperMode.Mode.PAUSED)
@Config(manifest = Config.NONE, sdk = [Build.VERSION_CODES.N])
class UserDetailsVMTest {

    private lateinit var userDetailsVM: UserDetailsVM
    private lateinit var userInfoRepoUseCaseMock: UserInfoRepoUseCase
    private lateinit var fakeUserInfoRepo: UserInfoRepo

    @Before
    fun setup() {
        fakeUserInfoRepo = FakeUserInfoRepo()
        userInfoRepoUseCaseMock = UserInfoRepoUseCase(fakeUserInfoRepo)
        userDetailsVM = UserDetailsVM(userInfoRepoUseCaseMock)
    }

    @Test
    fun `test fetchAllUsers`() = runBlockingTest {
        userDetailsVM.fetchAllUsers()
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        val value = userDetailsVM.userListData.value
        assertNotNull(value)
    }
}