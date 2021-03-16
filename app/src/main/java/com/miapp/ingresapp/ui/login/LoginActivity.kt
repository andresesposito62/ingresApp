package com.miapp.ingresapp.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.miapp.ingresapp.databinding.ActivityLoginBinding
import com.miapp.ingresapp.ui.home.ActionSelectorActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel  : LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        //Se crea el observer
        val listObserver = Observer<Boolean>{
            //Lo que este aca se ejecuta cada vez que hay un cambio en nuestro objeto livedata
            //lo que se va arecibir es una UserList

            if(it){
                val intent = Intent(this, ActionSelectorActivity::class.java)
                startActivity(intent)
            }

        }

        //Se suscribe el observador al obrvable
        viewModel.setHomeView.observe(this@LoginActivity, listObserver)

    }
}