package com.example.doctormedetel.shared_preferences

import android.content.Context

class SharedPreferences(context : Context) {
    private val sharedPreferences = context.getSharedPreferences(PREFS_NAME ,Context.MODE_PRIVATE)
    companion object{
        private const val PREFS_NAME = "MyAppPrefs"
        private const val ACCESS_TOKEN = "accessToken"
        private const val EMAIL = "email"
        private const val NAME =  "name"
    }

    fun saveAccessToken(token:String){
        sharedPreferences.edit().putString(ACCESS_TOKEN , token).apply()
    }
    fun getAccessToken():String?{
        return sharedPreferences.getString(ACCESS_TOKEN , null)

    }
    fun saveEmail(email : String){
        sharedPreferences.edit().putString(EMAIL,email).apply()

    }
    fun getEmail():String?{
        return sharedPreferences.getString(EMAIL , null)
    }

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }



}