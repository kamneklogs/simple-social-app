package com.kamneklogs.socialapp.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kamneklogs.socialapp.context.Prefs
import com.kamneklogs.socialapp.databinding.ActivityLoginBinding
import com.kamneklogs.socialapp.service.UserService

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private val sharedPreference: Prefs by lazy {
        Prefs(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.loginSignInBtn.setOnClickListener(::login)
    }

    private fun login(view: View) {
        val username = binding.loginEmailET.text.toString()
        val password = binding.loginPassET.text.toString()

        if (UserService.userExist(username)) {
            if (UserService.validatePassword(username, password)) {
                sharedPreference.usernameLogged = username
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                binding.msgError.text = "Contraseña incorrecta"
                binding.msgError.visibility = View.VISIBLE
            }
        } else {
            binding.msgError.text = "Usuario no encontrado"
            binding.msgError.visibility = View.VISIBLE
        }
    }
}