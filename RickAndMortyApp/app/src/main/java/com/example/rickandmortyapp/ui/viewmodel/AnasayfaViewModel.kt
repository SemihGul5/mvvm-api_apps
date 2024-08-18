package com.example.rickandmortyapp.ui.viewmodel

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.data.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor (var repository: Repository):ViewModel() {
    var karakters = MutableLiveData<List<Character>>()


    init {
        karakterleriYukle()
    }

    fun karakterleriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            karakters.value=repository.karakterleriYukle()
        }
    }

     fun isNetworkAvailable(context: Context):Boolean{



         val b= repository.isNetworkAvailable(context)
         return b
    }



}