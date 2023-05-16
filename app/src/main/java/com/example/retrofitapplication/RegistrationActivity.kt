package com.example.retrofitapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.retrofitapplication.databinding.ActivityMainBinding
import com.example.retrofitapplication.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private val viewModel by viewModels<RegistrationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)
        viewModel.registrationResult.observe(this) {
            when (it) {
                is BaseResponse.Loading -> {
                    showLoading()
                }

                is BaseResponse.Success -> {
                    stopLoading()
                    processLogin(it.data)
                }

                is BaseResponse.Error -> {
                    processError(it.msg)
                }

                else -> {
                    stopLoading()
                }
            }
        }
        binding.btnRegister2.setOnClickListener {
            doSignup()
        }
    }
    private fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(
            Intent.FLAG_ACTIVITY_CLEAR_TOP or
                Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        startActivity(intent)
    }
    fun doSignup() {
        val name = binding.txtInputName.text.toString()
        val email = binding.txtInputEmail2.text.toString()
        val pwd = binding.txtPass2.text.toString()
        viewModel.registerUser(name = name, email = email, password = pwd)
    }
    fun processLogin(data: RegisterResponse?) {
        showToast("Success:" + data?.message)
        navigateToHome()
    }
    fun showLoading() {
        binding.prgbar2.visibility = View.VISIBLE
    }
    fun stopLoading() {
        binding.prgbar2.visibility = View.GONE
    }
    fun processError(msg: String?) {
        showToast("Error:" + msg)
    }
    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}