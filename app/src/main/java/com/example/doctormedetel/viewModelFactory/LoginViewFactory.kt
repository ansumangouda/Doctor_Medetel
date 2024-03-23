package com.example.doctormedetel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.doctormedetel.repository.LoginRepository
import com.example.doctormedetel.viewModel.UserViewModel

class LoginViewFactory(private val repository: LoginRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel ::class.java)){
            @Suppress("Unchecked_Cast")
            return UserViewModel(repository)as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}