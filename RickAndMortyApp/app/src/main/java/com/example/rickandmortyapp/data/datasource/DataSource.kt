package com.example.rickandmortyapp.data.datasource

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.retrofit.CharacterDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DataSource(var characterDao: CharacterDao) {

    suspend fun karakterleriYukle() : List<Character> =
        withContext(Dispatchers.IO){
            return@withContext characterDao.karakterYukle().results
        }



     fun isNetworkAvailable(context: Context): Boolean {
         val connectivityManager =
             context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
         val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
         return activeNetwork?.isConnectedOrConnecting == true
    }
}