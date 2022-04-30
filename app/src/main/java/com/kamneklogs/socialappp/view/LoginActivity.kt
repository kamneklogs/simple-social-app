package com.kamneklogs.socialappp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kamneklogs.socialappp.databinding.ActivityLoginBinding
import com.kamneklogs.socialappp.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}