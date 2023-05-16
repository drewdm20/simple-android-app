package com.example.retrofitapplication

import retrofit2.Response
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("/api/authaccount/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>
    @POST("/api/authaccount/registration")
    suspend fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterResponse>
    companion object {
        fun getApi(): UserApi? {
            return ApiClient.client?.create(UserApi::class.java)}
    }
}