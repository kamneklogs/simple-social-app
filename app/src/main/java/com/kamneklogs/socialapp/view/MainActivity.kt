package com.kamneklogs.socialapp.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kamneklogs.socialapp.context.Prefs
import com.kamneklogs.socialapp.databinding.ActivityMainBinding
import com.kamneklogs.socialapp.model.User
import com.kamneklogs.socialapp.service.UserService

class MainActivity : AppCompatActivity() {
    private val sharedPreference: Prefs by lazy {
        Prefs(applicationContext)
    }

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var currentUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        UserService.saveUser(User("logs", "123", "Camilo Cordoba", 12))
        UserService.saveUser(User("logs2", "123", "Andres Cordoba", 12))

        verifyLoggedUser()
    }

    private fun verifyLoggedUser() {
        sharedPreference.usernameLogged?.let {
            if (it != "") {
                currentUser = UserService.findUserByUsername(it)!!
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
    }
}