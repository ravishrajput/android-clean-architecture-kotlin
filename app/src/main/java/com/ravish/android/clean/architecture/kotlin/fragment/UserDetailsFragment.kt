package com.ravish.android.clean.architecture.kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ravish.android.clean.architecture.kotlin.databinding.FragmentUserDetailsBinding
import com.ravish.android.clean.architecture.kotlin.models.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailsFragment : Fragment() {

    private var user: User? = null
    private lateinit var binding: FragmentUserDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            user = UserDetailsFragmentArgs.fromBundle(it).userDetails
        }

        updateUI()
    }

    private fun updateUI() {
        with(binding) {
            user?.let {
                detailTextName.text = it.name
                detailTextEmail.text = it.email
            }
        }
    }
}