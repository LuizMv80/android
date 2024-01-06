package com.example.weatherapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.InitClass
import com.example.weatherapp.databinding.ActivityLoginBinding
import com.example.weatherapp.ui.dashboard.HomeActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel = VMLogin()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkSession()
        checkRemember()
        binding.buttonLogin.setOnClickListener { login() }
    }

    private fun login(){

        if(viewModel.validateCredentials(
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString(),
                binding.checkbok.isChecked
            )) {
            goToHome()
        } else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkSession(){
        if(InitClass.prefs.getLogin()) goToHome()
    }

    private fun checkRemember(){
        if(InitClass.prefs.getRemember()){
            binding.etEmail.setText(InitClass.prefs.getEmail())
            binding.etPassword.setText(InitClass.prefs.getPassword())
            binding.checkbok.isChecked = true
        }
    }

    private fun goToHome(){
        var intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

}