package com.example.doctormedetel.RetrofitNetwork

import com.example.doctormedetel.ApiService.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retroit {
    private val httpClient = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpClient)
        .build();
    private val retroitClient = Retrofit.Builder()
                 .baseUrl("https://telmed.medetel.in/")
                 .addConverterFactory(GsonConverterFactory.create())
                 .client(okHttpClient)
                 .build()


    val apiService: ApiService = retroitClient.create(ApiService::class.java)

}

