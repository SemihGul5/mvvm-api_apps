package com.example.rickandmortyapp.retrofit

import com.example.rickandmortyapp.data.model.CharacterCevap
import retrofit2.http.GET

interface CharacterDao {
    @GET("character")
    suspend fun karakterYukle():CharacterCevap
}