package com.example.doctormedetel.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.doctormedetel.ResponceClass.LoginResponce
import com.example.doctormedetel.RetrofitNetwork.Retroit

class UserViewModel : ViewModel() {
    private  val  userRepository = Retroit()
    private val loginData = MutableLiveData<List<LongProgression>>()
    val users: MutableLiveData<List<LongProgression>> get() = loginData
    fun fetchUser(){

    }
}