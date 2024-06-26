package com.example.doctormedetel.repository

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctormedetel.ApiService.ApiService
import com.example.doctormedetel.LoginActivity
import com.example.doctormedetel.ResponceClass.LoginResponce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository(private val apiService: ApiService, private val loginActivity: LoginActivity) {

    val loginData = MutableLiveData<LoginResponce>()

    val user : LiveData<LoginResponce>get() = loginData


    fun getUserDetails(
        user: String,
        password: String,
        clientId: String,
        grantType: String,
        clientSecret: String,
        role: String
    ) {
        val call = apiService.login(user,password,clientId,grantType,clientSecret,role)
        call.enqueue(object :Callback<LoginResponce>{
            override fun onResponse(call: Call<LoginResponce>, response: Response<LoginResponce>) {
                if (response.isSuccessful){
                    loginData.value = response.body()
                   Toast.makeText(loginActivity,"oooook",Toast.LENGTH_SHORT).show()
                } else {
                    val errorBody = response.errorBody()?.string()
                    println("Res code: ${response.code()} with error body : $errorBody")
                   // println("Res code: ${response.code()} with error body : ${response.errorBody().toString()}")
                }
            }

            override fun onFailure(call: Call<LoginResponce>, t: Throwable) {
                Toast.makeText(loginActivity,"Nooooo",Toast.LENGTH_SHORT).show()
                println("exemption ${t.message}")

            }

        })
    }


}