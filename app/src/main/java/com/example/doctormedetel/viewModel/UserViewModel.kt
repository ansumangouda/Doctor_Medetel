package com.example.doctormedetel.viewModel


import androidx.lifecycle.ViewModel
import com.example.doctormedetel.repository.LoginRepository


class UserViewModel(private val repository: LoginRepository) : ViewModel() {
    fun accessRepo(){
        repository.getUserDetails()
    }
}