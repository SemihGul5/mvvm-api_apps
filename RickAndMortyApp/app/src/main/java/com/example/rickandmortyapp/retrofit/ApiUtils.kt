package com.example.rickandmortyapp.retrofit

import com.example.rickandmortyapp.data.model.Character

class ApiUtils {
    companion object{
        val BASE_URL="https://rickandmortyapi.com/api/"

        fun getCharacterDao(): CharacterDao{
            return RetrofitClient.getClient(BASE_URL).create(CharacterDao::class.java)
        }
    }
}