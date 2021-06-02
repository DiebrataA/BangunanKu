package com.anggarad.dev.bangunganku.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anggarad.dev.bangunganku.data.network.Resource
import com.anggarad.dev.bangunganku.data.network.UserApi
import com.anggarad.dev.bangunganku.data.repository.UserRepository
import com.anggarad.dev.bangunganku.data.source.remote.response.UserResponse
import com.anggarad.dev.bangunganku.databinding.FragmentProfileBinding
import com.anggarad.dev.bangunganku.ui.base.BaseFragment
import com.anggarad.dev.bangunganku.ui.visible
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding, UserRepository>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBar.visible(false)

        viewModel.getUser()

        viewModel.user.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Success -> {
                    binding.progressBar.visible(false)
                    updateUI(it.value)
                }
                is Resource.Loading -> {
                    binding.progressBar.visible(true)
                }
            }
        })
    }

    private fun updateUI(user: UserResponse) {
        with(binding) {
            tvUsersName.text = user.fullname
            tvCity.text = user.city
        }
    }

    //    private lateinit var profileViewModel: ProfileViewModel
    override fun getViewModel(): Class<ProfileViewModel> {
        return ProfileViewModel::class.java
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater, container, false)
    }

    override fun getFragmentRepos(): UserRepository {

        val token = runBlocking { userPref.accessToken.first() }
        val api = remoteDataSource.getApiService(UserApi::class.java, token)
        return UserRepository(api)
    }
}