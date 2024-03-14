package com.example.doctormedetel.ApiService

import com.example.doctormedetel.ResponceClass.LoginResponce
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("connect/token")
    fun login(): Call<LoginResponce>
}