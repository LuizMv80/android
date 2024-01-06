package com.example.weatherapp.providers

import android.content.Context

class Prefs (val context: Context) {
    val LOGIN = "login"
    val EMAIL = "email"
    val DB_NAME = "MyDb"
    val PASSWORD = "password"
    val REMEMBER = "remember"
    val prefs = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE)

    fun saveEmail(email: String) = prefs.edit().putString(EMAIL, email).apply()

    fun getEmail() : String = prefs.getString(EMAIL, "")!!

    fun saveLogin(login: Boolean) = prefs.edit().putBoolean(LOGIN, login).apply()

    fun getLogin() : Boolean = prefs.getBoolean(LOGIN, false)

    fun deleteLogin() = prefs.edit().remove(LOGIN).apply()

    fun savePassword(password: String) = prefs.edit().putString(PASSWORD, password).apply()

    fun getPassword() : String = prefs.getString(PASSWORD,"")!!

    fun saveRemember(remember: Boolean) = prefs.edit().putBoolean(REMEMBER, remember).apply()

    fun getRemember() : Boolean = prefs.getBoolean(REMEMBER, false)

}