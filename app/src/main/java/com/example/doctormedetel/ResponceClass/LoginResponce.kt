package com.example.doctormedetel.ResponceClass

data class LoginResponce(
    val Id: String,
    val access_token: String,
    val emailConfirmed: Boolean,
    val emailId: String,
    val expires_in: Int,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val phoneNumberConfirmed: Boolean,
    val refresh_token: String,
    val roleId: String,
    val roleName: String,
    val scope: String,
    val token_type: String,
    val userId: Int,
    val userName: String
)
