package com.example.retrofitapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RegistrationViewModel(application: Application): AndroidViewModel(application) {
    val userRepo = UserRepository()
    val registrationResult: MutableLiveData<BaseResponse<RegisterResponse>> = MutableLiveData()

    fun registerUser(name:String, email:String, password:String){
        registrationResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val registerRequest = RegisterRequest(
                    name = name,
                    email = email,
                    password = password
                )
                val response = userRepo.registerUser(registerRequest = registerRequest)
                if (response?.code() == 200) {
                    registrationResult.value = BaseResponse.Success(response.body())
                } else {
                    registrationResult.value = BaseResponse.Error(response?.message())
                }
            } catch (ex: Exception) {
                registrationResult.value = BaseResponse.Error(ex.message)
            }
        }
    }
}