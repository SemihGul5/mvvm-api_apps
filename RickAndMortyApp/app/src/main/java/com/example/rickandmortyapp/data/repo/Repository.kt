package com.example.rickandmortyapp.data.repo

import android.content.Context
import com.example.rickandmortyapp.data.datasource.DataSource
import com.example.rickandmortyapp.data.model.Character

class Repository(var ds:DataSource) {
    suspend fun karakterleriYukle() : List<Character> =ds.karakterleriYukle()

     fun isNetworkAvailable(context: Context): Boolean=ds.isNetworkAvailable(context)
}