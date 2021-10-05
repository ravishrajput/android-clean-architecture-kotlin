package com.ravish.android.clean.architecture.kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ravish.android.clean.architecture.kotlin.adapter.UserListAdapter
import com.ravish.android.clean.architecture.kotlin.databinding.FragmentUsersListBinding
import com.ravish.android.clean.architecture.kotlin.delegates.viewBinding
import com.ravish.android.clean.architecture.kotlin.viewmodel.UserDetailsVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersListFragment : Fragment() {

    private lateinit var binding: FragmentUsersListBinding
    private val userDetailsVM: UserDetailsVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeListData()
        userDetailsVM.fetchAllUsers()
    }

    private fun observeListData() {
        userDetailsVM.userListData.observe(viewLifecycleOwner, {
            binding.rvUsersList.adapter = UserListAdapter().apply {
                submitList(it)
            }
        })
    }
}