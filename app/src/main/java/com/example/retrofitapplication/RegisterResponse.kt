package com.example.retrofitapplication

import com.google.gson.annotations.SerializedName

data class RegisterResponse (
    @SerializedName("code")
    var code: Int,
    @SerializedName("data")
    var `data`: LoginResponse.Data,
    @SerializedName("id")
    var id: String,
    @SerializedName("message")
    var message: String
    ) {
    data class Data (
        @SerializedName("Email")
        var email: String,
        @SerializedName("id")
        var id: String,
        @SerializedName("Id")
        var id2: Int,
        @SerializedName("Name")
        var name: String,
        @SerializedName("Token")
        var token: String
            )
}