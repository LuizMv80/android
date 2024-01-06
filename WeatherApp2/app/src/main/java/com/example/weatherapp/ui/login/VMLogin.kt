package com.example.weatherapp.ui.login

import com.example.weatherapp.InitClass

class VMLogin() {

    fun validateCredentials(user: String, pass: String, rememberSession: Boolean): Boolean {
        var success = user == "luis@hotmail.com" && pass == "ecore"

        if(success){
            saveUserData(user, pass, rememberSession)
        }
        return success
    }

    fun saveUserData(user: String, pass: String, rememberSession: Boolean){
        InitClass.prefs.saveLogin(true)
        InitClass.prefs.saveEmail(user)
        if(rememberSession){
            InitClass.prefs.savePassword(pass)
            InitClass.prefs.saveRemember(true)
        }
    }

}