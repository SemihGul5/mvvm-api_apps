package com.example.gotapiapp.retrofit

import com.example.gotapiapp.data.model.Karakter
import retrofit2.http.GET

interface KarakterDao {//sadece get, post istekleri yazılır
    @GET("Characters")
    suspend fun karakterYukle(): List<Karakter>
}