package com.miapp.ingresapp.ui.readperson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.miapp.ingresapp.R
import com.miapp.ingresapp.databinding.ActivityLoginBinding
import com.miapp.ingresapp.databinding.ActivityReadBinding
import com.miapp.ingresapp.ui.login.LoginViewModel

class ReadActivity : AppCompatActivity() {

    private lateinit var viewModel : ReadViewModel
    private lateinit var binding : ActivityReadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}