package com.example.retrofitapplication

import retrofit2.Response

class UserRepository {
    suspend fun loginUser(loginRequest:LoginRequest):
            Response<LoginResponse>? {
        return UserApi.getApi()?.loginUser(loginRequest =
        loginRequest)
    }
    suspend fun registerUser(registerRequest: RegisterRequest):
            Response<RegisterResponse>? {
        return UserApi.getApi()?.registerUser(registerRequest = registerRequest)
    }
}