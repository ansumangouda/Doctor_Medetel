package com.example.doctormedetel.ApiService

import com.example.doctormedetel.ResponceClass.LoginResponce
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("connect/token")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("client_id") client_id: String,
        @Field("grant_type") grant_type: String,
        @Field("client_secret") client_secret: String,
        @Field("role") role: String
    ): Call<LoginResponce>
}