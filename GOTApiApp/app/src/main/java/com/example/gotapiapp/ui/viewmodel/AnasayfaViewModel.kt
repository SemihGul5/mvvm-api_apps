package com.example.gotapiapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gotapiapp.data.model.Karakter
import com.example.gotapiapp.data.repo.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel:ViewModel() {
    var karakters=MutableLiveData<List<Karakter>>()
    var repo=Repository()

    init {
        karakterYukle()
    }

    fun karakterYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            karakters.value=repo.karakterYukle()
        }
    }
}