package com.example.doctormedetel.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.doctormedetel.ResponceClass.LoginResponce
import com.example.doctormedetel.repository.LoginRepository


class UserViewModel(private val repository: LoginRepository) : ViewModel() {
    val loginResponse: LiveData<LoginResponce> = repository.user
    fun accessRepo(
        user: String, password: String, clientId: String, grantType: String, clientSecret: String, role: String) {
        repository.getUserDetails(user,password,clientId,grantType,clientSecret,role)
    }
}