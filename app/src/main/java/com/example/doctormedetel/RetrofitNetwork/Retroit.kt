package com.example.doctormedetel.RetrofitNetwork

import com.example.doctormedetel.ApiService.ApiService
import com.example.doctormedetel.ResponceClass.LoginResponce

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class Retroit {
    val retroit = Retrofit.Builder()
                 .baseUrl("https://telemedicinepvtapi.esdinfra.com")
                 .addConverterFactory(GsonConverterFactory.create())
                 .build()

    val apiService = retroit.create(ApiService::class.java)

}

